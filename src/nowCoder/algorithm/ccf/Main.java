package nowCoder.algorithm.ccf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n  = scan.nextInt();
		/**
		 *  nextInt()�������ȡ��һ��int�ͱ�־��token.���ǽ��㲻���ƶ�����һ�У���Ȼ������һ���ϡ�
		 *  ��ʹ��nextLine()����ʱ���ȡ����ʣ������е����ݣ��������з���
		 *  Ȼ��ѽ����ƶ�����һ�еĿ�ͷ�������������޷����յ���һ�������String���͵ı�����
		 *  next���Ի��л��߿ո��Ϊ�ָ��߶�ȡ�ַ����� 
		 */
		String input = scan.next() /*��ȡ��һ���ַ�*/ + scan.nextLine();//����inputû�����ݣ�û������
		String[] result = input.split(" ");
		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < n; i++) {//ͳ��Ƶ��  value�ǳ��ֵĴ����������п�����ͬ
			if (count.containsKey(result[i])){
				count.put(result[i], count.get(result[i]) + 1);
			} else {
				count.put(result[i], 1);
			}
		}
		System.out.println(count.toString());
		//Ƶ��ͳ��֮�󻹵����򡣡����ܳ��ֺܶ������ֵĴ�����ͬ�����  ���ҳ��ִ�������
		//int[] maxValue = new int[n];//���������������key  �п���ÿ��������ֵ������һ��
		List<Integer> maxList = new ArrayList<>();
		//int i = 0;//��¼maxValue���±�
		int maxCount = 0;//��ǰ���ֵ�������
		for (String str : count.keySet()) {
			Integer value = count.get(str);
			if (value > maxCount){
				maxCount = value;
				maxList.clear();
				/*maxValue = new int[n];//�������飬����
				i = 0;
				maxValue[i++] = Integer.parseInt(str);*/
				maxList.add(Integer.parseInt(str));
			} else if (value == maxCount){
				maxList.add(Integer.parseInt(str));
			} else {
				continue;
			}
			System.out.print(maxCount + " --> ");
		}
		//��󷵻س��ִ�����ͬ����С����  ��maxValue����
		for (int j = 0, len = maxList.size(); j < len; j++) {
			System.out.print(maxList.get(j) + " ");
		}
		System.out.println();
		//Arrays.sort(maxValue);//ǰ���п�����һ��0����������Ŀؼ��Ƚϴ�
		Collections.sort(maxList);
		for (int j = 0, len = maxList.size(); j < len; j++) {
			System.out.print(maxList.get(j) + " ");
		}
		System.out.println(maxList.get(0));
	}
}
