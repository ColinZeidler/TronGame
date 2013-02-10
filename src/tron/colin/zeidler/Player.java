package tron.colin.zeidler;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	int x;
	int y;
	Color colour;
	int xSpeed;
	int ySpeed;
	boolean dead, moved;

	Player(int x, int y) {
		this.y = y;
		this.x = x;
		xSpeed = 0;
		ySpeed = 0;
		dead = false;
		moved=false;
	}

	void draw(Graphics g) {
		g.setColor(colour);
		g.fillRect(x, y, 10, 10);
		
		if(!dead) //if dead, stop in place
		{
			x += xSpeed;
			y += ySpeed;
		}
		
	}

}
