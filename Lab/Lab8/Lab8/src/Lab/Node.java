package Lab;

public class Node {
	private String value;
	private Node next;
	
	public Node(String i){
		value = i;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public boolean equals(Node n){
		return n.getValue().equalsIgnoreCase(value);
	}
	public String toString(){
		return value+"";
	}
}
