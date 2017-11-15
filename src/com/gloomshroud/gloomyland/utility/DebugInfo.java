package com.gloomshroud.gloomyland.utility;

import java.awt.Graphics;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class DebugInfo {
	
	public static String debugInfo = "";
	public static Input input;
	public static boolean toggle1 = false;
	public static boolean toggle2 = false;
	
	public static void ShowDebugInfo(GameContainer gc, int posX, int posY) {
		
		input = gc.getInput();
						
		// Press F2 to toggle mouse position debug info
		if (input.isKeyPressed(Input.KEY_F2)) {
			toggle1 = !toggle1;
		}
		
		if(toggle1) {
			debugInfo = "Mouse X: " + posX + " " + " Mouse Y: " + posY;
		} else { debugInfo = ""; }
		
		// Press F3 to toggle player position debug info
		if (input.isKeyPressed(Input.KEY_F3)) {
			toggle2 = !toggle2;
		}
		if(toggle2) {
			debugInfo = "Gloom X: " + posX + " " + " Gloom Y: " + posY;
		} else { debugInfo = ""; }
		
	}
	
	public static void DrawDebugInfo(org.newdawn.slick.Graphics g) {
		if (toggle1) {
			g.drawString(debugInfo, 10, 25);
		}
		
		if (toggle2) {
			g.drawString(debugInfo, 100, 250);
		}
		
	}

}
