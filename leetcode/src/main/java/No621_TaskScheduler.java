import java.util.Arrays;

/**
 * Created by Hiki on 2017/10/10.
 */
public class No621_TaskScheduler {

	public int leastInterval(char[] tasks, int n) {

		int all = tasks.length;
		if (n == 0) return all;

		// 保存各个任务（字母）剩余个数并初始化
		int[] counts = new int[26];
		int[] durations = new int[26];
		for (char task : tasks)
			counts[task-'A']++;

		// 每个周期找出最合适的task，并计算idle或count
		int time = 0;
		for (int i = 0; i < all; i++){
			int bestTask = findCurrentBestTask(counts, durations);
			// 如果找出的当前的task需要等待
			if (durations[bestTask] != 0){
				int d = durations[bestTask];
				reduceTime(durations, d);
				time += d;
			}
			reduceTime(durations, 1);
			time += 1;
			counts[bestTask]--;
			durations[bestTask] = n;
		}

		return time;

	}

	private int findCurrentBestTask(int[] counts, int[] durations){
		int res = 0, max = 0, min = 101;

		for (int i = 0; i < counts.length; i++){
			if (counts[i] > max && durations[i] == 0){
				max = counts[i];
				res = i;
			}
		}
		if (max != 0) return res;

		for (int i = 0; i < durations.length; i++){
			if (durations[i] < min && counts[i] > 0){
				min = durations[i];
				res = i;
			}
		}
		return res;
	}

	private void reduceTime(int[] durations, int d){
		for (int i = 0; i < durations.length; i++)
			durations[i] = Math.max(0, durations[i]-d);
	}

	public static void main(String[] args) {
		No621_TaskScheduler ts = new No621_TaskScheduler();
		char[] a = {'A','A','A','B','B','B'};
		System.out.println(ts.leastInterval(a, 2));
	}

}
