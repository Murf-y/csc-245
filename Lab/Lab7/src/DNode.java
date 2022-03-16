
public class DNode {
	private int value;
	private DNode next;
	private DNode prev;
	
	public DNode(int i ) {
		value = i;
		next = null;
		prev = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public DNode getPrev() {
		return prev;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	
	public boolean equals(DNode n) {
		return n.getValue() == value;
	}
	
	public String toString() {
		return value + "";
	}
	
}
