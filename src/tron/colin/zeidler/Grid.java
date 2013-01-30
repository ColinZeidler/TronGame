package tron.colin.zeidler;


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
	

}
