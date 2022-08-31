package OCPPrinciple;

public class LionCounter extends Lion implements Animal{

    private static int count;

    public void  eat() {
        count++;
        super.eat();
        System.out.println("count"+count);
    }

}
