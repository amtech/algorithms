package nowCoder.algorithm.list;

/**
 * ����һ��������ת�����������������Ԫ�ء�
 * @author snow
 *
 */
public class ReverseList {
	
	/**
	 * ��������ָ�룬�ֱ�ָ��ǰ�������Ľ�㡢ǰһ����㡢��һ�����
	 * h -> i -> j   h <- i  j
	 * ����i.nextָ��h֮ǰ����Ҫ��j������������ֹ������i���Ͽ�
	 */
	public ListNode ReverseList(ListNode head) {
		ListNode pReverseHead = null;
		ListNode pNode = head;//��ǰ���
		ListNode pPrev = null;
		while (pNode != null){
			ListNode pNext = pNode.next;
			if (pNext == null){
				pReverseHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		return pReverseHead;
    }
	
	/**
	 * ��ԭ�����ͷ��һ��һ��ȡ�ڵ㲢���뵽�������ͷ��
	 * class Solution {
		public:
		    ListNode* ReverseList(ListNode* pHead) {
		        if (pHead == NULL) return NULL;
		        ListNode* head = pHead;
		        pHead = pHead->next;
		        head->next = NULL;
		        while (pHead) {
		            ListNode *next = pHead->next;
		            pHead->next = head;
		            head = pHead;
		            pHead = next;
		        }
		        return head;
		    }
		};
	 */
}
