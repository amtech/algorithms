package nowCoder.basic;

public class LastLaugh {
	public static void main(String[] args) {
		System.out.println("H" + "a");//Ha
		/**
		 * 是字符型字面常量，所以执行的加法操作，而不是字符串链接操作
		 * + ""
		 */
		System.out.println('H' + 'a');//169
		System.out.printf("%c%c", 'H', 'a');
		System.out.println("2 + 2= " + 2 + 2);//2 + 2= 22
	}
}
