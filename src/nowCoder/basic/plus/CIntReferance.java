package nowCoder.basic.plus;

/**
 * ģ��c��int*���͵�����
 * �ô�����ÿ�εݹ�����Ҫ�õ������д����ȥ��int*���ͣ�ִ�н���ķ���ֵ
 * ���Դ���һ��������룬�޸����Ծ���
 * @author snow
 *
 */
public class CIntReferance {
	public static void main(String[] args) {
		CIntReferance intRef = new CIntReferance();
		Integer c = 0;
		intRef.test(c);
		System.out.println(c.intValue());//�������0��֤��û�л�ȡ�޸ĺ��ֵ
		Integer cb = 256;
		intRef.test(cb);
		System.out.println(cb.intValue());//�����256,����û���޸�
		String cr = "0";
		intRef.test(cr);
		System.out.println(cr);//�������0���Ҳ�
		IntRef intRefer = new IntRef(0);
		intRef.test(intRefer);
		System.out.println(intRefer.i);//1,�ɹ�
		
	}
	public void test(Integer c){
		c++;
	}
	public void test(String c){
		//String b = (Integer.parseInt(c) + 1) + "";
		c = (Integer.parseInt(c) + 1) + "";//����˵�޸���c�������˰�
	}
	public void test(IntRef intRef){
		intRef.i++;
	}
}
class IntRef{//IntHolder,��Ҫ��һ�����װһ�£�ΪʲôInteger������
	int i;
	public IntRef(int value){
		i = value;
	}
}
