package nowCoder.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public int[] bubbleSortMe(int[] A, int len) {
		int lastSwapPos = len, lastSwapPosTemp = len;
    	for (int i = 0; i < len; i++) {
    		lastSwapPos = lastSwapPosTemp;
			for (int j = 1; j < lastSwapPos; j++) {
				if (A[j] < A[j - 1]){//每次比较两个值，将大的放在后面
					Tools.swap(A, j, j - 1);
					lastSwapPosTemp = j;
				}
			}
			if (lastSwapPos == lastSwapPosTemp){
				break;
			}
		}
    	System.out.println(Arrays.toString(A));
		return A;
    }
	/**
	 * 大的放在后面
	 * @param A 带排序数组
	 * @param len 数组元素长度，个数,能够验证数组是否为空
	 * @return
	 */
    public int[] bubbleSort(int[] A, int len) {
    	//if (A != null){
    	for (int i = 0; i < len; i++) {
    		int temp = 0;
			for (int j = 1; j < len - i; j++) {
				if (A[j] < A[j - 1]){//每次比较两个值，将大的放在后面
					temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				}
			}
		}
    	System.out.println(Arrays.toString(A));
		return A;
    }
    
    /**
     * 大的放在后面
     * 里面一层循环在某次扫描中没有执行交换，则说明此时数组已经全部有序列，无需再扫描了。
     * 因此，增加一个标记，每次发生交换，就标记，如果某次循环完没有标记，则说明已经完成排序
     * @param A
     * @param len
     * @return
     */
    public int[] bubbleSort2(int[] A, int len) {
    	boolean flag = true;
    	for (int i = 0; i < len; i++) {
    		flag = false;
    		int temp = 0;
			for (int j = 1; j < len - i; j++) {
				if (A[j] < A[j - 1]){//每次比较两个值，将大的放在后面
					temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
					flag = true;
				}
			}
			if (!flag){//如果上一次扫描没有发生交换，则说明数组全部有序，退出循环
				break;
			}
		}
    	System.out.println(Arrays.toString(A));
		return A;
    }
    
    /**
     * 将小的放在前面
     * 如果R[0..i]已是有序区间，上次的扫描区间是R[i..n]，记上次扫描时最后 一次执行交换的
     * 位置为lastSwapPos，则lastSwapPos在i与n之间，不难发现R[i..lastSwapPos]区间也是有序的，
     * 否则这个区间也会发生交换；所以下次扫描区间就可以由R[i..n] 缩减到[lastSwapPos..n]。
     * @param A
     * @param len
     * @return
     */
    public int[] bubbleSort3(int[] A, int size) {
    	int lastSwapPos = 0,lastSwapPosTemp = 0;  
        for (int i = 0; i < size - 1; i++)  
        {  
            lastSwapPos = lastSwapPosTemp;  
            for (int j = size - 1; j >lastSwapPos; j--)  
            {  
                if (A[j - 1] > A[j])  
                {  
                    int temp = A[j - 1];  
                    A[j - 1] = A[j];  
                    A[j] = temp;  
      
                    lastSwapPosTemp = j;  
                }  
            }  
			if (lastSwapPos == lastSwapPosTemp)//说明没有发生交换
	            break; 
		}
    	System.out.println(Arrays.toString(A));
		return A;
    }
    public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] a = {1, 2, 3, 5, 2, 3};
		//int[] a = {};
		bs.bubbleSortMe(a, 6);
	}
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;//检查代码鲁棒性
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Tools.swap(arr, j, j + 1);
                }
            }
        }
    }
    
}