package nowCoder.algorithm.array;

import java.util.ArrayList;

/**
 * ����һ����������������һ������s���������в�����������ʹ�����ǵĺ�Ϊs
 * ����ж�����ֵĺ�Ϊs������˻���С��һ��
 * �����������С�������
 * 
 * ˼·����������ѡ����������aheadָ��arr[0],behindָ��arr[length-1]�������==s���򷵻�
 * 	�� �� < s ��ahead����ƶ����ͱ�����ظ��Ƚ�
 *  �� �� > s ��behind��ǰ�ƶ����ͱ�С���ظ��Ƚ�
 * @author snow
 *
 */
public class FindNumbersWithSum {
	
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
		//�Ͳ�������Ϊint�ͣ�˵��������֮��û�г���int�ı�ʾ��Χ
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length < 2){
			return list;
		}
		int ahead = 0;
		int behind = array.length - 1;
		long curSum = 0;//�Ϳ��ܳ���int��Χ
		//Map<Integer, Integer> map = new HashMap<>();
		while (ahead < behind){//��������������,��С�����±�С�ڽϴ����ֵ��±�
			curSum = array[ahead] + array[behind];
			System.out.println("curSum: " + curSum);
			if (curSum == sum){
				/*map.put(array[ahead], array[behind]);
				�п����ж�������ҵ���ֱ��ahead++
				ahead++;
				�ҵ��ĵ�һ����һ���ǳ˻���С��������
				*/
				list.add(array[ahead]);
				list.add(array[behind]);
				break;
			}else if (curSum < sum){
				ahead++;
			}else {
				behind--;
			}
		}
		return /*findMinMultiply(map)*/list;
    }
	
	/**
	 * ��Ϊ���鰴�մ�С������������Գ˻���С��������һ�����ҵ��ĵ�һ����
	 * @param map
	 * @return
	 */
	/*public ArrayList<Integer> findMinMultiply(Map<Integer, Integer> map){
		ArrayList<Integer> list = new ArrayList<Integer>();
		long multiply = Long.MAX_VALUE;
		//�ҵ��˻���С��������
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			long curMulti = entry.getKey() * entry.getValue();
			if (curMulti < multiply){
				multiply = curMulti; 
				list.clear();//���ԭ�������� 
				list.add(entry.getKey());
				list.add(entry.getValue());
			}
		}
		return list;
	}*/
	public static void main(String[] args) { 
		FindNumbersWithSum findSum = new FindNumbersWithSum();
		int[] arr = new int[]{0, 1, 2, 4, 7, 11, 15};
		ArrayList<Integer> list = findSum.findNumbersWithSum(arr, 15);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
