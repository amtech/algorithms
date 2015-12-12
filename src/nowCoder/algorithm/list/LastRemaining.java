package nowCoder.algorithm.list;

import java.util.ArrayList;

/**
 * 圆圈中剩下的数字(约瑟夫环问题):
 * 0到n-1个数字，从0开始，每次删除第m个数字，求圆圈中剩下的最后一个数字
 * 法一：经典的解法：用环形链表模拟圆圈
 * 	可以用LinkedList，但是他自身并不是环形结构，因此每当迭代器扫描到最后一个元素时，可以将迭代器移动到链表的头部
 * 	环形链表需要重复遍历很多遍，没删除一个数字需要m步运算，总共有n个数字，需要O(mn)
 * 	还需要一个长度为n的辅助链表来模拟圆圈，所以需要O(n)空间
 * 法二：分析每次被删除的数字的规律，并直接计算圆圈中剩下的数字
 * 	分析过程详见<<剑指offer>>
 *      		0        , n = 1;
 *  f(n, m) = {
 *  			[f(n -1, m) + m] % n , n > 1;
 * @author snow
 *
 */
public class LastRemaining {
	
	/*
	 *  我们知道第一个人(编号一定是m%n-1) 出列之后，剩下的n-1个人组成了一个
	 *  新  的约瑟夫环（以编号为k=m%n的人开始）:
        k  k+1  k+2  ... n-2, n-1, 0, 1, 2, ... k-2并且从k开始报0。
           把他们的编号做一下转换：
		k     --> 0
		k+1   --> 1
		k+2   --> 2
		...
		n -1  --> n -1 -k
		0     --> n -k     (0可以看作是n，因为会%n)
		1     --> n -k + 1
		...
		k-2   --> n-2
		
		映射前的数字是x，则映射后为(x-k)%n
	 */
	public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1){//检查鲁棒性
        	return -1;
        }
        int last = 0;
        /*
         * 循环直接从2开始，1的时候，默认就是last的0
         * 第n个的结果会是n-1的结果向后推m个，超过取余就得结果
         * 时间复杂度为O(n),空间为O(1)
         */
        for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
        return last;
    }
	
	int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
//          System.out.println(data);
            index = (index + m) % data.size();
//          System.out.println(data.get(index));
            data.remove(index);
            index--;//这里需要-1，因为当前数已被删除
        }
        return data.get(0);
    }
	
	/*
    *这道题我用数组来模拟环，思路还是比较简单，但是各种下标要理清
    */
    public static int findLastNumber(int n,int m){
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if(i>=n) i=0;  //模拟环。
            if(array[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if(step==m) {               //找到待删除的对象。
                array[i]=-1;
                step = 0;
                count--;
            }        
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }
	
	public static void main(String[] args) {
		LastRemaining last = new LastRemaining();
		System.out.println(last.lastRemaining(5, 3));//3
	}
}
