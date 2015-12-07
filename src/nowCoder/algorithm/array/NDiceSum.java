package nowCoder.algorithm.array;

/**
 * n�����ӵĵ�������������Ϊ6^n
 * n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡs�����п��ܵ�ֵ���ֵĸ���
 * ˼·��
 * �������������洢���ӵ�����ÿһ���������ֵĴ���
 * 	��һ�������еĵ�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ������ټ���һ���µ����ӣ�
 * ��ʱ��Ϊn�����ӳ��ֵĴ���Ӧ�õ�����һ��ѭ�������ӵ�����Ϊn-1,n-2,n-3,n-4,n-5,n-6�Ĵ������ܺ�
 * @author snow
 *
 */
public class NDiceSum {
	private int sMaxValue = 6;//�������ӵ�������
	
	public int findNiceSum(int n, int s){
		if (s < n || s > sMaxValue * n){
			return 0;
		}else if (n == 1){
			return 1;
		}else {//���ֵݹ飬�д������ظ����㣬Ч�ʵ�
			return findNiceSum(n -1, s - 1) + findNiceSum(n -1, s - 2) + findNiceSum(n -1, s - 3) + 
					findNiceSum(n -1, s - 4) + findNiceSum(n -1, s - 5) + findNiceSum(n -1, s - 6);
		}
	}
	
	public void dice1(){
	 /*const*/ int n = 6;
	 int[] sum = new int[n * n + 1];//��ʼ��ȫΪ0
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
	
	//��dice��ֱ��ѭ����ȣ���������չ�Ժ�
	//˼·��������6��6���������Ѹ�λ���ּ�����
	public void dice2(){
	/* const*/ int n = 6;
	 int[] sum = new int[n * n + 1];
	 for(int i = (int) (Math.pow(n, n) - 1); i >= 0; i--){
	  int s = 0;
	  for(int x = i; x != 0; x /= n){
	   //��Ϊ��ѭ���Ĵ�����������6�Σ�����sҪ��ѭ������+6
	   s += x % n;
	  }
	  sum[s + 6]++;
	 }
	 /*for(int j = 0; j < DIMOF(sum); j++)
	 {
	  printf("x=%d, sum=%d\n", j, sum[j]);
	 }*/
	}
	
	public void dice3(int number){//���Ӹ���
		if (number < 1){
			return;
		}
		//������������ΪsMaxValue * number + 1������  Ĭ�϶���0
		int[][] pProbabilities = new int[2][sMaxValue * number + 1];
		int flag = 0;//��ʶ����ʹ�õ����ĸ�����
		for (int i = 1; i <= sMaxValue; i++) {
			//��һ�����ӣ������������ֵĴ�����Ϊ1
			pProbabilities[flag][i] = 1;
		}
		for (int k = 2; k <= number; k++) {
			for (int i = 0; i < k; i++) {
			//û����������ΪʲôҪ����  ��k������  k�����ӣ�������СΪk������<k�ĵ������ֵĴ���Ϊ0
				pProbabilities[1 - flag][i] = 0;
			}
			for (int i = k; i <= sMaxValue * k; i++) {//k�����ӣ���С������������֮��
				pProbabilities[1 - flag][i] = 0;//Ϊ��k�����ӵļ�������
				for (int j = 1; j <= i && j <= sMaxValue; j++) {
					//�����k�����ӣ���Ϊi�ĵ����Ĵ���
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
