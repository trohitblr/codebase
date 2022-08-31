package inheritanceConcept;

public class C extends B{


    public void printClass(){
        System.out.println("From C");
    }

    public static void main(String [] args){

       // C c  = new C();
        // c.print();

        A a = new C();
        // a.printClass();
    }
}
