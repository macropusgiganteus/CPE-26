/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package hw;

public class Stack {
    Node[] arr; // regular array
    int capacity=0;
    int size=0;

    public Stack(int cap){          // constructor //
        this.capacity = cap;
        arr = new Node[cap];
    }
    
    public void push(Node node){    //เพิ่มสมาชิกใน Stack//
        if (!isFull()){ //ถ้า Stack ไม่เต็ม //
             arr[size] = node;
             size++;
        }else{ // ถ้า Stack เต็ม //
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){ // pop สมาชิกบนสุดออก //
        if (!isEmpty()){    //ถ้า Stack ไม่ว่าง //      
            size--;     
            return arr[size];
        }else{      //ถ้า Stack ว่าง //
            System.out.println("Stack Underflow!!!");
            return null; 
        }    
    }
       
        
    public boolean isFull(){ //เช็ค Stack ว่าเต็มหรือไม่ //
        if(size==capacity){ //ถ้าสมาชิกเต็ม //
            return true;
        }
        else{ //ถ้าสมาชิกไม่เต็ม //
            return false; 
        }
        
    }
    public boolean isEmpty(){ //เช็คว่า Stack ว่างหรือไม่ //
        if(size ==0){ // ถ้าStack ว่าง //
            return true;
        }
        return false; 
    }
    
    public void printStack(){ //print ค่าของสมาชิกใน Stack //
        if (!isEmpty()) { //ถ้า Stack ไม่ว่าง //
            System.out.print("[Bottom] "); 
            for(int i=0;i<size;i++){ // ไล่ลำดับจากสมาชิกตัวแรกถึงตัวสุดท้าย //
                System.out.print(arr[i].data+" ");
            }
            System.out.println("[Top]");
        } else { //ถ้า Stack ว่าง //
            System.out.println("Empty Stack!!!");
        }
    }
}
