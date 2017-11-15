package com.gloomshroud.gloomyland.utility;

import java.awt.Graphics;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class DebugInfo {
	
	public static String debugInfo = "";
	public static Input input;
	public static boolean toggle1 = false;
	
	public static void ShowDebugInfo(GameContainer gc, int posX, int posY) {
		
		input = gc.getInput();
						
		// Press F2 to toggle mouse position debug info
		if (input.isKeyPressed(Input.KEY_F2)) {
			toggle1 = !toggle1;
		}
		
		if(toggle1) {
			debugInfo = "Mouse X: " + posX + " " + " Mouse Y: " + posY;
		} else { debugInfo = ""; }
		

	}
	
	public static void DrawDebugInfo(org.newdawn.slick.Graphics g) {
		if (toggle1) {
			g.drawString(debugInfo, 10, 25);
		}
		
	}

}
