package Q2;

public class Graph {
	private int[] vertices;
	private LinkedList[] edges;
	private int count;
	public Graph(){
		vertices=new int[10];
		edges=new LinkedList[10];
		count=0;
	}
	public int findV(int i){
		for(int j=0;j<count;j++){
			if(vertices[j]==i)
				return j;
		}
		return -1;
	}
	public void addEdge(int u, int v){
		int j=findV(u);
		if(j!=-1){
			if(edges[j]==null){
				edges[j]=new LinkedList();
			}
			if(edges[j].find(v)==null)
				edges[j].add(new Node(v));
		}
	}
	public void deleteEdge(int u, int v){
		int j=findV(u);
		if(j!=-1){
			if(edges[j].find(v)!=null)
				edges[j].remove(v);
		}
	}
	public void deleteVertex(int i){//delete the vertex and all associated edges with it.
		int j=findV(i);
		if(j!=-1){
			for(int z=j;z<count;z++){
				if(z!=vertices.length-1){
					vertices[z]=vertices[z+1];
				}else{
					vertices[z]=0;
				}
			}
			for(int z=j;z<count;z++){
				if(z!=edges.length-1){
					edges[z]=edges[z+1];
				}else{
					edges[z]=null;
				}
			}
			count--;
			for(int z=0;z<count;z++){
				if(edges[z]!=null)
					edges[z].remove(i);
			}
		}
	}
	public void printEdges(){
		for(int i=0;i<count;i++){
			System.out.print(vertices[i]+": ");
			if(edges[i]==null){
				System.out.println();
				continue;
			}
			edges[i].print();
		}
	}
	public void addVertex(int i){
		if(findV(i)==-1){
			vertices[count]=i;
			count++;
		}
	}
	public int degree(int i){
		int j=findV(i);
		int degree=0;
		if(j!=-1){
			degree+=edges[j].size();
			for(int z=0;z<count;z++){
				if(z!=j){
					if(edges[z]!=null&&edges[z].find(i) != null){
						degree++;
					}
				}
			}
		}else{
			degree=-1;
		}
		return degree;
	}
	public boolean adjacent(int u, int v){
		int j=findV(u);
		if(j!=-1){
			if(edges[j].find(v)!=null)
				return true;
		}
		return false;
	}
	public boolean connected(int u, int v){
		boolean[] visited=new boolean[count];
		int i=findV(u);
		int j=findV(v);
		return CDFS(i,visited,j) || CDFS(j,visited,i);
	}
	public boolean CDFS(int u, boolean[] vis, int v){//goes to each neighbor of u and checks their neighbor, goes by depth, so goes to the first neighbor then checks its first neighbor and so on, afterwards it goes back and checks the second neighbor. If a vertex already visited is passed again, we ignore its neighbors.
		// if vertex 3 is connected to 5,6 and 7 and 5 is connected to 3,2 and 1 and 2 is connected to 8 and 9. We go from 3 to 5, then from 5 to 3, but since 3 has been visited we ignore its neighbors and move on to 2, then from 2 to 8. 8 is not connected to anything, we go back to the second neighbor which is 9, same thing to 9. No more neighbors for 2, we go to 1 and so on and so forth.
		// if u is passed again we stop and return true else we continue till all vertices from u or v are visited.
		if(u==v)
			return true;
		vis[u]=true;
		if(edges[u]==null)
			return false;
		boolean state=false;
		for(Node current=edges[u].getHeader();current!=null;current=current.getNext()){
			int i=findV(current.getInfo());
			if(vis[i]==false){
				state=CDFS(i,vis,v);
			}
		}
		return state;
	}
	public Graph reverseGraph(){
		Graph g1=new Graph();
		g1.setVertices(vertices);
		g1.setCount(count);
		LinkedList[] edges2=new LinkedList[vertices.length];
		for(int i=0;i<count;i++){
			if(edges[i]==null)
				continue;
			Node current=edges[i].getHeader();
			int v=vertices[i];
			while(current!=null){
				int e=findV(current.getInfo());
				if(edges2[e]==null)
					edges2[e]=new LinkedList();
				edges2[e].add(new Node(v));
				current=current.getNext();
			}
		}
		g1.setEdges(edges2);
		return g1;
	}
public int[] getVertices() {
		return vertices;
	}
	public void setVertices(int[] vertices) {
		this.vertices = vertices;
	}
	public LinkedList[] getEdges() {
		return edges;
	}
	public void setEdges(LinkedList[] edges) {
		this.edges = edges;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Graph complement(){
		Graph g1=new Graph();
		g1.setVertices(vertices);
		g1.setCount(count);
		LinkedList[] edges2=new LinkedList[vertices.length];
		for(int i=0;i<count;i++){
			boolean[] visited=new boolean[count];
			Node current=null;
			if(edges[i]!=null)
				current=edges[i].getHeader();
			while(current!=null){
				int e = findV(current.getInfo());
				visited[e]=true;
				current=current.getNext();
			}
			for(int j=0;j<count;j++){
				if(visited[j]!=true){
					if(edges2[i]==null)
						edges2[i]=new LinkedList();
					edges2[i].add(new Node(vertices[j]));
				}
			}
		}
		g1.setEdges(edges2);
		return g1;
	}
	
	public void printV(){
		for(int i=0;i<count;i++){
			System.out.print(vertices[i]+"	");
		}
	}
	public static void main(String[] args){
		Graph g=new Graph();
		System.out.println("Generating a graph with addVertex and addEdge and printing both edges and vertices");
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,1);
		g.addEdge(4,5);
		g.addEdge(3,1);
		g.addEdge(1,3);
		System.out.println("Edges");
		g.printEdges();
		System.out.println("Vertices");
		g.printV();
		System.out.println();
		System.out.println("Deleting a vertex (3)");
		g.deleteVertex(3);
		System.out.println("Edges");
		g.printEdges();
		System.out.println("Vertices");
		g.printV();
		g.addVertex(3);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(3,1);
		g.addEdge(1,3);
		System.out.println();
		System.out.println();
		System.out.print("Checking the degree for vertex 3: ");
		System.out.println(g.degree(3));
		System.out.println("Edges");
		g.printEdges();
		System.out.println("Vertices");
		g.printV();
		System.out.println();
		System.out.println();
		System.out.println("Check if two vertices are adjacent (3 and 2)");
		System.out.println(g.adjacent(3,2));
		System.out.println();
		System.out.println("Check if two vertices are connected (4 and 3)");
		System.out.println(g.connected(4,3));
		System.out.println("Check if two vertices are connected (4 and 2)");
		System.out.println(g.connected(4,2));
		System.out.println();
		System.out.println("Finding the reverse");
		Graph g1=g.reverseGraph();
		g1.printEdges();
		System.out.println();
		System.out.println("Finding the compliment");
		Graph g2=g.complement();
		g2.printEdges();
	}
}
