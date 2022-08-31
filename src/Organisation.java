import java.util.ArrayList;
import java.util.List;

public class Organisation {

    public List<Department> getDeps() {
        return deps;
    }

    public void setDeps(List<Department> deps) {
        this.deps = deps;
    }

    List<Department> deps = new ArrayList<>();
}
