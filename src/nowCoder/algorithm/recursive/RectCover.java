package nowCoder.algorithm.recursive;

/**
 * ���󸲸����⣬ʵ�ʻ���쳲���������
 * ��2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ�
 * �ܹ��ж����ַ�����
 * 
 * ��һ��С���󣬸��Ǵ���������ʱ��������ѡ�񣬺��ŷź����ŷ�
 *   ���ŷţ��ұ߻�ʣ�£�2 * (n - 1)������f(n - 1)
 *   ���ŷţ���߱ض��Ƿ�����, f(n - 2)
 * @author snow
 *
 */
public class RectCover {
	public int rectCover(int target) {
		if (target <= 1){//=0ʱ��һ�ַ���
			return 1;
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
}
