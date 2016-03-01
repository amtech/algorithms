package nowCoder.algorithm.hash;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。
 * 若为空串，返回-1。位置索引从0开始
 * 
 * 哈希表：
 * 	统计每个字符，在字符串中出现的次数
 * 	将每个字符映射成一个数字
 * 	从头到尾扫描次数两次，第一次：对应的次数+1， 第二次：每扫描到一个字符，就用O(1)的时间从中得到次数
 * 
 * 字符串是一个长度为8bit的数据类型，java为16。总共有256种可能，所以数组长度为256
 * 辅助内存大小： int 4字节 4 * 256  1KB,大小是常数，所以可以看作O(1)
 * @author snow
 *
 */
public class FirstNotRepeatingChar {
	//private static final int _1M = 1024 * 1024;
	public int firstNotRepeatingChar(String str){
		if (str == null){
			return -1;
		}
		//将字母的ASCII作为数组的下标索引，值为出现的次数  默认是初始化为0的
		int[] charCount = new int[256];
		int len = str.length();
		for (int i = 0 ; i < len; i++) {
			charCount[(int)str.charAt(i)]++;
		}
		for (int i = 0; i < len; i++) {
			if (charCount[(int)str.charAt(i)] == 1){
				return i;
			}
		}
		return -1;//有可能，没有出现次数为1的
	}
	public static void main(String[] args) {
		System.out.println((int)"as4".charAt(1));
		FirstNotRepeatingChar fc = new FirstNotRepeatingChar();
		System.out.println(fc.firstNotRepeatingChar("21213443"));
	}
}
