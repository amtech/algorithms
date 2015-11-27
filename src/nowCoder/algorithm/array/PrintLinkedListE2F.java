package nowCoder.algorithm.array;

import java.util.ArrayList;

/**
 * ��β��ͷ��ӡ��������� ����ı�����ָ��ķ�������Դ�ͷ��β��ӡ�����Ƿ���Ը�������Ľṹ��ȡ�������Թٵ����� �򵥵ķ�����
 * ����һ��������������������ݣ������������ջ���棬����������飬���ߵ�ջ����
 * 
 * @author snow
 *
 */
public class PrintLinkedListE2F {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);//�и�this
            arrayList.add(listNode.val);
        }
        return arrayList;
    }ֱ��ʹ�õݹ�ʵ�֣�����ҳ���飬���������������̫�࣬���ܶ�ջ���
    */
	/**
	 * ע�⣬listNode����Ϊnull����Ӧ���ص�ArrayListӦ��Ϊ[]
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listNode == null){
			return list;//��ʱΪ[]
		}
		ListNode listNode2 = listNode;//������������
		while (listNode2.next != null){//�˳�ѭ��ʱ������һ���������
			list.add(listNode2.val);
			listNode2 = listNode2.next;
		}
		list.add(listNode2.val);
		ArrayList<Integer> listReverse = new ArrayList<Integer>(list.size());
		for (int i = list.size() - 1/*, j = 0*/; i >= 0; i--/*, j++*/) {
			System.out.print(list.get(i) + " ");
			//listReverse[j] = list[i]; ArrayListԪ�ؼ䲻����Array����ֱ�Ӹ�ֵ
			listReverse.add(list.get(i));
		}
		return listReverse;
	}
	public static void main(String[] args) {
		PrintLinkedListE2F E2F = new PrintLinkedListE2F();
		ListNode listNode = E2F.new ListNode(0);
		ListNode cur = listNode;
		for (int i = 1; i < 6; i++) {
			cur.next = E2F.new ListNode(i);
			cur = cur.next;
		}
		E2F.printListFromTailToHead(listNode);
		
	}
}
