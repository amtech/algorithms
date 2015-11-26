package nowCoder.basic;

public class AnimalFarm {
	public static void main(String[] args) {
		final String pig = "length: 10";
		final String dog = "length: " + pig.length();//调用了方法，不是常量表达式
		/*
		 * 如果用常量表达式来初始化pig和dog，确实会指向相同的对象
		 * +操作符，无论是用作加法还是字符串连接操作，优先级都比==操作符高
		 * 下面等价于
		 * ("Animals are equeals: " +  pig) == dog
		 * 所以只输出了一个false
		 * 当使用字符串连接操作符是，总是将非平凡的操作符用()括起来
		 * (pig == dog)
		 */
		System.out.println("Animals are equeals: " +  pig == dog);//只有false，没有前面的字符串
	}
}
