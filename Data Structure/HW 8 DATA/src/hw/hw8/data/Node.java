/* HW8
 * Due: 18 November 2018
 * Problem Header Hash Code: 8033763464f100405513a3e9d1c5017e
*/ 
package hw8;

public class Node {
    double price;
    int investorID;
    int amount;
    long timestamp; // Heap.push() is the only function that modify this variable
    boolean isMinHeap;
    public Node(double price, int investorID, int amount, boolean isMinHeap){
        this.price = price;
        this.investorID = investorID;
        this.amount = amount;
        this.isMinHeap = isMinHeap;
    }
    
    // return true if Priority(thisNode) > Priority(rightNode) and vice versa
    // minHeap: the lower the price, the higher the priority and vice versa
    // maxHeap: the lower the price, the lower the priority and vice versa
    //
    // You may create your own function if you do not understand my code
    public boolean compare(Node rightNode){
        if(rightNode==null){
            return true;
        }
        if (this.price == rightNode.price) {
            if(this.timestamp<rightNode.timestamp){
                return true;
            }else{
                return false; 
            }
        }else{
            if (isMinHeap){
                if(this.price<rightNode.price){
                    return true;
                }else{
                    return false; 
                }            
            }else{
                if(this.price>rightNode.price){
                    return true;
                }else{
                    return false; 
                } 
            }
        }
    }
}
