public class Sum<T1 extends Number,T2 extends Number> {


    public void sum(T1 t1, T2 t2){

        if(t1 instanceof Double ){

            Double d = Double.sum((Double) t1,Double.valueOf((Integer)t2));
            System.out.println(d.doubleValue());
        }

    }

    public static void main(String [] args){
        Sum<Double,Integer> s =new Sum<>();
        double x = 5.2;
        int y = 10;
        s.sum(x,y);
    }
}
