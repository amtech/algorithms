package nowCoder.algorithm.array;

/**
 * ��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7�� 
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * 
 * ����ֻ�ܱ�2��3��5����
 * ���һ�����ܱ�2�������Ͱ���������2��  3��5ͬ��
 * �������õ�1�����ǳ���
 * @author snow
 *
 */
public class UglyNumber {
	
	
	/**
	 * ��1������ֻ�ܱ�2��3��5����
	 * ���һ�����ܱ�2�������Ͱ���������2��  3��5ͬ��
	 * �������õ�1�����ǳ���
	 */
	public boolean isUglyNumber(int n){
		while (n % 2 == 0){
			n = n / 2;
		}
		while (n % 3 == 0){
			n = n / 3;
		}
		while (n % 5 == 0){
			n = n / 5;
		}
		return (n == 1) ? true : false;
	}
	
	/* ����˳���ж�ÿ�����ǲ��ǳ���  1�ǵ�һ������*/
	public int getUglyNum(int index){//�ڶ��ٸ�����
		if (index <= 0)
			return 0;
		int uglyFound = 0;//Ŀǰ�����ĸ���
		int number = 0;//��ǰ����ֵ
		while (uglyFound < index){
			//��������ж�ǰ�棬�����ж��ǳ����ˣ���+��1
			number++;
			if (isUglyNumber(number)){
				uglyFound++;
			}
		}
		return number;
	}
	
	/**
	 * ��2���������鱣���Ѿ��ҵ��ĳ������ÿռ任ʱ��
	 * 1500������ÿ��int4�ֽڣ���6kb�ĸ����ռ�
	 * ����Ӧ������һ������*2��3��5�Ľ����1����
	 * ����һ�����飬ȷ�����������������õĳ���
	 * 		���������ź�������ĳ���ΪM
	 * ��һ��������Ӧ���������е���*2��3��5�Ľ������õ����ɸ�<=M�Ľ����
	 * 		<=M�����Ѿ����������ˣ�����Ҫ���ǣ���Ҫ����ÿ��*2,3,5�е�һ��>M��������ΪM2, M3, M5
	 * ��һ��������Ӧ������3�����У���С���Ǹ�
	 * 
	 * û�б�Ҫÿ�ζ������еĳ���*2��3��5
	 * ���磺*2����Ȼ����ĳ����T2��֮ǰ����*2 <=M ,T2 * 2 > M
	 * ��¼���T2����Ϊ֮ǰ�������Ѿ�����Ҫ��*2��
	 * ÿ�������µĳ�����ʱ�򣬸���T2,T3,T5
	 * @param args
	 */
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		int[] uglyNumers = new int[index];
		uglyNumers[0] = 1;//��һ��������1
		int nextUglyIndex = 1;
		int T2, T3, T5;
		T2 = T3 = T5 = 0;
		while (nextUglyIndex < index){
			int min = min(uglyNumers[T2] * 2, uglyNumers[T3] * 3, uglyNumers[T5] * 5);
			uglyNumers[nextUglyIndex] = min;
			while (uglyNumers[T2] * 2 <= min)
				T2++;
			while (uglyNumers[T3] * 3 <= min)
				T3++;
			while (uglyNumers[T5] * 5 <= min)
				T5++;
			nextUglyIndex++;
		}
		
        return uglyNumers[nextUglyIndex - 1];
    }
	
	public int min(int num1, int num2, int num3){
		int min = (num1 < num2) ? num1 : num2;
		return (min < num3) ? min : num3;
	}
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		System.out.println(un.getUglyNum(1));
		System.out.println(un.isUglyNumber(1));
		System.out.println(un.GetUglyNumber_Solution(5));
	}
}
