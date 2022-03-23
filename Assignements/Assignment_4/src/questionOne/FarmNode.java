/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 20, 2022
 * LastModified: Mar 20, 2022
 * FileName: FarmNode.java
 *****************************************************
 */
package questionOne;

public class FarmNode {
	private Animal animal;
	private FarmNode next;
	
	
	public FarmNode(Animal a) {
		animal = a;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public FarmNode getNext() {
		return next;
	}
	public void setNext(FarmNode next) {
		this.next = next;
	}
	

	public String toString() {
		return animal.toString();
	}
	public boolean equals(FarmNode other) {
		return animal.equals(other.getAnimal());
	}
}
