import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {


    public static void main(String[] args) {
        Department d = new Department();
        d.setDeptName("ABC");

        List<Employee> emps = new ArrayList<>();
        Employee e1 = new Employee("Rohit", 10);

        Employee e2 = new Employee("Rohit123", 8);
        emps.add(e1);
        emps.add(e2);
        d.setEmps(emps);

        Department d1 = new Department();
        d.setDeptName("ABCD");

        List<Employee> emps1 = new ArrayList<>();
        Employee e11 = new Employee("Rohit", 2);

        Employee e21 = new Employee("Rohit123", 6);
        emps.add(e11);
        emps.add(e21);
        d1.setEmps(emps1);

        Organisation o = new Organisation();
        List<Department> dd = new ArrayList<>();
        dd.add(d);
        dd.add(d1);
        o.setDeps(dd);


        System.out.println(o.getDeps().stream().filter(d12 -> (d12.getEmps().stream().anyMatch( e -> e.count == 6))).findAny());


        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        System.out.println(ll);
        ll.add(2);
        System.out.println(ll);
    }
}
