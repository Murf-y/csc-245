
public class Giraffe extends Animal{
	
	public Giraffe(String name, int age, Lion spouse) {
		super(name,age,spouse);
	}
	
	public boolean sameInstance(Animal spouse) {
		return spouse instanceof Giraffe;
	}
	public void Mate(Animal spouse) {
		if(sameInstance(spouse)) {
			super.Mate(spouse);
		}
		else {
			System.out.println("You cannot mate this two type of animal!");
		}
	}
	
	public void Sound() {
		System.out.println("Bleat");
	}
	
	public boolean equals(Animal a) {
		return sameInstance(a) && super.equals(a);
				
	}
	
	public String toString() {
		return "Giraffe\t" + super.toString();
	}
	
}
