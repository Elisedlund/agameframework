package com.agameframework.debug;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Random;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.os.StatFs;

import com.agameframework.Game;
import com.agameframework.GameEngine;
import com.agameframework.GameThread;
import com.agameframework.settings.GameSettings;
import com.agameframework.utils.GameIntents;

public class GameErrorReporter implements Thread.UncaughtExceptionHandler {

	private String mVersionName;
	private String mPackageName;
	private String mFilePath;
	private String mPhoneModel;
	private String mAndroidVersion;
	private String mDevice;
	private String mDisplay;
	private String mFingerPrint;
	private String mHost;
	private String mId;
	private String mModel;
	private String mProduct;
	private String mTags;
	private long mTime;

	private Thread.UncaughtExceptionHandler mPreviousHandler;
	private static GameErrorReporter mInstance;


	private GameErrorReporter() {
		mPreviousHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
		CheckErrorAndSendMail();

	}

	public void errorDialog(final String report) {
		Builder dialog = new AlertDialog.Builder(Game.instance);
		dialog.setTitle(GameSettings.ERROR_DIALOG_TITLE);
		dialog.setMessage(GameSettings.ERROR_DIALOG_MESSAGE);
		dialog.setPositiveButton("YES", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				sendErrorMail(report);
			}
		});
		dialog.setNegativeButton("NO", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				GameEngine.sGameThread.setPaused(false); 
			}
		});
		dialog.show();
	}

	public String createInformationString() {
		String ReturnVal = "";
		ReturnVal += "Version : " + mVersionName;
		ReturnVal += "\n";
		ReturnVal += "Package : " + mPackageName;
		ReturnVal += "\n";
		ReturnVal += "FilePath : " + mFilePath;
		ReturnVal += "\n";
		ReturnVal += "Phone Model :" + mPhoneModel;
		ReturnVal += "\n";
		ReturnVal += "Android Version : " + mAndroidVersion;
		ReturnVal += "\n";
		ReturnVal += "Device : " + mDevice;
		ReturnVal += "\n";
		ReturnVal += "Display : " + mDisplay;
		ReturnVal += "\n";
		ReturnVal += "Finger Print : " + mFingerPrint;
		ReturnVal += "\n";
		ReturnVal += "Host : " + mHost;
		ReturnVal += "\n";
		ReturnVal += "ID : " + mId;
		ReturnVal += "\n";
		ReturnVal += "Model : " + mModel;
		ReturnVal += "\n";
		ReturnVal += "Product : " + mProduct;
		ReturnVal += "\n";
		ReturnVal += "Tags : " + mTags;
		ReturnVal += "\n";
		ReturnVal += "Time : " + mTime;
		ReturnVal += "\n";
		ReturnVal += "Total Internal memory : " + getTotalInternalMemorySize();
		ReturnVal += "\n";
		ReturnVal += "Available Internal memory : "
				+ getAvailableInternalMemorySize();
		ReturnVal += "\n";

		// ReturnVal += "Type : " + Type;
		// ReturnVal += "\n";
		// ReturnVal += "User : " + User;
		// ReturnVal += "\n";
		// ReturnVal += "Board : " + Board;
		// ReturnVal += "\n";
		// ReturnVal += "Brand : " + Brand;
		// ReturnVal += "\n";
		return ReturnVal;
	}

	public void uncaughtException(Thread t, Throwable e) {
		GameEngine.sGameThread.setPaused(true);// stop the game so nothing can happen. 
		String errorReport = "";
		Date CurDate = new Date();
		errorReport += "Error Report collected on : " + CurDate.toString();
		errorReport += "\n";
		errorReport += "\n";
		errorReport += "Device infomation:";
		errorReport += "\n";
		errorReport += "===================";
		errorReport += "\n";
		errorReport += "\n";
		getInformation(Game.instance);
		errorReport += createInformationString();

		errorReport += "\n\n";
		errorReport += "Stack : \n";
		errorReport += "=================== \n";
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		e.printStackTrace(printWriter);
		String stacktrace = result.toString();
		errorReport += stacktrace;

		errorReport += "\n";
		errorReport += "Cause : \n";
		errorReport += "=================== \n";
		// If the exception was thrown in a background thread inside
		// AsyncTask, then the actual exception can be found with getCause
		Throwable cause = e.getCause();
		while (cause != null) {
			cause.printStackTrace(printWriter);
			errorReport += result.toString();
			cause = cause.getCause();
		}
		printWriter.close();
		errorReport += "End of Report \n";
		errorReport += "===================";

		saveAsFile(errorReport);
		mPreviousHandler.uncaughtException(t, e);

	}

	private void saveAsFile(String errorString) {
		try {
			Random generator = new Random();
			int random = generator.nextInt(99999);
			String FileName = "stack" + mPackageName + random + ".stacktrace";
			FileOutputStream trace = Game.instance.openFileOutput(
					FileName, Context.MODE_PRIVATE);
			trace.write(errorString.getBytes());
			trace.close();
		} catch (IOException ioe) {
			Debug.warning("Error writing bugreport to file!");
		}
	}

	private String[] getErrorFileList() {
		String filePath = Game.instance.getFilesDir().getAbsolutePath();
		File dir = new File(filePath + "/");

		// Try to create the files folder if it doesn't exist
		dir.mkdir();

		// Filter for ".stacktrace" files
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".stacktrace");
			}
		};
		return dir.list(filter);
	}

	public boolean isThereAnyErrorFile() {
		return getErrorFileList().length > 0;
	}

	public void CheckErrorAndSendMail() {
		try {
			if (isThereAnyErrorFile()) {
				GameEngine.sGameThread.setPaused(true);
				String WholeErrorText = "";
				String[] ErrorFileList = getErrorFileList();
				int curIndex = 0;
				// We limit the number of crash reports to send ( in order not
				// to be too slow )
				final int MaxSendMail = GameSettings.MAX_CRASH_MAIL;
				String path = Game.instance.getFilesDir()
						.getAbsolutePath();
				for (String curString : ErrorFileList) {
					if (curIndex++ <= MaxSendMail) {
						WholeErrorText += "New Trace collected :\n";
						WholeErrorText += "===================\n ";
						String filePath = path + "/" + curString;
						BufferedReader input = new BufferedReader(
								new FileReader(filePath));
						String line;
						while ((line = input.readLine()) != null) {
							WholeErrorText += line + "\n";
						}
						input.close();
					}

					// DELETE FILES
					File curFile = new File(path + "/" + curString);
					curFile.delete();
				}
				errorDialog(WholeErrorText);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static GameErrorReporter getInstance() {
		if (mInstance == null) {
			mInstance = new GameErrorReporter();
		}
		return mInstance;
	}

	private void sendErrorMail(String ErrorContent) {
		String subject = GameSettings.BUG_EMAIL_TITLE
				+ Game.instance.getPackageName();
		String body = GameSettings.BUG_EMAIL_BODY +  "\n\n"
				+ "=================== \n" + ErrorContent + "\n\n";

		GameIntents
				.sendMail(subject, body, GameSettings.DEVELOPER_MAIL);
	}

	public long getAvailableInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		return availableBlocks * blockSize;
	}

	public long getTotalInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long totalBlocks = stat.getBlockCount();
		return totalBlocks * blockSize;
	}

	void getInformation(Context context) {
		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo pi;
			// Version
			pi = pm.getPackageInfo(context.getPackageName(), 0);
			mVersionName = pi.versionName;

			// Package name
			mPackageName = pi.packageName;

			// Files dir for storing the stack traces
			mFilePath = context.getFilesDir().getAbsolutePath();

			// Device model
			mPhoneModel = android.os.Build.MODEL;

			// Android version
			mAndroidVersion = android.os.Build.VERSION.RELEASE;

			mDevice = android.os.Build.DEVICE;
			mDisplay = android.os.Build.DISPLAY;
			mFingerPrint = android.os.Build.FINGERPRINT;
			mHost = android.os.Build.HOST;
			mId = android.os.Build.ID;
			mModel = android.os.Build.MODEL;
			mProduct = android.os.Build.PRODUCT;
			mTags = android.os.Build.TAGS;
			mTime = android.os.Build.TIME;

			// Board = android.os.Build.BOARD;
			// Brand = android.os.Build.BRAND;
			// Type = android.os.Build.TYPE;
			// User = android.os.Build.USER;

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

}// end of class
