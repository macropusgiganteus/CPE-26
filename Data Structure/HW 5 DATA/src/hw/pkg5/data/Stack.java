/* HW5
 * Due: 3 October 2018
 * Problem Header Hash Code: e601ff86c0ed76524b8d8c5370c15181
*/ 
package hw;

public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap){
        this.capacity = cap;
    }
    
    public void push(Node node){
        if (!isFull()){
            if(size==0){
                arr[0] = node;
            }else{
                arr[size] = node;
            }
             size++;
        }else{
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){
        if (!isEmpty()){
            size--;
        }else{
            System.out.println("Stack Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    public boolean isFull(){
        if(size==capacity){
            return true;
        }
        return false; 
    }
    public boolean isEmpty(){
        if(size ==0){
            return true;
        }
        return false; 
    }
    
    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            for(int i=0;i<size;i++){
                System.out.print(arr[i]);
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}
