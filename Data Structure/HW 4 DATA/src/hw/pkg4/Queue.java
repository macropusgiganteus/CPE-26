/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
*/ 
package hw.pkg4;

/**
 *
 * @author Patiwet
 */
public class Queue implements List{
    
    Node head;
    Node tail;
    
    public void push(Node node){ //functionนี้  เพิ่มสมาชิก
        if (head == null){ //ในกกรณที่คิวไม่มีสมาชิก
            head = node;
            tail = node;
            tail.next = null;
                  
            
        }else{ //ในกรณีที่มีสมาชิกอยู่
            tail.next = node;
            tail = tail.next;
            tail.next = null;
            
        }
    }
    
    public void pop(){ //functionนี้  เอาสมาชิกตัวแรกออก
        if (head != null){ //กรณีที่มีสมาชิกอยู่
            if (head != tail){//กรณีที่มีสมาชิกมากกว่า1ตัว
                head = head.next;
            }else{ //กรณีที่มีสมาชิกตัวเดียว
                head = null;
            }
        }
        else{ //กรณีที่ ไม่มีสมาชิก
            System.out.println("Error: Stack Underflow");
        }
    }
    
    public Node top(){ //functionนี้  รีเทิร์นสมาชิกที่อยู่หน้าสุดของคิว
        if(head!=null){ //ถ้ามีสมาชิกในคิว
            return head;
        }
        else{ //ถ้าไม่มีสมาชิกในคิว
            return null;
        }
        
    }
    
}
