package nowCoder.basic.plus;

/**
 * 模拟c中int*类型的引用
 * 用处：如每次递归中需要用到方法中传入进去的int*类型，执行结果的返回值
 * 可以传递一个对象进入，修改属性就行
 * @author snow
 *
 */
public class CIntReferance {
	public static void main(String[] args) {
		CIntReferance intRef = new CIntReferance();
		Integer c = 0;
		intRef.test(c);
		System.out.println(c.intValue());//结果还是0，证明没有获取修改后的值
		Integer cb = 256;
		intRef.test(cb);
		System.out.println(cb.intValue());//结果是256,还是没有修改
		String cr = "0";
		intRef.test(cr);
		System.out.println(cr);//结果还是0，我草
		IntRef intRefer = new IntRef(0);
		intRef.test(intRefer);
		System.out.println(intRefer.i);//1,成功
		
	}
	public void test(Integer c){
		c++;
	}
	public void test(String c){
		//String b = (Integer.parseInt(c) + 1) + "";
		c = (Integer.parseInt(c) + 1) + "";//按理说修改了c的引用了啊
	}
	public void test(IntRef intRef){
		intRef.i++;
	}
}
class IntRef{//IntHolder,需要建一个类包装一下，为什么Integer不行呢
	int i;
	public IntRef(int value){
		i = value;
	}
}
