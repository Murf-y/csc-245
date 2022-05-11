package Questions;

public class Node {
	private String info;
	private Node next;
	public Node(String i){
		info=i;
		next=null;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String i) {
		info = i;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node n) {
		next = n;
	}
	public String toString(){
		return "Info: "+info;
	}
}
