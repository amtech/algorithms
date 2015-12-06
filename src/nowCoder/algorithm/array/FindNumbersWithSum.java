package nowCoder.algorithm.array;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和为s
 * 如果有多对数字的和为s，输出乘积最小的一对
 * 输出两个数，小的先输出
 * 
 * 思路：在数组中选择两个数字ahead指向arr[0],behind指向arr[length-1]，如果和==s，则返回
 * 	① 和 < s 将ahead向后移动，和变大再重复比较
 *  ② 和 > s 将behind向前移动，和变小再重复比较
 * @author snow
 *
 */
public class FindNumbersWithSum {
	
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
		//和参数类型为int型，说明两个数之和没有超出int的表示范围
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length < 2){
			return list;
		}
		int ahead = 0;
		int behind = array.length - 1;
		long curSum = 0;//和可能超出int范围
		//Map<Integer, Integer> map = new HashMap<>();
		while (ahead < behind){//数组是排序数组,较小数字下标小于较大数字的下标
			curSum = array[ahead] + array[behind];
			System.out.println("curSum: " + curSum);
			if (curSum == sum){
				/*map.put(array[ahead], array[behind]);
				有可能有多对数，找到了直接ahead++
				ahead++;
				找到的第一组数一定是乘积最小的那组数
				*/
				list.add(array[ahead]);
				list.add(array[behind]);
				break;
			}else if (curSum < sum){
				ahead++;
			}else {
				behind--;
			}
		}
		return /*findMinMultiply(map)*/list;
    }
	
	/**
	 * 因为数组按照从小到大的排序，所以乘积最小的那组数一定是找到的第一组数
	 * @param map
	 * @return
	 */
	/*public ArrayList<Integer> findMinMultiply(Map<Integer, Integer> map){
		ArrayList<Integer> list = new ArrayList<Integer>();
		long multiply = Long.MAX_VALUE;
		//找到乘积最小的两个数
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			long curMulti = entry.getKey() * entry.getValue();
			if (curMulti < multiply){
				multiply = curMulti; 
				list.clear();//清空原来的数据 
				list.add(entry.getKey());
				list.add(entry.getValue());
			}
		}
		return list;
	}*/
	public static void main(String[] args) { 
		FindNumbersWithSum findSum = new FindNumbersWithSum();
		int[] arr = new int[]{0, 1, 2, 4, 7, 11, 15};
		ArrayList<Integer> list = findSum.findNumbersWithSum(arr, 15);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
