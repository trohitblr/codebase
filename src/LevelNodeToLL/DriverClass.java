package LevelNodeToLL;

public class DriverClass {

//     1
  //  2

    // (3) + 3


   //  iteration (On) :
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(0);

        BinaryNode fir = new BinaryNode(1);

        BinaryNode sec = new BinaryNode(2);

        BinaryNode thir = new BinaryNode(3);

        BinaryNode four = new BinaryNode(4);

        BinaryNode fifth = new BinaryNode(5);

        BinaryNode six = new BinaryNode(6);


        root.leftChild=fir;
        root.rightChild=sec;

        fir.leftChild=thir;
        fir.rightChild=four;
        sec.leftChild=fifth;
        sec.rightChild=six;


        NodeProcessor.levelConnect(root);

        System.out.println("next node of 2 :- "+sec.next);

        System.out.println("next node of 4 :- "+four.next.data);

        System.out.println("next node of 6 :- "+six.next);



    }
}
