/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
*/ 
package hw.pkg4;

/**
 *
 * @author Patiwet
 */
public class Stack implements List{
    // Implement Stack using Linked List without tail
    Node head;
    Node current;
    
    public void push(Node node){ //function สำหรับเพิ่มสมาชิกด้านบนของ stack
        if (head == null){ //ถ้ามีสมาชิกใน stack
            head = node;
            head.next = null;
        }else{ // ถ้าไม่มีสมาชิกใน stack
            node.next = head;
            head = node;     
        }
    }
    
    public void pop(){ //เอาสมาชิกด้านบนสุดออกจาก stack
        if (head!=null){ //ถ้ามีสมาชิกใน stack
           head = head.next;
        }else{ // ถ้าไม่มีสมาชิกใน stack
            System.out.println("Error: Stack Underflow");
        }
    }
    
    public Node top(){ // return Node บนสุดของ stack
        if(head!=null){ //ถ้ามีสมาชิกใน stack
        return head;
        }
        return null;
    }
    
}
