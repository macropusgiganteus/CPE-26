/* HW9
 * Due: 1 December 2018
 * Problem Header Hash Code: b92413879c0635f7773a1b9237d38d75
*/ 
package hw9;

/**
 *
 * @author Patiwet
 */
public class Stack {
    Node head;
    
    public void push(Vertex v){
        if (head!=null){
            Node node = new Node(v);
            node.next = head;
            head = node;            
        }else{
            head = new Node(v);
        }
    }
    
    public Vertex pop(){
        Node node = head;
        head = head.next;
        return node.vertex;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
}
