package nowCoder.algorithm.array;

/**
 * �ҵ�������ֻ����һ�ε�����
 * һ���������飬������������֮�⣬���������ֶ�����������
 * �ȿ���������ֻ��һ�����ֳ���һ�Σ������Ķ��������Σ�
 *  ������㣺�κ�һ����������Լ�������0����ͷ��β���һ��O(n),���յĽ�����ǳ���һ�ε�����
 * ���������ֳ�����һ�Σ�
 * 		������ֳ����������飬ÿһ���������а���һ������һ�ε�����
 * 	�٣���ͷ��β������ս��������ֻ����һ�ε��������Ľ������Ϊ��ͬ�����Զ������бض���һλ��1
 *  �ڣ��ҵ���һ��Ϊ1�Ķ�����λ�����Ϊn���Ե�nλ�ǲ���1�������Ϊ����������(1,0)
 *  �ۣ��������ε����ֿ϶�����ͬһ���������У���nλһ����ͬ
 *  �ܣ��ٶ�ÿһ�������������򣬵õ����
 *  
 *  ���Ӧ��java���޷������͵�ȱʧ��http://www.tuicool.com/articles/7VRBZj
 *  Java �е� byte ��Զ�� 1 �ֽڣ� short �� 2 �ֽڣ� int �� 4 �ֽڣ� long �� 8 �ֽڡ�
 *  ʹ�ñ�Ҫ�õ��޷������͸�����з�������
 *  ʹ�� short �������޷��ŵ��ֽڣ�ʹ�� long �������޷��������ȣ���������ʹ�� char �������޷��Ŷ����ͣ���
 *  ȷʵ���������������˷ѣ���Ϊ��ʹ���� 2 ���Ĵ洢�ռ䣬����Ҳû�и��õİ취�ˡ����⣬��Ҫ���ѵ��ǣ�
 *  ���� long ���ͱ����ķ��ʲ���ԭ���Բ��������ԣ�����ڶ��̳߳����У�����Լ�ȥ����ͬ�������⡣
 * @author snow
 *
 */
public class FindNumsAppearOnce {
	
	/**
	 * ������������֮�⣬���������ֶ�����������
	 * num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
     * ��num1[0],num2[0]����Ϊ���ؽ��
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]){
		if (array == null || array.length < 2){
			return;
		}
		int resultExclusiveOR = 0;//���������
		for (int i = 0; i < array.length; i++) {
			resultExclusiveOR ^= array[i];
		}
		//System.out.println(resultExclusiveOR);
		//�ҵ��������ƽ���д����ұ����һ��Ϊ1��λ
		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		//System.out.println(indexOf1 + " indexOf1");//2
		num1[0] = num2[0] = 0;
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], indexOf1) == 1){
		//��ʹ������ֻ����һ�ε�����0��0���֮����0���������õĳ�ʼ��ֵ��Ӱ����
				num1[0] ^= array[i];
			}else {
				num2[0] ^= array[i];
			}
		}
	}
	
	/**
	 * ��num�Ķ����Ʊ�ʾ�У��ҵ����ұ���1��λ
	 * num����Ϊ0�������0indexBitλ0
	 * 0ԭ����00000000 
	   -0ԭ����10000000 
	   
	   0������00000000 
	   -0������11111111 
	
	  0������00000000 
	    ����û����0�븺0֮�֡�
	 * @param num
	 * @return
	 */
	public /*unsigned*/ int findFirstBitIs1(int num){
		if (num == 0){
			return 0;
		}
		int indexBit = 1;
		while ((num & 1) == 0 && indexBit <= 32){
			num = num >> 1;
			indexBit++;
		}
		return indexBit;
	}
	
	/*
	 * ����num�Ķ����Ʊ�ʾ�У��жϴ��ұ������indexBitλ�ǲ���1
	 * �ұ����һλ���������ұ���λ������Ҫ���ƣ�������indexBit -1
	 * indexBitӦ����һ���޷���int�ģ�����java�����������Ͷ����з��ŵ�
	 * �����Զ������װһ��
	 * ����int4�ֽڣ�32λ��int�ı�ʾ��Χ�ڣ�ֻ��Ҫ�Լ��жϼ���
	 */
	public int isBit1(int num,/*unsigned*/ int indexBit){
		if (indexBit > 0){
			num = num >> (indexBit - 1);
			return (num & 1);//true
		}
		return 0;//false
	}
	
	public static void main(String[] args) {
		FindNumsAppearOnce find = new FindNumsAppearOnce();
		//System.out.println(find.findFirstBitIs1(0));
		//System.out.println(0 == -0);//true
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		find.findNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);
		System.out.println(num1[0] + " " + num2[0]);
		//System.out.println(4 ^ 6);//2
	}
}
