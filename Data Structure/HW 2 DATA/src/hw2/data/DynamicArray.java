/* HW2
 * Due: 13 September 2018
 * Problem Header Hash Code: 6fbdec4a211198f5804996340a81c52f
*/ 
package hw2;

/**
 *
 * @author Patiwet
 */
public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void pushBack(int data){
        if(size<capacity){
            arr[size] = data; 
            size++;
        }
        else{
            int [] arr2 = new int[capacity*2];
            for(int i=0;i<=size;i++){
                arr2[i]=arr[i];
            }
            arr = arr2;
            arr[size] = data; 
            size++;
        }
            
    }
    public int popBack(){
        
        if(size>0){
            int sum = arr[size-1] ;
            size-- ;
            return sum ;
        }
        else{
            System.out.println("ERROR");
            return 0 ;
        }
    }

    public int get(int i){
        for(int j=0;j<size;j--){
            if(arr[j]==i) {
                return j;
            }  
        }
        System.out.println("ERROR");
        return 0 ;
        
    }
    
    public void set(int i, int value){
        arr[i] = value;
    }
    
    public void remove(int i){
        if(i>=size||i<=0) {
            System.out.println("ERROR");
        }
        else{
            for(int a=i;a<size-1;a++){
            arr[a] = arr[a+1];
            }
        }
    }
    
    public boolean isEmpty(){
        if(size==0) 
            return true;
        else
            return false;
        
    }
    
    public int getSize(){
        return size;
    }
    
    public void printStructure(){
        
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = ["); 
        for(int i=0;i<size;i++){
            System.out.print(arr[i]);
        }   
        System.out.print("] ");    
    }
