/* HW6
 * Due: 21 October 2018
 * Problem Header Hash Code: 72768a5124c7d61e8573f7c39c398e64
*/ 

package hw.pkg6.data;

public class Main {
    
    public static void printNodeKey(Node node){
       if(node!=null)System.out.println(node.key); // Do something
       else {
           System.out.println("Node not found!!!");
       }
    }
    
    public static void main(String[] args) {
        System.out.println("EX 1\n");
        Tree tree = new Tree();
        tree.printTree();

        int[] keyList = {5, 3, 1, 2, 7, 9, 10, 8};
        for (int i=0; i<keyList.length; i++)
        tree.insert(keyList[i]);
        tree.printTree();

        Node node = tree.find(3); printNodeKey(node);
        node = tree.find(4); printNodeKey(node);
        node = tree.findClosest(4); printNodeKey(node);
        node = tree.findClosest(3); printNodeKey(node);
        node = tree.findClosest(-999); printNodeKey(node);
        node = tree.findClosest(999); printNodeKey(node);
        
        System.out.println("\nEX 2\n");
         tree = new Tree();
        int[] keyList1 = {6, 7, 9, 5, 3, 9, 10, 8, 1};
        for (int i=0; i<keyList1.length; i++)
        tree.insert(keyList1[i]);
        tree.printTree();

        List list = tree.rangeSearch(4, 8);
        list.printList();
        System.out.println("\nEX 3\n");
         tree = new Tree();
        int[] keyList2 = {5, 3, 1, 2, 7, 9, 10, 8};
        for (int i=0; i<keyList2.length; i++)
        tree.insert(keyList2[i]);
        tree.printTree(); System.out.println("----------------");

        tree.delete(7);
        tree.printTree(); System.out.println("----------------");
        tree.delete(3);
        tree.printTree();
        tree.delete(9);
        tree.delete(1);
        tree.delete(5);
        tree.delete(5); System.out.println("----------------");
        tree.printTree();

        System.out.println("\nEX 4\n");
         tree = new Tree();

        int[] keyList3 = {5, 3, 1, 2, 7, 9, 10, 8};
        for (int i=0; i<keyList3.length; i++)
        tree.insert(keyList3[i]);
        tree.printTree();

         node = tree.find(4);
        printNodeKey(node);
        node = tree.findClosest(4);
        printNodeKey(node);
        node = node.findNext();
        printNodeKey(node);
        node = node.findNext();
        printNodeKey(node);
        node = node.findNext();
        printNodeKey(node);

        System.out.println("\nEX 5\n");
         tree = new Tree();

        int[] keyList4 = {5, 3, 1, 2, 7, 9, 10, 8};
        for (int i=0; i<keyList4.length; i++)
        tree.insert(keyList4[i]);
        tree.printTree();

        tree.printPreOrderDFT();
        tree.printInOrderDFT();
        tree.printPostOrderDFT();
        System.out.println("\nEX 6\n");
         tree = new Tree();
         int[] keyList5 = {5, 2, 3, 9, 1, 10, 8, 7};
        for (int i=0; i<keyList5.length; i++)
        tree.insert(keyList5[i]);
        tree.printTree();
        System.out.println(tree.depth());
        System.out.println(tree.height());
         node = tree.find(9);
        System.out.println(node.depth(tree));
        System.out.println(node.height());
        node = tree.findMax();
        printNodeKey(node);
        node = tree.findMin();
        printNodeKey(node);
        node = tree.findKthSmallest(6);
        printNodeKey(node);
        node = tree.findKthSmallest(3);
        printNodeKey(node);
    }
}
