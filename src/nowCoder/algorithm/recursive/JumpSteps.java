package nowCoder.algorithm.recursive;

/**
 * ��̨������:һֻ����һ�ο�����һ��̨�ף�Ҳ����������̨�ף������������n��̨�׹��ж��������� 
 * ���������̨�ף�������������
 * 	1������������ÿ����һ��
 * 	2��һ��������
 * ��n��̨�׿�����n�ĺ�����f(n)
 * ��n>2ʱ����һ��������ѡ��
 * 	 һ��ֻ��һ������ʱ������Ŀ=�����n-1��̨�׵�������Ŀf(n - 1)
 * 	��һ�������ڣ�������Ŀ=�����n-2��̨�׵�������Ŀf(n - 2)
 * f(n) = f(n - 1) + f (n - 2)     쳲���������
 * @author snow
 *
 */
public class JumpSteps {
	//����Ǵ�1��ʼ�ģ����Ǵ�0
	public int JumpFloor(int target) {
		if (target <= 1){
			return target <= 0 ? 0 : 1;
		}
		int fibNOne = 1;
		int fibNTwo = 1;
		int fibNN = 0;
		for (int i = 2; i <= target; i++) {
			fibNN = fibNOne + fibNTwo;
			fibNOne = fibNTwo;
			fibNTwo = fibNN;
		}
		return fibNN;
    }
	public static void main(String[] args) {
		JumpSteps jumpSteps = new JumpSteps();
		System.out.println(jumpSteps.JumpFloor(2));
	}
}
