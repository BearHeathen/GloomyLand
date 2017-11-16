package com.gloomshroud.gloomyland;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.gloomshroud.gloomyland.states.InGameMenu;
import com.gloomshroud.gloomyland.states.MainMenu;
import com.gloomshroud.gloomyland.states.Play;

public class Game extends StateBasedGame {
	
	public static final String version = " (v0.1.2)";
	public static final String gameName = "Gloomy Land" + version;
	public static final int SCREEN_WIDTH = 640;
	public static final int SCREEN_HEIGHT = 480;
	
	// STATES
	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int INGAME = 2;
	
	
	public Game(String gameName) {
		super(gameName);
		// DEFINE STATES
		this.addState(new MainMenu(MENU));
		this.addState(new Play());
		this.addState(new InGameMenu(INGAME));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		this.enterState(MENU);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gameName));
			appgc.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
			appgc.start();
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
	}

	

}
