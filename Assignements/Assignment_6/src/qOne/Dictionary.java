/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Apr 15, 2022
 * LastModified: Apr 15, 2022
 * FileName: Dictionary.java
 *****************************************************
 */
package qOne;

import java.util.Vector;

public class Dictionary {
	
	private class BTNode implements Comparable<BTNode>{
		private String word;
		private String definition;
		
		private BTNode left;
		private BTNode right;
		
		public BTNode getLeft() {
			return left;
		}

		public void setLeft(BTNode left) {
			this.left = left;
		}

		public BTNode getRight() {
			return right;
		}

		public void setRight(BTNode right) {
			this.right = right;
		}

		public String getWord() {
			return word;
		}

		@SuppressWarnings("unused")
		public void setWord(String word) {
			this.word = word;
		}

		public String getDefinition() {
			return definition;
		}

		@SuppressWarnings("unused")
		public void setDefinition(String definition) {
			this.definition = definition;
		}

		public BTNode(String word, String definition) {
			this.word = word;
			this.definition = definition;
			left = right = null;
		}
		
		public boolean isLeaf() {
			return left ==right && left == null;
		}
		public BTNode removeRightMost() {
			if(right == null) return left;
			
			right = right.removeRightMost();
			return this;
		}
		public BTNode getRightMost() {
			if(right == null) return this;
			return right.getRightMost();
		}
		public int compareTo(BTNode other) {
			return word.compareTo(other.word);
		}
		
		public String toString() {
			return word +" : " + definition;
		}
	}
	
	private BTNode root;
	
	public Dictionary() {
		root = null;
	}
	
	
	
	
	
	public void addWord(String word, String definition) {
		addNode(new BTNode(word,definition), root);
	}
	private void addNode(BTNode node, BTNode current) {
		
		// Only occurs if root is null
		if(current == null) {
			root = node;
		}else {
			
			// Current node is greater than the node to add
			if(current.compareTo(node) > 0) {
				if(current.getLeft() == null) {
					current.setLeft(node);
				}
				else {
					addNode(node, current.getLeft());
				}
			}
			// Current node is less than or equal than the node
			else {
				if(current.getRight() == null) {
					current.setRight(node);
				}
				else {
					addNode(node, current.getRight());
				}
			}
		}
	}
	
	
	
	public void remove(String word) {
		// removes a word that already exists in the dictionary
		
		// Prerequesit : The word needs to truly exists in the dictionary
		
		// This method works by findind the node with the word
		// find the parent of that node
		// find the rightmost of the left of the node
		// use the rightmost of the left to replace this node
		// remove the rightmost of the left
		
		// the root 
		if(root.getLeft() == null && root.getRight() == null) {
			root = null;
			return;
		}
		BTNode node = root;
		BTNode parent = root;
		while(true) {
			if(node.getWord().equalsIgnoreCase(word)) {
				break;
			}else if(node.getWord().compareTo(word) > 0) {
				parent = node;
				node = node.getLeft();
			}else {

				parent = node;
				node = node.getRight();
			}

		}
		if(node == root && node.getLeft() == null) {
			root = node.getRight();
			return;
		}
		
		if(node.isLeaf()) {
			if(parent.getLeft() == node) {
				parent.setLeft(null);
			}else {
				parent.setRight(null);
			}
		}
		else if(node.getLeft() == null) {
			if(parent.getLeft() == node) {
				parent.setLeft(node.getRight());
			}else {
				parent.setRight(node.getRight());
			}
		}else {
			BTNode rightmost_left = node.getLeft().getRightMost();
			node.setLeft(node.getLeft().removeRightMost());
			node.setWord(rightmost_left.getWord());
			node.setDefinition(rightmost_left.getDefinition());;
		}
		
	}
	
	
	
	
	public void InOrderAdd(Vector<String> words) {
		InOrderAdd(words,root);
	}
	private void InOrderAdd(Vector<String> words, BTNode current) {
		if(current == null) return;
		InOrderAdd(words, current.getLeft());
		words.add(current.toString());
		InOrderAdd(words, current.getRight());
	}
	
	
	
	
	
	public void displayInOrder() {
		if(root == null) {
			System.out.println("Empty Dictionary!");
			return;
		}
		displayInOrder(root);
	}
	private void displayInOrder(BTNode current) {
		if(current == null) return;
		displayInOrder(current.getLeft());
		System.out.println(current);
		displayInOrder(current.getRight());
	}
	
	
	
	
	
	
	public String findDefinition(String word) {
		if(!containsWord(word)) {
			throw new IllegalArgumentException();
		};
		return findDefinition(word, root);
	}
	
	private String findDefinition(String word, BTNode current) {
		if(current.getWord().equalsIgnoreCase(word)) {
			return current.getDefinition();
		}else if(current.getWord().compareTo(word) > 0){
			return findDefinition(word, current.getLeft());
		}
		else {
			return findDefinition(word, current.getRight());
		}
	}
	
	
	
	
	
	
	public boolean containsWord(String word) {
		if(root == null) return false;
		return containsWord(word, root);
	}
	
	private boolean containsWord(String word, BTNode current) {
		if(current == null) return false;
		else {
			if(current.getWord().equalsIgnoreCase(word)) {
				return true;
			}
			else if(current.getWord().compareTo(word) > 0) {
				return containsWord(word, current.getLeft());
			}else {
				return containsWord(word, current.getRight());
			}
		}
	}
	
	
	
	
	
	
	public boolean containsDefinition(String definition) {
		if(root == null) return false;
		return containsDefinition(definition, root);
	}
	
	private boolean containsDefinition(String definition, BTNode current) {
		if(current == null) return false;
		else {
			if(current.getDefinition().equalsIgnoreCase(definition)) {
				return true;
			}
			else if(current.getDefinition().compareTo(definition) > 0) {
				return containsDefinition(definition, current.getLeft());
			}else {
				return containsDefinition(definition, current.getRight());
			}
		}
	}

	
}
