package nowCoder.algorithm.tree;

/**
 * �ؽ��������������������ǰ�����������Ľ��
 * ǰ���ȷ��ʸ���㣬�ڷ�����������Ȼ��������
 * 		�� --> ������  -->  ������
 * �����ȷ�����������Ȼ�����㣬���������
 *      ������  --> ��  --> ������
 *     
 * ������Ҳ��������������ԭ��һ�������Բ��õݹ�
 * @author snow
 *
 */
public class BuildBTree {
	private class Node{
		int value;
		Node left;
		Node right;
		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right="
					+ right + "]";
		}
	}
	
	/**
	 * ���б�������������,(����������) ���ǹ���Ķ�������ʹ�������ʾ
	 * @param preOrder ǰ������
	 * @param inOrder  ��������
	 * @param length  ������
	 * @return
	 */
	public Node construct(Node[] preOrder, Node[] inOrder, int length){
		if (preOrder == null || inOrder == null || length <= 0){
			return null;
		}
		return constructCore(preOrder, inOrder, 0, length - 1, 0, length - 1);
	}
	
	/**
	 * 
	 * @param preOrder  ǰ���������
	 * @param inOrder  �����������
	 * @param startPreOrder  ǰ��������п�ͷ
	 * @param endPreOrder     ��β
	 * @param startInOrder   ����������п�ͷ
	 * @param endInOrder      ��β
	 * @return
	 */
	public Node constructCore(Node[] preOrder, Node[] inOrder, 
			int startPreOrder, int endPreOrder,
			int startInOrder, int endInOrder){
		//ǰ��������еĵ�һ�������Ǹ�����ֵ
		int rootValue = preOrder[startPreOrder].value;
		//�ؽ�������
		Node root = new Node();
		root.value = rootValue;
		root.left = root.right = null;//��ʼֻ�ܹ���������
		if (startPreOrder == endPreOrder){//ǰ�����ֻ��һ�����
			if (startInOrder == endInOrder && //�������Ҳֻ��һ�����
					preOrder[startPreOrder].value == inOrder[startInOrder].value){
				//�ӽṹ��ֻ��һ�������  �м�������һ����0����Ϊ�ǵݹ飬����
				return root;
			}else {
				try {
					throw new Exception("�������д���,�������в��ܹ������������ƥ��");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//�������������ҵ�����������ֵ
		//Node rootInOrder = inOrder[startInOrder];
		int rootIndexInOrder = startInOrder;//���������index
		while (rootIndexInOrder <= endInOrder && inOrder[rootIndexInOrder].value != rootValue){
			rootIndexInOrder++;//�˳�ѭ���������ҵ�����㣬����û�и����
		}
		if (rootIndexInOrder == endInOrder && 
				inOrder[endInOrder].value != rootValue){
			try {
				throw new Exception("�������д�������������û��ǰ������������Ӧ�ĸ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int leftLength = rootIndexInOrder - startInOrder;//�������ĳ���
		int leftPreOrderEnd = startPreOrder + leftLength;//ǰ������������������һ�����
		if (leftLength > 0){
			//����������
			root.left = constructCore(preOrder, inOrder, 
					startPreOrder + 1, leftPreOrderEnd, startInOrder, rootIndexInOrder - 1);
		}
		if (leftLength < endPreOrder - startPreOrder){//��������Ϊ��  ����������
			root.right = constructCore(preOrder, inOrder, 
					leftPreOrderEnd + 1, endPreOrder, rootIndexInOrder + 1, endInOrder);
		}
		return root;
	}
	
	public static void main(String[] args) {
		BuildBTree tree = new BuildBTree();
		Node[] preOrder = new Node[8];//��������ʱ������Ҫ�ⲿ��Ķ���
		for (int i = 0; i < preOrder.length; i++) {
			preOrder[i] = tree.new Node();//���ù��캯��ʱ������Ҫ�ⲿ��Ķ���  ��ʼ��
		}
		preOrder[0].value = 1;
		preOrder[1].value = 2;
		preOrder[2].value = 4;
		preOrder[3].value = 7;
		preOrder[4].value = 3;
		preOrder[5].value = 5;
		preOrder[6].value = 6;
		preOrder[7].value = 8;
		Node[] inOrder = new Node[8];
		for (int i = 0; i < inOrder.length; i++) {
			inOrder[i] = tree.new Node();
		}
		inOrder[0].value = 4;
		inOrder[1].value = 7;
		inOrder[2].value = 2;
		inOrder[3].value = 1;
		inOrder[4].value = 5;
		inOrder[5].value = 3;
		inOrder[6].value = 8;
		inOrder[7].value = 6;
		System.out.println(tree.construct(preOrder, inOrder, 8));
	}
}
