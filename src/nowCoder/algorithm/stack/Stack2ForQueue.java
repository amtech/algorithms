package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * ������ջ��ʵ��һ������
 * ɾ��һ��Ԫ�أ�
 * ��stack2��Ϊ��ʱ��ջ����Ԫ�ؾ������Ƚ�����е�Ԫ�أ����Ե���
 * ���stack2Ϊ�գ���stack1��Ԫ�����������ѹ��ջstack2
 * �����Ƚ�����е�Ԫ�ر�ѹ��stack1�ĵ׶ˣ�����������ѹ��֮��ʹ���stack2�Ķ����ˣ����Ե���
 * ����Ԫ�أ�
 * ѹ��stack1
 * 
 * ��������������ʵ��һ��ջ
 * @author snow
 *
 */
public class Stack2ForQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if (stack2.size() <= 0 ){
    		while (stack1.size() > 0){
    			int top = stack1.pop();
    			stack2.push(top);
    		}
    	}
    	if (stack2.size() == 0){
    		try {
				throw new Exception("����Ϊ�գ�û��Ԫ�ؿ���ɾ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	return stack2.pop();
    }
    public static void main(String[] args) {
		Stack2ForQueue s2q = new Stack2ForQueue();
		s2q.push(1);
		s2q.push(2);
		s2q.push(3);
		System.out.println(s2q.stack1.toString());
		s2q.pop();
		System.out.println(s2q.stack1.toString() + " " + s2q.stack2.toString());
		s2q.pop();
		s2q.push(4);
		
	}
}
