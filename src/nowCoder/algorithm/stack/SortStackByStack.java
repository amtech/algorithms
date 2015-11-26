package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 如果help栈顶的元素比stack栈顶弹出的元素cur大，循环弹出help的元素，直到cur <= help.peek
 * 然后再将cur压入到help中。当stack为空时，再将help弹出压入到stack中
 * @author snow
 *
 */
public class SortStackByStack {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()){
			int cur = stack.pop();//这个数已经从stack中弹出
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
		 * 因为每次stack弹出后，size都会变，所以这种循环遍历的方式，对栈不可行
		 * 应该使用while循环 
			System.out.print(stack.pop()); 
		}*/
	}
}
