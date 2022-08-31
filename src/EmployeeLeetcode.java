import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeLeetcode {
    public int id;
    public int importance;
    public List<Integer> subordinates;


    public static void main(String[] args) {

        EmployeeLeetcode emp = new EmployeeLeetcode();
        emp.id=1;
        emp.importance=3;

        List<Integer> subordinates = new ArrayList<>();
        subordinates.add(4);
        subordinates.add(5);

        emp.subordinates=subordinates;

        List<EmployeeLeetcode> empList = new ArrayList<>();
        empList.add(emp);

        int id =1;
       // List<Object> ids =  empList.stream().filter(e -> e.id == id).map(e -> e.subordinates.add(e.id) ? e.subordinates : e.subordinates ).flatMap(e -> e.stream()).collect(Collectors.toList());
       // System.out.println(ids);
       // System.out.println(empList.get(0).subordinates);


        List<Integer> ids1 =  empList.stream().filter(e -> e.id == id).map(e ->{

            ArrayList<Integer> aa = new ArrayList<>(e.subordinates);
            aa.add(e.id);
            return aa;
        } ).flatMap(e -> e.stream()).collect(Collectors.toList());
        System.out.println(ids1);


        ids1.stream().reduce(0,(x,y) -> x+y);
                //empList.stream().filter(e -> e.id == id).flatMap(e -> e.subordinates.add(e.id)).collect(Collectors.toList());


              //  .flatMap( e-> e.      subordinates.stream()).collect(Collectors.toList());
    }
}
