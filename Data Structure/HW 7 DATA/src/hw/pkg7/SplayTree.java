/* HW7
 * Due: 5 November 2018
 * Problem Header Hash Code: 355a88089e03b21a427e11aed9924786
*/ 

package hw.pkg7;

import jdk.nashorn.internal.codegen.CompilerConstants;

public class SplayTree extends BTreePrinter{
    Node root;
    
    public SplayTree(){
        
    }
    
    public SplayTree(Node root){
        
        if (root.parent!=null){ // To make sure the root has no parent
            if (root.key < root.parent.key){
                root.parent.left = null;
            }else{
                root.parent.right = null;
            }
            root.parent = null;
        }
        this.root = root;
    }
    
    public void printTree(){
        super.printTree(root);
    }
    
    public Node find(int search_key) { 
        splay(find(root,search_key)); 
        return null;
    }

    // This function is already complete, no need to modify
    public Node findWithoutSplaying(int search_key) {
        return find(root, search_key);
    }
    
    // This function is already complete, no need to modify
    private static Node find(Node node, int search_key) {
        if (search_key == node.key) {
            return node;
        } else if ((search_key < node.key) && (node.left != null)) {
            return find(node.left, search_key);
        } else if ((search_key > node.key) && (node.right != null)) {
            return find(node.right, search_key);
        } else {
            return null;
        }
    }
    
    // This function is already complete, no need to modify
    private Node findMin() {
        return findMin(root);
    }

    // This function is already complete, no need to modify
    private static Node findMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }
    
    // This function is already complete, no need to modify
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }

    // Fix this function to have splaying feature
    private static void insert(SplayTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        } else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;     
                tree.splay(tree.findWithoutSplaying(key));
            } else {
                insert(tree, node.left, key);
                ;
            }
        } else{ // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;  
                tree.splay(tree.findWithoutSplaying(key));
            } else {
                insert(tree, node.right, key);
                
            }
        }
    }
    
    
    public void delete(int key) { //delete node
        if(this.findWithoutSplaying(key) != null){ //if node exists
            Node target = findWithoutSplaying(key);
            while(target.parent != null){ //if target isn't root
                zig(target); 
            }
        } 
        root.key = findMin(root.right).key;
        if(findMin(root.right).parent != root){
            findMin(root.right).parent.left = null; //delete leaf node
        }
        else findMin(root.right).parent.right = null; //delete leaf node
        
        
        
        // To delete a key in a splay tree, do the following steps
        // 1. splay node with the key to the root of tree1
        // 2. create another tree using the node of the right-subtree (tree2)
        // 3. Find min of the right-subtree and splay to the root
        // 4. Take left-subtree of the tree1 and hang as the left subtree of the tree2
        // 5. Reassign a new root (root of the tree2)
    }
    
    // Use this function to call zigzig or zigzag
    public void splay(Node node){ //splay node to root
        if (node!=null && node != root){ //if node is not root node and  null node
            if (node.parent == root){ //if parent is root
                zig(node);
            }else{ //if parent isn't root 
                if (node.key < node.parent.key){ //if node is left child of parent
                    if (node.parent.key < node.parent.parent.key){ //if parent is left child of grandparent
                        zigzig(node);
                    }else{  //if parent is right child of grandparent
                        zigzag(node);
                    }
                }else{ //if node is right child of parent
                    if (node.parent.key > node.parent.parent.key){ //if parent is right child of grandparent
                        zigzig(node);
                    }else{  //if parent is left child of grandparent
                        zigzag(node);
                    }
                }
                splay(node);
            }
        }
    }
    
    // Use this function to call zig
    public void zigzig(Node node){ // Move two nodes up along the Outer path
        zig(node.parent);
        zig(node);
    }
    
    // Use this funciton to call zig
    public void zigzag(Node node){ // Move two nodes up along the Inner path
        zig(node);
        zig(node);
    }
    
    // This function should be called by zigzig or zigzag
    public void zig(Node node){// Move up one step
        if (node.parent == null){
            System.out.println("Cannot perform Zig operation on the root node");
        }else if (node.parent == root){ // If the node is a child of the root
            if (node.key<node.parent.key){// Zig from left
               root = node;
               if(node.right!=null){ //if node has right child
                   node.right.parent = node.parent;
                   node.parent.left = node.right;
               }else{ //if node doesn't have right child
                   node.parent.left = null;
               }
               node.right = node.parent;
               node.parent.parent = node;
               node.parent = null;
            }else{ // Zig from right
                root = node;
               if(node.left!=null){ //if node has left child
                   node.left.parent = node.parent;
                   node.parent.right = node.left;
               }else{ //if node doesn't have left child
                   node.parent.right =null;
               }
               
               node.left = node.parent;
               node.parent.parent = node;
               node.parent = null;
            }
        }else{// if the node is not a child of the root
            if(node.parent.parent!=null){ //if node has grand parent
            if(node.parent.parent.key>node.parent.key){     //if parent  is left child of grandparent          
               node.parent.parent.left = node;
            }else{      //if parent  is right child of grandparent
               node.parent.parent.right = node;
                }
            }
            if (node.key<node.parent.key){// Zig from left
               if(node.right!=null){ //if node has right child
                   node.right.parent = node.parent;
                   node.parent.left = node.right;
               }else{ //if node doesn't have right child
                   node.parent.left = null;
               }
               
               node.right = node.parent;
               node.parent = node.parent.parent;
               node.right.parent = node;
               
            }else{ // Zig from right
               if(node.left!=null){ //if node has left child
                   node.left.parent = node.parent;
                   node.parent.right = node.left;
               }else{ //if node doesn't have left child
                   node.parent.right =null;
               }
               
               node.left = node.parent;
               node.parent = node.parent.parent;
               node.left.parent = node;
               
            }
        }
    }
}
