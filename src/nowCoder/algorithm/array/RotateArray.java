package nowCoder.algorithm.array;

/**
 * ��ת���飺������õ������ǰһ���֣��ƶ���ĩβ�������������򡣲�����С��Ԫ��
 *  �������򣬿����ö��ֲ��� log(n)
 *  ԭ���飬���ƶ���0��Ԫ�ص������Ҳ����ת���� 
 *  Ԫ�ؿ�����ͬ�� 
 *  10111 11101     ��index1��index2��indexMidָ���Ԫ�ض���ͬʱ���޷�ȷ��indexMid������һ����������
 *  		��ʱ��ֻ����˳�����
 *  
 *  ʹ������ָ�룬index1ָ��array[0], index2ָ��array[array.length - 1]   ��ʼʱ
 *  �м�Ԫ��>=index1�����м�Ԫ��λ�ڵ�һ���������С���С��Ԫ��Ӧ��λ�ڸ��м�Ԫ�صĺ��档
 *  		��index1ָ����м�Ԫ�أ���Сһ�뷶Χ��index1��Ȼλ�ڵ�һ������������
 *  �м�Ԫ��<=index2,��λ�ڵڶ����������С���С��Ԫ��Ӧ��λ�ڸ��м�Ԫ�ص�ǰ��
 *  		��Index2ָ����м�Ԫ�ء�index2��Ȼλ�ڵڶ�������������
 *  
 *  ��һ��ָ������ָ��ǰ��ĵ���Ԫ�أ��ڶ���ָ������ָ�����ĵ���Ԫ��
 *  	���գ���һ��ָ��ָ��ǰ�����Ԫ�ص���󣬵ڶ���ָ��ָ���ǰ����Ԫ�صĵ�һ��Ԫ��
 *    ���ջ�ָ���������ڵ�Ԫ�ء��ڶ���ָ��ָ��ĸպ�����С��Ԫ��    ѭ������������
 *  
 *  ��һ��Ԫ������>=���һ��Ԫ��
 * @author snow
 *
 */
public class RotateArray {
	public int minNumberInRotateArray(int [] array) {
	    if (array == null || array.length == 0){
	    	try {
				throw new Exception("����Ϊ�գ���������ȷ������");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return Integer.MIN_VALUE;//����0
	    }
	    int index1 = 0;
	    int index2 = array.length - 1;//�������鳤�ȱ���>=0
	    //��� ������ǰ���0��Ԫ�ذᵽ���棬���һ��Ԫ�ؾ�����С�����֣�����ֱ�ӷ���   ��Ҳ��һ����ת����
	    int indexMid = index1;//ָ���м�Ԫ�ص��±�
	    while (array[index1] >= array[index2]){
	    	if (index2 - index1 == 1){
	    		indexMid = index2;
	    		break;
	    	}
	    	indexMid = (index1 + index2) / 2;
	 //��index1��index2��indexMidָ���Ԫ�ض���ͬʱ,�޷�ȷ��indexMid������һ����������,ֻ��˳�����
	    	if (array[index1] == array[index2] && array[indexMid] == array[index1]){
	    		return MinInOrder(array, index1, index2);
	    	}
	    	if (array[indexMid] >= array[index1]){
	    		index1 = indexMid;
	    	} else if (array[indexMid] <= array[index2]){
	    		index2 = indexMid;
	    	}
	    }
	    return array[indexMid];
    }

	private int MinInOrder(int[] array, int index1, int index2) {
		int result = array[index1];
		for (int i = index1 + 1; i <= index2; i++) {
			if (result > array[i]){
				result = array[i];
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		//int[] arr = {3, 4, 5, 1, 2};
		//int[] arr = {3, 4, 5, 1, 2, 2, 3};
		//int[] arr = {};//������Ϊ�յ�ʱ��ע��߽�ֵ
		//int[] arr = new int[0];
		int[] arr = {1, 0, 1, 1, 1};
		
		System.out.println(rotateArray.minNumberInRotateArray(arr));
	}
}
