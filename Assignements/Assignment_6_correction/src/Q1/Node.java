package Q1;

public class Node {
	private String[] info=new String[2];
	private Node left;
	private Node right;
	public Node(String a, String b){
		info[0]=a;
		info[1]=b;
		left=null;
		right=null;
	}
	public String toString(){
		return info[0]+": "+info[1];
	}
	public void setLeft(Node l){
		left=l;
	}
	public Node getLeft(){
		return left;
	}
	public void setRight(Node r){
		right=r;
	}
	public Node getRight(){
		return right;
	}
	public void setWord(String w){
		info[0]=w;
	}
	public String getWord(){
		return info[0];
	}
	public void setDef(String d){
		info[1]=d;
	}
	public String getDef(){
		return info[1];
	}
}
