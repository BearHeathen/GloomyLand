package com.gloomshroud.gloomyland.utility;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class MenuButtonProcessor {
	
	// Properties
	private Input input;
	private GameContainer gc;
	private int posX;
	private int posY;
	private boolean playButton = false;
	private boolean exitButton = false;
	
	public MenuButtonProcessor(Input input, GameContainer gc, int posX, int posY) {
		this.input = input;
		this.gc = gc;
		this.posX = posX;
		this.posY = posY;
	}
	
	//Methods
	public boolean processPlayButton() {
		
		if ((posX > 100 && posX < 250) && (posY > 215 && posY < 275)){
			playButton = true;
			return playButton;
		}
		
		return false;
		
	}
	
	public boolean processExitButton() {
		if ((posX > 400 && posX < 550) && (posY > 215 && posY < 275)){
			exitButton = true;
			return exitButton;
		}
		return false;
	}
}
