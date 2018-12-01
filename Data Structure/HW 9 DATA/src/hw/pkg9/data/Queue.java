/* HW9
 * Due: 1 December 2018
 * Problem Header Hash Code: b92413879c0635f7773a1b9237d38d75
*/ 
package hw9;

/**
 *
 * @author Patiwet
 */
public class Queue {
    Node head;
    Node tail;
    
    public Queue(Vertex v){
        head = new Node(v);
        tail = head;
    }
    
    public void enqueue(Vertex v){
        if (tail!=null){
            tail.next = new Node(v);
            tail = tail.next;
        }else{
            head = new Node(v);
            tail = head;
        }    
    }
    
    public Vertex dequeue(){
        Node node = head;
        head = head.next;
        if (head==null){
            tail = null;
        }
        return node.vertex;
    }

    public boolean isEmpty(){
        return head==null;
    }
}
