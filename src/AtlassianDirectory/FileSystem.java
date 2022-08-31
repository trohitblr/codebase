package AtlassianDirectory;

import java.util.*;

public class FileSystem {

    private static FileSystem fileSystem= null;

    private int size;

    List<Directory> files = new ArrayList<>();

    Map<String,Directory> hm = new HashMap<>();

    PriorityQueue<CollectionDir> pq  = new PriorityQueue<>(new Comparator<CollectionDir>() {
        @Override
        public int compare(CollectionDir o1, CollectionDir o2) {
            return o2.getSize() - o1.getSize();
        }
    });

    PriorityQueue<CollectionDir> pq1  = new PriorityQueue<CollectionDir>(new Comparator<CollectionDir>() {
        @Override
        public int compare(CollectionDir o1, CollectionDir o2) {
            return o2.getSize() - o1.getSize();
        }
    });



    private FileSystem(){
        size =0;
    }

    public static FileSystem getInstance(){

        if(fileSystem == null){
            fileSystem = new FileSystem();
        }
        return fileSystem;
    }


    public void addFile(String fileName, int size, String collectionName){

        if(collectionName.equals("")){
            Directory file = new File(fileName,size);
            files.add(file);
        }else{
            CollectionDir dir= (CollectionDir) hm.getOrDefault(collectionName,new CollectionDir(collectionName));

            if(hm.containsKey(dir.getName())) {
                pq.remove(dir);

            }
            dir.addFile(fileName,size);
            pq.add(dir);
            hm.put(collectionName,dir);
        }
        this.size = this.size+size;
    }


  public List<String> getTopKCollection(int k){

      List<String> collections = new ArrayList<>();
     // List<Directory> collectionsDir = new ArrayList<>();

      System.out.println("Collections :- "+pq);
      while( !pq.isEmpty() && k > 0){
          CollectionDir tmpDir = (CollectionDir) pq.poll();
          pq1.add(tmpDir);
          collections.add(tmpDir.getName());
          k--;
      }

     while(!pq1.isEmpty()){
         pq.add(pq1.poll());
     }


return collections;

  }


  public int getTotalSize(){
        return size;
  }



}
