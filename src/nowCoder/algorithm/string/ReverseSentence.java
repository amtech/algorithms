package nowCoder.algorithm.string;

/**
 * 输入一个英文句子，翻转句子中英文单词的顺序，但单词内字符的顺序不变
 * 两次翻转字符串：
 * ①：翻转句子中所有的字符
 * ②：再翻转每个单词中字符的顺序
 * 法二：
 * 利用split将String分为一个单词数组，然后交换单词顺序即可
 * @author snow
 *
 */
public class ReverseSentence {
	
	/**
	 * null需要先判断，否则可能造成空指针
	 * trim()不仅仅是去 空格 准确来说, 是去除字符串两端的不可见字符, 包括: 空格, 回车符, 制表符等
	 * 一般用于验证用户名，密码输入框等
	 * @param str
	 * @return
	 */
	public String reverseSentence(String str) {
		if (str == null /*|| str.equals("") || str.equals(" ") */|| str.trim().equals("")){
			return str;//句子可能由多个空格组成,前后都有可能有空格
		}
		
        String[] strArr = str.split(" ");//有可能句子只有一个空格 " "
        for (int i = 0, j = strArr.length - 1; i < j; i++, j--) {
			String temp = strArr[i];
			strArr[i] = strArr[j];
			strArr[j] = temp;
		}
        String s = "";//不能写为null  否则null将作为字符串
        for (int i = 0, len = strArr.length; i < len - 1; i++) {
        	
			s += strArr[i] + " ";
		}
        s += strArr[strArr.length - 1];
        return s;
    }
	
	/*public String reverseSentence(String str) {
        String s = "";//不能写为null  否则null将作为字符串
        char[] ch = str.toCharArray();
        
        return s;
    }*/
	
	public static void main(String[] args) {
		ReverseSentence reverse = new ReverseSentence();
		String str = reverse.reverseSentence("    a ");
		System.out.println(str + "|");
		String s = null;
		//System.out.println(s.isEmpty());//空指针
		System.out.println(reverse.reverseSentence2("i love  you") + "|");
		String test = " a ";
		String[] arr = test.split(" ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("**" + arr[i] + "**");//****(第一个元素为"")   **a**
		}
		System.out.println(arr.length);//2
	}
	public String reverseSentence2(String str) {
        if(str == null || str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = a.length; i > 0; i--){//从后往前构造
            sb.append(a[i-1]);
            if(i > 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
	
	public String reverseSentence3(String str) {//使用递归 "  a "这个例子也适用
        return (str.lastIndexOf(" ") == -1) ? str 
        		: str.substring(str.lastIndexOf(" ") + 1) + " " 
        	+ reverseSentence3(str.substring(0, str.lastIndexOf(" ")));
    }
}

