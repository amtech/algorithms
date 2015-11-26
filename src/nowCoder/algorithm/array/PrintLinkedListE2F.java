package nowCoder.algorithm.array;

import java.util.ArrayList;

/**
 * 从尾到头打印链表的内容 如果改变链表指针的方向，则可以从头到尾打印链表，是否可以更改链表的结构，取决于面试官的需求 简单的方法：
 * 遍历一遍链表，将链表里面的数据，存在数组或者栈里面，逆序输出数组，或者弹栈就行
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
            this.printListFromTailToHead(listNode.next);//有个this
            arrayList.add(listNode.val);
        }
        return arrayList;
    }直接使用递归实现，代码灰常简介，但是如果链表结点数太多，可能堆栈溢出
    */
	/**
	 * 注意，listNode可能为null，对应返回的ArrayList应该为[]
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listNode == null){
			return list;//这时为[]
		}
		ListNode listNode2 = listNode;//保存链表引用
		while (listNode2.next != null){//退出循环时，还有一个结点内容
			list.add(listNode2.val);
			listNode2 = listNode2.next;
		}
		list.add(listNode2.val);
		ArrayList<Integer> listReverse = new ArrayList<Integer>(list.size());
		for (int i = list.size() - 1/*, j = 0*/; i >= 0; i--/*, j++*/) {
			System.out.print(list.get(i) + " ");
			//listReverse[j] = list[i]; ArrayList元素间不能向Array那样直接赋值
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
