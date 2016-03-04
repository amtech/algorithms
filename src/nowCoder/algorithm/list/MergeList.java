package nowCoder.algorithm.list;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author snow
 *
 */
public class MergeList {
	
	/**
	 * 得到两个链表中值较小的结点，并把他链接到已经合并的链表之后
	 * 剩下的结点任然是排好序的，合并过程类似，   递归
	 * 要对空链表进行单独的处理：
	 * 	如果一个链表为空链表，则结果为另一个链表
	 * 	如果两个链表都是空链表，结果为null
	 */
	public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
        	return list2;//如果此时list2也为null，结果还是null
        }else if (list2 == null){
        	return list1;//已经包含了两个链表都为null的情况，结果还是null
        }
        ListNode mergeHead = null;
        if (list1.val < list2.val){
        	mergeHead = list1;
        	mergeHead.next = Merge(list1.next, list2);
        }else {
        	mergeHead = list2;
        	mergeHead.next = Merge(list1, list2.next);
        }
        return mergeHead;
    }
}
