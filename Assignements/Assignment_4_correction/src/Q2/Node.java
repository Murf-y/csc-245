package Q2;

public class Node {
	private Animal animal;
	private Node next;
	public Node(Animal n){
		animal=n;
		next=null;
	}
	public void setNext(Node n){
		next=n;
	}
	public Node getNext(){
		return next;
	}
	public Animal getAnimal(){
		return animal;
	}
	public void setAnimal(Animal n){
		animal=n;
	}
	public String toString(){
		return animal.toString();
	}
}
