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

	public void collisionCheck(Player p1) {
		if (grid[p1.x / 5][p1.y / 5] != 0) {
			p1.dead = true;
		}

	}

}
