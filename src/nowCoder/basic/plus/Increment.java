package nowCoder.basic.plus;

public class Increment {
	public static void main(String[] args) {
		int j = 0;
		for (int i = 0; i < 100; i++) {
			/*
			 * j = j++;
			 * �ȼ��ڣ�
			 * int temp = j;  �ȱ���j��ֵ
			 * j = j + 1; Ȼ��j����Ϊ��ֵ+1
			 * j = temp; ���j��λ����ʼֵ
			 * 
			 * ��Ҫ�ڵ������ʽ�ж���ͬ�ı�����ֵ����һ��
			 */
			j = j++;
			//j = ++j; ����  j++; 100
		}
		System.out.println(j);//0
	}
}
