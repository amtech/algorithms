package nowCoder.algorithm.array;

/**
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ���
 * �������ж���䣨A?B:C����
 *  n = (int) (Math.pow(n, 2)+n)>>1;
 *  �ڣ�bool a[n][n+1];
       return sizeof(a)>>1;
 * 
 * �й��캯�����麯����ģ����ȸ��ַ���c++�����<<��ָoffer>>
 * @author snow
 *
 */
public class Sum {
	
	/*
	 * ���ù��캯����
	 * ����һ���࣬Ȼ���ڹ��캯������N++,sum+=n
	 * Ȼ�󴴽�һ������ΪN�Ĵ����͵����飬�ͻ���ù��캯��N�Σ�����ۼ�
	 */
	public int sum(int n) {
        Temp[] temp = new Temp[n];//����ֻ�������˿ռ䣬��û�е��ù��캯��
        return temp[n-1].getSum();
    }
	
	/*public int Sum_Solution(int n) {
        int ans = n;
        //�ݹ飬��ansΪ0ʱ���ݹ���������ö�·����,����java��int��int����֧��&&
        ans && (ans += Sum_Solution(n - 1));
        return ans;
    }
    
    */
	
	public int Sum_Solution(int n) {
        int sum = n;
        //���ö�·���㣬�ݹ������������ж����дһ���Ϳ��ԡ���Ȼ�Ǻ�Ϊ���
        boolean flag = (n>0) && ((sum += Sum_Solution(n-1)) >0 );
        return sum;
    }
	
	public static void main(String[] args) {
		Sum s = new Sum();
		System.out.println(s.sum(10));
	}
}
class Temp{
	private static int n = 0;//ֻ��ʼ��һ��
	private static int sum = 0;
	public Temp(){
		n++;
		sum += n;
	}
	public int getSum(){
		return sum;
	}
}
