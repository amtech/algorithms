package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * ���stackPush��stackPop��ѹ�����ݣ�����һ���Եİ�stackPush�е�����ȫ��ѹ��
 * ���stackPop��Ϊ�գ�stackPush���Բ�����stackPop��ѹ������
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
