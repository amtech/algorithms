package nowCoder.basic.string;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Me {
	public static void main(String[] args) {
		/*
		 * nowCoder/basic/string/Me.class  
		 * old -> new
		 * ��һ���������ַ��������泣��   �Ὣ���е�.�滻��/ 
		 */
		System.out.println(Me.class.getName().replace(".", "/") + ".class");
		/*
		 * ////////////////////////.clas 
		 * ��һ��������һ��������ʽ��
		 * "."�����滻�κε������ַ�����������е�ÿһ���ַ������滻��/
		 */
		System.out.println(Me.class.getName().replaceAll(".", "/") + ".class");
		/*
		 * nowCoder/basic/string/Me.class
		 * \��ʶת���ַ��Ŀ�ʼ����˻���Ҫ һ��\��ת��\����
		 */
		System.out.println(Me.class.getName().replaceAll("\\.", "/") + ".class");
		
		/**
		 * java5����java.uitl.regex.Pattern.quote:
		 * ����һ���ַ�����Ϊ������������ӱ�Ҫ��ת���ַ���������һ��������ʽ�ַ���,����ȷƥ�������յ��ַ���
		 * nowCoder/basic/string/Me.class
		 * 
		 * ��ȷ����Ϊ����ƽ̨��صģ����������е��ļ�ϵͳ��ʹ��/���ָ���νṹ���ļ�����ɲ���
		 */
		System.out.println(Me.class.getName().replaceAll(Pattern.quote("."), "/") + ".class");
		
		Me me = new Me();
		me.replace();
		me.replaceBySeparator();
	}
	
	public void replace(){
		String str = "123 {{  name }} {{  345 ";
		//�滻�ַ����е����е� "{{ "  ���泣��
		System.out.println(str.replace("{{ ", "me"));
		//Pattern.quote�����泣��ת���ɶ�Ӧ������
		System.out.println(str.replaceAll(Pattern.quote("{{ "), "me"));
	}
	
	public void replaceBySeparator(){
		/*
		 * java.io.File.separator,ָ����һ��������String�򣬰�����ƽ̨��ص��ļ����ָ���
		 */
		System.out.println(java.io.File.separator);//  \
		/*����䣬��win�»ᱨ�쳣
		 * replaceAll("\\.", File.separator) �ڶ��������ǲ���һ����ͨ���ַ���������һ������ַ���
		 * \ ��ѽ��������ַ�ת�壬�����䰴���溬�屻������
		 * java.util.regex.Matcher.quoteReplacement,�Ὣ�ַ���ת������Ӧ���滻�ַ���
		 * 
		 * ����ֱ�ӵ���String.replace(CharSequence, CharSequence),���ú�replaceAll��ͬ
		 * ���� ����ģʽ������ﶼ�������溬����ַ�������
		 * 
		 * ������ʽ������������������������ʱ�̶������ڱ���ʱ�̱�¶����
		 */
		//System.out.println(Me.class.getName().replaceAll("\\.", File.separator));
		System.out.println(Me.class.getName().replaceAll("\\.", 
				Matcher.quoteReplacement(File.separator)));
		System.out.println(Me.class.getName().replace(".", File.separator ));
	}
}
