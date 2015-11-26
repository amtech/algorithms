package nowCoder.algorithm.stack;

import java.util.Stack;

/**
 * 用两个栈，实现一个队列
 * 删除一个元素：
 * 当stack2不为空时，栈顶的元素就是最先进入队列的元素，可以弹出
 * 如果stack2为空，把stack1的元素逐个弹出并压缩栈stack2
 * 由于先进入队列的元素被压倒stack1的底端，经过弹出和压入之后就处于stack2的顶端了，可以弹出
 * 插入元素：
 * 压入stack1
 * 
 * 还可以两个队列实现一个栈
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
				throw new Exception("队列为空，没有元素可以删除");
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
