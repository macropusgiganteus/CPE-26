/* HW7
 * Due: 5 November 2018
 * Problem Header Hash Code: 355a88089e03b21a427e11aed9924786
*/ 

package hw.pkg7;

public class BSTree extends BTreePrinter {

    Node root;

    public BSTree() {

    }

    public BSTree(Node root) {
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

    public Node find(int search_key) { //find node from key
        return find(root, search_key);
    }

    public static Node find(Node node, int search_key) {    //find node from key
        if (search_key == node.key) { //if found node
            return node;
        } else if ((search_key < node.key) && (node.left != null)) { //go left
            return find(node.left, search_key);
        } else if ((search_key > node.key) && (node.right != null)) { //go right
            return find(node.right, search_key);
        } else { //if not found
            return null;
        }
    }

    public Node findMin() {
        return findMin(root);
    }

    public static Node findMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public Node findMax() {
        return findMax(root);
    }

    public static Node findMax(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(root, key);
        }
    }

    public static void insert(Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key!!!");
        } else if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            } else {
                insert(node.left, key);
            }
        } else if (node.right == null) {
            node.right = new Node(key);
            node.right.parent = node;
        } else {
            insert(node.right, key);
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

    // You should have "root node deletion" in this function
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { // Delete root node
            if ((root.left == null) && (root.right == null)) { // Case 1 (leaf node)
                root = null;
            } else if ((root.left != null) && (root.right != null)) { // Case 3 (full node)
                Node minRightSubTree = findMin(root.right); // find min from the right subtree
                Node temp = new Node(minRightSubTree.key);
                replace(root, temp);
                root = temp;
                // recursively delete the node from the right subtree
                delete(root.right, minRightSubTree.key);
            } else if (root.left != null) { // Case 2 (single child, left child)
                root.left.parent = null;
                root = root.left; 
            } else { // Case 2 (single child, right child)
                root.right.parent = null;
                root = root.right; // promote the right child to the root
            }
        } else { // Delete non-root node
            delete(root, key);
        }
    }

    // this function should delete only non-root node
    public static void delete(Node node, int key) {
        if (node==null)
        {
            System.out.println("Key not found!!!");
        }else if (node.key > key){
            delete(node.left, key);
        }else if (node.key < key){
            delete(node.right, key);
        }else if (node.key == key){ // Node to be deleted is found
            if ((node.left == null) && (node.right == null)) { // Case 1(leaf node)
                if (node.key < node.parent.key) {
                    node.parent.left = null; // disown the left child
                } else {
                    node.parent.right = null; // disown the right child
                }
            } else if ((node.left != null) && (node.right != null)) { // Case 3 (full nodes)
                Node minRightSubTree = findMin(node.right); // find min from the right subtree
                Node temp = new Node(minRightSubTree.key);
                replace(node, temp);
                // recursively delete the node start from the right subtree
                delete(node.right, minRightSubTree.key);
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

    
    public static boolean isMergeable(Node r1, Node r2){
        if(findMax(r1).key<findMin(r2).key){
            return true;
        }
        return false;
    }
    
    public static Node mergeWithRoot(Node r1, Node r2, Node t){ //merg r1 and r2 with Node t
        if (isMergeable(r1, r2)) { //if max key of r1 tree < min key of r2 tree
            t.left = r1; 
            t.right = r2;
            r1.parent = t;
            r2.parent =t;
            return t;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }
          
    public void merge(BSTree tree2){
        if (isMergeable(this.root, tree2.root)){ //merg this tree and tree2
           Node t = new Node(this.findMax().key);
           delete(this.root,t.key);
           mergeWithRoot(root, tree2.root, t);
           root = t;
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
        
    }
    
    public NodeList split(int key){ //split 1 tree to 2 tree
        return  split(this.root,key); 
    }
    
    
    public static NodeList split(Node r, int key){
        NodeList list = new NodeList();
        if (r == null){ //if tree is empty
            return list;
        }else if (key < r.key){ 
            NodeList l = split(r.left, key);
            Node r3 = mergeWithRoot(l.r2, r.right, r);
            list.r2 = r3;
            return list;
        }else{ // key>=root.key
            NodeList l = split(r.right, key);
            Node r4 = mergeWithRoot(r.left, l.r1, r);
            list.r2 = r4;
            return list;
        }
    }
}
