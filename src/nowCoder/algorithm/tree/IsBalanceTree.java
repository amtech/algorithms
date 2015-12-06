package nowCoder.algorithm.tree;

/**
 * �ж�һ�����ǲ���ƽ���������
 * 		����ڵ���������������������1
 * �٣���������ÿһ���ڵ��ʱ�򣬵��ú���TreeDepth�õ�����������������ȣ�Ȼ���ж�
 * 		ȱ�㣺ÿһ�����ᱻ�ظ�������Σ�Ч�ʵ�
 * @author snow
 *
 */
public class IsBalanceTree {
	
	public boolean isBalancedTree(TreeNode root){
		IntHolder depth = new IntHolder(0);
		return isBalanced(root, depth);//ֻҪ����һ����������ƽ�����Ͳ���
	}
	//Ҳ���Խ�boolean��������Ȱ�װ��һ���෵��
	public boolean isBalanced(TreeNode root, IntHolder depth){
		if (root == null){
			depth.i = 0;//�������Ϊ0
			return true;
		}
		IntHolder left = new IntHolder(0);
		IntHolder right = new IntHolder(0);
		if (isBalanced(root.left, left) && isBalanced(root.right, right)){
			//������������ƽ����
			int diff = left.i - right.i;
			if (diff <= 1 && diff >= -1){//����������Ȳ�����1
				depth.i = ((left.i > right.i) ? left.i : right.i) + 1;
				return true;
			}
		}
		return false;
	}
	
}
class IntHolder{//��װint��ģ��int*,������ֵ
	int i;
	public IntHolder(int val){
		i = val;
	}
}
