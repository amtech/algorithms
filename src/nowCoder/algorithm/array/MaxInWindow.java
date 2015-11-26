package nowCoder.algorithm.array;

import java.util.ArrayList;

public class MaxInWindow {
	ArrayList<Integer> maxList = new ArrayList<Integer>();
	/**
	 * 数组为[4,3,5,4,3,3,6,7] size为3
	 * 一共产生n-w+1个窗口的最大值
	 * 555467
	 * @param num
	 * @param size
	 * @return
	 */
	public ArrayList<Integer> maxInWindows(int[] num, int size){
        if (num == null || size < 0 || num.length < size){
        	return maxList;//当num.length < size是否算一个窗口，此时最大值是数组中的最大值
        }
        return maxList;
    }
}
