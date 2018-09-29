/* HW3
 * Due: 20 September 2018
 * Problem Header Hash Code: 9af4b45be9aaf81c776e442d990d2cc2
*/ 
package hw3;

/**
 *
 * @author Patiwet
 */
public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    Node current = head;
    Node HighestGPA;
    
    public DoublyLinkedList(String name){
        listName = name;
        
    }
    
    public void popBack() { //ลบสมาชิกตัวสุดท้ายออก//
      if (isEmpty()){ //ถ้า list ว่าง//
          System.out.println("ERROR");
        }else{
          if(tail == head){ //กรณีที่ list มีสมาชิก 1 ตัว//
              head = null;
              tail = null;
          }
          else{ // กรณีที่ list มีสมาชิกมากกว่า 1 ตัว//
              tail = tail.previous;
              tail.next = null;   
          } 
        }
    }
    
    public void popFront(){ //ลบสมาชิกตัวแรกออก
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
        }else{ //ถ้า list ไม่ว่าง//
            if(tail == head){ //กรณีที่ list มีสมาชิก 1 ตัว//
              head = null;
              tail = null;
          }
          else{ // กรณีที่ list มีสมาชิกมากกว่า 1 ตัว//
              head = head.next;
              tail.next = null;   
          } 
            
        }
    }
    
    public Node topFront(){ //return node ที่อยู่หน้าสุด//
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {   //ถ้า list ไม่ว่าง//
            return new Node(head.student_id,head.name,head.gpa);
        }
    }
    
    public Node topBack(){ // return node ที่อยู่หลังสุด//
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//
            return new Node(tail.student_id,tail.name,tail.gpa);
        }
    }
    
    public void pushFront(Node node){  //เพิ่ม node ข้างหน้าสุด
        if (isEmpty()){ //ถ้า list ว่าง//
            head = node;
            tail = node;
            node.next = null;
            
        }else{ //ถ้า list ไม่ว่าง//
            node.next = head;
            head.previous = node;
            head = node;
        }
    }
    
    public void pushBack(Node node) { //เพิ่ม node ต่อหลังสุด//
        if (isEmpty()) { //ถ้า list ว่าง//
            head = node;
            tail = node;
            node.next = null;
        } else { //ถ้า list ไม่ว่าง//
            node.previous = tail;
            tail.next = node;
            tail = node;
            node.next = null;       
        }
    }

    public Node findNode(int id){ //ตามหา node ที่มี student id ตรงกับ key
        current = head;
        if (isEmpty()){ //ถ้า list ว่าง//
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//
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
    
    public Node eraseNode(int id){//ลบ node ที่มี student id ตรงกับ key//
        current = head;
        if (isEmpty()){ //ถ้า list ว่าง//
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้า list ไม่ว่าง//
            while(current!=null){ //เช็คสมาชิกจนถึงตัวสุดท้าย//
                if(current.student_id == id){ //ถ้า student id ของ node ตรงกับ key //
                    if(current.next == null){ //ถ้ากำลังเช็คตัวสุดท้าย//
                        tail = current.previous;
                        tail.next = null;
                        
                    }
                    else if(head==current){ //ถ้ากำลังเช็คตัวแรก//
                    head = head.next;
                    }
                    else { //ถ้ากำลังเช็คตัวอื่นๆที่ไม่ใช่ตัวแรกกับตัวสุดท้าย//
                         current.previous.next = current.next;
                         current.next.previous = current.previous;                      
                    }  
                    return current;
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
        if(tail == current){ //ถ้ากำลังเช็คตัวสุดท้าย//
            node2.next = null;
            node2.previous = tail;
            tail.next = node2;
        }else{ //ถ้าไม่ได้กำลังเช็คตัวสุดท้าย//
            node2.next = current.next;
            node2.previous = current;
            current.next.previous = node2;
            current.next = node2;
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){ //เพิ่ม node ข้างหน้า node สมาชิกของ list//
        current = head;
        while(current!=node1){ //ตามหา node ที่เป็นสมาชิกของ list//
            current = current.next;   
        } 
        if(head == current){ //ถ้ากำลังเช็คตัวแรก//
            node2.next = head; 
            head.next.previous = node2;
            head = node2;
        }else{ //ถ้าไม่ได้กำลังเช็คตัวแรก//
            node2.next = current;
            node2.previous = current.previous;
            current.previous.next = node2;
            current.previous = node2;
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
    public void merge(DoublyLinkedList list){ //รวม list เข้าด้วยกัน//
        while(!list.isEmpty()){ //ถ้า list ที่จะเพิ่มเข้ามาไม่ว่าง//
            pushBack(list.topFront());
            list.popFront();
        }
    }
    
    public void printStructure(){ // print สมาชิก//
        current = head;
        System.out.print(listName+": "+"head <-> ");
        while(current!=null){ //เช็คสมาชิกจนถึงตัวสุดท้าย//
            System.out.print("["+current.student_id+"] <-> " );
            current = current.next;
        }
        System.out.print("tail\n");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
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
