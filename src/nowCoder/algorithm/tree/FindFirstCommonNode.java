package nowCoder.algorithm.tree;

/**
 * ���������е�һ�������ӽ��
 * ��������
 * 		�ӵ�һ��������㿪ʼ��֮���������еĽ�㶼���غϵģ������ܳ��ֲַ�
 * 		Ҳ�����ܳ����غϲ��ֳ��Ȳ�һ�µ����
 * 		������״ΪY��������X
 * 
 * ���٣�������
 *   �ڵ�һ��������˳�����ÿһ����㣬ÿ������һ������ʱ���ڵڶ���������˳�����ÿһ�����
 *   O(mn)
 * ���ڣ�
 * 		������������β�����Ӻ�ʼ�����һ����ͬ�Ľ�㣬��Ϊ��һ�������ӽڵ� 
 * 		��󵽵׵�β��㣬ȴҪ���ȱȽϣ� �������ȳ��������Բ���ջ����β������
 * 	ʱ��O(m+n)�� �ռ�O(m+n)
 * ���ۣ���������
 * 		�ȵõ�ÿ������ĳ��ȣ��ҳ����ȵĲ�ֵdiff
 * 		������������diff����Ȼ����ͬʱ�������ҵ�һ����ͬ�Ľ����ǵ�һ�������ӽڵ�
 * 	ʱ��O(m+n)
 * 		
 * @author snow
 *
 */
public class FindFirstCommonNode {
	private int getListLen(ListNode head){
		int count = 0;
		while (head != null){
			count++;
			//�ı�head�����ã��᲻��Ӱ���ⲿ�����ͷ��  
			head = head.next;
		}
		return count;
	}
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null){
		//�������Ϊ��,Ҳ���Բ��ü��,�������һ������Ϊnull����һ������ִ����for֮��Ҳ��null
			return null;
		}
		 int len1 = getListLen(pHead1);
		 int len2 = getListLen(pHead2);
		 ListNode longerList = pHead1;//Ĭ�ϳ�������ΪpHead1
		 ListNode shortList = pHead2;
		 //Ҫ֪������һ��������
		 int diff = (len1 > len2) ? (len1 - len2) : (len2 - len1);
		 if (len1 < len2){
			 longerList = pHead2;
			 shortList = pHead1;
		 }
		 for (int i = 0; i < diff; i++) {
			longerList = longerList.next;
		 }
		 /*
		  * �п�����������valueֵ��ȣ�����ָ��ͬ�Ľ�㣬���Բ�����ֵ���ж�
		  * ��һ�������ӽڵ㣬�϶���ַ��ͬ����ͬһ�����
		  * Ҳ�п���û�й����ӽڵ㣬�˳�ѭ��
		  * while�д�ʱ���ȿ϶���ͬ��ҪôΪ�𰸣�ҪôΪnull��������ֱ�ӷ���
		  */
		 while (longerList != null && shortList != null
				 && longerList/*.val*/ != shortList/*.val*/){
			 longerList = longerList.next;
			 shortList = shortList.next;
		 }
		 return longerList;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}