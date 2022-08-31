package AtlassianDirectory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionDir implements Directory {

    private String CollecName;

    private List<String> fileName;

    private int size;

    public CollectionDir(String CollecName){
        fileName = new ArrayList<>();
        size =0;
        this.CollecName=CollecName;
    }


    public void addFile(String fileName , int size){
        this.size = this.size+size;
        this.fileName.add(fileName);
    }


    /*public String getCollecName() {
        return CollecName;
    }

    public void setCollecName(String collecName) {
        CollecName = collecName;
    }

    public List<String> getFileName() {
        return fileName;
    }

    public void setFileName(List<String> fileName) {
        this.fileName = fileName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    */

    public int getSize() {
        return size;
    }
    public String getName() {
        return CollecName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectionDir)) return false;
        CollectionDir that = (CollectionDir) o;
        return getSize() == that.getSize() && CollecName.equals(that.CollecName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CollecName, getSize());
    }
}
