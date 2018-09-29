/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package hw;

public class Node extends BTreePrinter {

    Node left;
    Node right;
    int data;
    
    public Node(int data) {
        this.data = data;
    }

    public void printTree() {
         BTreePrinter.printTree();
    }

    public void printBFT() {
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");
        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
        System.out.println("]");
    }
}
