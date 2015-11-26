package nowCoder.basic.string;

import java.util.Random;

public class Rhymes {
	private static Random rand = new Random();
	public static void main(String[] args) {
		Rhymes rhymes = new Rhymes();
		rhymes.rhymes1();
		rhymes.rhymes2();
		rhymes.rhymes3();
	}
	
	public void rhymes1(){
		StringBuffer word = null;
		switch(rand.nextInt(2)){//0、1
			case 1: word = new StringBuffer('P');
			case 2: word = new StringBuffer('G');
			default: word = new StringBuffer('M');
			/*
			 * 每个case中没有break，结果word始终是default，会被覆盖
			 * StringBuffer构造器：
			 * 1、无参构造器
			 * 2、String作为字符串缓冲区初始内容
			 * 3、int作为缓冲区初始容量
			 * 
			 * 字符字面常量 'M'，会被转换成int 77
			 * 返回的是具有初始容量77的空的字符串缓冲区，随后加入ain。所以结果为ain
			 * 
			 * char更像int，而不是像String
			 */
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word);
		/**
		 * 输出结果总是  "ain"
		 */
	}
	
	public void rhymes2(){
		StringBuffer word = null;
		switch(rand.nextInt(3)){//0、1、2
			case 1: word = new StringBuffer("P");
				break;
			case 2: word = new StringBuffer("G");
				break;
			default: word = new StringBuffer("M");
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word);
		/**
		 * 输出结果总是  "ain"
		 */
	}
	public void rhymes3(){
		System.out.println("PGM".charAt(rand.nextInt(3)) + "ain");
	}
	public void rhymes4(){//更好的版本，不依赖于只有第一个字符不同的事实、更加通用
		String[] str = {"Main", "Pain", "Gain"};
		System.out.println(str[rand.nextInt(str.length)]);
	}
}	
