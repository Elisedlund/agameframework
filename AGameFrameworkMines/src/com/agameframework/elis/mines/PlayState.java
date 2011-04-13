//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Point;
//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//
///*
// * to do 
// * array med kartan
// * rita ändast ut de skadade i arrayen
// * rita ändast ut det som ändrats i backbuffern
// * äkta fullscreen 
// * 
// */
//
///**
// * a state where you play the game.
// * @author Elis
// *
// */
//public class PlayState extends AbstractGameState
//{


////	/** 
////	 * if mouse button is down
////	 */
////	public void handleLeftMousePressed(int mouseX, int mouseY)
////	{
////		int x= mouseX/31;
////		int y= mouseY/31;
////		if (lost)
////		{
////			lost=false;
////			createNewLevel();
////			return;
////		}
////		if (!buttons[x][y].getFlag())
////		{
////			if (buttons[x][y].getValue()==0 && !buttons[x][y].isMine() && !buttons[x][y].isShow())
////			{
////				openZeroButtons(x,y);
////			}
////			buttons[x][y].setShow(true);
////			if(buttons[x][y].isMine())
////			{
////				showAll();
////				lost=true;
////			}
////		}
////	}
//
//	
//
//
//}//end of class