
public class DoublyLinkedList {
	private DNode header;
	
	public DNode getHeader() {
		return header;
	}

	public void setHeader(DNode header) {
		this.header = header;
	}

	public DoublyLinkedList() {
		header = null;
	}
	
	
	public int size() {
		return size(header);
	}
	private int size(DNode curr) {
		if(curr == null) {
			return 0;
		}
		else if(curr.getNext() == null) {
			return 1;
		}
		else {
			return 1 + size(curr.getNext());
		}
	}
	
	public void displayListRecursive() {
		System.out.print("head: ");
		displayListRecursive(header);
	}
	private void displayListRecursive(DNode curr) {
		String linker = " => ";
		String null_rep = "//";
		if(curr == null) {
			System.out.println("Empty Doubly Linked List");
		}
		else if(curr.getNext() == null) {
			System.out.println(curr.getValue() + linker + null_rep);
		}else {
			System.out.print(curr.getValue() + linker);
			displayListRecursive(curr.getNext());
		}
	}

	public void addElementRecursive(int i) {
		addElementRecursive(new DNode(i));
	}
	public void addElementRecursive(DNode n) {
		addElementRecursive(n, header);
	}
	private void addElementRecursive(DNode n, DNode curr) {
		if(curr == null) {
			header = n;
		}
		else if(curr.getNext() == null) {
			curr.setNext(n);
			n.setPrev(curr);
		}else {
			addElementRecursive(n, curr.getNext());
		}
	}

	public void deleteElementRecursive(int i) {
		deleteElementRecursive(new DNode(i));
	}
	public void deleteElementRecursive(DNode n) {
		deleteElementRecursive(n, header);
	}
	public void deleteElementRecursive(DNode n, DNode curr) {
		
	}
}

