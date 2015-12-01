package nowCoder.algorithm.array;

/**
 * �ҳ����������У�K���ֵĴ���(��ʱ�������п���û��K)
 * �������飺ֱ�Ӵ�ͷ��βɨ��һ�飬ʱ�临�Ӷ�O(n)
 * ����ʹ�ö��ּ��������ҵ�K
 * 	�٣��ҵ������е�һ��K
 * 		�����ǰkǰһ��ֵ����K����ǰK�ǵ�һ��K
 * 		���򣺵�һ����λ��end = index(K-1)��ǰ���
 * 		�ݹ飬�ҵ���һ��K
 *  �ڣ��ҵ����������һ��K
 * @author snow
 *
 */
public class GetNumOfK {
	/*
	 * ����ٶ�������������Ŀռ�ȫ��������, length=size
	 * ���򣬻���Ҫһ����������ʶ��������ʹ�õ����ݿռ�
	 * k�п��ܲ�����
	 */
	public int GetNumberOfK(int[] array , int k) {
	    int number = 0;//��������ڣ�����ĿΪ0
	    int first = getFirstK(array, k, 0, array.length - 1);
	    int last = getLastK(array, k, 0, array.length - 1);
	    if (first > -1 && last > -1){
	    	//�����ܳ�������һ����-1����һ�����ǵ����
	    	number = last - first + 1;
	    }
		return number;
    }
	
	public int getFirstK(int[] arr, int k, int start, int end){
		if (start > end){//k������
			return -1;
		}
		int middleIndex = (start + end) / 2;
		int middleData = arr[middleIndex];
		if (middleData == k){
			//�ж��ǲ��ǵ�һ��k
			if (middleIndex > start && arr[middleIndex - 1] != k 
					|| middleIndex == start){
				return middleIndex;
			}else {
				end = middleIndex - 1;
			}
		}else if (middleData > k){
			 end = middleIndex - 1;
		}else {
			start = middleIndex + 1;
		}
		return getFirstK(arr, k, start, end);//�ݹ����
	}
	
	public int getLastK(int[] arr, int k, int start, int end){
		if (start > end){//k������
			return -1;
		}
		int middleIndex = (start + end) / 2;
		int middleData = arr[middleIndex];
		if (middleData == k){
			//�ж��ǲ������һ��k
			if (middleIndex < end && arr[middleIndex + 1] != k 
					|| middleIndex == end){
				return middleIndex;
			}else {
				start = middleIndex + 1;
			}
		}else if (middleData < k){
			start = middleIndex + 1;
		}else {
			end = middleIndex - 1;
		}
		return getLastK(arr, k, start, end);//�ݹ����
	}
	public static void main(String[] args) {
		GetNumOfK get = new GetNumOfK();
		int[] arr = new int[]{1, 2, 3,3,3,3, 4, 5};
		System.out.println(arr.length);//8
		System.out.println(get.GetNumberOfK(arr, 3));
		System.out.println(get.getFirstK(arr, 3, 0, 7));//2
		System.out.println(get.getLastK(arr, 3, 0, 7));//5
	}
}
