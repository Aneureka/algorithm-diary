import java.util.Arrays;

/**
 * Created by Hiki on 2017/10/12.
 */
public class No289_GameOfLife {

	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		// 用一个数组做临时储值器，不管更新储值器，则可以实现in-place的替换
		int[] window = new int[n];
		for (int i = 0; i < m; i++){
			int[] tmp = Arrays.copyOf(window, n);
			for (int j = 0; j < n; j++){
				// 计算出周围数字的和
				int total = 0;
				for (int di = i-1; di <= i+1; di++)
					for (int dj = j-1; dj <= j+1; dj++)
						if (di >= 0 && di < m && dj >= 0 && dj < n)
							total += board[di][dj];
				total -= board[i][j];
				// 判断
				if (board[i][j] == 0 && total == 3 || board[i][j] == 1 && (total < 2 || total > 3))
					window[j] = 1-board[i][j];
				else
					window[j] = board[i][j];
			}
			// 将上一个覆盖
			if (i > 0)
				board[i-1] = tmp;
			// 如果到达末尾，则末尾用window代替
			if (i == m-1)
				board[i] = window;
		}

	}

	public static void main(String[] args) {
		No289_GameOfLife gl = new No289_GameOfLife();
		int[][] ex = {{1,1},{1,0}};
		gl.gameOfLife(ex);
		System.out.println(ex);
	}
}
