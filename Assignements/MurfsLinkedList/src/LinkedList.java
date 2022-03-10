public class LinkedList {
	private Node header;
	
	public Node getHeader() {return header;}
	public void setHeader(Node header) {this.header = header;}
	
	//	header
	// 		  |_1
	// 			|_2
	// 	 		  |_5
	//     			|_ //
	
	//	header
	// 		  |_//
	
	//	header
	// 		  |_1
	// 			|_//
	
	public void addFirst(Node n) {
		n.setNext(header);
		header = n;
	}
	public void addFirst(int i) {
		addFirst(new Node(i));
	}
	
	
	public void displayList() {
		if(header == null) {
			System.out.println("Empty Linked List");
		}
		else {
			String linker = "|_";
			String null_representation = "//";
			String repeat = " ";
			String new_line = "\n";
			
			String result = "head\n";
			
			int count = 1;
			for(Node current = header; current != null ; current = current.getNext(), count++) {
				result += repeat.repeat(count);
				result += linker;
				result += current.getValue();
				result += new_line;
			}
			result += repeat.repeat(count);
			result += linker;
			result += null_representation;
			
			System.out.println(result);
		}
	}
	
	public boolean insertElementAt(int index , Node n) {
		if(index > size() ||index < 0) {
			return false;
		}
		if(index == 0) {
			addFirst(n);
			return true;
		}
		Node current = header;
		for(int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		
		n.setNext(current.getNext());
		current.setNext(n);
		return true;
	}
	public boolean insertElementAt(int index , int k) {
		return insertElementAt(index, new Node(k));
	}
	
	
	
	public boolean removeElement(Node n) {
		return unlink(n);
	}
	public boolean removeElement(int i) {
		return removeElement(new Node(i));
	}
	public boolean removeElementAt(int index) {
		if(index < 0 || index >= size()) {
			return false;
		}
		if(index == 0) {
			return removeElement(header);
		}
		else {
			Node current = header;
			for(int j = 0; j < index ; j++) {
				current = current.getNext();
			}
			return removeElement(current);
		}
		
	}

	public void clear() {
		for(Node current = header; current != null ;) {
			Node next = current.getNext();
            current.setNext(null);
            current = next;
		}
		header = null;
	}
	
	public int indexOf(int i) {
		return indexOf(new Node(i));
	}
	public int indexOf(Node n) {

		if(header == null) {
			return -1;
		}
		else {
			int index = 0;
			for(Node current = header; current != null; current = current.getNext(), index++) {
				if(current.equals(n)) {
					return index;
				}
			}
			return -1;
		}
	}
	
	public Node getNodeAtIndex(int index) {
		if(index < 0 || index >= size()) {
			return null;
		}
		Node current = header;
		for(int j = 0; j < index; j++) {
			current = current.getNext();
		}
		return current;
	}
	
	public Node getPrevNode(Node n) {
		if(n == null || header == null || header.equals(n)) {
			return null;
		}
		Node current = header;
		while(current.getNext() != null) {
			if(current.getNext().equals(n)) {
				return current;
			}
			current = current.getNext();
		}
		return current;
	}
	private boolean unlink(Node n) {
		// Unlinks a non null node
		// return true or false dpending on the success of unlinking the node
		if(n == null) {return false;}
		for(Node current = header; current != null; current = current.getNext()) {
			if(current.equals(n)) {
				Node prev = getPrevNode(current);
				Node next = current.getNext();
				if(prev != null) {
					
					prev.setNext(next);
					return true;
				}
				else {
					header = next;
					return true;
				}
			}
		}
		return false;
	}

	public void addElement(int i) {
		addElement(new Node(i));
	}
	public void addElement(Node n) {
		if(header == null) {
			header = n;
		}
		else {
			Node last = header;
			for(Node current = header ; current != null; current = current.getNext()) {
				last = current;
			}
			last.setNext(n);
		}		
	}
	public int size() {
		// Return the actual length of the linked list
		
		if(header == null) return 0;
		int count = 1;
		Node current = header;
		while(current.getNext() != null) {
			++count;
			current = current.getNext();
		}
		return count;
	}
}
