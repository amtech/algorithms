package nowCoder.algorithm.tree;

public class BuildTree2 {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right="
					+ right + "]";
		}
	 }
	 /**
	  * 传入前序和中序序列的数组
	  * @param pre
	  * @param in
	  * @return 返回TreeNode树
	  */
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length <= 0 ){
        	return null;//树为空
        }//length为数组分配空间的长度，不是初始化的长度     这里应该是实际存数据的长度
        return reConstructCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
	
	private TreeNode reConstructCore(int[] pre, int[] in, 
			int startPre, int endPre, int startIn, int endIn){
		TreeNode root = new TreeNode(pre[startPre]);//前序遍历的第一个结点为根结点
		//子树只有一个结点的情况
		if (startPre == endPre){//前序遍历只有一个结点
			if (startIn == endIn && pre[startPre] == in[startIn]){//只有一个结点
				return root;
			}else {
				try {
					throw new Exception("输入有误，前序和中序不能构建一个二叉树，不匹配");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//在中序序列中找到根结点
		int rootIndexIn = startIn;
		while (rootIndexIn <= endIn && in[rootIndexIn] != root.val){
			//退出循环： 可能找到根结点，可能没有找到根结点
			rootIndexIn++;
		}
		if (rootIndexIn == endIn && in[rootIndexIn] != root.val){
			try {
				throw new Exception("输入序列错误，中序序列中没有前序序列子树对应的根结点");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int leftLength = rootIndexIn - startIn;//左子树的长度
		int preEnd = startPre + leftLength;//前序遍历中左子树的最后一个结点位置
		if (leftLength > 0){
			root.left = reConstructCore(pre, in,
					startPre + 1, preEnd, startIn, rootIndexIn -1 );
		}
		if (leftLength < endPre - startPre){//右子树不为空，构建右子树
			root.right = reConstructCore(pre, in, 
					preEnd + 1, endPre, rootIndexIn + 1, endIn);
		}
		return root;
	}
	public static void main(String[] args) {
		/*int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};//直接给数组初始化
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};*/
		int[] pre = {};
		int[] in = {};
		/*int[] pre = new int[0];
		int[] in = new int[0];*/
		BuildTree2 bt = new BuildTree2();
		System.out.println(bt.reConstructBinaryTree(pre, in));
	}
}
