
public class Node {
	private int value;
	private Node next;
	
	public Node(int i) {
		value = i;
		next = null;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return ""+value;
	}
	public boolean equals(Node n) {
		return value == n.getValue();
	}
	
}
