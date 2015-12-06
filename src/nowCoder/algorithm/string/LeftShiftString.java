package nowCoder.algorithm.string;

/**
 * ����ת�ַ���: ���ַ���ǰn���ַ��ƶ����ַ�����β��
 * Ҫ��ʱ�临�Ӷ�O(n),�ռ�O(1)
 * ˼·�����ַ�����Ϊ�����֣�ǰn���ַ����ͺ�����ַ���
 * �٣���תǰn���ַ�
 * �ڣ���ת������ַ�
 * �ۣ���ת�����ַ���
 * ���磺abcdefg����תǰ2�������Ϊcdefgab
 * ��תab -> ba
 * ��ת���� cdefg -> gfedc
 * ��תbagfedc -> cdefgab
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
	
	//����
	public String LeftRotateString(String str, int n) {
		if (str == null || str.equals("") || n < 0){//n���ܴ���str�ĳ��ȣ���Ҫ��ģ
			return str;
		}
		char[] ch = str.toCharArray();
		int len = ch.length;
		reverse(ch, 0, n % len - 1);//Ӧ������ģ��Ȼ����-1
		reverse(ch, n % len, ch.length - 1);
		reverse(ch, 0, ch.length - 1);
		return String.valueOf(ch);//��char[]ת����String
    }
	
	private void reverse(char[] ch, int begin, int end){
		char temp = ' ';
		while (begin < end){
			temp = ch[begin];
			ch[begin] = ch[end];
			ch[end] = temp;
			begin++;
			end--;
		}
	}
	
	/**
	 * ţ�Ƶķ���
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString2(String str, int n) {
		if (str == null || str.equals("") || n < 0){//n���ܴ���str�ĳ��ȣ���Ҫ��ģ
			return str;
		}
        int len = str.length();
        n = n % len;
        str += str;//ţ�ư�!!!
        return str.substring(n, len + n);//����
	}
	
	public static void main(String[] args) {
		LeftShiftString shift = new LeftShiftString();
		String str = shift.LeftRotateString2("abcdefg", 2);
		System.out.println(str);
	}
}
