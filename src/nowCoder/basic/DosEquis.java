package nowCoder.basic;

public class DosEquis {
	public static void main(String[] args) {
		char x = 'X';
		int i = 0;
		System.out.print(true ? x : 0);//x   int常量0，可以表示成char
		System.out.print(false ? i : x);//88  int变量i，二进制提升，被提升后的类型是int
		/**
		 * 每个表达式第二个和第三个操作数的类型不同
		 * 混合类型的计算会引起混乱
		 * 如果一个操作数的类型是T:byte, short,char另一个是int类型的常量表达式，值可以用T表示
		 * 		结果就是T类型
		 * 否则，就进行二进制的提升，类型是两个操作数被提升之后 的类型
		 * 
		 * 最好使用类型相同的第二和第三操作数
		 * 表达式的类型，将确定哪一个重载的print方法将会被调用
		 * PrintStream.print(char)
		 */
	}
}
