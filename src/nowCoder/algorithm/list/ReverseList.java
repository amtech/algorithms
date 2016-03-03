package nowCoder.algorithm.list;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author snow
 *
 */
public class ReverseList {
	
	/**
	 * 定义三个指针，分别指向当前遍历到的结点、前一个结点、后一个结点
	 * h -> i -> j   h <- i  j
	 * 当把i.next指向h之前，需要把j保存起来，防止链表在i处断开
	 */
	public ListNode ReverseList(ListNode head) {
		ListNode pReverseHead = null;
		ListNode pNode = head;//当前结点
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
	 * 从原链表的头部一个一个取节点并插入到新链表的头部
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
