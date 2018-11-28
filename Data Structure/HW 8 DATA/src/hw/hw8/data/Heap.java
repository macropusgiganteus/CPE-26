/* HW8
 * Due: 18 November 2018
 * Problem Header Hash Code: 8033763464f100405513a3e9d1c5017e
*/ 
package hw8;

/**
 *
 * @author patiw
 */
public class Heap {
    boolean isMinHeap; // true if minHeap, false if maxHeap
    int heapSize;
    Node[] arr;//Array as a complete binary tree
    int back;
    // For each node to be inserted into the heap, timeCounter will increase by 1
    int timeCounter;
    public Heap(boolean isMinHeap, int size){
        arr = new Node[size+1];
        heapSize = size;
        back = 1;
        this.isMinHeap = isMinHeap;
        timeCounter = 0;
    }
    public Node top(){
        return arr[1];
    }
    
    public void push(Node node){
//        if(isMinHeap){
//            System.out.println("**************************** [ SELL ORDER ] ******************************************");
//        }else{
//            System.out.println("**************************** [ BUY ORDER ] ******************************************");
//        }
//        System.out.println("************************************* [ PUSHING ] *********************************");
//        System.out.println("Before Pushing "+node.price+"   ---------------------------------------------------------");
//        System.out.println("Back = "+ back +" ");
//        if(back==1){
//            System.out.println("Empty ");
//        }else{
//            this.printArray();
//            this.printInvesterArray();
//        }
//        System.out.println("Pushing "+node.price+"          ---------------------------------------------------------");
        // time stamp
        node.timestamp = 0;
        node.timestamp = timeCounter; //set node's time stamp
        timeCounter = timeCounter+1;
        // Push new node at the end 
        int i = back;
        arr[back] = node;
        back++;
//        this.printArray();
        // sift (percolate) up
        if(back-1!=1){ //if array not empty
                while(arr[i].compare(arr[i/2])){  //while Priority(arr[i]>Priority(arr[i/2])) 
//                    System.out.println("swap "+node.price+" and "+arr[i].price +"        ---------------------------------------------------------"); 
                        this.swap(i, i/2);      
                       i=i/2; 
                       if(i == 1){ //if pushing node is root
                        break;
                        } 
                }
//            
        }
//        System.out.println("After Pushing "+node.price+"        ---------------------------------------------------------");
//        System.out.println("Back = "+ back +" ");
//        this.printArray();
//        this.printInvesterArray();
        
         
//        System.out.println("**********************************************************************\n");
    }
    public Node pop(){ 
//        if(isMinHeap){
//            System.out.println("**************************** [ SELL ORDER ] ******************************************");
//        }else{
//            System.out.println("**************************** [ BUY ORDER ] ******************************************");
//        }
//        System.out.println("**************************** [ POPPING ] ******************************************");
        Node popnode;
        Node backnode = arr[back-1];
        int i = 1;      
        popnode = arr[1]; // 1. mark the root for return
//        System.out.println("Before popping "+popnode.price+"   ---------------------------------------------------------");
//        System.out.println("Back = "+ back +" ");
//        if(back==1){
//            System.out.println("Empty ");
//        }else{
//            this.printArray();
//            this.printInvesterArray();
//        }
        arr[1] = backnode; // 2. Replace the last node with the root 
        arr[back-1] = null;
        
        // 3. Sift (percolate) down
        if(arr[1]!=null){    
                while(arr[i*2]!=null||arr[i*2+1]!=null){   //while currentNode has a child(s);              
                    if(arr[i*2]!=null&&arr[i*2+1]!=null){ // if currentNode has 2 children
                        if(arr[i*2].compare(arr[i*2+1])){ //if Priority(leftchild) > Priority(rightchild))
                            if(arr[i*2].compare(arr[i])){ //if Priority(leftchild) > Priority(currentNode))
//                                System.out.println("swap "+arr[i].price+" and "+arr[i*2].price +" [ "+ arr[i*2].investorID +" ] ---------------------------------------------------------");  
                                swap(i, i*2);
                                
                                i=i*2;
                            }else{ //if Priority(leftchild) < Priority(currentNode)
                                break;
                            }
                        }else{ //if Priority(leftchild) < Priority(rightchild)
                            if(arr[i*2+1].compare(arr[i])){ //if Priority(rightchild) > Priority(currentNode)
//                                System.out.println("swap "+arr[i].price+" and "+arr[i*2+1].price +" [ "+ arr[i*2+1].investorID +" ] ---------------------------------------------------------");  
                                swap(i, i*2+1);
                                
                                i=i*2+1;
                            }else{ //if Priority(rightchild) < Priority(currentNode)
                                break;
                            }
                        }
                    }
                    else if(arr[i*2]==null){ // if currentNode has only right child
                        if(arr[i*2+1].compare(arr[i])){ // if Priority(rightchild) > Priority(currentNode)
//                            System.out.println("swap "+arr[i].price+" and "+arr[i*2+1].price +" [ "+ arr[i*2+1].investorID +" ] ---------------------------------------------------------");  
                            swap(i, i*2+1);
                            
                            i=i*2+1;
                        }else { //if Priority(rightchild) < Priority(currentNode)
                            break;
                        }
                    }else if(arr[i*2+1]==null){ // if currentNode has only left child
                        if(arr[i*2].compare(arr[i])){ //if Priority(leftchild) > Priority(currentNode)
//                            System.out.println("swap "+arr[i].price+" and "+arr[i*2].price +" [ "+ arr[i*2].investorID +" ] ---------------------------------------------------------");  
                            swap(i, i*2);
            
                            i = i*2;
                        }else { //if Priority(leftchild) < Priority(currentNode)
                            break;
                        }
                    }
                }
//            
        }
        back = back-1;
//        System.out.println("After Poping "+popnode.price +" -----------------------------------------------------------");
//        System.out.println("Back = "+ back +" ");
        
//       if(back==1){
//            System.out.println("Empty ");
//        }else{
//            this.printArray();
//            this.printInvesterArray();
//        }
//       
//        System.out.println("**********************************************************************\n");
        return popnode; 
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void swap(int index1, int index2){
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void printArray(){
        System.out.print("[");
        for (int i=1; i<back; i++){
            System.out.print(arr[i].price);
            if (i<back-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public void printInvesterArray(){
        System.out.print("[");
        for (int i=1; i<back; i++){
            System.out.print(arr[i].investorID);
            if (i<back-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
    

}

//commented functions are for showing how stock market work in detail