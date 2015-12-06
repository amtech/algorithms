package nowCoder.algorithm.string;

/**
 * ����һ��Ӣ�ľ��ӣ���ת������Ӣ�ĵ��ʵ�˳�򣬵��������ַ���˳�򲻱�
 * ���η�ת�ַ�����
 * �٣���ת���������е��ַ�
 * �ڣ��ٷ�תÿ���������ַ���˳��
 * ������
 * ����split��String��Ϊһ���������飬Ȼ�󽻻�����˳�򼴿�
 * @author snow
 *
 */
public class ReverseSentence {
	
	/**
	 * null��Ҫ���жϣ����������ɿ�ָ��
	 * trim()��������ȥ �ո� ׼ȷ��˵, ��ȥ���ַ������˵Ĳ��ɼ��ַ�, ����: �ո�, �س���, �Ʊ����
	 * һ��������֤�û���������������
	 * @param str
	 * @return
	 */
	public String reverseSentence(String str) {
		if (str == null /*|| str.equals("") || str.equals(" ") */|| str.trim().equals("")){
			return str;//���ӿ����ɶ���ո����,ǰ���п����пո�
		}
		
        String[] strArr = str.split(" ");//�п��ܾ���ֻ��һ���ո� " "
        for (int i = 0, j = strArr.length - 1; i < j; i++, j--) {
			String temp = strArr[i];
			strArr[i] = strArr[j];
			strArr[j] = temp;
		}
        String s = "";//����дΪnull  ����null����Ϊ�ַ���
        for (int i = 0, len = strArr.length; i < len - 1; i++) {
        	
			s += strArr[i] + " ";
		}
        s += strArr[strArr.length - 1];
        return s;
    }
	
	/*public String reverseSentence(String str) {
        String s = "";//����дΪnull  ����null����Ϊ�ַ���
        char[] ch = str.toCharArray();
        
        return s;
    }*/
	
	public static void main(String[] args) {
		ReverseSentence reverse = new ReverseSentence();
		String str = reverse.reverseSentence("    a ");
		System.out.println(str + "|");
		String s = null;
		//System.out.println(s.isEmpty());//��ָ��
		System.out.println(reverse.reverseSentence2("i love  you") + "|");
		String test = " a ";
		String[] arr = test.split(" ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("**" + arr[i] + "**");//****(��һ��Ԫ��Ϊ"")   **a**
		}
		System.out.println(arr.length);//2
	}
	public String reverseSentence2(String str) {
        if(str == null || str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = a.length; i > 0; i--){//�Ӻ���ǰ����
            sb.append(a[i-1]);
            if(i > 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
	
	public String reverseSentence3(String str) {//ʹ�õݹ� "  a "�������Ҳ����
        return (str.lastIndexOf(" ") == -1) ? str 
        		: str.substring(str.lastIndexOf(" ") + 1) + " " 
        	+ reverseSentence3(str.substring(0, str.lastIndexOf(" ")));
    }
}

