/* HW9
 * Due: 1 December 2018
 * Problem Header Hash Code: b92413879c0635f7773a1b9237d38d75
*/ 
package hw9;

/**
 *
 * @author Patiwet
 */
public class Node {
    // Node properties
    Vertex vertex; // Point to Vertex in the Vertex list
    Node next; // Point to next node in the list
    
    public Node(Vertex vertex){
        this.vertex = vertex;
    }
}
