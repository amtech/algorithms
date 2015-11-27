package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * ���õݹ��ջ��������һ��ջ
 * @author snow
 *
 */
public class ReverseStack {
	//��stack��ջ��Ԫ��ɾ��������
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
