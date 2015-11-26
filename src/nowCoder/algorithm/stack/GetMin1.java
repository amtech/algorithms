package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * 返回栈中的最小元素，O(1)
 * stackMin中存的元素是从栈底到栈顶逐渐变小的，栈顶元素既是stackMin中的最小元素，
 * 也是stackData中的最小元素
 * 
 * @author snow
 *
 */
public class GetMin1 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public GetMin1() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	/**
	 * 先将当前数据压入stackData
	 * 1、如果stackMin为空，压入stackMin
	 * 2、如果不为空，比较newNum和stackMin的栈顶元素哪一个更小
	 * 		如果newNum<=栈顶，则stackMin压栈
	 * 		如果>，不入栈
	 * @param newNum
	 */
	public void push(int newNum){
		if (stackMin.isEmpty()){
			stackMin.push(newNum);
		}else if (stackMin.peek() >= newNum){
			//这个分支，说明stackMin不为空，可以peek
			stackMin.push(newNum);
		}
		stackData.push(newNum);
	}
	
	/**
	 * 当value=栈顶Min的元素时，stackMin弹出栈顶，不等时，不弹
	 * stackMin中存的元素是从栈底到栈顶逐渐变小的，栈顶元素既是stackMin中的最小元素，也是stackData中的最小元素
	 * value值可能>=min.peek
	 * @return
	 */
	public int pop(){
		if (stackData.isEmpty()){
			throw new RuntimeException("your stack is empty..");
		}
		int value = stackData.pop();
		if (value == stackMin.peek()){//this.getMin()
			stackMin.pop();
		}
		return value;
	}
	
	public int getMin(){
		if (stackMin.isEmpty()){
			throw new RuntimeException("Your stack is empty..");
		}
		return stackMin.peek();
	}
	public static void main(String[] args) {
		
	}
}
