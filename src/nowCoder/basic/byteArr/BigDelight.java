package nowCoder.basic.byteArr;

public class BigDelight {
	private static final byte TARGET = (byte) 0x90;//0x90����byte��˵����һ����Ч����ֵ��������Ҫǿת
	public static void main(String[] args) {
		BigDelight bigDelight = new BigDelight();
		bigDelight.byte1();
	}
	public void byte1(){
		for (int i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
			/*
			 * 0x90��int������������byte�ı�ʾ��Χ  ���λ����1��8λint��ֵ  144
			 * ���ԣ����������
			 */
			if (i == 0x90){//������ͱȽ�
				System.out.println("Joy! + byte��int�Ƚ�");
			}
			if (i == (byte) 0x90){//true
				System.out.println("Joy! + ��intת����byte��Ȼ����byte�Ƚ�");
			}
			if ((i & 0xff) == 0x90){//�����λ��ƣ��ή�ͳ���Ŀɶ���
				System.out.println("Joy! + ʹ�������룬������������չ��Ӱ��");
			}
			if (i == TARGET){
				System.out.println("Joy! + ��һ�������������滻0x90");
			}
		}
		/*
		 * byte�з��ţ�(byte) 0x90ִ�з�����չ��������(byte) 0x90��ֵ��������������ȵ�int��ֵ
		 * (byte) 0x90����Ϊint -112 ������int��ֵ 0x90 144
		 */
		System.out.println((byte) 0x90 == 0x90);//false
	}
}
