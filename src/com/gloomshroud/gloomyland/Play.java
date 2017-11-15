package com.gloomshroud.gloomyland;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.gloomshroud.gloomyland.utility.DebugInfo;

public class Play extends BasicGameState {

	private Animation gloomy, movingUp, movingDown, movingLeft, movingRight;
	private Image worldMap;
	private boolean quit = false;
	public int[] duration = { 200, 200 };
	public int gloomyPosX = 0;
	public int gloomyPosY = 0;
	public float shiftX = gloomyPosX + 320; // shiftX and shiftY keep "camera" centered on player
	public float shiftY = gloomyPosY + 160;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		worldMap = new Image("res/world.png");
		Image[] walkUp = { new Image("res/isaacsBack.png"), new Image("res/isaacsBack.png") };
		Image[] walkDown = { new Image("res/isaacsFront.png"), new Image("res/isaacsFront.png") };
		Image[] walkLeft = { new Image("res/isaacsLeft.png"), new Image("res/isaacsLeft.png") };
		Image[] walkRight = { new Image("res/isaacsRight.png"), new Image("res/isaacsRight.png") };

		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		// Initial orientation
		gloomy = movingDown;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		worldMap.draw(gloomyPosX, gloomyPosY);
		gloomy.draw(shiftX, shiftY);
		DebugInfo.DrawDebugInfo(g);
		g.drawString("Gloom X: " + gloomyPosX + "\n" + "Gloom Y: " + gloomyPosY, 400, 20);

		if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit Game (Q)", 250, 200);

			if (quit == false) {
				g.clear();
			}
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		DebugInfo.ShowDebugInfo(gc, gloomyPosX, gloomyPosY);
		processInput(gc, delta);
		processMenu(gc, sbg);

	}

	private void processMenu(GameContainer gc, StateBasedGame sbg) {
		// TODO: Put all this into a new game state pause menu. Confirm each action except resume. Save/Load.
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}

		// When the menu is up
		if (quit == true) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);

			}
			if (input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);

			}
		}
	}

	private void processInput(GameContainer gc, int delta) {
		Input input = gc.getInput();
		float movementSpeed = 0.5f;

		// Move Up
		if (input.isKeyDown(Input.KEY_UP)) {
			gloomy = movingUp;
			gloomyPosY += delta * movementSpeed;
			if (gloomyPosY >= 104) {
				gloomyPosY -= delta * movementSpeed;
			}
		}

		// Move Down
		if (input.isKeyDown(Input.KEY_DOWN)) {
			gloomy = movingDown;
			gloomyPosY -= delta * movementSpeed;
			if (gloomyPosY <= -481) {
				gloomyPosY += delta * movementSpeed;
			}

		}

		// Move Left
		if (input.isKeyDown(Input.KEY_LEFT)) {
			gloomy = movingLeft;
			gloomyPosX += delta * movementSpeed;
			if (gloomyPosX >= 268) {
				gloomyPosX -= delta * movementSpeed;
			}
		}
		// Move Right
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			gloomy = movingRight;
			gloomyPosX -= delta * movementSpeed;
			if (gloomyPosX <= -936) {
				gloomyPosX += delta * movementSpeed;
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}