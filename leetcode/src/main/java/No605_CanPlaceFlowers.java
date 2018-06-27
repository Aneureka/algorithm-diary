import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2017/10/10.
 */
public class No605_CanPlaceFlowers {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int len = flowerbed.length;
		List<Integer> flowers = new ArrayList<>();
		// 收集已有的花的位置信息，用于建立区间
		flowers.add(-2);
		for (int i = 0; i < len; i++)
			if (flowerbed[i] == 1)
				flowers.add(i);
		flowers.add(len+1);

		// 对每个区间进行处理，添加到结果中
		int ans = 0;
		for (int i = 0; i < flowers.size()-1; i++){
			int holes = flowers.get(i+1) - flowers.get(i) - 1;
			ans += Math.max(0, (holes-1)/2);
		}
		return ans >= n;
	}

	public static void main(String[] args) {
		No605_CanPlaceFlowers cpf = new No605_CanPlaceFlowers();
		int[] ex = {1,0,0,0,1,0,0};
		cpf.canPlaceFlowers(ex, 2);
	}

}
