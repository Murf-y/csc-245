/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 27, 2022
 * LastModified: Mar 27, 2022
 * FileName: Stack.java
 *****************************************************
 */
package questionTwo;

import java.util.EmptyStackException;

// Implementing a stack using a linked list
// by adding to the end of the list
// removing from the end of the list
public class Stack<T> {

	private static class Node<E> {
		private E info;
		private Node<E> next;

		public Node(E obj) {
			info = obj;
		}

		public E getInfo() {
			return info;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	private Node<T> header;

	public Stack() {
		header = null;
	}

	public void push(T obj) {
		push(new Node<T>(obj));
	}

	private void push(Node<T> n) {
		n.setNext(header);
		header = n;
	}

	public T pop() {
		if (header == null)
			throw new EmptyStackException();
		T obj = header.getInfo();
		header = header.getNext();
		return obj;
	}

	public boolean isEmpty() {
		return header == null;
	}
	
	public T peek() {
		if (header == null)
			throw new EmptyStackException();
		T obj = header.getInfo();
		return obj;
	}
}
