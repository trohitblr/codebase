package OCPPrinciple;

public class Test {

    public static void main(String[] args) {
        // Animal animal = new Lion();
        Animal animal = new LionCounter();
       /// LionCounter l=new LionCounter();
        doSomething(animal);
        //animal.co

    }
    //==============================================
    public static void doSomething(Animal animal) {
        animal.eat();
        animal.eat();
        animal.eat();
    }
}
