package nowCoder.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public int[] bubbleSortMe(int[] A, int len) {
		int lastSwapPos = len, lastSwapPosTemp = len;
    	for (int i = 0; i < len; i++) {
    		lastSwapPos = lastSwapPosTemp;
			for (int j = 1; j < lastSwapPos; j++) {
				if (A[j] < A[j - 1]){//ÿ�αȽ�����ֵ������ķ��ں���
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
	 * ��ķ��ں���
	 * @param A ����������
	 * @param len ����Ԫ�س��ȣ�����,�ܹ���֤�����Ƿ�Ϊ��
	 * @return
	 */
    public int[] bubbleSort(int[] A, int len) {
    	//if (A != null){
    	for (int i = 0; i < len; i++) {
    		int temp = 0;
			for (int j = 1; j < len - i; j++) {
				if (A[j] < A[j - 1]){//ÿ�αȽ�����ֵ������ķ��ں���
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
     * ��ķ��ں���
     * ����һ��ѭ����ĳ��ɨ����û��ִ�н�������˵����ʱ�����Ѿ�ȫ�������У�������ɨ���ˡ�
     * ��ˣ�����һ����ǣ�ÿ�η����������ͱ�ǣ����ĳ��ѭ����û�б�ǣ���˵���Ѿ��������
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
				if (A[j] < A[j - 1]){//ÿ�αȽ�����ֵ������ķ��ں���
					temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
					flag = true;
				}
			}
			if (!flag){//�����һ��ɨ��û�з�����������˵������ȫ�������˳�ѭ��
				break;
			}
		}
    	System.out.println(Arrays.toString(A));
		return A;
    }
    
    /**
     * ��С�ķ���ǰ��
     * ���R[0..i]�����������䣬�ϴε�ɨ��������R[i..n]�����ϴ�ɨ��ʱ��� һ��ִ�н�����
     * λ��ΪlastSwapPos����lastSwapPos��i��n֮�䣬���ѷ���R[i..lastSwapPos]����Ҳ������ģ�
     * �����������Ҳ�ᷢ�������������´�ɨ������Ϳ�����R[i..n] ������[lastSwapPos..n]��
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
			if (lastSwapPos == lastSwapPosTemp)//˵��û�з�������
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
            return;//������³����
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