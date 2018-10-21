/* HW6
 * Due: 21 October 2018
 * Problem Header Hash Code: 72768a5124c7d61e8573f7c39c398e64
*/ 
package hw.pkg6.data;

import java.util.concurrent.ThreadLocalRandom;
import jdk.nashorn.internal.codegen.CompilerConstants;

public class Node{
    Node left;
    Node right;
    Node parent;
    int key;
    
    public Node(int data){
        this.key = data;   
    }
    
    public int height(){
        return height(this);
    }
    
    public static int height(Node node){    
        if (node == null)
            return -1; 
        else return 1 + Integer.max(height(node.left), height(node.right));
    }

    public int size(){
        if(this==null){
                return 0;
            }
            else {
                return 1+size(this.left)+size(this.right);
            }
    }
    
    public static int size(Node node){
            if(node==null){
                return 0;
            }
            else {
                return 1+size(node.left)+size(node.right);
            }
    }
      
    
    public Node findNext(){
        if (this.right==null){
            return rightAncestor(this) ;
        }
        else {
            return leftDescendant(this.right);
        }
        
    }
    
    public static Node leftDescendant(Node node){// Case 1
        Node current = node;
        if(current.left==null) return current;
        else{
          return leftDescendant(node.left);
        }
    }
    
    public static Node rightAncestor(Node node) {// Case 1
        Node current = node;     
            if(current.key<current.parent.key){
                return current.parent;
            }else{
                rightAncestor(current.parent);
            }
        return null;
        
    }
    
    public int depth(Tree tree){ // Node Depth
        int i=0;
        Node current = this;
        while (current!=tree.root)
        {
            current=current.parent;
            i++;
        }
        return i;
    }
}
