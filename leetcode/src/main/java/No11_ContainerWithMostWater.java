/**
 * Created by Hiki on 2017/8/24.
 */
public class No11_ContainerWithMostWater {


	// 正解，双指针，关键在于如何遍历maxArea的情况
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}


//	优化的暴力解法，TLE
//	public int maxArea(int[] height) {
//
//		int res = 0;
//		int ix = 0;
//		for (int i = 0; i < height.length-1; i++){
//			if (height[i] < height[ix]) continue;
//			for (int j = i+1; j < height.length; j++){
//				int area = (j-i) * Math.min(height[i], height[j]);
//				if (area >= res){
//					res = area;
//					ix = i;
//				}
//			}
//		}
//
//		return res;
//	}
}
