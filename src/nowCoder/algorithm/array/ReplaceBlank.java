package nowCoder.algorithm.array;

/**
 * �滻�ַ����еĿո�
 * ��' '�滻�� "%20"
 * ���������У����URL�������������ַ�������' ', '#'�ȡ����ܵ��·��������޷������ȷ�Ĳ���ֵ
 * ��Ҫ�������ַ�ת���ɷ���������ʶ����ַ�   ���� %�����ASCII����λ16���Ƶı�ʾ
 *   ��ո�32�� ������%20
 * �滻ʱ��ԭ��һ���ո��ַ����滻����% 2 0�����ַ����ַ����ĳ�������2
 * 	�����ԭ�����ַ��������滻����ǰ���󣬺�������ݾͿ��ܱ�����
 * 	����ڴ��㹻�����Դ����µ��ַ�����Ȼ�����µ������滻
 *             ��Ҫ�������Թٵ�����
 *             
 *  ��ֱ�۵���������ǰ����ɨ�������ַ����������ո���滻��"%20"�������������Ҫȫ������2λ O(n)
 *  ��O(n)���ո���ʱ�临�Ӷ�ΪO(n ^ 2)
 *  
 *  ��2�� �Ӻ���ǰɨ�裬�滻
 *    �ȴ�ǰ����ɨ��һ�Σ�ͳ�Ƴ��ո�ĸ�����������滻����ַ������ܳ���
 *           �ܳ��� = ԭ�����ܳ��� + 2 * �ո�ĸ���
 *    ������ָ�룬p1ָ��ԭ���ַ�����ĩβ��P2ָ���滻֮����ַ�����ĩβ
 *    �Ӻ���ǰɨ��
 *    ��ǰ�ƶ�ָ��P1�������P1ָ����ַ����Ƶ�P2ָ���λ�ã�ֱ��������һ���ո�Ϊֹ
 *     P1��ǰ�ƶ�һ��λ�ã���P2֮ǰ����"%20"��P2��ǰ�ƶ�3��λ��
 *    ֱ��P2��P1ָ��ͬһ��λ�ã��������еĿո��Ѿ��滻���
 * 
 * ָ��
 * @author snow
 *
 */
public class ReplaceBlank {
	/**
	 * c��ֱ����ָ�룬java����Ӧ����char����
	 * @param str
	 * @return
	 */
	public String replaceBlank(String str, int len){//������֪
		if (len <= 0){
			return "";
		}
		char[] strArray = str.toCharArray();//ת����char����  �ǲ��Ƕ�̬���ݵģ�java�ַ���ĩβû��\n
		int countBlank = 0;
		int P1 = len - 1;//ָ��ԭʼ�ַ�����ĩβ
		for (int i = 0; i < len; i++) {
			if (strArray[i] == ' '){
				countBlank++;
			}
		}
		int P2 = P1 + 2 * countBlank;//ָ�����ַ�����ĩβ
		char[] newStrArray = new char[P2 + 1];//�����滻�������
		while (P2 >= 0){
		//ֻҪ����ָ��ָ����ͬ��λ�ã���ǰ��û�пո�,���ǻ���Ҫ��ǰ����ַ������Ƶ���������
			if (strArray[P1] != ' '){
				newStrArray[P2--] = strArray[P1--];
			} else {
				newStrArray[P2--] = '0';
				newStrArray[P2--] = '2';
				newStrArray[P2--] = '%';
				P1--;
			}
		}
		return new String(newStrArray);
	}
	
	public String replaceSpace(StringBuffer str) {
		/*StringBuffer sb = null;
		for (int i = 0, len = str.length(); i < len; i++) {
			���ֱ��ʹ��StringBuffer��û���Ѷ�
		}*/
		char[] strArray = str.toString().toCharArray();//ת����char����  �ǲ��Ƕ�̬���ݵģ�java�ַ���ĩβû��\n
		int countBlank = 0;
		int P1 = strArray.length - 1;//ָ��ԭʼ�ַ�����ĩβ
		for (int i = 0; i < P1 + 1; i++) {
			if (strArray[i] == ' '){
				countBlank++;
			}
		}
		int P2 = P1 + 2 * countBlank;//ָ�����ַ�����ĩβ
		char[] newStrArray = new char[P2 + 1];//�����滻�������
		while (P2 >= 0){
		//ֻҪ����ָ��ָ����ͬ��λ�ã���ǰ��û�пո�,���ǻ���Ҫ��ǰ����ַ������Ƶ���������
			if (strArray[P1] != ' '){
				newStrArray[P2--] = strArray[P1--];
			} else {
				newStrArray[P2--] = '0';
				newStrArray[P2--] = '2';
				newStrArray[P2--] = '%';
				P1--;
			}
		}
		return new String(newStrArray);
    }
	public static void main(String[] args) {
		ReplaceBlank rb = new ReplaceBlank();
		System.out.println(rb.replaceSpace(new StringBuffer("i love you")));
	}
}
