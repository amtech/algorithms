package nowCoder.algorithm.string;

/**
 * ����ת�ַ���
 * Ҫ��ʱ�临�Ӷ�O(n),�ռ�O(1)
 * @author snow
 *
 */
public class LeftShiftString {
	
	/**
	 * ��һ��������λ����ÿ��һλһλ���ƶ�����m��
	 * @param str
	 * @param n
	 */
	public void leftShiftOne(char[] str, int n){
		char t = str[0];//���������һλ�ַ�
		for (int i = 1; i < n; i++) {
			str[i - 1] = str[i];
		}
		str[n - 1] = t;
	}
	
	public void leftShift(char[] str, int n, int m){
		while (m-- > 0){//ʱ�临�Ӷȣ�O(m * n)
			leftShiftOne(str, n);
		}
	}
}
