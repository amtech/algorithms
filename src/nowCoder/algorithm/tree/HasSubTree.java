package nowCoder.algorithm.tree;

/**
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 * @author snow
 *
 */
public class HasSubTree {
	
	/**
	 *树B为空，算不算包含
	 * ①：在A中查找和B的根结点值相同的结点R
	 * ②：再判断A中以R为根结点的子树是不是包含B一样的结构
	 * ③：对于A来说，每一个结点为根判断是否包含B，是一个递归的过程
	 * 递归代码比较简洁，如果面试时没有特殊的要求，通常会采用递归
	 * 
	 * 法二：
	 * 采用遍历A和B，产生遍历序列，判断A的序列是否包含B ( KMP,或者结果为string，然后contains)
	 * 由于一个遍历序列可能对应多种树结构，至少需要包含中序遍历
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null){
			if (root1.val == root2.val){
				//判断以root1为根的子树是否包含root2
				result = DoesTree1HasTree2(root1, root2);
			}
			if (!result){
				result = HasSubtree(root1.left, root2);
			}
			if (!result){
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
    }

	/**
	 * 如果结点R的值和B的根结点的值相同
	 * 	递归的判断各自左右结点的值是不是相同
	 * 终止条件：到达A或者B的叶节点
	 */
	private boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null){
			return true;
		}
		if (root1 == null){
			//此时root2肯定不为null，如果为null第一个if已经判断返回了
			return false;
		}
		if (root1.val != root2.val){
			return false;
		}
		return DoesTree1HasTree2(root1.left, root2.left) &&
				DoesTree1HasTree2(root1.right, root2.right);
	}
	public static void main(String[] args) {
		TreeNode A = new TreeNode(8);
		A.left = new TreeNode(8);
	}
	
	/**
	 * 利用好短路特性，完全不用那么多flag
		class Solution {
		    bool isSubtree(TreeNode* pRootA, TreeNode* pRootB) {
		        if (pRootB == NULL) return true;
		        if (pRootA == NULL) return false;
		        if (pRootB->val == pRootA->val) {
		            return isSubtree(pRootA->left, pRootB->left)
		                && isSubtree(pRootA->right, pRootB->right);
		        } else 
		        	return false;
		    }
		public:
		    bool HasSubtree(TreeNode* pRootA, TreeNode* pRootB)
		    {
		        if (pRootA == NULL || pRootB == NULL) return false;
		        return isSubtree(pRootA, pRootB) ||
		            HasSubtree(pRootA->left, pRootB) ||
		            HasSubtree(pRootA->right, pRootB);
		    }
		};

	 */
}
