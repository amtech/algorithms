package nowCoder.algorithm.array;

/**
 * 找出排序数组中，K出现的次数(此时，数组中可能没有K)
 * 无序数组：直接从头到尾扫描一遍，时间复杂度O(n)
 * 排序：使用二分检索，查找到K
 * 	①：找到数组中第一个K
 * 		如果当前k前一个值不是K，则当前K是第一个K
 * 		否则：第一个ｋ位于end = index(K-1)的前半段
 * 		递归，找到第一个K
 *  ②：找到数组中最后一个K
 * @author snow
 *
 */
public class GetNumOfK {
	/*
	 * 这里假定数组中所申请的空间全部存数据, length=size
	 * 否则，还需要一个参数，标识数组中已使用的数据空间
	 * k有可能不存在
	 */
	public int GetNumberOfK(int[] array , int k) {
	    int number = 0;//如果不存在，则数目为0
	    int first = getFirstK(array, k, 0, array.length - 1);
	    int last = getLastK(array, k, 0, array.length - 1);
	    if (first > -1 && last > -1){
	    	//不可能出现其中一个是-1，另一个不是的情况
	    	number = last - first + 1;
	    }
		return number;
    }
	
	public int getFirstK(int[] arr, int k, int start, int end){
		if (start > end){//k不存在
			return -1;
		}
		int middleIndex = (start + end) / 2;
		int middleData = arr[middleIndex];
		if (middleData == k){
			//判断是不是第一个k
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
		return getFirstK(arr, k, start, end);//递归调用
	}
	
	public int getLastK(int[] arr, int k, int start, int end){
		if (start > end){//k不存在
			return -1;
		}
		int middleIndex = (start + end) / 2;
		int middleData = arr[middleIndex];
		if (middleData == k){
			//判断是不是最后一个k
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
		return getLastK(arr, k, start, end);//递归调用
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
