package AtlassianDirectory;

public class Driver {



    public static void main(String [] args){

        /*
        file1.txt(size: 100)
        file2.txt(size: 200) in collection "collection1"
        file3.txt(size: 200) in collection "collection1"
        file4.txt(size: 300) in collection "collection2"
        file5.txt(size: 100)
         */


        FileSystem fs = FileSystem.getInstance();

        fs.addFile("file1",100,"");

        System.out.println("Total size :- "+ fs.getTotalSize());
        System.out.println("TopK collection :- "+ fs.getTopKCollection(2));

        fs.addFile("file2",200,"collection1");
        System.out.println("Total size :- "+ fs.getTotalSize());
        System.out.println("TopK collection :- "+ fs.getTopKCollection(2));

        fs.addFile("file3",200,"collection1");

        System.out.println("Total size :- "+ fs.getTotalSize());
        System.out.println("TopK collection :- "+ fs.getTopKCollection(2));

        fs.addFile("file4",300,"collection2");

        System.out.println("Total size :- "+ fs.getTotalSize());
        System.out.println("TopK collection :- "+ fs.getTopKCollection(2));

        fs.addFile("file5",100,"");

        System.out.println("Total size :- "+ fs.getTotalSize());
        System.out.println("TopK collection :- "+ fs.getTopKCollection(2));
    }
}
