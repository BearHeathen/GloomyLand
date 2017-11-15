package com.gloomshroud.gloomyland;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.gloomshroud.gloomyland.utility.DebugInfo;

public class Play extends BasicGameState {
	
	private Animation gloomy, movingUp, movingDown, movingLeft, movingRight;
	private Image worldMap;
	private boolean quit = false;
	public int[] duration = {200, 200};
	public int gloomyPosX = 0;
	public int gloomyPosY = 0;
	public float shiftX = gloomyPosX + 320; // shiftX and shiftY keep "camera" centered on player
	public float shiftY = gloomyPosY + 160;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		worldMap = new Image("res/world.png");
		Image[] walkUp = {new Image("res/isaacsBack.png"), new Image("res/isaacsBack.png")};
		Image[] walkDown = {new Image("res/isaacsFront.png"), new Image("res/isaacsFront.png")};
		Image[] walkLeft = {new Image("res/isaacsLeft.png"), new Image("res/isaacsLeft.png")};
		Image[] walkRight = {new Image("res/isaacsRight.png"), new Image("res/isaacsRight.png")};
		
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		//Initial orientation
		gloomy = movingDown;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		worldMap.draw(gloomyPosX, gloomyPosY);
		gloomy.draw(shiftX, shiftY);
		DebugInfo.DrawDebugInfo(g);
		//g.drawString("Gloom X: " + gloomyPosX + "\n" + "Gloom Y: " + gloomyPosY, 400, 20);
		
		if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 100);
			g.drawString("Quit Game (Q)", 2500, 200);
			
			if (quit == false) {
				g.clear();
			}
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		DebugInfo.ShowDebugInfo(gc, gloomyPosX, gloomyPosY);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}