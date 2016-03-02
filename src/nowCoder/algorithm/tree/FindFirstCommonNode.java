package nowCoder.algorithm.tree;

/**
 * 两个链表中第一个公共子结点
 * 单向链表：
 * 		从第一个公共结点开始，之后他们所有的结点都是重合的，不可能出现分叉
 * 		也不可能出现重合部分长度不一致的情况
 * 		拓扑形状为Y，而不是X
 * 
 * 法①：蛮力法
 *   在第一个链表上顺序遍历每一个结点，每遍历到一个结点的时候，在第二个链表上顺序遍历每一个结点
 *   O(mn)
 * 法②：
 * 		公共结点出现在尾部，从后开始，最后一个相同的结点，即为第一个公共子节点 
 * 		最后到底的尾结点，却要最先比较， “后入先出”，可以采用栈，从尾部弹出
 * 	时间O(m+n)， 空间O(m+n)
 * 法③：遍历两遍
 * 		先得到每个链表的长度，找出长度的差值diff
 * 		长的链表先走diff步，然后再同时遍历，找到一个相同的结点就是第一个公共子节点
 * 	时间O(m+n)
 * 		
 * @author snow
 *
 */
public class FindFirstCommonNode {
	private int getListLen(ListNode head){
		int count = 0;
		while (head != null){
			count++;
			//改变head的引用，会不会影响外部链表的头部  
			head = head.next;
		}
		return count;
	}
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null){
		//链表可能为空,也可以不用检查,如果其中一个链表为null，另一个链表执行完for之后，也是null
			return null;
		}
		 int len1 = getListLen(pHead1);
		 int len2 = getListLen(pHead2);
		 ListNode longerList = pHead1;//默认长的链表为pHead1
		 ListNode shortList = pHead2;
		 //要知道是哪一个链表长了
		 int diff = (len1 > len2) ? (len1 - len2) : (len2 - len1);
		 if (len1 < len2){
			 longerList = pHead2;
			 shortList = pHead1;
		 }
		 for (int i = 0; i < diff; i++) {
			longerList = longerList.next;
		 }
		 /*
		  * 有可能两个结点的value值相等，但是指向不同的结点，所以不能用值来判断
		  * 第一个公共子节点，肯定地址相同，是同一个结点
		  * 也有可能没有公共子节点，退出循环
		  * while中此时长度肯定相同，要么为答案，要么为null，都可以直接返回
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