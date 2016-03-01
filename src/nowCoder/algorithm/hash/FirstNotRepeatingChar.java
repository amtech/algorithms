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
	
	/**
	 * 其他hash表相关的问题：
	 * ①：从第一个字符串中删除在第二个字符串中出现过的所有字符
	 * 		创建用数组实现的简单哈希表来存储第二个字符串	
	 * 		从头到尾扫描第一个字符串中的字符，可以在O(1)的时间内，判断该字符串是否出现在第二个字符串中
	 * 		O(n)
	 * ②：删除字符串中所有重复出现的字符
	 * 		用布尔型数组实现的简单哈希表
	 * 		数组中元素的意义：下标看作是ASCII码，布尔值为对应的字母是否在字符串中出现过
	 * 		第一次出现，设置为true，下次检测到值为true时，表示已经出现过，O(1)时间判断
	 * 		O(n)
	 * ③：如果两个单词中出现的字母相同，并且每个字母出现的次数也相同：变位词
	 * 		创建一个用数组实现的简单哈希表
	 * 		当扫描到第一个单词中的每个字符时，为哈希表中对应的项的值+1
	 * 		扫描第二个单词，没扫描到一个字符，就将对应的项-1
	 * 		扫描完后，哈希表对应的所有值为0，就是变位词
	 * 
	 */
	public static void main(String[] args) {
		System.out.println((int)"as4".charAt(1));
		FirstNotRepeatingChar fc = new FirstNotRepeatingChar();
		System.out.println(fc.firstNotRepeatingChar("21213443"));
	}
}
