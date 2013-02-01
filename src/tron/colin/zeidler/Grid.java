package tron.colin.zeidler;

public class Grid {
	int[][] grid;

	Grid(int x, int y) {
		x = x / 5;
		y = y / 5;
		grid = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				grid[i][j] = 0;
			}
		}
	}
	public void print() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();

	}

	public void collisionCheck(Player p1, Player p2, Player p3, Player p4) {
		//if moved over already full cell, die.
		if ((grid[p1.x / 5][p1.y / 5] != 0) && p1.moved) {
			p1.dead = true;
		}
		if ((grid[p2.x / 5][p2.y / 5] != 0) && p2.moved) {
			p2.dead = true;
		}
		if ((grid[p3.x / 5][p3.y / 5] != 0) && p3.moved) // if x and y is not 0,
															// and moving
		{
			p3.dead = true;
		}
		if ((grid[p4.x / 5][p4.y / 5] != 0) && p4.moved) {
			p4.dead = true;
		}

	}

}
