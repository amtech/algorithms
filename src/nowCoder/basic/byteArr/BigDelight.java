package nowCoder.basic.byteArr;

public class BigDelight {
	private static final byte TARGET = (byte) 0x90;//0x90对于byte来说不是一个有效的数值，所以需要强转
	public static void main(String[] args) {
		BigDelight bigDelight = new BigDelight();
		bigDelight.byte1();
	}
	public void byte1(){
		for (int i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
			/*
			 * 0x90是int常量，超出了byte的表示范围  最高位被置1的8位int数值  144
			 * 所以，不会有输出
			 */
			if (i == 0x90){//混合类型比较
				System.out.println("Joy! + byte与int比较");
			}
			if (i == (byte) 0x90){//true
				System.out.println("Joy! + 将int转换成byte，然后与byte比较");
			}
			if ((i & 0xff) == 0x90){//用屏蔽机制，会降低程序的可读性
				System.out.println("Joy! + 使用屏蔽码，来消除符号扩展的影响");
			}
			if (i == TARGET){
				System.out.println("Joy! + 用一个常量声明来替换0x90");
			}
		}
		/*
		 * byte有符号，(byte) 0x90执行符号扩展。将负的(byte) 0x90数值提升到数字上相等的int数值
		 * (byte) 0x90提升为int -112 不等与int数值 0x90 144
		 */
		System.out.println((byte) 0x90 == 0x90);//false
	}
}
