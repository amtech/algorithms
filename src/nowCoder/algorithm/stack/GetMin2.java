package nowCoder.algorithm.stack;

import java.util.Stack;

public class GetMin2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public GetMin2() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	/**
	 * 先将当前数据压入stackData
	 * 1、如果stackMin为空，压入stackMin
	 * 2、如果不为空，比较newNum和stackMin的栈顶元素哪一个更小
	 * 		如果newNum<=栈顶，则stackMin压栈
	 * 		如果栈顶元素小，则将min栈顶元素重复压入栈
	 * @param newNum
	 */
	public void push(int newNum){
		if (stackMin.isEmpty()){
			stackMin.push(newNum);
		}else if (stackMin.peek() >= newNum){
			stackMin.push(newNum);
		}else {
			stackMin.push(stackMin.peek());
		}
		stackData.push(newNum);
	}
	
	/**
	 * value值可能>=min.peek
	 * 每次都弹min
	 * @return
	 */
	public int pop(){
		if (stackData.isEmpty()){
			throw new RuntimeException("your stack is empty..");
		}
		stackMin.pop();
		return stackData.pop();
	}
	
	public int getMin(){
		if (stackMin.isEmpty()){
			throw new RuntimeException("Your stack is empty..");
		}
		return stackMin.peek(); 
	}
}
