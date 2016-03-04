package nowCoder.algorithm.tree;

/**
 * �������Ŷ�����A��B���ж�B�ǲ���A���ӽṹ��
 * @author snow
 *
 */
public class HasSubTree {
	
	/**
	 *��BΪ�գ��㲻�����
	 * �٣���A�в��Һ�B�ĸ����ֵ��ͬ�Ľ��R
	 * �ڣ����ж�A����RΪ�����������ǲ��ǰ���Bһ���Ľṹ
	 * �ۣ�����A��˵��ÿһ�����Ϊ���ж��Ƿ����B����һ���ݹ�Ĺ���
	 * �ݹ����Ƚϼ�࣬�������ʱû�������Ҫ��ͨ������õݹ�
	 * 
	 * ������
	 * ���ñ���A��B�������������У��ж�A�������Ƿ����B ( KMP,���߽��Ϊstring��Ȼ��contains)
	 * ����һ���������п��ܶ�Ӧ�������ṹ��������Ҫ�����������
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null){
			if (root1.val == root2.val){
				//�ж���root1Ϊ���������Ƿ����root2
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
	 * ������R��ֵ��B�ĸ�����ֵ��ͬ
	 * 	�ݹ���жϸ������ҽ���ֵ�ǲ�����ͬ
	 * ��ֹ����������A����B��Ҷ�ڵ�
	 */
	private boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null){
			return true;
		}
		if (root1 == null){
			//��ʱroot2�϶���Ϊnull�����Ϊnull��һ��if�Ѿ��жϷ�����
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
	 * ���úö�·���ԣ���ȫ������ô��flag
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
