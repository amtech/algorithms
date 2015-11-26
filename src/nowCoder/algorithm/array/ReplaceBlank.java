package nowCoder.algorithm.array;

/**
 * 替换字符串中的空格
 * 将' '替换成 "%20"
 * 在网络编程中，如果URL参数含有特殊字符，例如' ', '#'等。可能导致服务器端无法获得正确的参数值
 * 需要将特殊字符转换成服务器可以识别的字符   规则： %后加上ASCII的两位16进制的表示
 *   如空格，32， 所以是%20
 * 替换时，原来一个空格字符，替换后变成% 2 0三个字符，字符串的长度增加2
 * 	如果在原来的字符串上做替换，从前往后，后面的内容就可能被覆盖
 * 	如果内存足够，可以创建新的字符串，然后在新的上做替换
 *             需要明白面试官的需求
 *             
 *  最直观的做法，从前往后扫描整个字符串，遇到空格就替换成"%20"，后面的内容需要全部后移2位 O(n)
 *  有O(n)个空格，则时间复杂度为O(n ^ 2)
 *  
 *  法2： 从后往前扫描，替换
 *    先从前往后扫描一次，统计出空格的个数，计算出替换后的字符串的总长度
 *           总长度 = 原来的总长度 + 2 * 空格的个数
 *    用两个指针，p1指向原来字符串的末尾，P2指向替换之后的字符串的末尾
 *    从后往前扫描
 *    向前移动指针P1，逐个将P1指向的字符复制到P2指向的位置，直到碰到第一个空格为止
 *     P1向前移动一个位置，在P2之前插入"%20"，P2向前移动3个位置
 *    直到P2和P1指向同一个位置，表明所有的空格都已经替换完成
 * 
 * 指针
 * @author snow
 *
 */
public class ReplaceBlank {
	/**
	 * c中直接用指针，java里面应该用char数组
	 * @param str
	 * @return
	 */
	public String replaceBlank(String str, int len){//长度已知
		if (len <= 0){
			return "";
		}
		char[] strArray = str.toCharArray();//转换成char数组  是不是动态扩容的？java字符串末尾没有\n
		int countBlank = 0;
		int P1 = len - 1;//指向原始字符串的末尾
		for (int i = 0; i < len; i++) {
			if (strArray[i] == ' '){
				countBlank++;
			}
		}
		int P2 = P1 + 2 * countBlank;//指向新字符串的末尾
		char[] newStrArray = new char[P2 + 1];//构造替换后的数组
		while (P2 >= 0){
		//只要两个指针指向相同的位置，则前面没有空格,但是还需要将前面的字符串复制到新数组中
			if (strArray[P1] != ' '){
				newStrArray[P2--] = strArray[P1--];
			} else {
				newStrArray[P2--] = '0';
				newStrArray[P2--] = '2';
				newStrArray[P2--] = '%';
				P1--;
			}
		}
		return new String(newStrArray);
	}
	
	public String replaceSpace(StringBuffer str) {
		/*StringBuffer sb = null;
		for (int i = 0, len = str.length(); i < len; i++) {
			如果直接使用StringBuffer，没有难度
		}*/
		char[] strArray = str.toString().toCharArray();//转换成char数组  是不是动态扩容的？java字符串末尾没有\n
		int countBlank = 0;
		int P1 = strArray.length - 1;//指向原始字符串的末尾
		for (int i = 0; i < P1 + 1; i++) {
			if (strArray[i] == ' '){
				countBlank++;
			}
		}
		int P2 = P1 + 2 * countBlank;//指向新字符串的末尾
		char[] newStrArray = new char[P2 + 1];//构造替换后的数组
		while (P2 >= 0){
		//只要两个指针指向相同的位置，则前面没有空格,但是还需要将前面的字符串复制到新数组中
			if (strArray[P1] != ' '){
				newStrArray[P2--] = strArray[P1--];
			} else {
				newStrArray[P2--] = '0';
				newStrArray[P2--] = '2';
				newStrArray[P2--] = '%';
				P1--;
			}
		}
		return new String(newStrArray);
    }
	public static void main(String[] args) {
		ReplaceBlank rb = new ReplaceBlank();
		System.out.println(rb.replaceSpace(new StringBuffer("i love you")));
	}
}
