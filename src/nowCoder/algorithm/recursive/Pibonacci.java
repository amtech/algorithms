package nowCoder.algorithm.recursive;

/**
 * �ݹ飺������
 * ȱ�㣺������������ʱ��Ϳռ����Ƶģ�ÿһ�κ������ö���Ҫ���ڴ�ջ�з���ռ��Ա�����������ص�ַ����ʱ����
 * ������ջ����ѹ��͵������ݶ���Ҫʱ��
 * 	�ݹ��п����кܶ��ظ��ļ��㣬�����ܴ����ܴ�ĸ���Ӱ��
 *  ���ʣ���һ������ֳ�2������С���⣬������С��������໥�ص���������ʹ����ظ�����
 *  �����ܵ��µ���ջ�����ÿһ�κ����������ڴ��з���ռ䣬��ÿ�����̵�ջ�ռ������޵�
 *  쳲������ݹ��У��ظ��Ľ����������n��������������ӡ�ʱ�临�Ӷ�����n��ָ���ķ�ʽ������ 
 *  
 *  ����ķ�����O(logn)
 * @author snow
 *
 */
public class Pibonacci {
	/**
	 * Ӧ�ô������ϼ��㣬�ȼ���f1��f2��Ȼ�����ǰ�߼���f3
	 * ���Ѿ��õ��������м��������
	 * ʱ�临�Ӷ�O(n)
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
