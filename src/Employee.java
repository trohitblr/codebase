import java.util.Comparator;
import java.util.PriorityQueue;

public class Employee {

    String name;

    int count;


    public Employee(String name, int count) {
        this.count = count;
        this.name = name;
    }


    public static void main(String[] args) {

        PriorityQueue<Employee> pp = new PriorityQueue<>((a, b) -> (b.count - a.count));

        Employee e1 = new Employee("Rohit", 10);

        Employee e2 = new Employee("Rohit123", 8);

        pp.add(e1);
        pp.add(e2);

        System.out.println("pp.poll()");
        while (!pp.isEmpty()) {
            System.out.println(pp.poll().name);
        }

        pp.add(e1);
        pp.add(e2);
        e2.count=20;

        System.out.println("contains :- "+pp.contains(e2)+"--currentValue--"+e2.count);

        pp.remove(e2);

        System.out.println("pp.poll()----");
        while (!pp.isEmpty()) {
            System.out.println(pp.poll().name);
        }


        PriorityQueue<Employee> pp1 = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                System.out.println("o1 name:- "+o1.name);
                System.out.println("o2 name:- "+o2.name);
                return o1.name.compareTo(o2.name);
            }
        });

        Employee e11 = new Employee("Rohit", 10);

        pp1.add(e11);
        System.out.println("pp1 :- "+pp1);

        Employee e21 = new Employee("Amit", 8);

        pp1.add(e21);
        System.out.println("pp1 :- "+pp1);

        Employee e22 = new Employee("Tripathi", 8);
        pp1.add(e22);
        System.out.println("pp1 :- "+pp1);
    }
}
