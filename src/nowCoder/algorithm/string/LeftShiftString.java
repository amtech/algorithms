package nowCoder.algorithm.string;

/**
 * 左旋转字符串: 将字符串前n个字符移动到字符串的尾部
 * 要求：时间复杂度O(n),空间O(1)
 * 思路：将字符串分为两部分，前n个字符，和后面的字符串
 * ①：旋转前n个字符
 * ②：旋转后面的字符
 * ③：旋转整个字符串
 * 例如：abcdefg，旋转前2个，结果为cdefgab
 * 旋转ab -> ba
 * 旋转后面 cdefg -> gfedc
 * 旋转bagfedc -> cdefgab
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
	
	//法二
	public String LeftRotateString(String str, int n) {
		if (str == null || str.equals("") || n < 0){//n可能大于str的长度，需要求模
			return str;
		}
		char[] ch = str.toCharArray();
		int len = ch.length;
		reverse(ch, 0, n % len - 1);//应该先求模，然后再-1
		reverse(ch, n % len, ch.length - 1);
		reverse(ch, 0, ch.length - 1);
		return String.valueOf(ch);//将char[]转换成String
    }
	
	private void reverse(char[] ch, int begin, int end){
		char temp = ' ';
		while (begin < end){
			temp = ch[begin];
			ch[begin] = ch[end];
			ch[end] = temp;
			begin++;
			end--;
		}
	}
	
	/**
	 * 牛逼的法三
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString2(String str, int n) {
		if (str == null || str.equals("") || n < 0){//n可能大于str的长度，需要求模
			return str;
		}
        int len = str.length();
        n = n % len;
        str += str;//牛逼啊!!!
        return str.substring(n, len + n);//精辟
	}
	
	public static void main(String[] args) {
		LeftShiftString shift = new LeftShiftString();
		String str = shift.LeftRotateString2("abcdefg", 2);
		System.out.println(str);
	}
}
