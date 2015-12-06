package nowCoder.algorithm.array;

import java.util.ArrayList;

/**
 * ����һ����������ӡ�����к�Ϊsum����������������(���ٰ���������)
 * ˼·����small��big�ֱ��ʾ���е���Сֵ�����ֵ(��ʼֵΪ1��2)
 * ��small��big�����кͣ�
 * �٣�����s�����Դ�������ȥ����С��ֵ��������small��ֵ
 * �ڣ�С��s����������big
 * һֱ����smallֱ��(1+s)/2
 * 
 * @author snow
 *
 */
public class FindContinuousSequence {
	
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (sum < 3){//���ٰ���������������sum>=3
			return list;
		}
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		while (small < middle){//��sumΪ3����middleΪ2��smallֻ��Ϊ1����=
			if (curSum == sum){
				list.add(addList(small, big));
			}
			while (curSum > sum && small < middle){
				curSum -= small;
				small++;
				if (curSum == sum){
					list.add(addList(small, big));
				}
			}//�˳�while�����ʱcurSum < sum����small=middle(���while����֤)
			big++;
			curSum += big;
		}
		return list;
    }
	
	public ArrayList<Integer> addList(int small, int big){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = small; i <= big; i++) {
			list.add(i);
		}
		return list;
	}
	public static void main(String[] args) {
		FindContinuousSequence findSeq = new FindContinuousSequence();
		ArrayList<ArrayList<Integer>> list = findSeq.findContinuousSequence(9);
		for (ArrayList<Integer> arrayList : list) {
			for (Integer i : arrayList) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

