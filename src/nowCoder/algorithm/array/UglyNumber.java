package nowCoder.algorithm.array;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * 丑数只能被2，3，5整除
 * 如果一个数能被2整除，就把他连续除2，  3，5同理
 * 最后如果得到1，则是丑数
 * @author snow
 *
 */
public class UglyNumber {
	
	
	/**
	 * 法1：丑数只能被2，3，5整除
	 * 如果一个数能被2整除，就把他连续除2，  3，5同理
	 * 最后如果得到1，则是丑数
	 */
	public boolean isUglyNumber(int n){
		while (n % 2 == 0){
			n = n / 2;
		}
		while (n % 3 == 0){
			n = n / 3;
		}
		while (n % 5 == 0){
			n = n / 5;
		}
		return (n == 1) ? true : false;
	}
	
	/* 按照顺序判断每个数是不是丑数  1是第一个丑数*/
	public int getUglyNum(int index){//第多少个丑数
		if (index <= 0)
			return 0;
		int uglyFound = 0;//目前丑数的个数
		int number = 0;//当前数的值
		while (uglyFound < index){
			//必须放在判断前面，否则判断是丑数了，还+了1
			number++;
			if (isUglyNumber(number)){
				uglyFound++;
			}
		}
		return number;
	}
	
	/**
	 * 法2：创建数组保存已经找到的丑数，用空间换时间
	 * 1500个数，每个int4字节，共6kb的辅助空间
	 * 丑数应该是另一个丑数*2，3，5的结果，1除外
	 * 创建一个数组，确保里面的数字是排序好的丑数
	 * 		数组中以排好序的最大的丑数为M
	 * 下一个丑数：应该是数组中的数*2，3，5的结果，会得到若干个<=M的结果。
	 * 		<=M的数已经在数组中了，不需要考虑，需要考虑每次*2,3,5中第一个>M的数，即为M2, M3, M5
	 * 下一个丑数，应该是这3个数中，最小的那个
	 * 
	 * 没有必要每次都把已有的丑数*2，3，5
	 * 例如：*2，必然存在某个数T2，之前的数*2 <=M ,T2 * 2 > M
	 * 记录这个T2，因为之前的数，已经不需要再*2了
	 * 每次生成新的丑数的时候，更新T2,T3,T5
	 * @param args
	 */
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		int[] uglyNumers = new int[index];
		uglyNumers[0] = 1;//第一个丑数是1
		int nextUglyIndex = 1;
		int T2, T3, T5;
		T2 = T3 = T5 = 0;
		while (nextUglyIndex < index){
			int min = min(uglyNumers[T2] * 2, uglyNumers[T3] * 3, uglyNumers[T5] * 5);
			uglyNumers[nextUglyIndex] = min;
			while (uglyNumers[T2] * 2 <= min)
				T2++;
			while (uglyNumers[T3] * 3 <= min)
				T3++;
			while (uglyNumers[T5] * 5 <= min)
				T5++;
			nextUglyIndex++;
		}
		
        return uglyNumers[nextUglyIndex - 1];
    }
	
	public int min(int num1, int num2, int num3){
		int min = (num1 < num2) ? num1 : num2;
		return (min < num3) ? min : num3;
	}
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		System.out.println(un.getUglyNum(1));
		System.out.println(un.isUglyNumber(1));
		System.out.println(un.GetUglyNumber_Solution(5));
	}
}
