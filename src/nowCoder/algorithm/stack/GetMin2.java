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
	 * �Ƚ���ǰ����ѹ��stackData
	 * 1�����stackMinΪ�գ�ѹ��stackMin
	 * 2�������Ϊ�գ��Ƚ�newNum��stackMin��ջ��Ԫ����һ����С
	 * 		���newNum<=ջ������stackMinѹջ
	 * 		���ջ��Ԫ��С����minջ��Ԫ���ظ�ѹ��ջ
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
	 * valueֵ����>=min.peek
	 * ÿ�ζ���min
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
