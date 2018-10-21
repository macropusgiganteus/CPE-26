/* HW6
 * Due: 21 October 2018
 * Problem Header Hash Code: 72768a5124c7d61e8573f7c39c398e64
*/ 

package hw.pkg6.data;

// This Tree needs to inherit BTreePrinter

import com.sun.org.apache.bcel.internal.generic.NOP;

public class Tree extends BTreePrinter{
    Node root;
    
    public Tree(){
        // can be left blank
    }
    
    public Tree(Node root){
        this.root = root;
        // fix this
    }
    
    public void printTree(){
        if(root!=null)this.printTree(root);
        else{
            System.out.println("Empty tree!!!");
        }
        //super.printTree(root);
    }

    public Node find(int search_key){ //ตามหา Node ที่บรรจุ Key ที่ต้องการค้นหา
        Node current = root; 
        while(current!=null){ //ทำเมื่อจุดที่เช็คไม่ว่าง
        if(search_key==current.key) { //ถ้า key ของ Nodeตรงกับที่ค้นหา
            return current;
        }
        else if(search_key<current.key) { //ถ้า key ของ Node มากกว่าที่ค้นหา
            current = current.left;
        }
        else current = current.right; ///ถ้า key ของ Node น้อยกว่าที่ค้นหา
        }
        return null;
    }
    
    public static Node find(Node node, int search_key){
         Node current = node;
         if(current!=null){ //ถ้าจุดที่เช็คไม่ว่าง
            if(search_key==current.key){ //ถ้า Key ของ Node ตรงกับที่ค้นหา 
                return current;
            }   
           else if(search_key>current.key) { //ถ้า key ที่ค้นหา(รงกับข้อมูลเ)ที่เช็ค
               return find(node.right, search_key);
           }
           else { //ถ้า key ที่ตามหาตรงกับข้อมูลที่เช็ค
               return find(node.left, search_key);
           }
           }
        return current;
    }
    
    public Node findClosest(int search_key){
        Node current = root; 
        while(current!=null){
            if(search_key==current.key) {

                return current;
            }
            else if(search_key<current.key) {
                if(current.left==null) return current;
                current = current.left;
            }
            else {
                if(current.right==null) return current;
                current = current.right;
            }

        }
        return null;
        
    }
    
    public static Node findClosest(Node node, int search_key){
        Node current = node; 
        while(current!=null){
            if(search_key==current.key) {
                return current;
            }
            else if(search_key<current.key) {
                if(current.left==null) return current;
                current = current.left;
            }
            else {
                if(current.right==null) return current;
                current = current.right;
            }

        }
        return null;
    }
    
    public Node findMin(){
        Node current = root;
        if(current.left==null) return current;
        else{
            while(current.left!=null){
                current = current.left;
            }
            return current;
        }
    }
    
    public static Node findMin(Node node){
        Node current = node;
        if(current.left==null) return current;
        else{
            while(current.left!=null){
                current = current.left;
            }
            return current;
        }
    }
    
    public Node findMax(){
        Node current = root;
        if(current.right==null){
            return current;
        }
        while(current.right!=null){
            current=current.right;
        }
        return current;
    }
    
    public static Node findMax(Node node){
        Node current = node;
        if(current.right==null){
            return current;
        }
        while(current.right!=null){
            current=current.right;
        }
        return current;
    }
    
    public Node findKthSmallest(int k){
        int l ;
        if(root.left!=null)  l = root.left.size();
        else l = 0;
        if(k==l+1) {
            return root;
        }
        else if(k<l+1) {
            return findKthSmallest(root.left, k);
        }
        else {
            return findKthSmallest(root.right, k-l-1);
        }
    }
    
    public static Node findKthSmallest(Node node, int k){
        int l ;
        if(node.left!=null)  l = node.left.size();
        else l = 0;
        if(k==l+1) {
            return node;
        }
        else if(k<l+1) {
            return findKthSmallest(node.left, k);
        }
        else {
            return findKthSmallest(node.right, k-l-1);
        }
    }
    
    public List rangeSearch(int x, int y){
        List list = new List(100);
        Node N = findClosest(root,x);
        while(N.key<=y){
            if(N.key>=x){
                list.append(N);
            }
            N=N.findNext();
        }
        return list;
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [");
        printPreOrderDFT(root);
        
        System.out.println(" ]");
    }

    
    public static void printPreOrderDFT(Node node){     
        if(node.left==null&&node.right==null) System.out.print(" "+node.key);
        else{
            System.out.print(" "+node.key);
            if(node.left!=null)
            printPreOrderDFT(node.left);
            if(node.right!=null)
            printPreOrderDFT(node.right);
        } 
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [");
        printInOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        if (node == null)
            return;
        else
        {
            printInOrderDFT(node.left);
            System.out.print(node.key+" ");
            printInOrderDFT(node.right);
        }
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [");
        printPostOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        if(node.left==null&&node.right==null) System.out.print(" "+node.key);
        else{
            if(node.left!=null)
            printPostOrderDFT(node.left);
            if(node.right!=null)
            printPostOrderDFT(node.right);
            System.out.print(" "+node.key);
        }
    }
    
    public void insert(int key) {
        Node current = root;
        if (current == null) {
            root = new Node(key);
        } else {
            while(current!=null){
                if(current.key==key){
                    System.out.println("Duplicated key!!!");
                    break;
                } 
                else if(key<current.key){
                    if(current.left==null) break;
                    current = current.left;         
                }
                else if(key>current.key){
                    if(current.right==null) break;
                    current = current.right;   
                } 
            }  
            if(current.key!=key){
                if(key<current.key){
                    current.left = new Node(key);
                    current.left.parent = current;
                }else{
                    current.right = new Node(key);
                    current.right.parent = current;
                }
            }
        }
    }
    
    
    public void delete(int key) {
        if (root == null) {                     //ถ้า root Node ไม่มีลูก
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { // Delete root node
            if(root.left==null&&root.right==null){ //ถ้า root Node เป็น Node ใบ
                root.parent.left = null;
                root.parent.right = null;
            }else if(root.left==null||root.right==null){ //ถ้า root Node มีลูก 1 คน
                if(root.left ==null){ //ถ้าไม่มีลูกด้านซ้าย
                    root = root.right;
                    root.parent = null;
                }else{ //ถ้าไม่มีลูกด้านขวา
                    root = root.left;
                    root.parent = null;
                }
            }else{ //ถ้าลูกเต็มมือ
               
                root.key = findMin(root.right).key;
                delete(findMin(root.right));
            }
        } else { //ลบตัวอื่นๆที่ไม่ใช่ root Node
            Node current =  find(key);    //หา Node ที่ต้องการลบ   
                 if(current==null){ //ถ้าหาไม่เจอ
                     System.out.println("Key not found!!!");
                 }
                 else{ //ถ้าหาเจอ
                     delete(current);
                 }
        }
    }
    
    // this function should delete only non-root node
    public static void delete(Node node){
        Node current = node;
        if(current.left==null&&current.right==null) { //กรณีเป็น Node ใบ
            if(current.key<current.parent.key){ //ถ้าข้อมูลของ Node น้อยกว่าพ่อแม่
                current.parent.left =null; //พ่อแม่ตัดลูกซ้าย
            }
            else { //ถ้าข้อมูลของ Node มากกว่าพ่อแม่
                current.parent.right =null; //พ่อแม่ตัดลูกขวา
            }
        }else if(current.left!=null&&current.right!=null){ //กรณีมีลูกเต็มมือ     
             Node del = findMin(node.right);
            current.key = del.key; //เอาค่าที่น้อยที่สุดจาก right sub tree มาใส่แทน
            delete(del); //ลบตัวที่เอาค่ามาใส่ออก
        }else{  //กรณีมีลูก 1 Node
            if(node.parent.left==node)
            {
                if(node.left==null)
                {
                    node.parent.left=node.right;
                    node.right.parent=node.parent;
                }else if(node.right==null)
                {
                    node.parent.left=node.left;
                    node.left.parent=node.parent;
                }

            }
            else if(node.parent.right==node)
            {
                if(node.left==null)
                {
                    node.parent.right=node.right;
                    node.right.parent=node.parent;
                }else if(node.right==null)
                {
                    node.parent.right=node.left;
                    node.left.parent=node.parent;
                }
            }
        }
                
                
    }
                
    
    // Replace node1 with a new node2
    // node2 must be created using "new Node(key)" before calling this function
    // This function is optional, you do not have to use it
    public static void replace(Node node1, Node node2){ 
        if ((node1.left != null) && (node1.left != node2)){
            node2.left = node1.left;
            node1.left.parent = node2;
        }
        if ((node1.right != null) && (node1.right != node2)){
            node2.right = node1.right;
            node1.right.parent = node2;
        }
        if ((node1.parent != null) && (node1.parent != node2)){
            node2.parent = node1.parent;
            if (node1.parent.key > node1.key){
                node1.parent.left = node2;
            }else{
                node1.parent.right = node2;
            }
        }
    }
    
    public int height(){
        if(root!=null)return root.height();
        return -1; // fix this with a single line
    }
    
    public int depth(){// Tree depth is equal to tree height
        if(root!=null)return root.height();
        return -1; // fix this with a single line
    }
    
    public int size(){
        if(root!=null)return root.size();
        return 0; // fix this with a single line
    }
}
