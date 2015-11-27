package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * ����ջ�е���СԪ�أ�O(1)
 * stackMin�д��Ԫ���Ǵ�ջ�׵�ջ���𽥱�С�ģ�ջ��Ԫ�ؼ���stackMin�е���СԪ�أ�
 * Ҳ��stackData�е���СԪ��
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
	 * �Ƚ���ǰ����ѹ��stackData
	 * 1�����stackMinΪ�գ�ѹ��stackMin
	 * 2�������Ϊ�գ��Ƚ�newNum��stackMin��ջ��Ԫ����һ����С
	 * 		���newNum<=ջ������stackMinѹջ
	 * 		���>������ջ
	 * @param newNum
	 */
	public void push(int newNum){
		if (stackMin.isEmpty()){
			stackMin.push(newNum);
		}else if (stackMin.peek() >= newNum){
			//�����֧��˵��stackMin��Ϊ�գ�����peek
			stackMin.push(newNum);
		}
		stackData.push(newNum);
	}
	
	/**
	 * ��value=ջ��Min��Ԫ��ʱ��stackMin����ջ��������ʱ������
	 * stackMin�д��Ԫ���Ǵ�ջ�׵�ջ���𽥱�С�ģ�ջ��Ԫ�ؼ���stackMin�е���СԪ�أ�Ҳ��stackData�е���СԪ��
	 * valueֵ����>=min.peek
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
