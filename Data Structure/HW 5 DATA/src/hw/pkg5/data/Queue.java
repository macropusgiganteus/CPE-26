/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package hw;

public class Queue {
    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        this.capacity = cap;
    }
    
    public void enqueue(Node node){
        if (!isFull()){
            if(size==0){
                front=0;
                back=0;
                arr[front] = node;
            }else{  
                if(arr[back].right==null){
                    arr[back].right = node;
                }else{
                    arr[back].left = node;
                }
                if(back+1==capacity&&size!=capacity){
                    back = 0;
                }
                else{
                    back++;
                }
                arr[back] = node;
            }
            size++;
            
        }else{
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){
        
        if (!isEmpty()){
            arr[back] = null;
            if(back==0){
                back=capacity-1; 
            }
            else{              
                back--;
            }
            size--;
            
        }else{
            System.out.println("Queue Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false; // fix this
    }
    
    public boolean isFull(){
        if(size == capacity){
            return true;
        }
        return false; // fix this
    }
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){
        if (!isEmpty()){
            System.out.print("[Front] ");
            int i = front;
            for(int r=0;r<=size;r++){
                if(i==capacity){
                    i = 0;
                    System.out.println(arr[i]);
                }
                else{
                    System.out.println(arr[i]);
                }
                i++;
            }
            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
}
