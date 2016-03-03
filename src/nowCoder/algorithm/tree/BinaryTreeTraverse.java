package nowCoder.algorithm.tree;

import java.util.Stack;

/**
 * 二叉树的遍历
 * 先序遍历：根、左、右
 * 中序遍历：左、根、右
 * 后序遍历：左、右、根
 * 
 * 		用递归能解决的问题用非递归的方法都能实现，递归无非是利用函数栈来保存信息，
 * 如果用自己申请的数据结构来代替函数栈，也可以实现相同的功能
 * @author snow
 *
 */
public class BinaryTreeTraverse {
	
	/*递归先序遍历*/
	public void preOrderRecur(Node head){
		if (head == null)
			return;
		System.out.println(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	/**
	 * 非递归先序遍历：(栈后进先出，前序遍历先压入right)
	 * ①：申请一个栈,Stack,将头结点head压入栈
	 * ②：从Stack弹出栈顶结点cur，打印cur的值，再将cur的右孩子结点，不为空的话，压入Stack中，
	 * 最后将cur的左孩子结点不为空的话压入Stack
	 * ③：不断重复步骤②，直到Stack为空为止
	 * 
	 * @param head
	 */
	public void preOrderUnRecur(Node head){
		System.out.println("Pre Order : ");
		if (head != null){
			Stack<Node> stack = new Stack<Node>();
			/**
			 * add和push有什么区别
			 * Stack 继承自Vector(线程安全)
			 * push是stack自带的方法
			 * 	 	返回值：当前push放入的元素
			 * 而add是Vector的方法
			 * 		synchronized修饰，并且add时会进行容量检查是否扩容
			 * 		返回值：是否成功加入boolean类型
			 */
			stack.add(head);
			while (!stack.isEmpty()){
				head = stack.pop();//返回并弹出，peek只返回不弹出
				System.out.println(head.value + " ");
				if (head.right != null){
					stack.push(head.right);
				}
				if (head.left != null){
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
	/*递归中序遍历*/
	public void inOrderRecur(Node head){
		if (head == null)
			return;
		preOrderRecur(head.left);
		System.out.println(head.value + " ");
		preOrderRecur(head.right);
	}
	
	/**
	 * 非递归中序遍历：
	 * ①：申请一个栈Stack。初始时，令cur=head
	 * ②：先把cur结点压入stack，对以cur结点为头的整棵子树来说，依次把左边界压入栈
	 * 即不停的令cur = cur.left，然后重复步骤②
	 * ③：不断重复步骤②，直到发现cur为null，此时从stack中弹出一个结点，记为node。
	 * 打印node的值，并且让cur = node.right，并重复步骤②
	 * ④：当stack为空，且cur为空时，整个过程停止
	 * 
	 * 依次先打印左子树，然后是每棵子树的头结点，最后打印右子树
	 */
	public void inOrderUnRecur(Node head){
		System.out.println("In Order: ");
		if (head != null){
			Stack<Node> stack = new Stack<Node>();
			Node cur = head;
			while (!stack.isEmpty() || head != null	){
				if (head != null){
					stack.push(head);
					head = head.left;
				}else {
					head = stack.pop();
					System.out.println(head.value + " ");
					head = head.right;
				}
			}
		}
	}
	
	/*递归后序遍历*/
	public void posOrderRecur(Node head){
		if (head == null)
			return;
		preOrderRecur(head.left);
		System.out.println(head.value + " ");
		preOrderRecur(head.right);
	}
	
	/**
	 * 非递归后序遍历法 一
	 * ①：申请一个栈s1，然后将head压入s1
	 * ②：从s1中弹出结点cur，依次将cur的左右结点压入s1
	 * ③：在整个过程中，每个从s1中弹出的结点都放入s2中
	 * ④：重复步骤2和3，直到s1为空为止，过程停止
	 * ⑤：从s2中依次弹出结点并打印，打印的顺序就是后序遍历的顺序
	 * 
	 * @param head
	 */
	public void posOrderRecur1(Node head){
		System.out.println("Pos Order: ");
		if (head != null){
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()){
				Node node = s1.pop();
				s2.push(node);
				if (node.left != null){
					s1.push(node.left);
				}
				if (node.right != null){
					s1.push(node.right);
				}
			}
			while (!s2.isEmpty()){
				System.out.println(s2.pop().value + " ");
			}
		}
	}
	
	/**
	 * 非递归后序遍历(使用一个栈)
	 * ①：将头结点head压入stack，同时设置两个变量last和cur。在整个流程中，
	 * last代表最近一次弹出并打印的结点，cur代表stack的栈顶结点，初始时last=head，cur=null
	 * ②：每次令cur=stack.peek不从栈中弹出。分为3中情况
	 *  2.1，如果cur的左孩子不为null，并且last!=cur的左右孩子结点，则把cur.left压入栈
	 *  	原因：last代表最近一次弹出并打印的结点，如果last等于cur的左孩子或者右孩子，则说明
	 *  cur的左右子树已经打印完毕，不应该将cur的孩子结点压入stack。否则说明左子树，没有处理过，
	 *  将cur.left压入stack中
	 *  2.2 如果条件2.1不成立，并且cur.right不为null，last!=cur.right，则把右孩子压入stack
	 *  	原因：如果last等于右孩子，则cur的右子树已经打印过，此时不应该再将右孩子压入stack
	 *  否则，说明右子树没有打印，将右孩子压入stack中
	 *  2.3 如果条件2.1和2.2都不成立，说明cur的左子树和右子树都已经打印完毕，
	 * 	从stack中弹出cur，并打印。然后令last = cur
	 * ③：一直重复步骤②，直到stack为null
	 *  
	 * @param head
	 */
	public void posOrderUnCur2(Node head){
		if (head != null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			Node last = head;
			Node cur = null;
			while (!stack.isEmpty()){
				cur = stack.peek();//不弹出
				if (cur.left != null && last != cur.left && last != cur.right){
					stack.push(cur.left);
				}else if (cur.right != null && last != cur.right){
					stack.push(cur.right);
				}else {
					cur = stack.pop();
					System.out.println(cur.value + " ");
					last = cur;//每弹出一个cur，访问过后才更新last
				}
			}
		}
	}
}
