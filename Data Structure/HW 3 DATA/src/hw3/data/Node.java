/* HW3
 * Due: 20 September 2018
 * Problem Header Hash Code: 9af4b45be9aaf81c776e442d990d2cc2
*/ 
package hw3;

/**
 *
 * @author Patiwet
 */
public class Node {
    public int student_id;
    public String name;
    public double gpa;
    
    
    Node next;
    Node previous;
    
    // Constructor 1
    public Node(int id, String name, double gpa){
        student_id = id;
        this.name = name;
        this.gpa =gpa;
    }
    // Constructor 2
    public Node(String name){
        this.name = name;
    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }
    
    public void printIDName(){
        System.out.println("StudentID: " + student_id + " , Name: " + name);
    }

}
