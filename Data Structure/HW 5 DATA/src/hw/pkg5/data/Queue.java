/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package hw;

public class Queue {
    Node[] arr; // circular Queue
    int capacity;
    int front=0;
    int back=0;
    int size;
    
    public Queue(int cap){ //Constructor//
        this.capacity = cap;
        arr = new Node[cap];
    }
    
    public void enqueue(Node node){ //เพิ่มสมาชิกต่อหลัง queue//
        if (!isFull()){      //ถ้า queue ไม่เต็ม //
                arr[back] = node;
                if(back+1==capacity){ //ถ้าตัวสุดท้ายอยู่ตำแหน่งสุดท้ายของ queue //
                    back = 0;
                }
                else{ //ถ้าตัวสุดท้ายไม่ได้อยู่ตำแหน่งสุดท้ายของ queue //
                    back++;
                }    
            size++;
        }else{      //ถ้า queue เต็ม //
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){ //เอาสมาชิกตัวหน้าออกจาก queue //
        Node deQ = null;
        if (!isEmpty()){ //ถ้าqueue ไม่ว่าง //
             deQ = arr[front]; //เก็บค่าตัวที่จะลบ //
            if(front+1==capacity){ //ถ้าสมาชิกตัวหน้าอยู่ตำแหน่งสุดท้ายของ queue //
                front=0; 
            }
            else{  //ถ้าสมาชิกตัวหน้าไม่ได้อยู่ตำแหน่งสุดท้ายของ queue //            
                front++;
            }
            size--;
            return deQ; //return Node ที่ถูกลบ //
        }else{ //ถ้า queue ว่าง //
            System.out.println("Queue Underflow!!!");
            return null;
        }
        
    }
    
    public boolean isEmpty(){ //เช็คว่า queue ว่างหรือไม่//
        if(size==0){ // ว่าง //
            return true;
        }
        else{// ไม่ว่าง //
            return false; // fix this
        }
    }
    
    public boolean isFull(){ //เช็คว่า queue เต็มหรือไม่ //
        if(size == capacity){// เต็ม //
            return true;
        }
        return false; // ไม่เต็ม //
    }
    
    public void printCircularIndices(){ // print ตำแหน่ง front , back //
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){ //print สมาชิกใน queue //
        if (!isEmpty()){ // ถ้า queue ไม่ว่าง //
            System.out.print("[Front] ");
            int i = front; 
            for(int r=0;r<size;r++){ // ทำตามจำนวนสมาชิก //
                if(i+1==capacity){ //ถ้าสมาชิกตัวแรกอยู่ตำแหน่งสุดท้ายของ queue //
                    System.out.print(arr[i].data+" ");
                     i = 0;
                }
                else{ 
                    System.out.print(arr[i].data+" ");
                    i++;
                }       
            }
            System.out.println("[Back]");
        }else{ // ถ้า queue ว่าง //
            System.out.println("Empty Queue!!!");
        }
    }
}
