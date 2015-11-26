package nowCoder.basic.plus;

public class IPlusPlus {
	public static void main(String[] args) {
		IPlusPlus ipp = new IPlusPlus();
		int i  = 0;
		int j = 0;
		ipp.fun(i);
		/**
		 * 分三步，第一步，计算i++表达式，值为0。第二步，i自增，变为1.第三步，赋值，将0赋值给i。
		 * 以下是i= i ++;字节码指令:
		 * iload_2       //将i从 局部变量表 加载到 栈顶, i = 0
		 * iinc     2, 1  //将 局部变量表 中的i 加1, 局部变量表中变为1
		 * istore_2      //将栈顶的0 存回到 局部变量表, i变回0
		 */
		i = i++;
		System.out.println(i++);//为什么是0呢
		j = i++;
		System.out.println(j);//1
		
		/**
		 * 上面的回答都没说明白为什么会这样，首先运行这个程序，在c/c++和java会发现不一样，
		 * 在c/c++中答案是1，在java中答案是0。为什么呢？
		 * 原因：jvm里面有两个存储区，一个是暂存区（是一个堆栈，以下称为堆栈），另一个是变量区。
		 * jvm会这样运行这条语句，　JVM把count值（其值是0）拷贝到临时变量区。
		 *  步骤2　count值加1，这时候count的值是1。 
		 *  步骤3　返回临时变量区的值，注意这个值是0，没修改过。 
		 *  步骤4　返回值赋值给count，此时count值被重置成0。 
		 *  c/c++中没有另外设置一个临时变量或是临时空间来保存i,所有操作都是在一个内存空间中完成的。
		 *  所以答案是1。
		 */
	}
	
	void fun(int i ){
		i++;
	}
}
