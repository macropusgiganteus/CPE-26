/* HW6
 * Due: 21 October 2018
 * Problem Header Hash Code: 72768a5124c7d61e8573f7c39c398e64
*/ 
package hw.pkg6.data;

/**
 *
 * @author Patiwet
 */
public class List {
    Node [] arr;
    int capacity;
    int size;
    
    public List(int cap){
        arr = new Node[cap];
        capacity = cap;
    }
    
    public void append(Node node){
        if (size<capacity){
            arr[size] = node;
            size++;
        }
    }
    
    public void printList(){
        System.out.print("[Head] ");
        for (int i=0; i<size; i++){
            System.out.print(arr[i].key + " ");
        }
        System.out.print("[Tail] ");
    }
}
