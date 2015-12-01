package nowCoder.algorithm.tree;

/*
 * 二叉树的深度:
 * 最长路径的长度为二叉树的深度
 * ①：得到所有的路径，就能得到最长 路径及长度
 * ②：该树的深度就是左右子树的深度的较大值再加1： 递归
 * 
 */
public class TreeDepth {
	public class Solution {
	    public int TreeDepth(TreeNode root) {
	        if (root == null){
	        	return 0;
	        }//递归求左右子树的深度
	        int left = TreeDepth(root.left);
	        int right = TreeDepth(root.right);
	        return (left > right) ? (left + 1) : (right + 1);
	    }
	}
}
class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(){}
	public TreeNode(int value){
		val = value;
	}
}
