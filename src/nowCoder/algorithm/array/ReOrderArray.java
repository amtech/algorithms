package nowCoder.algorithm.array;

import nowCoder.algorithm.sort.Tools;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * ά������ָ�룺A,B
 * Aָ���һ��Ԫ�أ�ֻ����ƶ�
 * Bָ�����һ��Ԫ�أ�ֻ��ǰ�ƶ�
 * ����֮ǰ��A������B֮ǰ
 * ���Aָ��ż��������Bָ���������ͽ������������֣�A����ƶ�һλ��B��ǰ�ƶ�һλ
 * 
 * @author snow
 *
 */
public class ReOrderArray {
	
	public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1){
        	return;
        }
        /*
         * û�� ��֤Ԫ��֮������˳�򲻱�
         * int start = 0;
        int end = array.length - 1;
        while (start < end){
        	while (start < end && (array[start] & 0x01) != 0)
        		start++;
        	while (start < end && (array[end] & 0x01) == 0)
        		end--;
        	if (start < end){
        		swap(array, start, end);
        	}
        }*/
        //����ʹ������ð��������������ķ�������Ϊ�������㷨�����ȶ��ģ�����ı����ֵ����λ��
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2==1) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
	
	
	public static void swap(int[] arr, int index1, int index2) {
	    int temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
		ReOrderArray r = new ReOrderArray();
		r.reOrderArray(a);
		Tools.printArray(a);
	}
}
