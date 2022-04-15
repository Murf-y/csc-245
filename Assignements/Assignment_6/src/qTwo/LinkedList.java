/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Apr 15, 2022
 * LastModified: Apr 15, 2022
 * FileName: LinkedList.java
 *****************************************************
 */
package qTwo;

public class LinkedList {
	public class Node {
		private int value;
		private Node next;
		
		public Node(int i ) {
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
	}

	private Node header;
	private int size;
	
	public Node getHeader() {
		return header;
	}

	public void setHeader(Node header) {
		this.header = header;
	}
	
	public LinkedList() {
		header = null;
		size = 0;
	}
	
	public void addElement(int i) {
		addElement(new Node(i), header);
		size++;
	}
	private void addElement(Node n, Node current) {
		if(current == null) {
			header = n;
		}
		else if(current.getNext() == null) {
			current.setNext(n);
		}
		else {
			addElement(n, current.getNext());
		}
	}
	
	public void removeElement(int i) {
		// removes the first occurence of i if found
		if(header == null) {
			return;
		}
		if(header.getValue() == i) {
			size--;
			header = header.getNext();
		}
		else {
			Node current = header;
			Node prev = header;
			while(current != null) {
				if(current.getValue() == i) {
					size--;
					prev.setNext(current.getNext());
					break;
				}
				prev = current;
				current = current.getNext();
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(int i) {
		Node current = header;
		while(current != null) {
			if(current.getValue() == i) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
}
