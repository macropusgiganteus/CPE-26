/* HW3
 * Due: 20 September 2018
 * Problem Header Hash Code: 9af4b45be9aaf81c776e442d990d2cc2
*/ 
package hw3;

/**
 *
 * @author Patiwet
 */
public class SinglyLinkedList {
    Node head;
    String listName;
    Node current;
    Node HighestGPA;
    
    public SinglyLinkedList(String name){
        listName = name;
    }
    
    public void popBack() { //ลบสมาชิกตัวสุดท้ายออก//
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
        }else{ //ถ้า list ไม่ว่าง//
            current = head;
            if(current.next == null){ //ถ้ามีสมาชิก 1 ตัว//
                head = null;
            }
            else{ //ถ้ามีสมาชิกมากกว่า 1 ตัว//
                while(current.next.next!=null){ //ถ้าตัวถัดไปไม่ใช่ตัวสุดท้าย//
                current = current.next;
                }
                current.next = null;
            }       
        }
    }
    
    public void popFront(){ //ลบสมาชิกตัวแรกออก
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
        }else{ //ถ้า list ไม่ว่าง//
            head = head.next;
        }
    }
    
    public Node topFront(){ //return node ที่อยู่หน้าสุด//
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//    
            return new Node(head.student_id,head.name,head.gpa);
        }
    }
    
    public Node topBack(){ // return node ที่อยู่หลังสุด//
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//
            current = head;
            while(current.next!=null){ //ถ้าตัวที่เช็คไม่ใช่ตัวสุดท้าย//
                current = current.next;
            }
            return new Node(current.student_id,current.name,current.gpa);
        }
    }
    
    public void pushFront(Node node){ //เพิ่ม node ข้างหน้าสุด
        if (isEmpty()){ //ถ้า list ว่าง//
            head = node;
            node.next = null;
        }else{ //ถ้า list ไม่ว่าง//
            node.next = head;
            head = node;
        }
    }
    
    public void pushBack(Node node) { //เพิ่ม node ต่อหลังสุด//
        if (isEmpty()){ //ถ้า list ว่าง//
            head = node;
            node.next = null;
        } else { //ถ้า list ไม่ว่าง//
            current = head;
            while(current.next!=null){ //ถ้าตัวที่เช็คไม่ใช่ตัวสุดท้าย//
                current = current.next;
            }
            current.next = node;
            node.next = null;
        }
    }

    public Node findNode(int id){ //ตามหา node ที่มี student id ตรงกับ key
        if (isEmpty()){ //ถ้า list ว่าง//
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//
            current = head;
            while(current!=null){ //เช็คสมาชิกจนถึงตัวสุดท้าย//
                if(current.student_id == id){ //ถ้า student id ของ node ตรงกับ key //
                    return current;
                }else{ //กรณี student id ของ node ไม่ตรงกับ key//
                    current = current.next;
                }
            }
            return new Node("Student Not Found"); //เมื่อหาสมาชิกที่มี student id ตรงกับ key ไม่เจอ//
        }
    }
    
    public Node eraseNode(int id){ //ลบ node ที่มี student id ตรงกับ key//
        if (isEmpty()){ //ถ้า list ว่าง//
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//
            current = head;
            while(current.next!=null){ //เช็คสมาชิกจนถึงตัวสุดท้าย//
                if(current.next.student_id == id){ //ถ้า student id ของ node ตรงกับ key //
                    Node erased = current.next;
                    current.next = current.next.next;
                    return erased;
                }else{ //ถ้า student id ของ node ไม่ตรงกับ key //
                    current = current.next;
                }
            }
            return new Node("Student Not Found"); //เมื่อหาสมาชิกที่มี student id ตรงกับ key ไม่เจอ//
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){ //เพิ่ม node ต่อจาก node สมาชิกของ list//
        current = head;
        while(current!=node1){ //ตามหา node ที่เป็นสมาชิกของ list//
            current = current.next;   
        } 
        node2.next = current.next;
        current.next = node2;
        
    }
    
    public void addNodeBefore(Node node1, Node node2){ //เพิ่ม node ข้างหน้า node สมาชิกของ list//
        current = head;
        if(current == node1){ //ถ้า node ที่เป็นสมาชิกคือตัวหน้าสุด//
            pushFront(node2);
        } 
        else{ //ถ้า node ที่เป็นสมาชิกไม่ใช่ตัวหน้าสุด//
            while(current.next!=node1){ //ตามหา node ที่เป็นสมาชิกของ list//
            current = current.next;
            }
            node2.next = current.next;
            current.next = node2;  
        }
    }
    
    public boolean isEmpty(){ //เช็คว่า list ว่าง//
        if(head!=null){ //ถ้าไม่มีสมาชิก//
            return false;
        }
        else{ //ถ้ามีสมาชิก//
            return true;
        }
    }
    public void merge(SinglyLinkedList list){ //รวม list เข้าด้วยกัน//
        while(!list.isEmpty()){ //ถ้า list ที่จะเพิ่มเข้ามาไม่ว่าง//
            pushBack(list.topFront());
            list.popFront();
        }
    }
    
    public void printStructure(){ // print สมาชิก//
        current = head;
        System.out.print(listName+": "+"head -> ");
        while(current!=null){ //เช็คสมาชิกจนถึงตัวสุดท้าย//
            System.out.print("["+current.student_id+"] -> " );
            current = current.next;
        }
        System.out.print("null\n");
    }
    
    public Node whoGotHighestGPA(){ //ตามหาคนที่ GPA สูงสุดใน list//
        if (isEmpty()) { //ถ้า list ว่าง//
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//
            current = head;
            HighestGPA = head;
            while(current!=null){ //เช็คสมาชิกจนถึงตัวสุดท้าย//
            if(current.gpa>=HighestGPA.gpa){ //ถ้า GPA ของตัวที่เช็คมากกว่าหรือเท่ากับคนที่เช็คไปแล้ว//
                HighestGPA = current;
            }
            current = current.next;    
            }    
            return HighestGPA;
        }
    }
}
