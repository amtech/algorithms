package nowCoder.algorithm.array;

import java.util.ArrayList;

/**
 * 输入一个整数，打印出所有和为sum的连续正整数序列(至少包含两个数)
 * 思路：用small和big分别表示序列的最小值和最大值(初始值为1，2)
 * 从small到big的序列和：
 * ①：大于s，可以从序列中去除较小的值，即增大small的值
 * ②：小于s，可以增大big
 * 一直增加small直到(1+s)/2
 * 
 * @author snow
 *
 */
public class FindContinuousSequence {
	
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (sum < 3){//至少包含两个数，所以sum>=3
			return list;
		}
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		while (small < middle){//如sum为3，则middle为2，small只能为1不能=
			if (curSum == sum){
				list.add(addList(small, big));
			}
			while (curSum > sum && small < middle){
				curSum -= small;
				small++;
				if (curSum == sum){
					list.add(addList(small, big));
				}
			}//退出while，则此时curSum < sum或者small=middle(外层while中验证)
			big++;
			curSum += big;
		}
		return list;
    }
	
	public ArrayList<Integer> addList(int small, int big){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = small; i <= big; i++) {
			list.add(i);
		}
		return list;
	}
	public static void main(String[] args) {
		FindContinuousSequence findSeq = new FindContinuousSequence();
		ArrayList<ArrayList<Integer>> list = findSeq.findContinuousSequence(9);
		for (ArrayList<Integer> arrayList : list) {
			for (Integer i : arrayList) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

