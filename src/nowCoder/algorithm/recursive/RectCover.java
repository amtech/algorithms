package nowCoder.algorithm.recursive;

/**
 * 矩阵覆盖问题，实质还是斐波那契数列
 * 用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 * 
 * 第一个小矩阵，覆盖大矩阵最左边时，有两个选择，横着放和竖着放
 *   竖着放，右边还剩下，2 * (n - 1)的区域，f(n - 1)
 *   横着放，左边必定是放两个, f(n - 2)
 * @author snow
 *
 */
public class RectCover {
	public int rectCover(int target) {
		if (target <= 1){//=0时，一种方法
			return 1;
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
}
