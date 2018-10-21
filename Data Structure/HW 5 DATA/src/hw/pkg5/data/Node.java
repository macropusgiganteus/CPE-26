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

    public void printTree() { //print แผนภาะ tree //
         this.printTree(this);
    }

    public void printBFT() { //แสดงผลจากการเดินทางแบบ Breadth-first Traversal//
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");
                Node node = this;
                q.enqueue(node); // เพิ่ม root node ใน queue //
                while(!q.isEmpty()){//ทำเมื่อ queue ไม่ว่าง //
                    node = q.dequeue(); //ให้ node == สมาชิกตัวแรก แล้วเอาสมาชิกออกจาก queue //
                    System.out.print(node.data+" ");
                    if(node.left!=null){ //ถ้า node มีลูกฝั่งซ้าย //
                        q.enqueue(node.left);
                    }    
                    if(node.right!=null){ //ถ้า node มีลูกฝั่งขวา //
                        q.enqueue(node.right);
                    }      
                }   
        System.out.println("]");
    }

    public void printDFT() { // แสดงผลจากการเดินทางแบบ Depth-first Traversal//
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
                Node node = this;
                s.push(node); // เพิ่ม root node ใน Stack //
                while(!s.isEmpty()){ //ทำเมื่อ Stack ไม่ว่าง //
                    node = s.pop(); //ให้ node == สมาชิกตัวแรก แล้วเอาสมาชิกออกจาก Stack //
                    System.out.print(node.data+" ");
                    if(node.right!=null){ //ถ้า node มีลูกฝั่งขวา //
                        s.push(node.right);
                    }
                    if(node.left!=null){ //ถ้า node มีลูกฝั่งซ้าย //
                        s.push(node.left);
                    }    
                }
            
        System.out.println("]");
    }
}
