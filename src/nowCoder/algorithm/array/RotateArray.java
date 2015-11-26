package nowCoder.algorithm.array;

/**
 * 旋转数组：将排序好的数组的前一部分，移动到末尾，有两部分排序。查找最小的元素
 *  部分排序，可以用二分查找 log(n)
 *  原数组，即移动了0个元素到后面的也是旋转数组 
 *  元素可能相同： 
 *  10111 11101     当index1，index2和indexMid指向的元素都相同时，无法确定indexMid属于哪一个递增序列
 *  		此时，只有用顺序查找
 *  
 *  使用两个指针，index1指向array[0], index2指向array[array.length - 1]   初始时
 *  中间元素>=index1，则中间元素位于第一个递增序列。最小的元素应该位于该中间元素的后面。
 *  		将index1指向该中间元素，缩小一半范围，index1任然位于第一个递增序列中
 *  中间元素<=index2,则位于第二个递增序列。最小的元素应该位于该中间元素的前面
 *  		将Index2指向该中间元素。index2任然位于第二个递增序列中
 *  
 *  第一个指针总是指向前面的递增元素，第二个指针总是指向后面的递增元素
 *  	最终：第一个指针指向前面递增元素的最后，第二个指针指向后前递增元素的第一个元素
 *    最终会指向两个相邻的元素。第二个指针指向的刚好是最小的元素    循环结束的条件
 *  
 *  第一个元素总是>=最后一个元素
 * @author snow
 *
 */
public class RotateArray {
	public int minNumberInRotateArray(int [] array) {
	    if (array == null || array.length == 0){
	    	try {
				throw new Exception("数组为空，请输入正确的数组");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return Integer.MIN_VALUE;//或者0
	    }
	    int index1 = 0;
	    int index2 = array.length - 1;//所以数组长度必须>=0
	    //如果 将数组前面的0个元素搬到后面，则第一个元素就是最小的数字，可以直接返回   这也是一个旋转数组
	    int indexMid = index1;//指向中间元素的下标
	    while (array[index1] >= array[index2]){
	    	if (index2 - index1 == 1){
	    		indexMid = index2;
	    		break;
	    	}
	    	indexMid = (index1 + index2) / 2;
	 //当index1，index2和indexMid指向的元素都相同时,无法确定indexMid属于哪一个递增序列,只能顺序查找
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
		//int[] arr = {};//当数组为空的时候，注意边界值
		//int[] arr = new int[0];
		int[] arr = {1, 0, 1, 1, 1};
		
		System.out.println(rotateArray.minNumberInRotateArray(arr));
	}
}
