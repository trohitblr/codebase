import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.HashMap;

public class Employee1 {

    private String name;

    Employee1(String name){
this.name = name;
    }



    public static void main(String [] args){


        HashMap<Employee1, Integer> hm = new HashMap<>();


        hm.put(new Employee1("Bhaved"), 222);
        hm.put(new Employee1("Rohit"), 333);
        hm.put(new Employee1("Bhaved"), 6666);
        hm.put(new Employee1("Rohit"), 8888);

        System.out.println("Size"+hm.size());

        System.out.println("get  :- "+hm.get(new Employee1("Rohit")));

    }

}
