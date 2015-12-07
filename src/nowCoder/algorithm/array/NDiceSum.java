package nowCoder.algorithm.array;

/**
 * n个骰子的点数：总排列数为6^n
 * n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印s的所有可能的值出现的概率
 * 思路：
 * 用两个数组来存储骰子点数的每一个总数出现的次数
 * 	第一个数组中的第n个数字表示骰子和为n出现的次数，再加上一个新的骰子，
 * 此时和为n的骰子出现的次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5,n-6的次数的总和
 * @author snow
 *
 */
public class NDiceSum {
	private int sMaxValue = 6;//单个骰子的最大点数
	
	public int findNiceSum(int n, int s){
		if (s < n || s > sMaxValue * n){
			return 0;
		}else if (n == 1){
			return 1;
		}else {//这种递归，有大量的重复计算，效率低
			return findNiceSum(n -1, s - 1) + findNiceSum(n -1, s - 2) + findNiceSum(n -1, s - 3) + 
					findNiceSum(n -1, s - 4) + findNiceSum(n -1, s - 5) + findNiceSum(n -1, s - 6);
		}
	}
	
	public void dice1(){
	 /*const*/ int n = 6;
	 int[] sum = new int[n * n + 1];//初始化全为0
	 for(int i = 1; i <= n; i++) {
	  for(int j = 1; j <= n; j++){
	   for(int k = 1; k <= n; k++){
	    for(int x = 1; x <= n; x++){
	     for(int y = 1; y <= n; y++){
	      for(int z = 1; z <= n; z++){
	    	  sum[i + j + k + x + y + z]++;
	      }
	     }
	    }
	   }
	  }
	 }
	}
	
	//与dice的直接循环相比，本函数扩展性好
	//思路：看做是6个6进制数，把各位数字加起来
	public void dice2(){
	/* const*/ int n = 6;
	 int[] sum = new int[n * n + 1];
	 for(int i = (int) (Math.pow(n, n) - 1); i >= 0; i--){
	  int s = 0;
	  for(int x = i; x != 0; x /= n){
	   //因为本循环的次数可能少于6次，所以s要在循环外面+6
	   s += x % n;
	  }
	  sum[s + 6]++;
	 }
	 /*for(int j = 0; j < DIMOF(sum); j++)
	 {
	  printf("x=%d, sum=%d\n", j, sum[j]);
	 }*/
	}
	
	public void dice3(int number){//骰子个数
		if (number < 1){
			return;
		}
		//申请两个长度为sMaxValue * number + 1的数组  默认都是0
		int[][] pProbabilities = new int[2][sMaxValue * number + 1];
		int flag = 0;//标识到底使用的是哪个数组
		for (int i = 1; i <= sMaxValue; i++) {
			//第一个骰子，各个点数出现的次数都为1
			pProbabilities[flag][i] = 1;
		}
		for (int k = 2; k <= number; k++) {
			for (int i = 0; i < k; i++) {
			//没看懂，这里为什么要清零  第k个骰子  k个骰子，点数最小为k，所以<k的点数出现的次数为0
				pProbabilities[1 - flag][i] = 0;
			}
			for (int i = k; i <= sMaxValue * k; i++) {//k个骰子，最小点数和最大点数之间
				pProbabilities[1 - flag][i] = 0;//为第k个骰子的计算清零
				for (int j = 1; j <= i && j <= sMaxValue; j++) {
					//计算第k个骰子，和为i的点数的次数
					pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
				}
			}
			flag = 1 - flag;
		}
		double total = Math.pow(sMaxValue, number);
		for (int i = number; i <= sMaxValue * number; i++) {
			double ratio = (double) pProbabilities[flag][i] / total;
			System.out.printf("%d: %e\n", i, ratio);
		}
	}
	public static void main(String[] args) {
		NDiceSum sum = new NDiceSum();
		sum.dice3(3);
	}
}
