package nowCoder.algorithm.array;

import java.util.ArrayList;

public class MaxInWindow {
	ArrayList<Integer> maxList = new ArrayList<Integer>();
	/**
	 * ����Ϊ[4,3,5,4,3,3,6,7] sizeΪ3
	 * һ������n-w+1�����ڵ����ֵ
	 * 555467
	 * @param num
	 * @param size
	 * @return
	 */
	public ArrayList<Integer> maxInWindows(int[] num, int size){
        if (num == null || size < 0 || num.length < size){
        	return maxList;//��num.length < size�Ƿ���һ�����ڣ���ʱ���ֵ�������е����ֵ
        }
        return maxList;
    }
}
