/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Apr 15, 2022
 * LastModified: Apr 15, 2022
 * FileName: Application.java
 *****************************************************
 */
package qTwo;

public class Application {

	
	public void run() {
		DirectedGraph graph = new DirectedGraph(5);
		graph.addVertex(1);
		graph.addVertex(3);
		graph.addVertex(2);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		
		graph.addEdge(1, 4);
		graph.addEdge(1, 2);
		graph.addEdge(4, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(5, 7);
		graph.addEdge(5, 3);
		graph.addEdge(7, 6);
		graph.addEdge(6, 5);
		
		System.out.println("Degree of 4 is : " + graph.degree(4));
		System.out.println("Degree of 1 is : " + graph.degree(1));
		
		System.out.println("Is 1 and 4 adjacent: " + graph.adjacent(1,4));
		System.out.println("Is 3 and 1 adjacent: " + graph.adjacent(3,1));
		
		
		System.out.println("Is 1 and 3 connected: " + graph.connected(1,3));
		System.out.println("Is 1 and 5 connected: " + graph.connected(1,5));
		System.out.println("Is 6 and 7 connected: " + graph.connected(6,7));
		
		System.out.println("Graph: ");
		graph.displayListOfVertecies();
		
		System.out.println("Reversed graph: ");
		graph.reverse().displayListOfVertecies();
		
		System.out.println("Complemented graph: ");
		graph.compliment().displayListOfVertecies();
	}
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}

}
