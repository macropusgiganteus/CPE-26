/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package hw;

public class Main {
    
    
    public static void main(String[] args) {
        
        System.out.println("EX 1\n"); 
        Node tree = constructTree1();
        tree.printTree();
        
        System.out.println("\nEX 2\n");
        Node tree2 = constructTree2();
        tree2.printTree();
        
        System.out.println("\nEX 3\n");
         Stack s = new Stack(4);         
         s.pop();       
         s.push(new Node(5));    
         s.push(new Node(6));    
         s.push(new Node(7));      
         s.push(new Node(8));     
         s.printStack();       
         s.push(new Node(9)); 
        System.out.println(s.pop().data);         
        System.out.println(s.pop().data);        
        System.out.println(s.pop().data);        
        s.printStack();
        
        System.out.println("\nEX 4\n");
        Queue q = new Queue(4);         
        q.dequeue();         
        q.enqueue(new Node(5));         
        q.enqueue(new Node(6));       
        q.enqueue(new Node(7));        
        q.enqueue(new Node(8));      
        q.printQueue();     
        q.enqueue(new Node(9));  
        System.out.println(q.dequeue().data);    
        System.out.println(q.dequeue().data);   
        System.out.println(q.dequeue().data);   
        q.printQueue();
          
        System.out.println("\nEX 5\n");
        q = new Queue(4);         
        q.printCircularIndices();   
        q.enqueue(new Node(5));     
        q.enqueue(new Node(6));     
        q.printCircularIndices();   
        q.enqueue(new Node(7));     
        q.enqueue(new Node(8));     
        q.printCircularIndices();    
        q.printQueue();  
        System.out.println(q.dequeue().data);  
        q.printCircularIndices();   
        System.out.println(q.dequeue().data);    
        q.printCircularIndices();      
        System.out.println(q.dequeue().data);     
        q.printCircularIndices();       
        q.enqueue(new Node(9));  
        q.enqueue(new Node(10));     
        q.enqueue(new Node(11));      
        q.printQueue(); 
        
        System.out.println("\nEX 6\n");
        Node tree3 = constructTree1();   
        tree3.printTree();        
        tree3.printBFT();       
        tree3.printDFT();
        
    }
    
    public static Node constructTree1(){
        Node root = new Node(3);
        root.left = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new  Node(1);
        root.left.right.right = new Node(8);
        root.right = new Node(5);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);
        return root;
    }
    public static Node constructTree2(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new  Node(7);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(10);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.left = new Node(9);
        return root;
    }
}
