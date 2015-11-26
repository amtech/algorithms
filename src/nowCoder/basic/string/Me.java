package nowCoder.basic.string;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Me {
	public static void main(String[] args) {
		/*
		 * nowCoder/basic/string/Me.class  
		 * old -> new
		 * 第一个参数是字符序列字面常量   会将所有的.替换成/ 
		 */
		System.out.println(Me.class.getName().replace(".", "/") + ".class");
		/*
		 * ////////////////////////.clas 
		 * 第一个参数是一个正则表达式，
		 * "."可以替换任何单个的字符，因此类名中的每一个字符都被替换成/
		 */
		System.out.println(Me.class.getName().replaceAll(".", "/") + ".class");
		/*
		 * nowCoder/basic/string/Me.class
		 * \标识转义字符的开始，因此还需要 一个\来转移\自身
		 */
		System.out.println(Me.class.getName().replaceAll("\\.", "/") + ".class");
		
		/**
		 * java5新增java.uitl.regex.Pattern.quote:
		 * 接收一个字符串作为参数，可以添加必要的转移字符，将返回一个正则表达式字符串,将精确匹配所接收的字符串
		 * nowCoder/basic/string/Me.class
		 * 
		 * 正确的行为是与平台相关的，并不是所有的文件系统都使用/来分隔层次结构的文件名组成部分
		 */
		System.out.println(Me.class.getName().replaceAll(Pattern.quote("."), "/") + ".class");
		
		Me me = new Me();
		me.replace();
		me.replaceBySeparator();
	}
	
	public void replace(){
		String str = "123 {{  name }} {{  345 ";
		//替换字符串中的所有的 "{{ "  字面常量
		System.out.println(str.replace("{{ ", "me"));
		//Pattern.quote将字面常量转换成对应的正则
		System.out.println(str.replaceAll(Pattern.quote("{{ "), "me"));
	}
	
	public void replaceBySeparator(){
		/*
		 * java.io.File.separator,指定了一个公共的String域，包含了平台相关的文件名分隔符
		 */
		System.out.println(java.io.File.separator);//  \
		/*该语句，在win下会报异常
		 * replaceAll("\\.", File.separator) 第二个参数是不是一个普通的字符串，而是一个替代字符串
		 * \ 会把紧随其后的字符转义，导致其按字面含义被处理了
		 * java.util.regex.Matcher.quoteReplacement,会将字符串转换成相应的替换字符串
		 * 
		 * 可以直接调用String.replace(CharSequence, CharSequence),作用和replaceAll相同
		 * 但是 ，将模式和替代物都当作字面含义的字符串处理
		 * 
		 * 正则表达式所引发的问题趋向于在运行时刻而不是在编译时刻暴露出来
		 */
		//System.out.println(Me.class.getName().replaceAll("\\.", File.separator));
		System.out.println(Me.class.getName().replaceAll("\\.", 
				Matcher.quoteReplacement(File.separator)));
		System.out.println(Me.class.getName().replace(".", File.separator ));
	}
}
