package nowCoder.basic;

import java.io.UnsupportedEncodingException;

public class StringCheese {
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = new byte[256];
		for (int i = 0; i < 255; i++) {
			bytes[i] = (byte) i;//可能是负数
		}
		/*这里采用的平台默认的字符集；win是GBK 
		 * byte数值通过new String()转换成了char数值
		 * char是无符号的，没有负数
		*/
		String str = new String(bytes);
		String str1 = new String(bytes, "ISO-8859-1");//指定字符集，输出就是0~255
		
		//System.out.println(str);
		for (int i = 0, n = bytes.length; i < n; i++) {
			/**
			 * 在不同机器上运行，会产生不同的序列，有时不能正常终止，行为完全不确定
			 * Str长度是字符集的一个函数，可能不等于byte数组的长度
			 */
			//System.out.println((int)str/*1*/.charAt(i) + " ");
		}
		System.out.println(java.nio.charset.Charset.defaultCharset());//GBK
	}
}
