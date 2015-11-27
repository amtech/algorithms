package nowCoder.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ����˫�˶���ʵ�ִ������ֵ�ĸ���
 * ÿ���±�����qmaxһ�Σ���qmaxһ�Σ�����ʱ�临�Ӷ�ΪO(n)
 * @author snow
 *
 */
public class GetMaxInWindow {
	public int[] getMaxWindow(int[] arr, int w){
		if (arr == null || w < 1 || arr.length < w){
			return new int[0];
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();//˫�˶���,����������ʵ��
		int[] res = new int[arr.length - w + 1];//���ֵ����
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
				qmax.pollLast();//������β
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w){
				qmax.pollFirst();//��ͷ�±���ڣ�������ͷ
			}
			if (i >= w - 1){//i��w-1��ʼ�����ڳ��֣�֮��ÿ��qmax.peekFirst���Ǵ��ڵ����ֵ
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
		LinkedList<Integer> qmax = new LinkedList<Integer>();//˫�˶���,����������ʵ��
		ArrayList<Integer> res = new ArrayList<>(arr.length - w + 1);//���ֵ����
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
				qmax.pollLast();//������β
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w){
				qmax.pollFirst();//��ͷ�±���ڣ�������ͷ
			}
			if (i >= w - 1){//i��w-1��ʼ�����ڳ��֣�֮��ÿ��qmax.peekFirst���Ǵ��ڵ����ֵ
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
