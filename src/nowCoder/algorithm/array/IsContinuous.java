package nowCoder.algorithm.array;

import java.util.Arrays;

/**
 * 扑克牌的顺序：
 * 从牌中任意取出5张，判断是不是一个顺子，即连续。大小王可以看成是任意的数字(看作是0)
 * 思路：
 * 	最直观的方法是将数组排序，由于0可以当作是任何的数字，可以将0去补满数组中的空缺
 *  ①：将数组排序
 *  ②：统计数组中0的个数
 *  ③：统计排序之后的数组中相邻数字之间的空缺总数
 *  ④：如果空缺总数<=0的个数，则是连续的，反之是不连续的
 *  ⑤：如果非0数字重复出现，也是不连续的，这个是对子，不是顺子了
 * 
 * @author snow
 *
 */
public class IsContinuous {
	
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 5){ //长度也该大于等于5吧
			return false;//数组可能是null，也可能使长度为0的[]
		}
		/*
		 * 快排：是O(nlogn),由于扑克牌的值是在0~13之间，
		 * 可以定义一个长度为14的hash表，就可以在O(n)内完成排序
		 * 通常认为不同级别的时间复杂度，只有在n足够大时才有意义
		 */
		Arrays.sort(numbers);
		int numOfZero = 0;//0的个数
		int numOfGap = 0;//空缺的个数
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			numOfZero++;//可以少个if
		}
		//System.out.println(numOfZero);
		//统计数组中间隔的数目
		int small = numOfZero;//0肯定是排在最前面的
		int big = small + 1;
		while (big < numbers.length){//下标从0开始
			//两个数相等，有对子，就不可能有顺子
			if (numbers[small] == numbers[big]){
				return false;
			}
			numOfGap += numbers[big] - numbers[small] - 1;
			small = big;
			big++;
		}
		return (numOfZero >= numOfGap) ? true : false;
    }
	public static void main(String[] args) {
		int[] arr = new int[]{};
		System.out.println(arr.length);//这里长度为0啊
		IsContinuous is = new IsContinuous();
		boolean flag = is.isContinuous(arr);
		System.out.println(flag);
	}
}
