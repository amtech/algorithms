package nowCoder.basic.string;

import java.util.Random;

public class BrowserTest {
	public static void main(String[] args) {
		System.out.print("iexplore:");
		/*
		 * 可以在任何语句前面防止标号
		 * http:是一个标号，后面的地址是//后的注释 所以正确
		 */
		http://www.google.com:;
		System.out.println(":maximize");
		System.out.println(new Random().nextInt(2));
	}
}
