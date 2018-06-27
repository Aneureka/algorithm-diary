/**
 * Created by Hiki on 2017/10/11.
 */
public class No566_ReshapeTheMatrix {

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int or = nums.length, oc = nums[0].length;
		if (r <= 0 || c <= 0 || r * c != or * oc)
			return nums;

		int[][] res = new int[r][c];
		for (int i = 0; i < r; i++){
			for (int j = 0; j < c; j++){
				int pos = i * c + j;
				res[i][j] = nums[pos/oc][pos%oc];
			}
		}

		return res;
	}

}
