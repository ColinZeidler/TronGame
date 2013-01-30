package tron.colin.zeidler;

import java.awt.Color;
import java.awt.Graphics;

public class Grid {
	int[][] grid;
	
	Grid(int x, int y) {
		x = x/5;
		y = y/5;
		grid = new int[x][y];
		for (int i =0; i< x; i++) {
			for (int j = 0; j < y;j++) {
				grid[i][j] = 0;
			}
		}
	}
	//test laptop
	
	void draw(Graphics g) {
		for (int i =0; i< grid.length; i++) {
			for (int j = 0; j < grid[i].length;j++) {
				if (grid[i][j] == 0) {
					g.setColor(Color.WHITE);
				}
				else if (grid[i][j] == 1) {
					g.setColor(Color.BLUE);
				}

				g.fillRect(i*5, j*5, 10, 10);
			}
		}

	}

}
