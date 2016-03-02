package nowCoder.algorithm.other;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * 出错的处理方法：可以和面试官讨论每种方式的优缺点，然后选择
 * ①：返回值
 * ②：全局代码  缺点：函数调用者可能会忘记检查，留下安全隐患
 * ③：异常 性能损耗
 * @author snow
 *
 */
public class Power {
	//设置全局代码，出错提示,区分是出错的时候返回的0，还是底数为0时正常返回的0
	boolean invalidInput = false;
	/**
	 * 输入的指数是0和负数怎么办
	 * 当指数为负数时， 先对指数取绝对值，然后算出次方的结果后再取倒数
	 * 		如果base为0，0不能作为分母
	 * 0的0次方，在数学上没有意义，0或者1都可以，和面试官讨论
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double Power(double base, int exponent) {
		//如果底数为0，并且指数为负数
        if (equal(base, 0.0) && exponent < 0){
        	invalidInput = true;
        	return 0.0;
        }
        if (exponent < 0){
        	return 1.0 / powerWithUnsignedExponent(base, -exponent);
        }else {
        	return powerWithUnsignedExponent(base, exponent);
        }
	}
	
	/**
	 * 			a^(n/2) * a^(n/2)   n为偶数
	 * 求a^n:   
	 *          a^((n-1)/2) * a^((n-1)/2) * a n为奇数
	 * O(logn)求裴波那数列，递归实现
	 * @return
	 */
	private double powerWithUnsignedExponent(double base, int exponent) {
		if (exponent == 0){
			return 1;
		}
		if (exponent == 1){
			return base;
		}//用 >>代替 除以2
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result *= result;//不管n是奇数还是偶数都得乘
		if ((exponent & 0x01) == 1){//需要加上括号，==优先级比&高  &代替%
			result *= base;
		}
		return result;
	}

	/**
	 * 判断两个double类型的数据是否相等
	 * 不能直接判断base是否为0
	 */
	private boolean equal(double num1, double num2) {
		if (num1 - num2 > -0.0000001 && num1 - num2 < 0.00000001)
			return true;
		return false;
	}
	
	/**非递归版
	 * double Power(double base, int exponent) {
        int p = abs(exponent);
        double r = 1.0;
        while(p){
            if(p & 1) r *= base;
            base *= base;
            p >>= 1;
        }
        return exponent < 0 ? 1/ r : r;
    }
	 */
	
	public static void main(String[] args) {
		System.out.println(3 & 1);
		Power p = new Power();
		System.out.println(p.Power(2, 3));
	}
}
