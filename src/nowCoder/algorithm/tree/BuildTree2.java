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
	  * ����ǰ����������е�����
	  * @param pre
	  * @param in
	  * @return ����TreeNode��
	  */
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length <= 0 ){
        	return null;//��Ϊ��
        }//lengthΪ�������ռ�ĳ��ȣ����ǳ�ʼ���ĳ���     ����Ӧ����ʵ�ʴ����ݵĳ���
        return reConstructCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
	
	private TreeNode reConstructCore(int[] pre, int[] in, 
			int startPre, int endPre, int startIn, int endIn){
		TreeNode root = new TreeNode(pre[startPre]);//ǰ������ĵ�һ�����Ϊ�����
		//����ֻ��һ���������
		if (startPre == endPre){//ǰ�����ֻ��һ�����
			if (startIn == endIn && pre[startPre] == in[startIn]){//ֻ��һ�����
				return root;
			}else {
				try {
					throw new Exception("��������ǰ��������ܹ���һ������������ƥ��");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//�������������ҵ������
		int rootIndexIn = startIn;
		while (rootIndexIn <= endIn && in[rootIndexIn] != root.val){
			//�˳�ѭ���� �����ҵ�����㣬����û���ҵ������
			rootIndexIn++;
		}
		if (rootIndexIn == endIn && in[rootIndexIn] != root.val){
			try {
				throw new Exception("�������д�������������û��ǰ������������Ӧ�ĸ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int leftLength = rootIndexIn - startIn;//�������ĳ���
		int preEnd = startPre + leftLength;//ǰ������������������һ�����λ��
		if (leftLength > 0){
			root.left = reConstructCore(pre, in,
					startPre + 1, preEnd, startIn, rootIndexIn -1 );
		}
		if (leftLength < endPre - startPre){//��������Ϊ�գ�����������
			root.right = reConstructCore(pre, in, 
					preEnd + 1, endPre, rootIndexIn + 1, endIn);
		}
		return root;
	}
	public static void main(String[] args) {
		/*int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};//ֱ�Ӹ������ʼ��
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};*/
		int[] pre = {};
		int[] in = {};
		/*int[] pre = new int[0];
		int[] in = new int[0];*/
		BuildTree2 bt = new BuildTree2();
		System.out.println(bt.reConstructBinaryTree(pre, in));
	}
}
