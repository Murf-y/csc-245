
public class Animal {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Animal getSpouse() {
		return spouse;
	}

	public void setSpouse(Animal spouse) {
		this.spouse = spouse;
	}

	private int age;
	private Animal spouse;
	
	public Animal(String name, int age, Animal spouse) {
		this.name = name;
		this.age = age;
		this.spouse = spouse;
	}
	
	public void Mate(Animal new_spouse) {
		if(this.spouse != null) {
			System.out.println("This animal already have a spouse!");
		}
		else if(new_spouse.spouse != null) {
			System.out.println("The specified animal already have a spouse!");
		}
		else {
			this.spouse = new_spouse;
		}
	}
	
	public void Sound() {
		// TODO: to be implemented in child class
	}
	
	public boolean equals(Animal a) {
		if(this.getSpouse() != null && a.getSpouse() != null) {
			return this.getName().equalsIgnoreCase(a.getName()) &&			
					this.getAge() == a.getAge() &&
					this.getSpouse().equals(a.getSpouse());
		}
		else {
			return this.getName().equalsIgnoreCase(a.getName()) &&			
					this.getAge() == a.getAge();
		}
				
	}
	public String toString() {
		if(this.spouse != null) {
			
			return String.format("Name: %s, age: %s, Spouse: %s", name,age,spouse);
		}
		else {

			return String.format("Name: %s, age: %s, Spouse: No Spouse", name,age);
		}
	}
	
	
}
