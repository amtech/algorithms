package nowCoder.algorithm.tree;

/**
 * 重建二叉树，输入二叉树的前序和中序遍历的结果
 * 前序：先访问根结点，在访问左子树，然后右子树
 * 		根 --> 左子树  -->  右子树
 * 中序：先访问左子树，然后根结点，最后右子树
 *      左子树  --> 根  --> 右子树
 *     
 * 子树，也是树，处理方法和原树一样，可以采用递归
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
	 * 序列保存在数组里面,(还是用链表) 但是构造的二叉树，使用链表表示
	 * @param preOrder 前序序列
	 * @param inOrder  中序序列
	 * @param length  结点个数
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
	 * @param preOrder  前序遍历数组
	 * @param inOrder  中序遍历数组
	 * @param startPreOrder  前序遍历序列开头
	 * @param endPreOrder     结尾
	 * @param startInOrder   中序遍历序列开头
	 * @param endInOrder      结尾
	 * @return
	 */
	public Node constructCore(Node[] preOrder, Node[] inOrder, 
			int startPreOrder, int endPreOrder,
			int startInOrder, int endInOrder){
		//前序遍历序列的第一个数字是根结点的值
		int rootValue = preOrder[startPreOrder].value;
		//重建二叉树
		Node root = new Node();
		root.value = rootValue;
		root.left = root.right = null;//初始只能构造个根结点
		if (startPreOrder == endPreOrder){//前序遍历只有一个结点
			if (startInOrder == endInOrder && //中序遍历也只有一个结点
					preOrder[startPreOrder].value == inOrder[startInOrder].value){
				//子结构中只有一个根结点  中间索引不一定是0，因为是递归，子树
				return root;
			}else {
				try {
					throw new Exception("输入序列错误,两个序列不能构造二叉树，不匹配");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//在中序序列中找到子树根结点的值
		//Node rootInOrder = inOrder[startInOrder];
		int rootIndexInOrder = startInOrder;//保存根结点的index
		while (rootIndexInOrder <= endInOrder && inOrder[rootIndexInOrder].value != rootValue){
			rootIndexInOrder++;//退出循环，可能找到根结点，可能没有根结点
		}
		if (rootIndexInOrder == endInOrder && 
				inOrder[endInOrder].value != rootValue){
			try {
				throw new Exception("输入序列错误，中序序列中没有前序序列子树对应的根结点");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int leftLength = rootIndexInOrder - startInOrder;//左子树的长度
		int leftPreOrderEnd = startPreOrder + leftLength;//前序遍历中左子树的最后一个结点
		if (leftLength > 0){
			//构建左子树
			root.left = constructCore(preOrder, inOrder, 
					startPreOrder + 1, leftPreOrderEnd, startInOrder, rootIndexInOrder - 1);
		}
		if (leftLength < endPreOrder - startPreOrder){//右子树不为空  构建右子树
			root.right = constructCore(preOrder, inOrder, 
					leftPreOrderEnd + 1, endPreOrder, rootIndexInOrder + 1, endInOrder);
		}
		return root;
	}
	
	public static void main(String[] args) {
		BuildBTree tree = new BuildBTree();
		Node[] preOrder = new Node[8];//声明类型时，不需要外部类的对象
		for (int i = 0; i < preOrder.length; i++) {
			preOrder[i] = tree.new Node();//调用构造函数时，才需要外部类的对象  初始化
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
