/* HW9
 * Due: 1 December 2018
 * Problem Header Hash Code: b92413879c0635f7773a1b9237d38d75
*/ 
package hw9;

/**
 *
 * @author patiw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       System.out.println("\nEX 1 \n");
        Graph graph = new Graph(32); 
        for (int i=0; i<16; i++)
            graph.addVertex(i);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 8);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(6, 10);
        graph.addEdge(6, 9);
        graph.addEdge(7, 14);
        graph.addEdge(8, 9);
        graph.addEdge(8, 13);
        graph.addEdge(8, 12);
        graph.addEdge(10, 14);
        graph.addEdge(11, 15);
        graph.addEdge(13, 14);
        graph.addEdge(14, 15);
        
        
        graph.vertexList[0].showList();
        
        graph.vertexList[1].showList();
        graph.vertexList[5].showList();
        graph.vertexList[14].showList();
        graph.vertexList[11].showList();
        
        
        graph.DFS();
        System.out.println("\nEX 2 \n");
        
        graph = new Graph(32); 
        for (int i=0; i<16; i++)
            graph.addVertex(i);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(5, 9);
        graph.addEdge(6, 9);
        graph.addEdge(7, 14);
        graph.addEdge(8, 13);
        graph.addEdge(8, 12);
        graph.addEdge(10, 14);
        graph.addEdge(11, 15);
        graph.addEdge(14, 15);
        
        graph.DFS();
        
        System.out.println("\nNumber of connected component = " + (graph.cc-1));
        
             
        /*
        for (int i=0; i<16; i++)
            graph.vertexList[i].showList();
*/
        
        System.out.println("\nEX 3 \n");
        long p = 101111; // Big Prime (Hash key1)
        long x = 101; // Small number (Hash key2)
        HashGraph hashgraph = new HashGraph(32, p, x); 
        String[] cities = new String[]{"Dublin", "Edinburgh", "Manchester", 
            "Copenhagen", "Lisbon", "London", "Berlin", "Prague", "Madrid", 
            "Paris", "Vienna", "Budapest", "Geneva", "Milan", "Zurich", "Rome"};
        for (int i=0; i<16; i++){
            hashgraph.addVertex(cities[i]);
        }
        
        hashgraph.addEdge("Dublin", "Edinburgh");
        hashgraph.addEdge("Dublin", "London");                
        hashgraph.addEdge("Dublin", "Lisbon");
        hashgraph.addEdge("Edinburgh", "Manchester");
        hashgraph.addEdge("Manchester", "London");
        hashgraph.addEdge("Manchester", "Copenhagen");
        hashgraph.addEdge("Copenhagen", "Berlin");
        hashgraph.addEdge("Lisbon", "Madrid");
        hashgraph.addEdge("London", "Paris");
        hashgraph.addEdge("Berlin", "Prague");
        hashgraph.addEdge("Berlin", "Vienna");
        hashgraph.addEdge("Berlin", "Paris");
        hashgraph.addEdge("Prague", "Zurich");
        hashgraph.addEdge("Madrid", "Paris");
        hashgraph.addEdge("Madrid", "Milan");
        hashgraph.addEdge("Madrid", "Geneva");
        hashgraph.addEdge("Vienna", "Zurich");
        hashgraph.addEdge("Budapest", "Rome");
        hashgraph.addEdge("Milan", "Zurich");
        hashgraph.addEdge("Zurich", "Rome");
        
        
        hashgraph.vertexList[hashgraph.hashCode("Paris")].showList();
        hashgraph.vertexList[hashgraph.hashCode("Zurich")].showList();
        hashgraph.vertexList[hashgraph.hashCode("Geneva")].showList();
        
        hashgraph.printShortestPart("London", "Budapest");
        hashgraph.printShortestPart("Berlin", "Dublin");
        
    }
    
}

