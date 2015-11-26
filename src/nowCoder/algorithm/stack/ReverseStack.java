package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * 仅用递归和栈操作逆序一个栈
 * @author snow
 *
 */
public class ReverseStack {
	//将stack的栈底元素删除并返回
	public static int getAndRemoveLast(Stack<Integer> stack){
		int result = stack.pop();
		if (stack.isEmpty()){
			return result;
		}else {
			int last = getAndRemoveLast(stack);
			stack.push(result);
			return last;
		}
	}
	public static void reverse(Stack<Integer> stack){
		if (stack.isEmpty()){
			return;
		}
		int i = getAndRemoveLast(stack);
		reverse(stack);
		stack.push(i);
	}
}
