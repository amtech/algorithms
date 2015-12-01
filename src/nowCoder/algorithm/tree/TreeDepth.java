package nowCoder.algorithm.tree;

/*
 * �����������:
 * �·���ĳ���Ϊ�����������
 * �٣��õ����е�·�������ܵõ�� ·��������
 * �ڣ���������Ⱦ���������������ȵĽϴ�ֵ�ټ�1�� �ݹ�
 * 
 */
public class TreeDepth {
	public class Solution {
	    public int TreeDepth(TreeNode root) {
	        if (root == null){
	        	return 0;
	        }//�ݹ����������������
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
