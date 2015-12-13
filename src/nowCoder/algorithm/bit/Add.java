package nowCoder.algorithm.bit;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 对数字做运算，除了四则运算之外，就只有位运算了，但是位运算是针对二进制的，所以需要转成二进制
 * 
 * 试着将二进制的加法用位运算来代替：
 * ①：不考虑进位对每一位相加
 * 	0加0，1加1结果都是0，0加1，1加0结果都是1   
 * 		和异或结果一样
 * ②：考虑进位
 * 	0加0，0加1，1加0都不会进位，只有1加1才会进位
 * 		考虑成两个数先做&运算，然后再向左移动一位
 * ③：将前两个步骤的结果相加，重复前面两步，直到不产生进位为止
 * 
 * 
 * a+b = (a^b) + (a&b)*2 ，然后将 a^b 作为新的a, (a&b)*2作为新的b，直到b=0
 * @author snow
 *
 */
public class Add {
	
	public int Add(int num1, int num2) {
        int sum, carry;
        do {
        	//不考虑进位加法，即异或
        	sum = num1 ^ num2;
        	//进位，即&，进位即是左移一位
        	carry = (num1 & num2) << 1;
        	num1 = sum;
        	num2 = carry;
        } while(num2 != 0);//还有进位，说明还得有加法
        return sum;
    }
	public static void main(String[] args) {
		Add add = new Add();
		int i = add.Add(-1, -3);
		System.out.println(i);
	}
}
