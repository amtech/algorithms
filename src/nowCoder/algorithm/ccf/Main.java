package nowCoder.algorithm.ccf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n  = scan.nextInt();
		/**
		 *  nextInt()方法会读取下一个int型标志的token.但是焦点不会移动到下一行，仍然处在这一行上。
		 *  当使用nextLine()方法时会读取改行剩余的所有的内容，包括换行符，
		 *  然后把焦点移动到下一行的开头。所以这样就无法接收到下一行输入的String类型的变量。
		 *  next是以换行或者空格符为分隔线读取字符串的 
		 */
		String input = scan.next() /*读取第一个字符*/ + scan.nextLine();//所以input没有数据，没有输入
		String[] result = input.split(" ");
		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < n; i++) {//统计频率  value是出现的次数，次数有可能相同
			if (count.containsKey(result[i])){
				count.put(result[i], count.get(result[i]) + 1);
			} else {
				count.put(result[i], 1);
			}
		}
		System.out.println(count.toString());
		//频率统计之后还得排序。。可能出现很多数出现的次数相同的情况  查找出现次数最多的
		//int[] maxValue = new int[n];//保存出现最多次数的key  有可能每个数，都值出现了一次
		List<Integer> maxList = new ArrayList<>();
		//int i = 0;//记录maxValue的下标
		int maxCount = 0;//当前出现的最大次数
		for (String str : count.keySet()) {
			Integer value = count.get(str);
			if (value > maxCount){
				maxCount = value;
				maxList.clear();
				/*maxValue = new int[n];//重置数组，清零
				i = 0;
				maxValue[i++] = Integer.parseInt(str);*/
				maxList.add(Integer.parseInt(str));
			} else if (value == maxCount){
				maxList.add(Integer.parseInt(str));
			} else {
				continue;
			}
			System.out.print(maxCount + " --> ");
		}
		//最后返回出现次数相同的最小的数  对maxValue排序
		for (int j = 0, len = maxList.size(); j < len; j++) {
			System.out.print(maxList.get(j) + " ");
		}
		System.out.println();
		//Arrays.sort(maxValue);//前面有可能有一堆0，数组申请的控件比较大
		Collections.sort(maxList);
		for (int j = 0, len = maxList.size(); j < len; j++) {
			System.out.print(maxList.get(j) + " ");
		}
		System.out.println(maxList.get(0));
	}
}
