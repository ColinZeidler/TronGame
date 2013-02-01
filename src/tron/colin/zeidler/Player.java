package tron.colin.zeidler;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	int x;
	int y;
	Color colour;
	int xSpeed;
	int ySpeed;
	boolean dead;
	
	String[] keys;

	Player(int x, int y) {
		this.y = y;
		this.x = x;
		xSpeed = 0;
		ySpeed = 0;
		dead = false;
		keys = new String[4];
	}

	void draw(Graphics g) {
		g.setColor(colour);
		g.fillRect(x, y, 10, 10);
		x += xSpeed;
		y += ySpeed;
	}
	
	void setKeys(String sUp, String sDown, String sLeft, String sRight) {
		keys[0] = sUp;
		keys[1] = sDown;
		keys[2] = sLeft;
		keys[3] = sRight;
	}
	
	String[] getKeys() {
		return keys;
	}

}
