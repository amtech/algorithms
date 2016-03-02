package nowCoder.algorithm.array;

import nowCoder.algorithm.sort.Tools;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 维护两个指针：A,B
 * A指向第一个元素，只向后移动
 * B指向最后一个元素，只向前移动
 * 相遇之前，A总是在B之前
 * 如果A指向偶数，并且B指向奇数，就交换这两个数字，A向后移动一位，B向前移动一位
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
         * 没有 保证元素之间的相对顺序不变
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
        //可以使用类似冒泡排序或插入排序的方法，因为这两种算法都是稳定的，不会改变数字的相对位置
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
