package com.gloomshroud.gloomyland;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.gloomshroud.gloomyland.utility.DebugInfo;
import com.gloomshroud.gloomyland.utility.MenuButtonProcessor;

public class Menu extends BasicGameState {
	
	// PROPERTIES
	public Image playNow;
	public Image exitGame;
	public Image title;
	public Input input;
	public  MenuButtonProcessor bp;
	
	public Menu(int menu) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		playNow = new Image("res/button_play.png");
		exitGame = new Image("res/button_exit.png");
		title = new Image("res/title.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		DebugInfo.DrawDebugInfo(g);
		title.draw(0, 0);
		playNow.draw(100, 200);
		exitGame.draw(400, 200);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		input = gc.getInput();
		bp = new MenuButtonProcessor(input, gc, posX, posY);
		
		// Play button
		if (bp.processPlayButton()) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		
		// Exit button
		if (bp.processExitButton()) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
		
		DebugInfo.ShowDebugInfo(gc, posX, posY); // Method I made to show debug info. Toggle w/ F2
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
