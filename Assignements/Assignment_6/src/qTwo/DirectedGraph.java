/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Apr 15, 2022
 * LastModified: Apr 15, 2022
 * FileName: DirectedGraph.java
 *****************************************************
 */
package qTwo;


import qTwo.LinkedList.Node;

public class DirectedGraph {
	private int[] V;
	private LinkedList[] E;
	
	int index;
	
	public DirectedGraph(int initial_capacity) {
		V = new int[initial_capacity];
		E = new LinkedList[initial_capacity];
		index = 0;
	}
	
	public int getIndexOf(int u) {
		// return the index of i if found otherwise -1
		for (int j = 0; j < V.length; j++) {
			if(V[j] == u) {
				return j;
			}
		}
		return -1;
	}
	public void ensureCapacity() {
		if(index == V.length) {
			int[] new_v = new int[V.length + 5];
			LinkedList[] new_e = new LinkedList[E.length + 5];
			
			for(int i = 0; i < V.length; i++) {
				new_v[i] = V[i];
				new_e[i] = E[i];
			}
			
			V = new_v;
			E = new_e;
		}
	}
	public void addVertex(int u) {
		ensureCapacity();
		
		V[index] = u;
		E[index] = new LinkedList();
		
		index++;
	}
	public void removeVertex(int u) {
		int index_of_u = getIndexOf(u);
		if(index_of_u == -1) {
			return;
		}
		index--;
		for(int j = index_of_u; j < V.length - 1; j++) {
			V[j] = V[j+1];
			E[j] = E[j+1];
			 
		}
		V[index] = 0;
		E[index] = null;
		
	}
	
	public void addEdge(int u, int v) {
		// Adds an edge between u => v
		int index_of_u = getIndexOf(u);
		int index_of_v = getIndexOf(v);
		
		if(index_of_u == -1 || index_of_v == -1) return;
		
		E[index_of_u].addElement(v);
	}
	public void removeEdge(int u, int v) {
		// Removes an edge between u => v
		int index_of_u = getIndexOf(u);
		int index_of_v = getIndexOf(v);
				
		if(index_of_u == -1 || index_of_v == -1) return;
				
		E[index_of_u].removeElement(v);
	}
	public int degree(int u) {
		// Return the number of edges from u, if u exists otherwise -1
		
		int index_of_u = getIndexOf(u);
		if(index_of_u == -1) return -1;
		
		return E[index_of_u].size();
	}
	public boolean adjacent(int u, int v) {
		// returns whether u and v are connected with an EDGE, from u to v, if found, otherwise false
		int index_of_u = getIndexOf(u);
		int index_of_v = getIndexOf(v);	
		if(index_of_u == -1 || index_of_v == -1) return false;
		
		return E[index_of_u].contains(v);
	}
	public boolean connected(int u, int v) {
		// returns whether u and v are connected, if found, otherwise false
		int index_of_u = getIndexOf(u);
		int index_of_v = getIndexOf(v);	
		if(index_of_u == -1 || index_of_v == -1) return false;
		
		// use depth first search (we dont care about short path, we just want if their is a path)
		return dfs(u, v) || dfs(v,u);
	}
	
	private boolean dfs(int start, int target) {
		// depth first search from u to v, return true if reaches v, otherwise false
		boolean[] passed_by = new boolean[index == V.length ? index : index + 1];
		return dfs_rec(start,target, passed_by);
	}
	private boolean dfs_rec(int start, int target, boolean[] passed_by) {
		if(start == target) return true;
		int index_start = getIndexOf(start);
		
		passed_by[index_start] = true;
		Node current = E[index_start].getHeader();
		while(current != null) {
			int index_of_current = getIndexOf(current.getValue());
			if(!passed_by[index_of_current]) {
				return dfs_rec(current.getValue(), target, passed_by);
			}
			passed_by[index_of_current] = true;
			current = current.getNext();
		}
		return false;
	}
	
	
	public DirectedGraph reverse() {
		
		DirectedGraph g_prime = new DirectedGraph(V.length);
		
		// for each vertex u in V, add u to g_prime
		for(int j = 0; j < index; j++) {
			g_prime.addVertex(V[j]);
		}
		
		// for each vertex u,v in V, if (u,v) in g => add edge (v,u) in g_prime
		for(int j = 0; j < index; j++) {
			int u = V[j];
			Node current = E[j].getHeader();
			
			while(current != null) {
				int v = current.getValue();
				g_prime.addEdge(v, u);
				current = current.getNext();
			}
		}
		
		return g_prime;
	}
	
	public void displayListOfVertecies() {
		for(int i = 0; i < index; i ++) {
			int u = V[i];
			Node current = E[i].getHeader();
			System.out.print(u +": ");
			while(current != null) {
				System.out.print(current.getValue() + " => ");
				current = current.getNext();
			}
			System.out.println(" // ");
		}
		System.out.println("----------------");
	}
	
	public DirectedGraph compliment() {
		DirectedGraph g_prime = new DirectedGraph(V.length);
		
		// for each vertex u in V, add u to g_prime
		for(int j = 0; j < index; j++) {
			g_prime.addVertex(V[j]);
		}
				
		// for each vertex u in V, for each vertex v in V (u != v)
		// add edge(u,v) if (u,v) not in E
		for (int i = 0; i < index; i++) {
			int u = V[i];
			for (int j = 0; j < index; j++) {
				int v = V[j];
				if(i != j) {
					if(!E[i].contains(v)) {
						g_prime.addEdge(u, v);
					}
				}
			}
		}
		return g_prime;
	}
}
