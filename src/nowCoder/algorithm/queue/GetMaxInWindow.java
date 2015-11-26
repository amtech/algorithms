package nowCoder.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 利用双端队列实现窗口最大值的更新
 * 每个下标最多进qmax一次，出qmax一次，所以时间复杂度为O(n)
 * @author snow
 *
 */
public class GetMaxInWindow {
	public int[] getMaxWindow(int[] arr, int w){
		if (arr == null || w < 1 || arr.length < w){
			return new int[0];
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();//双端队列,可以用链表实现
		int[] res = new int[arr.length - w + 1];//最大值数组
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
				qmax.pollLast();//弹出队尾
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w){
				qmax.pollFirst();//队头下标过期，弹出队头
			}
			if (i >= w - 1){//i从w-1开始，窗口出现，之后每个qmax.peekFirst都是窗口的最大值
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	public ArrayList<Integer> maxInWindows(int [] arr, int w)
    {
       if (arr == null || w < 1 || arr.length < w){
			return new ArrayList<Integer>();
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();//双端队列,可以用链表实现
		ArrayList<Integer> res = new ArrayList<>(arr.length - w + 1);//最大值数组
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
				qmax.pollLast();//弹出队尾
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w){
				qmax.pollFirst();//队头下标过期，弹出队头
			}
			if (i >= w - 1){//i从w-1开始，窗口出现，之后每个qmax.peekFirst都是窗口的最大值
				res.add(arr[qmax.peekFirst()]);
			}
		}
		return res;
    }
	public static void main(String[] args) {
		int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
		ArrayList list = new GetMaxInWindow().maxInWindows(arr, 3);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));//555467
		}
	}
}
