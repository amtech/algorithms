package nowCoder.basic;

import java.io.UnsupportedEncodingException;

public class StringCheese {
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = new byte[256];
		for (int i = 0; i < 255; i++) {
			bytes[i] = (byte) i;//�����Ǹ���
		}
		/*������õ�ƽ̨Ĭ�ϵ��ַ�����win��GBK 
		 * byte��ֵͨ��new String()ת������char��ֵ
		 * char���޷��ŵģ�û�и���
		*/
		String str = new String(bytes);
		String str1 = new String(bytes, "ISO-8859-1");//ָ���ַ������������0~255
		
		//System.out.println(str);
		for (int i = 0, n = bytes.length; i < n; i++) {
			/**
			 * �ڲ�ͬ���������У��������ͬ�����У���ʱ����������ֹ����Ϊ��ȫ��ȷ��
			 * Str�������ַ�����һ�����������ܲ�����byte����ĳ���
			 */
			//System.out.println((int)str/*1*/.charAt(i) + " ");
		}
		System.out.println(java.nio.charset.Charset.defaultCharset());//GBK
	}
}
