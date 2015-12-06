package nowCoder.algorithm.tree;

/**
 * 判断一棵树是不是平衡二叉树：
 * 		任意节点的左右子树的深度相差不超过1
 * ①：遍历树的每一个节点的时候，调用函数TreeDepth得到他的左右子树的深度，然后判断
 * 		缺点：每一个结点会被重复遍历多次，效率低
 * @author snow
 *
 */
public class IsBalanceTree {
	
	public boolean isBalancedTree(TreeNode root){
		IntHolder depth = new IntHolder(0);
		return isBalanced(root, depth);//只要其中一棵子树不是平衡树就不是
	}
	//也可以将boolean和树的深度包装成一个类返回
	public boolean isBalanced(TreeNode root, IntHolder depth){
		if (root == null){
			depth.i = 0;//子树深度为0
			return true;
		}
		IntHolder left = new IntHolder(0);
		IntHolder right = new IntHolder(0);
		if (isBalanced(root.left, left) && isBalanced(root.right, right)){
			//左右子树都是平衡树
			int diff = left.i - right.i;
			if (diff <= 1 && diff >= -1){//左右子树深度不超过1
				depth.i = ((left.i > right.i) ? left.i : right.i) + 1;
				return true;
			}
		}
		return false;
	}
	
}
class IntHolder{//包装int，模拟int*,做返回值
	int i;
	public IntHolder(int val){
		i = val;
	}
}
