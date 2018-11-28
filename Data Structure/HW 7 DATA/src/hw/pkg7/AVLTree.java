/* HW7
 * Due: 5 November 2018
 * Problem Header Hash Code: 355a88089e03b21a427e11aed9924786
*/ 

package hw.pkg7;


public class AVLTree extends BTreePrinter {

    Node root;

    public AVLTree() {

    }

    public AVLTree(Node root) {
        this.root = root;
        this.root.parent = null; // To make sure the root has no parent
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }

    public Node find(int search_key) {
        return find(root, search_key);
    }

    public static Node find(Node node, int search_key) {
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

    public Node findMin() {
        return findMin(root);
    }

    public static Node findMin(Node node) {
        if (node==null || node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public Node findMax() {
        return findMax(root);
    }

    public static Node findMax(Node node) {
        if (node==null || node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
        
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    public static void insert(AVLTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        } else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;      
                
            } else {
                insert(tree, node.left, key);
                rebalance(tree, node); //rebalance
            }
            
        } else{ // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;   
            } else {
                insert(tree, node.right, key);
                rebalance(tree, node); //rebalance
            } 
        } 
    }
    
    // Fix this
    // If you do not understant my code, feel free to implement your own code
    public static void rebalance(AVLTree tree, Node node){
        if (node.isImbalance()){
            
            /////////////////////////////////////////////////////////////////////////////
            // This code segment is make sure that we rebalance the first imbalance node closest to the leaves
            if (Node.height(node)>2){
                if (Node.height(node.left) > Node.height(node.right)){
                    rebalance(tree, node.left);
                }else{
                    rebalance(tree, node.right); 
                }
            }
            /////////////////////////////////////////////////////////////////////////////
            
            if (Node.height(node.left) > Node.height(node.right)) { // Left heavy?
                if (Node.height(node.left.left) > Node.height(node.left.right)) { // Outer?
                    System.out.println("Perform SingleRotationFromLeft (Node " + node.key +")"); // fix ???
                    tree.singleRotateFromLeft(node);
                }else{ // Inner?
                    System.out.println("Perform DoubleRotationFromLeft (Node " + node.key +")"); // fix ???
                    tree.doubleRotateFromLeft(node);
                }
            }else{ // Right heavy?
                if (Node.height(node.right.right) > Node.height(node.right.left)) { //Outer?
                    System.out.println("Perform SingleRotationFromRight (Node " + node.key +")"); // fix ???
                    tree.singleRotateFromRight(node);
                } else { // Inner?
                    System.out.println("Perform DoubleRotationFromRight (Node " + node.key +")"); // fix ???
                    tree.doubleRotateFromRight(node);
                }
            }
        }
    }
    
    public void singleRotateFromLeft(Node y) { //rotate node.left to node
        if(y!=root){ //if node isn't root
           if(y.key>y.parent.key){
               y.parent.right = y.left;       
           }else{
               y.parent.left = y.left;
           }
           y.left.parent = y.parent;
        }else{ //if node is root
           root = y.left;
           y.left.parent= null;
       }
        y.parent = y.left;
        if(y.left.right!=null){ //if y.left has right child
            y.left.right.parent = y;
        }
        y.left = y.left.right;
        y.parent.right = y;
    }

    public void singleRotateFromRight(Node y) { //rotate node.right to node
        if(y!=root){ //if node isn't root
           if(y.key>y.parent.key){
               y.parent.right = y.right;       
           }else{
               y.parent.left = y.right;
           }
           y.right.parent = y.parent;
        }else{ //if node is root
           root = y.right;
           y.right.parent= null;
       }
        y.parent = y.right;
        if(y.right.left!=null){ //if y.right has left child
            y.right.left.parent = y;
        }
        y.right = y.right.left;
        y.parent.left = y;
    
    }

    public void doubleRotateFromLeft(Node y) { //rotate node.left.right to node
        singleRotateFromRight(y.left);
        singleRotateFromLeft(y);
    }

    public void doubleRotateFromRight(Node y) { //rotate node.right.left to node
        singleRotateFromLeft(y.right);
        singleRotateFromRight(y);
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    // This function will delete root or call the recursive delete function
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { // Delete root node
            if ((root.left == null) && (root.right == null)) { // Case 1 (leaf node)
                root = null;
            } else if ((root.left != null) && (root.right != null)) { // Case 3 (full node)
                Node minRightSubTree = findMin(root.right);
                Node temp = new Node(minRightSubTree.key);
                replace(root, temp);
                root = temp;
                // recursively delete the node
                delete(this, root.right, minRightSubTree.key);
                rebalance(this, root); //rebalance
            } else if (root.left != null) { // Case 2 (single child, left child)
                root.left.parent = null; // make left child the root
                root = root.left;
                rebalance(this, root); //rebalance
            } else { // Case 2 (single child, right child)
                root.right.parent = null; // make right child the root
                root = root.right; 
                rebalance(this, root); //rebalance
            }        
        } else { // Delete non-root node
            delete(this, root, key);
            rebalance(this, root); //rebalance
        }
        
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    // This function will delete non-root nodes
    public static void delete(AVLTree tree, Node node, int key) {
        if (node==null)
        {
            System.out.println("Key not found!!!");
        }else if (node.key > key){ // Go left
            delete(tree, node.left, key);
            rebalance(tree, node); //rebalance
        }else if (node.key < key){ // Go right
            delete(tree, node.right, key);
            rebalance(tree, node); //rebalance
        }else if (node.key == key){ // Node to be deleted is found
            if ((node.left == null) && (node.right == null)) { // Case 1(leaf node)
                if (node.key < node.parent.key) {
                    node.parent.left = null; // disown the left child
                } else {
                    node.parent.right = null; // disown the right child
                }
                
            } else if ((node.left != null) && (node.right != null)) { // Case 3 (full nodes)
                Node minRightSubTree = findMin(node.right);
                Node Rb = minRightSubTree.parent;
                Node temp = new Node(minRightSubTree.key);
                replace(node, temp);
                // recursively delete the node
                delete(tree, node.right, minRightSubTree.key);
                
            } else {// Case 2 (single child)
                Node childNode;
                if (node.left != null) {  // only the left child
                    childNode = node.left;
                } else { // only the right child
                    childNode = node.right;
                }
                
                childNode.parent = node.parent;
                if (node.parent.key > node.key) {
                    node.parent.left = childNode;
                } else {
                    node.parent.right = childNode;
                }
            }
        }
       
    }
    
    // Replace node1 with a new node2
    // node2 must be created using "new Node(key)" before calling this function
    // This function is optional, you do not have to use it
    public static void replace(Node node1, Node node2) {
        if ((node1.left != null) && (node1.left != node2)) {
            node2.left = node1.left;
            node1.left.parent = node2;
        }
        if ((node1.right != null) && (node1.right != node2)) {
            node2.right = node1.right;
            node1.right.parent = node2;
        }
        if ((node1.parent != null) && (node1.parent != node2)) {
            node2.parent = node1.parent;
            if (node1.parent.key > node1.key) {
                node1.parent.left = node2;
            } else {
                node1.parent.right = node2;
            }
        }
    }

    public static boolean isMergeable(Node r1, Node r2){ //check if r1 and r2 can merg together
        if(r1==null||r2==null){ //if r1 or r2 is empty node
            return true;
        }
        if(findMax(r1).key<findMin(r2).key){ // if all node in r1 tree is smaller than all node in r2 tree
            return true;
        }
        return false;
    }
    
    public static Node mergeWithRoot(Node r1, Node r2, Node t){ // merg ri and r2 with node t
       if(isMergeable(r1, r2)){
           if(Math.abs(Node.height(r1)-Node.height(r2)) <=1) //if height of r1 and height of r2 are different <=1
            {
                t.left=r1;
                t.right=r2;
                if(r1!=null)r1.parent=t;
                if(r2!=null)r2.parent=t;
                return t;
            }else if(Node.height(r1)>Node.height(r2)) //else if r1 higher than r2
            {
                Node r_prime =mergeWithRoot(r1.right,r2,t);
                r1.right=r_prime;
                r_prime.parent=r1;
                AVLTree tree=new AVLTree(r1);
                rebalance(tree,r1);
                return tree.root;
            }else if(Node.height(r1)<Node.height(r2)) //else if r2 higher than r1
            {
                Node r_prime =mergeWithRoot(r2.left,r1,t);    
                r2.left=r_prime;
                r_prime.parent=r2;
                AVLTree tree=new AVLTree(r2);
                rebalance(tree,r2);
                return tree.root;
            }
        }
        else{ //if unmergeable
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return t;
        }
        return t;
    }
          
    public void merge(AVLTree tree2){
        if (isMergeable(this.root, tree2.root)){ //if this and tree2 can merge together
           Node t = this.findMax();
            this.delete(t.key);
            mergeWithRoot(this.root, tree2.root, t);
            root = t.parent;
        }else{ //if unmergeable
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
        
    }
    
    public NodeList split(int key){ // split tree from key
        return  split(root,key); 
    }
    
    public static NodeList split(Node r, int key){ //split tree with root node r from  key
        NodeList list = new NodeList();
        if (r == null){ //if tree is empty
            list.r1 =null;
            list.r2 =null;
            return list;
        }else if (key < r.key){ //split left
            list = split(r.left, key);
            Node r3 = mergeWithRoot(list.r2, r.right, r);
            list.r2 = r3;
            return list;
        }else { // key>=root.key
                //split right
            list = split(r.right, key);
            Node r3 = mergeWithRoot( r.left,list.r1, r);
            list.r1 = r3;
            return list;
        }
    } 
}
