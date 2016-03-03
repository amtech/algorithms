package nowCoder.algorithm.tree;

import java.util.Stack;

/**
 * �������ı���
 * �����������������
 * ����������󡢸�����
 * ������������ҡ���
 * 
 * 		�õݹ��ܽ���������÷ǵݹ�ķ�������ʵ�֣��ݹ��޷������ú���ջ��������Ϣ��
 * ������Լ���������ݽṹ�����溯��ջ��Ҳ����ʵ����ͬ�Ĺ���
 * @author snow
 *
 */
public class BinaryTreeTraverse {
	
	/*�ݹ��������*/
	public void preOrderRecur(Node head){
		if (head == null)
			return;
		System.out.println(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	/**
	 * �ǵݹ����������(ջ����ȳ���ǰ�������ѹ��right)
	 * �٣�����һ��ջ,Stack,��ͷ���headѹ��ջ
	 * �ڣ���Stack����ջ�����cur����ӡcur��ֵ���ٽ�cur���Һ��ӽ�㣬��Ϊ�յĻ���ѹ��Stack�У�
	 * ���cur�����ӽ�㲻Ϊ�յĻ�ѹ��Stack
	 * �ۣ������ظ�����ڣ�ֱ��StackΪ��Ϊֹ
	 * 
	 * @param head
	 */
	public void preOrderUnRecur(Node head){
		System.out.println("Pre Order : ");
		if (head != null){
			Stack<Node> stack = new Stack<Node>();
			/**
			 * add��push��ʲô����
			 * Stack �̳���Vector(�̰߳�ȫ)
			 * push��stack�Դ��ķ���
			 * 	 	����ֵ����ǰpush�����Ԫ��
			 * ��add��Vector�ķ���
			 * 		synchronized���Σ�����addʱ�������������Ƿ�����
			 * 		����ֵ���Ƿ�ɹ�����boolean����
			 */
			stack.add(head);
			while (!stack.isEmpty()){
				head = stack.pop();//���ز�������peekֻ���ز�����
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
	
	/*�ݹ��������*/
	public void inOrderRecur(Node head){
		if (head == null)
			return;
		preOrderRecur(head.left);
		System.out.println(head.value + " ");
		preOrderRecur(head.right);
	}
	
	/**
	 * �ǵݹ����������
	 * �٣�����һ��ջStack����ʼʱ����cur=head
	 * �ڣ��Ȱ�cur���ѹ��stack������cur���Ϊͷ������������˵�����ΰ���߽�ѹ��ջ
	 * ����ͣ����cur = cur.left��Ȼ���ظ������
	 * �ۣ������ظ�����ڣ�ֱ������curΪnull����ʱ��stack�е���һ����㣬��Ϊnode��
	 * ��ӡnode��ֵ��������cur = node.right�����ظ������
	 * �ܣ���stackΪ�գ���curΪ��ʱ����������ֹͣ
	 * 
	 * �����ȴ�ӡ��������Ȼ����ÿ��������ͷ��㣬����ӡ������
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
	
	/*�ݹ�������*/
	public void posOrderRecur(Node head){
		if (head == null)
			return;
		preOrderRecur(head.left);
		System.out.println(head.value + " ");
		preOrderRecur(head.right);
	}
	
	/**
	 * �ǵݹ��������� һ
	 * �٣�����һ��ջs1��Ȼ��headѹ��s1
	 * �ڣ���s1�е������cur�����ν�cur�����ҽ��ѹ��s1
	 * �ۣ������������У�ÿ����s1�е����Ľ�㶼����s2��
	 * �ܣ��ظ�����2��3��ֱ��s1Ϊ��Ϊֹ������ֹͣ
	 * �ݣ���s2�����ε�����㲢��ӡ����ӡ��˳����Ǻ��������˳��
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
	 * �ǵݹ�������(ʹ��һ��ջ)
	 * �٣���ͷ���headѹ��stack��ͬʱ������������last��cur�������������У�
	 * last�������һ�ε�������ӡ�Ľ�㣬cur����stack��ջ����㣬��ʼʱlast=head��cur=null
	 * �ڣ�ÿ����cur=stack.peek����ջ�е�������Ϊ3�����
	 *  2.1�����cur�����Ӳ�Ϊnull������last!=cur�����Һ��ӽ�㣬���cur.leftѹ��ջ
	 *  	ԭ��last�������һ�ε�������ӡ�Ľ�㣬���last����cur�����ӻ����Һ��ӣ���˵��
	 *  cur�����������Ѿ���ӡ��ϣ���Ӧ�ý�cur�ĺ��ӽ��ѹ��stack������˵����������û�д������
	 *  ��cur.leftѹ��stack��
	 *  2.2 �������2.1������������cur.right��Ϊnull��last!=cur.right������Һ���ѹ��stack
	 *  	ԭ�����last�����Һ��ӣ���cur���������Ѿ���ӡ������ʱ��Ӧ���ٽ��Һ���ѹ��stack
	 *  ����˵��������û�д�ӡ�����Һ���ѹ��stack��
	 *  2.3 �������2.1��2.2����������˵��cur�������������������Ѿ���ӡ��ϣ�
	 * 	��stack�е���cur������ӡ��Ȼ����last = cur
	 * �ۣ�һֱ�ظ�����ڣ�ֱ��stackΪnull
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
				cur = stack.peek();//������
				if (cur.left != null && last != cur.left && last != cur.right){
					stack.push(cur.left);
				}else if (cur.right != null && last != cur.right){
					stack.push(cur.right);
				}else {
					cur = stack.pop();
					System.out.println(cur.value + " ");
					last = cur;//ÿ����һ��cur�����ʹ���Ÿ���last
				}
			}
		}
	}
}
