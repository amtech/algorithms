package nowCoder.basic;

public class AnimalFarm {
	public static void main(String[] args) {
		final String pig = "length: 10";
		final String dog = "length: " + pig.length();//�����˷��������ǳ������ʽ
		/*
		 * ����ó������ʽ����ʼ��pig��dog��ȷʵ��ָ����ͬ�Ķ���
		 * +�������������������ӷ������ַ������Ӳ��������ȼ�����==��������
		 * ����ȼ���
		 * ("Animals are equeals: " +  pig) == dog
		 * ����ֻ�����һ��false
		 * ��ʹ���ַ������Ӳ������ǣ����ǽ���ƽ���Ĳ�������()������
		 * (pig == dog)
		 */
		System.out.println("Animals are equeals: " +  pig == dog);//ֻ��false��û��ǰ����ַ���
	}
}
