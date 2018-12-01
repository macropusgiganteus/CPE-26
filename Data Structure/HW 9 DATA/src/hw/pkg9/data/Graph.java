/* HW9
 * Due: 1 December 2018
 * Problem Header Hash Code: b92413879c0635f7773a1b9237d38d75
*/ 
package hw9;

/**
 *
 * @author patiwet.w
 */
public class Graph {
    Vertex[] vertexList;
    int cap;
    int size;
    int cc;
    public static final int INFINITY = -1;
    public Graph(int cap){
        this.cap = cap;
        size = 0;
        vertexList = new Vertex[cap];
    }
    
    public void addVertex(int key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }else{
            Vertex ADD = new Vertex(key);
            vertexList[key] = ADD;
            size++;
        }
        // Create a new vertex and place it at the appropriate location of the vertexList
    }
    
    // Two way edge
    // If you make a path from source to destination, you must make a path from the destination to the source
    public void addEdge(int source, int destination){
        if (vertexList[source]==null){
            System.out.println("Source node does not exist");
            return;
        } if (vertexList[destination]==null){
            System.out.println("Destination node does not exist");
            return;
        }
        // Check if there is already a path from source to destination
        if (!vertexList[source].isConnected(destination) && !vertexList[destination].isConnected(source)){
            Node Edge = new Node(vertexList[destination]);
            vertexList[source].append(Edge.vertex);
            Edge.vertex = vertexList[source];
            vertexList[destination].append(Edge.vertex);
        }else{
            System.out.println("There are already a path conntecting "+source+" and "+destination);
        }
    }
    
    public void DFS(){
        cc =1;
       for(int i=0;i<cap;i++){ //mark all vertices unvisited
           if(vertexList[i]!=null){
               vertexList[i].visited = false;
           }
       }
       for(int i=0;i<cap;i++){ //explore all connected vertices 
           if(vertexList[i]!=null){
                if(vertexList[i].visited==false){
                    Explore(vertexList[i]);
                    cc++;
                }
           }
           
       }
    }
    public void Explore(Vertex v){
        v.visited = true;
        v.ccNum = cc;
        // Print vertex
        System.out.print(v.key +"/"+v.ccNum+" -> ");
        Node node = v.head;
        while(node!=null){//while vertex v has connected vertices
            if(node.vertex.visited==false){ //if current  vertex is not visited
                Explore(node.vertex);
            }
            node = node.next;
        }
        // Also Do something here
    }
    public void BFS(int s){
        for (int i=0; i<cap; i++){ 
            if (vertexList[i]!=null){ //if vertexList[i] is not empty
                vertexList[i].dist = -1;
                vertexList[i].prev = null;
                vertexList[i].next = null;
            }
        }
        vertexList[s].dist = 0;
        Queue Q = new Queue(vertexList[s]);
        while(!Q.isEmpty()){ //while queue is not empty
            Vertex DeQVertex =Q.dequeue();
            Node v = DeQVertex.head;
            while(v!=null){ //while v is not empty
                if(v.vertex.dist==-1){ //if distance of v node's vertex is infinity
                    Q.enqueue(v.vertex);                 
                    v.vertex.dist = DeQVertex.dist+1;
                    v.vertex.prev = DeQVertex;
                    DeQVertex.next = v.vertex;
                    v = v.next;
                }else{ //if distance of v node's vertex is not infinity
                    v = v.next;
                }
            }
        }
    }
    
    public Stack getShortestPathList(int s_key, int u_key){
        Stack s = new Stack();
        while(u_key!=s_key){ //while u_key is not equal to s_key
            if(vertexList[u_key]!=null){ //if vertex at u_key is not empty
                s.push(vertexList[u_key]);  
                u_key = vertexList[u_key].prev.key;
            }      
        }
        s.push(vertexList[u_key]);
        return s;
    }
    public void printShortestPart(int s, int u){
        System.out.println("\nShortestPart\n");   
        BFS(s);
        Stack stack = getShortestPathList(s, u);
        while(!stack.isEmpty()){ //while stack is not empty
            
            System.out.print(stack.pop()+" ");
        }
        
        System.out.println();
    }
}
