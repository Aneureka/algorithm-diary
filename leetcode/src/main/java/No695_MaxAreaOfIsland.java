/**
 * Created by Hiki on 2017/10/10.
 */
public class No695_MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int ans = 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				ans = Math.max(dfs(grid, i, j), ans);
		return ans;
	}

	private int dfs(int[][] grid, int x, int y){
		int row = grid.length;
		int col = grid[0].length;
		if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1)
			return 0;
		grid[x][y] = 0;
		return 1 + dfs(grid,x-1, y) + dfs(grid, x+1, y) + dfs(grid, x, y-1) + dfs(grid, x, y+1);
	}
}
