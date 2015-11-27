package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * ��һ��ջʵ����һ��ջ������
 * ���helpջ����Ԫ�ر�stackջ��������Ԫ��cur��ѭ������help��Ԫ�أ�ֱ��cur <= help.peek
 * Ȼ���ٽ�curѹ�뵽help�С���stackΪ��ʱ���ٽ�help����ѹ�뵽stack��
 * @author snow
 *
 */
public class SortStackByStack {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()){
			int cur = stack.pop();//������Ѿ���stack�е���
			while (!help.isEmpty() && help.peek() > cur){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while (!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 5; i++) {
			stack.add(i);
		}
		SortStackByStack.sortStackByStack(stack);
		/*for (int i = 0; i < stack.size(); i++) {
		 * ��Ϊÿ��stack������size����䣬��������ѭ�������ķ�ʽ����ջ������
		 * Ӧ��ʹ��whileѭ�� 
			System.out.print(stack.pop()); 
		}*/
	}
}
