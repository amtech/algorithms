package nowCoder.algorithm.array;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 *  n = (int) (Math.pow(n, 2)+n)>>1;
 *  ②：bool a[n][n+1];
       return sizeof(a)>>1;
 * 
 * 有构造函数，虚函数，模版类等各种方法c++，详见<<剑指offer>>
 * @author snow
 *
 */
public class Sum {
	
	/*
	 * 利用构造函数：
	 * 定义一个类，然后在构造函数里面N++,sum+=n
	 * 然后创建一个长度为N的此类型的数组，就会调用构造函数N次，完成累加
	 */
	public int sum(int n) {
        Temp[] temp = new Temp[n];//这里只是申请了空间，并没有调用构造函数
        return temp[n-1].getSum();
    }
	
	/*public int Sum_Solution(int n) {
        int ans = n;
        //递归，当ans为0时，递归结束，利用短路运算,但是java中int和int并不支持&&
        ans && (ans += Sum_Solution(n - 1));
        return ans;
    }
    
    */
	
	public int Sum_Solution(int n) {
        int sum = n;
        //利用短路运算，递归结束，后面的判断随便写一个就可以。虽然是横为真的
        boolean flag = (n>0) && ((sum += Sum_Solution(n-1)) >0 );
        return sum;
    }
	
	public static void main(String[] args) {
		Sum s = new Sum();
		System.out.println(s.sum(10));
	}
}
class Temp{
	private static int n = 0;//只初始化一次
	private static int sum = 0;
	public Temp(){
		n++;
		sum += n;
	}
	public int getSum(){
		return sum;
	}
}
