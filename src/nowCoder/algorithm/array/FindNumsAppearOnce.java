package nowCoder.algorithm.array;

/**
 * 找到数组中只出现一次的数字
 * 一个整型数组，除了两个数字之外，其他的数字都出现了两次
 * 先考虑数组中只有一个数字出现一次，其他的都出现两次：
 *  异或运算：任何一个数字异或自己都等于0，从头到尾异或一遍O(n),最终的结果就是出现一次的数字
 * 有两个数字出现了一次：
 * 		将数组分成两个子数组，每一个子数组中包含一个出现一次的数字
 * 	①：从头到尾异或，最终结果是两个只出现一次的数字异或的结果，因为不同，所以二进制中必定有一位是1
 *  ②：找到第一个为1的二进制位，标记为n，以第n位是不是1将数组分为两个子数组(1,0)
 *  ③：出现两次的数字肯定是在同一个子数组中，第n位一定相同
 *  ④：再对每一个子数组进行异或，得到结果
 *  
 *  如何应对java中无符号类型的缺失？http://www.tuicool.com/articles/7VRBZj
 *  Java 中的 byte 永远是 1 字节， short 是 2 字节， int 是 4 字节， long 是 8 字节。
 *  使用比要用的无符号类型更大的有符号类型
 *  使用 short 来处理无符号的字节，使用 long 来处理无符号整数等（甚至可以使用 char 来处理无符号短整型）。
 *  确实，这样看起来很浪费，因为你使用了 2 倍的存储空间，但是也没有更好的办法了。另外，需要提醒的是，
 *  对于 long 类型变量的访问不是原子性操作，所以，如果在多线程场景中，你得自己去处理同步的问题。
 * @author snow
 *
 */
public class FindNumsAppearOnce {
	
	/**
	 * 除了两个数字之外，其他的数字都出现了两次
	 * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]){
		if (array == null || array.length < 2){
			return;
		}
		int resultExclusiveOR = 0;//保存异或结果
		for (int i = 0; i < array.length; i++) {
			resultExclusiveOR ^= array[i];
		}
		//System.out.println(resultExclusiveOR);
		//找到异或二进制结果中从最右边起第一个为1的位
		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		//System.out.println(indexOf1 + " indexOf1");//2
		num1[0] = num2[0] = 0;
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], indexOf1) == 1){
		//即使数组中只出现一次的数是0，0异或之后还是0，数组设置的初始化值不影响结果
				num1[0] ^= array[i];
			}else {
				num2[0] ^= array[i];
			}
		}
	}
	
	/**
	 * 在num的二进制表示中，找到最右边是1的位
	 * num可能为0，如果是0indexBit位0
	 * 0原码是00000000 
	   -0原码是10000000 
	   
	   0反码是00000000 
	   -0反码是11111111 
	
	  0补码是00000000 
	    补码没有正0与负0之分。
	 * @param num
	 * @return
	 */
	public /*unsigned*/ int findFirstBitIs1(int num){
		if (num == 0){
			return 0;
		}
		int indexBit = 1;
		while ((num & 1) == 0 && indexBit <= 32){
			num = num >> 1;
			indexBit++;
		}
		return indexBit;
	}
	
	/*
	 * 整数num的二进制表示中，判断从右边数起的indexBit位是不是1
	 * 右边起第一位，就是最右边那位，不需要右移，所以是indexBit -1
	 * indexBit应该是一个无符号int的，但是java里面数据类型都是有符号的
	 * 可以自定义类包装一下
	 * 这里int4字节，32位在int的表示范围内，只需要稍加判断即可
	 */
	public int isBit1(int num,/*unsigned*/ int indexBit){
		if (indexBit > 0){
			num = num >> (indexBit - 1);
			return (num & 1);//true
		}
		return 0;//false
	}
	
	public static void main(String[] args) {
		FindNumsAppearOnce find = new FindNumsAppearOnce();
		//System.out.println(find.findFirstBitIs1(0));
		//System.out.println(0 == -0);//true
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		find.findNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);
		System.out.println(num1[0] + " " + num2[0]);
		//System.out.println(4 ^ 6);//2
	}
}
