package nowCoder.algorithm.recursive;

/**
 * 跳台阶问题:一只青蛙一次可以跳一级台阶，也可以跳两级台阶，求该青蛙跳上n级台阶公有多少种跳法 
 * 如果有两级台阶，有两种跳法：
 * 	1、分两次跳，每次跳一级
 * 	2、一次跳两级
 * 把n级台阶看作是n的函数，f(n)
 * 当n>2时，第一次有两种选择：
 * 	 一次只跳一级，此时跳法数目=后面的n-1级台阶的跳法数目f(n - 1)
 * 	第一次跳两节，跳法数目=后面的n-2级台阶的跳法数目f(n - 2)
 * f(n) = f(n - 1) + f (n - 2)     斐波那契数列
 * @author snow
 *
 */
public class JumpSteps {
	//这个是从1开始的，不是从0
	public int JumpFloor(int target) {
		if (target <= 1){
			return target <= 0 ? 0 : 1;
		}
		int fibNOne = 1;
		int fibNTwo = 1;
		int fibNN = 0;
		for (int i = 2; i <= target; i++) {
			fibNN = fibNOne + fibNTwo;
			fibNOne = fibNTwo;
			fibNTwo = fibNN;
		}
		return fibNN;
    }
	public static void main(String[] args) {
		JumpSteps jumpSteps = new JumpSteps();
		System.out.println(jumpSteps.JumpFloor(2));
	}
}
