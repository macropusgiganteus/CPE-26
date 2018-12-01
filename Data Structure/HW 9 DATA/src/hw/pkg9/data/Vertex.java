/* HW9
 * Due: 1 December 2018
 * Problem Header Hash Code: b92413879c0635f7773a1b9237d38d75
*/ 
package hw9;

/**
 *
 * @author patiwet.w
 */
public class Vertex {
    
    // Vertex properties
    String str;
    int key;
    int ccNum;
    boolean visited;
    int dist;
    
    // Vertex previous pointer for constructing shortest-path tree
    Vertex prev; // Do not get confused with Node prev pointer
    Vertex next; // Do not get confused with Node next pointr
    
    // List properties
    Node head;
    Node tail;

    public Vertex(int key){
        this.key = key;
        this.str = Integer.toString(key);
    }

    // This function will test if a vertex with the key is connected to the current vertex
    public boolean isConnected(int key){ 
        Node node = head;
        if(node!=null){
            if(node.vertex.key==key){ //if key is in head vertex
                return true;
            }else{ //if key is not in head vertex
                if(node.next!=null){ //if node is not tail node
                    while(node!=tail){ //while node is not tail node
                        node = node.next;
                        if(node.vertex.key==key){ //if found that key is connected
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    // Create a list of nodes by adding a new node (containing a vertex) to the tail 
    public void append(Vertex linkedVertex){
        if (head==null){ //if Vertex isn't connected
             Node AdjVertx = new Node(linkedVertex);
            this.head = AdjVertx;
            this.tail = AdjVertx;
        }else{ //if Vertex is connected to  vertices
            Node AdjVertx = new Node(linkedVertex);
            this.tail.next = AdjVertx;
            this.tail = AdjVertx;
        }
    }
    
    public void showList(){
        Node node = head;
        System.out.print("Vertex " + str + " connected to the following vertices: ");
        while(node!=null){
            System.out.print(node.vertex.str + ", ");
            node = node.next;
        }
        System.out.println();
    }
}
