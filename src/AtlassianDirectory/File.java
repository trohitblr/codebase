package AtlassianDirectory;

import java.util.Objects;

public class File implements Directory{

    // file1.txt(size: 100)

    private String fileName;



    private int size;

    public File(String fileName,int size){
        this.fileName= fileName;
        this.size = size;
    }


    public String getFileName() {
        return fileName;
    }

  /*  public void setFileName(String fileName) {
        this.fileName = fileName;
    }*/

    public int getSize() {
        return size;
    }

   /* public void setSize(int size) {
        this.size = size;
    }*/

    public String getName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return getSize() == file.getSize() && getFileName().equals(file.getFileName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileName(), getSize());
    }
}
