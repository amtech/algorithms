package nowCoder.algorithm.bit;

/**
 * 二进制中1的个数
 * 用一条语句判断一个整数是不是2的整数次方
 * 		如果是，则二进制表示中，有且只有一位是1，减去1之后，再和自己做&，唯一的1就会变成0
 * 整数m，n。判断需要改变m的二进制表示中的多少位才能得到n
 * 		分两步，1，求mn的异或，2求异或结果中一共有多少个1   不同为1
 * @author snow
 *
 */
public class NumberOf1 {
	/**
	 * 可能引起死循环 n可能是负数。每次右移一位
	 * 如果是负数，前面是补1的，最后得到全是1的二进制，0xffffffff死循环
	 * 这里，可以分情况，如果是负数，先求该数的绝对值中1的个数，然后再求该数1的个数
	 * @param n
	 * @return
	 */
	public int numberOf1(int n){
		int count = 0;
		while (n != 0){
			if ((n & 1) == 1){
				count++;
			}
			n = n >> 1;
		}
		return n;
	}
	
	/**
	 * 为了避免死循环，不右移n
	 * n & 1,判断最低位是不是1，然后 1 << 1, n & 2,判断次低位是不是1，每次都左移&上的那个数
	 * @param n
	 * @return
	 */
	public int numberOf12(int n){
		int count = 0;
		int flag = 1;//循环的次数等于整数二进制的次数
		while (flag > 0){//flag中只有一位是1，判断该位在n中是不是1
			if ((n & flag) == 1){
				count++;
			}//每次左移一位 ，后面补0，最终会变成0，循环结束
			flag = flag << 1;
		}
		return count;
	}
	
	public int numberOf13(int n){
		int count = 0;
		while (n != 0){//如果一个整数不等于0，那么该数的二进制表示中至少有一位是1
			count++;//把一个整数和它-1的结果&，相当于把最右边的1变成0
			n = n & (n - 1);//有多少个1，就可以进行多少次这样的操作
		}
		return count;
	}
}
