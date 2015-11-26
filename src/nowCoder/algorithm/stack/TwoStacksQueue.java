package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * 如果stackPush往stackPop中压入数据，必须一次性的把stackPush中的数据全部压入
 * 如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
 * @author snow
 *
 */
public class TwoStacksQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStacksQueue(){
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	
	public void add(int num){
		stackPush.push(num);
	}
	
	private void isEmpty(){
		if (stackPop.empty() && stackPush.empty()){
			throw new RuntimeException("Queue is empty");
		}else if (stackPop.empty()){
			while (!stackPop.empty()){
				stackPop.push(stackPush.pop());
			}
		}
	}
	public int pop(){
		isEmpty();
		return stackPop.pop();
	}
	
	public int peek(){
		isEmpty();
		return stackPop.peek();
	}
}
