
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
	
	public boolean equals(Node n) {
		return this.value == n.getValue();

	}

	public String toString() {
		return String.format("%d",value);
	}
}
