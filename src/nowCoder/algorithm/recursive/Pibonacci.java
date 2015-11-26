package nowCoder.algorithm.recursive;

/**
 * 递归：代码简洁
 * 缺点：函数调用是有时间和空间限制的，每一次函数调用都需要在内存栈中分配空间以保存参数、返回地址、临时变量
 * 而且往栈里面压入和弹出数据都需要时间
 * 	递归中可能有很多重复的计算，对性能带来很大的负面影响
 *  本质：将一个问题分成2个或多个小问题，如果多个小问题存在相互重叠的情况，就存在重复计算
 *  还可能导致调用栈溢出，每一次函数调用在内存中分配空间，而每个进程的栈空间是有限的
 *  斐波那契递归中：重复的结点数会随着n的增大而急剧增加。时间复杂度是以n的指数的方式递增的 
 *  
 *  更快的方法是O(logn)
 * @author snow
 *
 */
public class Pibonacci {
	/**
	 * 应该从下往上计算，先计算f1，f2，然后根据前者计算f3
	 * 把已经得到的数据中间项保存起来
	 * 时间复杂度O(n)
	 * long long 
	 * @param n
	 * @return
	 */
	public int Fibonacci(int n) {
		/*int[] result = {0, 1};
		if (n < 2){
			//return result[n];
			return n <= 0 ? 0 : 1;
		}*/
		if (n < 2){
			return n <= 0 ? 0 : 1;
		}
		int fibNOne = 0;
		int fibNTwo = 1;
		int fibNN = 0;
		for (int i = 2; i <= n; i++) {
			fibNN = fibNOne + fibNTwo;
			fibNOne = fibNTwo;
			fibNTwo = fibNN;
		}
		return fibNN;
    }
	public static void main(String[] args) {
		Pibonacci pibonacci = new Pibonacci();
		System.out.println(pibonacci.Fibonacci(1));
	}
}
