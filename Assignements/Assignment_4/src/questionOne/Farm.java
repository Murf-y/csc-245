/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 20, 2022
 * LastModified: Mar 20, 2022
 * FileName: Farm.java
 *****************************************************
 */
package questionOne;

public class Farm {
	private FarmNode header;
	
	public Farm() {
		header= null;
	}

	public FarmNode getHeader() {
		return header;
	}
	public void setHeader(FarmNode header) {
		this.header = header;
	}
		
	private int size() {
		if(header== null) return 0;
		else {
			int total = 0;
			FarmNode current = header;
			while(current!=null) {
				total +=1;
				current = current.getNext();
			}
			return total;
		}
	}
	
	public void addElement(Animal a) {
		addElementRecursive(new FarmNode(a), header);
	}
	private void addElementRecursive(FarmNode node, FarmNode current) {
		if(current == null) {
			header = node;
		}
		else if(current.getNext() == null) {
			current.setNext(node);
		}
		else {
			addElementRecursive(node, current.getNext());
		}
	}
	
	

	public Animal animalWithSameCharacteristics(Animal animal) {
		return animalWithSameCharacteristics(new FarmNode(animal));
	}
	private Animal animalWithSameCharacteristics(FarmNode node) {
		if(header == null) {
			return null;
		}
		else {
			FarmNode current = header;
			while(current != null) {
				if(current.equals(node)) {
					return current.getAnimal();
				}
				current = current.getNext();
			}
			return null;
		}
	}

	
	

	public void displayAllAnimalsWithClass(Class<?> type) {
		System.out.println(type.getName().substring(12) + "s in the Farm: ");
		displayAllAnimalsWithClass(header, type);
	}
	private void displayAllAnimalsWithClass(FarmNode current, Class<?> type) {
		// I used some reflections sorry, i didnt want to do a big ugly switch statment
		if(current == null) {
			System.out.println("Empty Farm!");
		}
		else if(current.getNext() == null) {
			
			if(type.isInstance(current.getAnimal())) {				
				System.out.println(current.getAnimal());
			}
			System.out.println("-----------------\n");
		}else {

			if(type.isInstance(current.getAnimal())) {				
				System.out.println(current.getAnimal());
			}
			displayAllAnimalsWithClass(current.getNext(), type);
		}
	}

	
	
	public void sortByConsumption() {
		if(size() <= 1) {
			return;
		}
		FarmNode temp = header;
		while (temp != null) {
	        FarmNode min = temp;
	        FarmNode next = temp.getNext();
	 
	        // Traverse the unsorted sublist
	        while (next != null) {
	            if (min.getAnimal().getConsumptionAmount() > next.getAnimal().getConsumptionAmount())
	                min = next;
	 
	            next = next.getNext();
	        }
	        
			Animal x = temp.getAnimal();
			temp.setAnimal(min.getAnimal());
			min.setAnimal(x); 
			temp = temp.getNext();
							 
	    }
	}

	
	
	
	public void displayFarm() {
		System.out.println("Farm: ");
		displayFarm(header);
	}
	private void displayFarm(FarmNode current) {
		if(current == null) {
			System.out.println("Empty Farm");
		}
		else if(current.getNext() == null) {
			System.out.println(current.getAnimal());
		}
		else {
			System.out.println(current.getAnimal());
			displayFarm(current.getNext());
		}
	}
	
	
	public void removeConsumersGreaterThan(int k) {
		if(header == null) {
			return;
		}
		
		// Handles all possible header elements with consumption greater than k
		if(header.getAnimal().consumption_amount > k) {
			while(header != null && header.getAnimal().consumption_amount > k) {
				FarmNode next = header.getNext();
				header.setNext(null);
				header = next;
			}
		}
		
		// Already removed everything
		if(header == null || header.getNext() == null) return;
		
		// Check if next consumption is greater than k, if so remove it
		FarmNode prev = header;
		FarmNode next = header.getNext();
		
		while(next != null) {
			if(next.getAnimal().consumption_amount > k) {
				FarmNode new_next = next.getNext();
				next.setNext(null);
				prev.setNext(new_next);
				next = new_next;
			}else {
				prev = next;
				next = next.getNext();
			}
		}
	}
}
