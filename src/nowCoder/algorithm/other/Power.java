package nowCoder.algorithm.other;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * 
 * ����Ĵ����������Ժ����Թ�����ÿ�ַ�ʽ����ȱ�㣬Ȼ��ѡ��
 * �٣�����ֵ
 * �ڣ�ȫ�ִ���  ȱ�㣺���������߿��ܻ����Ǽ�飬���°�ȫ����
 * �ۣ��쳣 �������
 * @author snow
 *
 */
public class Power {
	//����ȫ�ִ��룬������ʾ,�����ǳ����ʱ�򷵻ص�0�����ǵ���Ϊ0ʱ�������ص�0
	boolean invalidInput = false;
	/**
	 * �����ָ����0�͸�����ô��
	 * ��ָ��Ϊ����ʱ�� �ȶ�ָ��ȡ����ֵ��Ȼ������η��Ľ������ȡ����
	 * 		���baseΪ0��0������Ϊ��ĸ
	 * 0��0�η�������ѧ��û�����壬0����1�����ԣ������Թ�����
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double Power(double base, int exponent) {
		//�������Ϊ0������ָ��Ϊ����
        if (equal(base, 0.0) && exponent < 0){
        	invalidInput = true;
        	return 0.0;
        }
        if (exponent < 0){
        	return 1.0 / powerWithUnsignedExponent(base, -exponent);
        }else {
        	return powerWithUnsignedExponent(base, exponent);
        }
	}
	
	/**
	 * 			a^(n/2) * a^(n/2)   nΪż��
	 * ��a^n:   
	 *          a^((n-1)/2) * a^((n-1)/2) * a nΪ����
	 * O(logn)���Შ�����У��ݹ�ʵ��
	 * @return
	 */
	private double powerWithUnsignedExponent(double base, int exponent) {
		if (exponent == 0){
			return 1;
		}
		if (exponent == 1){
			return base;
		}//�� >>���� ����2
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result *= result;//����n����������ż�����ó�
		if ((exponent & 0x01) == 1){//��Ҫ�������ţ�==���ȼ���&��  &����%
			result *= base;
		}
		return result;
	}

	/**
	 * �ж�����double���͵������Ƿ����
	 * ����ֱ���ж�base�Ƿ�Ϊ0
	 */
	private boolean equal(double num1, double num2) {
		if (num1 - num2 > -0.0000001 && num1 - num2 < 0.00000001)
			return true;
		return false;
	}
	
	/**�ǵݹ��
	 * double Power(double base, int exponent) {
        int p = abs(exponent);
        double r = 1.0;
        while(p){
            if(p & 1) r *= base;
            base *= base;
            p >>= 1;
        }
        return exponent < 0 ? 1/ r : r;
    }
	 */
	
	public static void main(String[] args) {
		System.out.println(3 & 1);
		Power p = new Power();
		System.out.println(p.Power(2, 3));
	}
}
