package LevelNodeToLL;

import java.util.LinkedList;
import java.util.Queue;

public class NodeProcessor {


    public static void levelConnect(BinaryNode root ){
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            BinaryNode prev = q.peek();
            q.remove();
            if(prev != null ){
                prev.next = q.peek();
                if(prev.leftChild != null){
                    q.add(prev.leftChild);
                }
                if(prev.rightChild != null){
                    q.add(prev.rightChild);
                }
            }else if(!q.isEmpty()){
                q.add(null);
            }

        }

    }
}
