package nowCoder.algorithm.list;


class ListNode {//外部类的修饰符只能是public，abstract和final和default不写
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 默认结点索引从1开始
 * 
 * 求链表的中间结点：结点总数为奇数，返回中间，如果为偶数，返回中间任意一个
 * 		两个指针，一个指针一次走一步，另一个指针一次性走两步
 * 		当走的快的指针走到了链表的末尾，走的慢的刚好在链表的中间
 * 判断单向链表是否形成了环形：
 * 		两个指针，一个指针一次走一步，另一个指针一次性走两步
 * 		当走的快 的指针追上了走的慢的指针，成环
 * 			有可能不是环，慢的到达尾部停止，然后快的才到    不可能
 * 			不是环，快的肯定比慢的先到达尾部
 * 		走得快到达链表末尾时，都没有追上，证明不是环形链表
 *   怎样判断是否追上？可能快的走两步刚好跳过慢的的结点位置
 * @author snow
 *
 */
public class FindKthToTail {
	
	/**
	 * 只遍历链表一遍
	 * 使用两个指针P1、P2
	 * ①：P1从链表头结点开始向前走k-1步，P2保持不动
	 * ②：从第k步开始，P2也开始从链表头开始遍历
	 * 		两个指针之间的距离为K-1，当P1到达链表尾部的时候，P2正好在倒数第K个结点的位置
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		/**需要检查链表的长度是否是>=k
		 * head是否为null, 如果是，则倒数第k个结点也是null
		 * 如果k为0，倒数第0个结点，没有意义，可以返回null
		 * 如果是c++中，使用unsigned int，k如果为0时，k-1会变成0xFFFFFFFF也会造成程序崩溃
		 */
		if (head == null || k == 0){
			return null;
		}
		ListNode  pAhead = head;
		ListNode pBehind = head;
		for (int i = 0; i < k - 1; i++) {//如果k为1，最后一个结点 pAhead不走
			if (pAhead.next != null){
				pAhead = pAhead.next;
			}else {//如果为null，则说明链表长度小于K
				return null;
			}
		}
		//这里必须加上.next,否则如果访问到了最后一个结点，还是会执行循环，返回null值
		while (pAhead.next != null){//这能访问最后一个结点吗？能
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
