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
		switch(rand.nextInt(2)){//0��1
			case 1: word = new StringBuffer('P');
			case 2: word = new StringBuffer('G');
			default: word = new StringBuffer('M');
			/*
			 * ÿ��case��û��break�����wordʼ����default���ᱻ����
			 * StringBuffer��������
			 * 1���޲ι�����
			 * 2��String��Ϊ�ַ�����������ʼ����
			 * 3��int��Ϊ��������ʼ����
			 * 
			 * �ַ����泣�� 'M'���ᱻת����int 77
			 * ���ص��Ǿ��г�ʼ����77�Ŀյ��ַ�����������������ain�����Խ��Ϊain
			 * 
			 * char����int����������String
			 */
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word);
		/**
		 * ����������  "ain"
		 */
	}
	
	public void rhymes2(){
		StringBuffer word = null;
		switch(rand.nextInt(3)){//0��1��2
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
		 * ����������  "ain"
		 */
	}
	public void rhymes3(){
		System.out.println("PGM".charAt(rand.nextInt(3)) + "ain");
	}
	public void rhymes4(){//���õİ汾����������ֻ�е�һ���ַ���ͬ����ʵ������ͨ��
		String[] str = {"Main", "Pain", "Gain"};
		System.out.println(str[rand.nextInt(str.length)]);
	}
}	
