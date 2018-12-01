/* HW9
 * Due: 1 December 2018
 * Problem Header Hash Code: b92413879c0635f7773a1b9237d38d75
*/ 
package hw9;

/**
 *
 * @author patiw
 */
public class HashGraph extends Graph{
    
    long p; // Big Prime
    long x; // Small number
    
    public HashGraph(int cap, long p, long x){
        super(cap);
        this.p = p;
        this.x = x;
    }
    
    public void addVertex(String key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to rehash");
            return;
        }
        int index = hashCode(key);
        vertexList[index] = new Vertex(index); // an Array of list contains many Lists
        vertexList[index].str = key;
        size++;
    }
    
    public void addEdge(String source, String destination){
        int sourceIndex = hashCode(source);
        int destinationIndex = hashCode(destination);
        super.addEdge(sourceIndex, destinationIndex);
    }

    public void BFS(String s){
        int start = (int)hashCode(s);
        super.BFS(start);
    }
    public Stack getShortestPathList(String s, String u){
        int s_key = (int)hashCode(s);
        int u_key = (int)hashCode(u);
        return super.getShortestPathList(s_key, u_key);
    }
    
    public int hashCode(String s){ 
        int index = (int)(HashGraph.polyHash(s,p,x) % cap);
        for(int k=0;k<cap;++k){
            if(vertexList[index]!=null){ //if lead to collison
                if(vertexList[index].str==s){
                    return index;
                }
                index = (index+k)%cap; //rehash
            }
        }
        // Check if the index leads collision, if yes, use the quadratic probing
        //
        
        return index;
    }

    public static long polyHash(String s, long p, long x){ //hash string to index
        long hash = 0;
        char[] charArray = s.toCharArray();
        for(int i = s.length()-1;i>0;i--){
            hash = ((hash*x)+(int)charArray[i])%p;
        }
        return hash;
    }
    
    public void printShortestPart(String s, String u){

        int s_key = (int)hashCode(s);
        int u_key = (int)hashCode(u);
        System.out.println("\nShortestPart from "+vertexList[s_key].str+" to "+vertexList[u_key].str+"\n");
        BFS(s);    
        Stack stack = getShortestPathList(s, u);
        
        while(!stack.isEmpty()){
            
            System.out.print(stack.pop().str+" -> ");
        }   
        System.out.println();
        
       
    } 
}
