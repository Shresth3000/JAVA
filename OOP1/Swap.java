class Num{
    int a,b;
}
class Swap{
     static void swapnum(Num o){
        int temp=o.a;
            o.a=o.b;
            o.b=temp;
    }
    public static void main(String args[]){
        Num obj=new Num();
        obj.a=45;
        obj.b=65;
        System.out.println(obj.a+" "+obj.b);
        swapnum(obj);
        System.out.println(obj.a+" "+obj.b);
    }
   
}