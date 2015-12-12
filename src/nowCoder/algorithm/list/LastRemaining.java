package nowCoder.algorithm.list;

import java.util.ArrayList;

/**
 * ԲȦ��ʣ�µ�����(Լɪ������):
 * 0��n-1�����֣���0��ʼ��ÿ��ɾ����m�����֣���ԲȦ��ʣ�µ����һ������
 * ��һ������Ľⷨ���û�������ģ��ԲȦ
 * 	������LinkedList���������������ǻ��νṹ�����ÿ��������ɨ�赽���һ��Ԫ��ʱ�����Խ��������ƶ��������ͷ��
 * 	����������Ҫ�ظ������ܶ�飬ûɾ��һ��������Ҫm�����㣬�ܹ���n�����֣���ҪO(mn)
 * 	����Ҫһ������Ϊn�ĸ���������ģ��ԲȦ��������ҪO(n)�ռ�
 * ����������ÿ�α�ɾ�������ֵĹ��ɣ���ֱ�Ӽ���ԲȦ��ʣ�µ�����
 * 	�����������<<��ָoffer>>
 *      		0        , n = 1;
 *  f(n, m) = {
 *  			[f(n -1, m) + m] % n , n > 1;
 * @author snow
 *
 */
public class LastRemaining {
	
	/*
	 *  ����֪����һ����(���һ����m%n-1) ����֮��ʣ�µ�n-1���������һ��
	 *  ��  ��Լɪ�򻷣��Ա��Ϊk=m%n���˿�ʼ��:
        k  k+1  k+2  ... n-2, n-1, 0, 1, 2, ... k-2���Ҵ�k��ʼ��0��
           �����ǵı����һ��ת����
		k     --> 0
		k+1   --> 1
		k+2   --> 2
		...
		n -1  --> n -1 -k
		0     --> n -k     (0���Կ�����n����Ϊ��%n)
		1     --> n -k + 1
		...
		k-2   --> n-2
		
		ӳ��ǰ��������x����ӳ���Ϊ(x-k)%n
	 */
	public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1){//���³����
        	return -1;
        }
        int last = 0;
        /*
         * ѭ��ֱ�Ӵ�2��ʼ��1��ʱ��Ĭ�Ͼ���last��0
         * ��n���Ľ������n-1�Ľ�������m��������ȡ��͵ý��
         * ʱ�临�Ӷ�ΪO(n),�ռ�ΪO(1)
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
            index--;//������Ҫ-1����Ϊ��ǰ���ѱ�ɾ��
        }
        return data.get(0);
    }
	
	/*
    *���������������ģ�⻷��˼·���ǱȽϼ򵥣����Ǹ����±�Ҫ����
    */
    public static int findLastNumber(int n,int m){
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){   //����ѭ��ʱ�����һ��Ԫ��Ҳ����Ϊ��-1
            i++;          //ָ����һ����ɾ���������һ��Ԫ�ء�
            if(i>=n) i=0;  //ģ�⻷��
            if(array[i] == -1) continue; //������ɾ���Ķ���
            step++;                     //��¼���߹��ġ�
            if(step==m) {               //�ҵ���ɾ���Ķ���
                array[i]=-1;
                step = 0;
                count--;
            }        
        }
        return i;//��������ѭ��ʱ��i,�����һ��������Ϊ-1��Ԫ��
    }
	
	public static void main(String[] args) {
		LastRemaining last = new LastRemaining();
		System.out.println(last.lastRemaining(5, 3));//3
	}
}
