package nowCoder.algorithm.list;


class ListNode {//�ⲿ������η�ֻ����public��abstract��final��default��д
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 * ����һ����������������е�����k����㡣
 * Ĭ�Ͻ��������1��ʼ
 * 
 * ��������м��㣺�������Ϊ�����������м䣬���Ϊż���������м�����һ��
 * 		����ָ�룬һ��ָ��һ����һ������һ��ָ��һ����������
 * 		���ߵĿ��ָ���ߵ��������ĩβ���ߵ����ĸպ���������м�
 * �жϵ��������Ƿ��γ��˻��Σ�
 * 		����ָ�룬һ��ָ��һ����һ������һ��ָ��һ����������
 * 		���ߵĿ� ��ָ��׷�����ߵ�����ָ�룬�ɻ�
 * 			�п��ܲ��ǻ������ĵ���β��ֹͣ��Ȼ���Ĳŵ�    ������
 * 			���ǻ�����Ŀ϶��������ȵ���β��
 * 		�ߵÿ쵽������ĩβʱ����û��׷�ϣ�֤�����ǻ�������
 *   �����ж��Ƿ�׷�ϣ����ܿ���������պ��������ĵĽ��λ��
 * @author snow
 *
 */
public class FindKthToTail {
	
	/**
	 * ֻ��������һ��
	 * ʹ������ָ��P1��P2
	 * �٣�P1������ͷ��㿪ʼ��ǰ��k-1����P2���ֲ���
	 * �ڣ��ӵ�k����ʼ��P2Ҳ��ʼ������ͷ��ʼ����
	 * 		����ָ��֮��ľ���ΪK-1����P1��������β����ʱ��P2�����ڵ�����K������λ��
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		/**��Ҫ�������ĳ����Ƿ���>=k
		 * head�Ƿ�Ϊnull, ����ǣ�������k�����Ҳ��null
		 * ���kΪ0��������0����㣬û�����壬���Է���null
		 * �����c++�У�ʹ��unsigned int��k���Ϊ0ʱ��k-1����0xFFFFFFFFҲ����ɳ������
		 */
		if (head == null || k == 0){
			return null;
		}
		ListNode  pAhead = head;
		ListNode pBehind = head;
		for (int i = 0; i < k - 1; i++) {//���kΪ1�����һ����� pAhead����
			if (pAhead.next != null){
				pAhead = pAhead.next;
			}else {//���Ϊnull����˵��������С��K
				return null;
			}
		}
		//����������.next,����������ʵ������һ����㣬���ǻ�ִ��ѭ��������nullֵ
		while (pAhead.next != null){//���ܷ������һ���������
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
    }
	public static void main(String[] args) {
		FindKthToTail ft = new FindKthToTail();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		/*while (node != null){
			System.out.println(node.val);
			node = node.next;
		}*/
		System.out.println(node.val);
		System.out.println(ft.FindKthToTail(node, 1));
	}
}
