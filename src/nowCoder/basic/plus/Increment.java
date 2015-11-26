package nowCoder.basic.plus;

public class Increment {
	public static void main(String[] args) {
		int j = 0;
		for (int i = 0; i < 100; i++) {
			/*
			 * j = j++;
			 * 等价于：
			 * int temp = j;  先保存j的值
			 * j = j + 1; 然后将j设置为其值+1
			 * j = temp; 最后将j复位到初始值
			 * 
			 * 不要在单个表达式中对相同的变量赋值超过一次
			 */
			j = j++;
			//j = ++j; 或者  j++; 100
		}
		System.out.println(j);//0
	}
}
