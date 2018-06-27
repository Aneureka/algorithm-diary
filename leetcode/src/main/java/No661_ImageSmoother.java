/**
 * Created by Hiki on 10/7/2017.
 */
public class No661_ImageSmoother {

	public int[][] imageSmoother(int[][] M) {
		int row = M.length;
		int col = M[0].length;

		int[][] cnt = new int[row][col];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				double sum = 0;
				double count = 0;
				for (int di = i-1; di <= i+1; di++){
					for (int dj = j-1; dj <= j+1; dj++){
						if (di >= 0 && di < row && dj >= 0 && dj < col){
							count++;
							sum += M[di][dj];
						}
					}
				}
				cnt[i][j] = (int)Math.floor(sum/count);
			}
		}
		return cnt;
	}
}
