package nowCoder.basic;
class Value{
    public int i=15;
}
public class Output{
    public static void main(String argv[]){
    	Output t=new Output( );
        t.first( );
    }
 
public void first( ){
    int i=5;
    Value v=new Value( );
    v.i=25;
    second(v,i);
    System.out.println(v.i);//20
}
 
public void second(Value v,int i){//v��first����v��һ�����ã���ָ��ͬһ����ַValue����
    i = 0;
    v.i = 20;//�޸���first�����v��i��ֵ
    Value val = new Value( );
    v = val;
    System.out.println(v.i+" "+i);//15 0 
   }
}