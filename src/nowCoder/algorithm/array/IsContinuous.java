package nowCoder.algorithm.array;

import java.util.Arrays;

/**
 * �˿��Ƶ�˳��
 * ����������ȡ��5�ţ��ж��ǲ���һ��˳�ӣ�����������С�����Կ��������������(������0)
 * ˼·��
 * 	��ֱ�۵ķ����ǽ�������������0���Ե������κε����֣����Խ�0ȥ���������еĿ�ȱ
 *  �٣�����������
 *  �ڣ�ͳ��������0�ĸ���
 *  �ۣ�ͳ������֮�����������������֮��Ŀ�ȱ����
 *  �ܣ������ȱ����<=0�ĸ��������������ģ���֮�ǲ�������
 *  �ݣ������0�����ظ����֣�Ҳ�ǲ������ģ�����Ƕ��ӣ�����˳����
 * 
 * @author snow
 *
 */
public class IsContinuous {
	
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 5){ //����Ҳ�ô��ڵ���5��
			return false;//���������null��Ҳ����ʹ����Ϊ0��[]
		}
		/*
		 * ���ţ���O(nlogn),�����˿��Ƶ�ֵ����0~13֮�䣬
		 * ���Զ���һ������Ϊ14��hash���Ϳ�����O(n)���������
		 * ͨ����Ϊ��ͬ�����ʱ�临�Ӷȣ�ֻ����n�㹻��ʱ��������
		 */
		Arrays.sort(numbers);
		int numOfZero = 0;//0�ĸ���
		int numOfGap = 0;//��ȱ�ĸ���
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			numOfZero++;//�����ٸ�if
		}
		//System.out.println(numOfZero);
		//ͳ�������м������Ŀ
		int small = numOfZero;//0�϶���������ǰ���
		int big = small + 1;
		while (big < numbers.length){//�±��0��ʼ
			//��������ȣ��ж��ӣ��Ͳ�������˳��
			if (numbers[small] == numbers[big]){
				return false;
			}
			numOfGap += numbers[big] - numbers[small] - 1;
			small = big;
			big++;
		}
		return (numOfZero >= numOfGap) ? true : false;
    }
	public static void main(String[] args) {
		int[] arr = new int[]{};
		System.out.println(arr.length);//���ﳤ��Ϊ0��
		IsContinuous is = new IsContinuous();
		boolean flag = is.isContinuous(arr);
		System.out.println(flag);
	}
}
