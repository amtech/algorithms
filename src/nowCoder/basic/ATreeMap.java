package nowCoder.basic;

import java.util.TreeSet;

public class ATreeMap {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(3);
		set.add(4);
		set.add(1);
		set.add(6);
		for (Integer integer : set) {
			System.out.print(integer);//1346
		}
		System.out.println("  " + set.first() + set.last());//1����һ��Ԫ������С��,���һ����6���
	}
}
