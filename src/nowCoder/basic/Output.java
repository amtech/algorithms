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
 
public void second(Value v,int i){//v是first里面v的一个引用，都指向同一个地址Value对象
    i = 0;
    v.i = 20;//修改了first里面的v中i的值
    Value val = new Value( );
    v = val;
    System.out.println(v.i+" "+i);//15 0 
   }
}