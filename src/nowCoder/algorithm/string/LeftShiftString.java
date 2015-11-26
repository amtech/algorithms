package nowCoder.algorithm.string;

/**
 * 左旋转字符串
 * 要求：时间复杂度O(n),空间O(1)
 * @author snow
 *
 */
public class LeftShiftString {
	
	/**
	 * 法一：暴力移位法，每次一位一位的移动，移m次
	 * @param str
	 * @param n
	 */
	public void leftShiftOne(char[] str, int n){
		char t = str[0];//保存数组第一位字符
		for (int i = 1; i < n; i++) {
			str[i - 1] = str[i];
		}
		str[n - 1] = t;
	}
	
	public void leftShift(char[] str, int n, int m){
		while (m-- > 0){//时间复杂度，O(m * n)
			leftShiftOne(str, n);
		}
	}
}
