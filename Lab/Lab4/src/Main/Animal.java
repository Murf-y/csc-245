package Main;

public abstract class Animal {
	protected String name;
	protected int age;
	protected boolean acquatic;

	protected String type;
	
	
	public Animal(String name, int age, boolean acquatic) {
		this.name = name;
		this.age = age;
		this.acquatic = acquatic;
	}
	public String getType() {
		return type;
	}
	
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
	public boolean isAcquatic() {
		return acquatic;
	}
	public void setAcquatic(boolean acquatic) {
		this.acquatic = acquatic;
	}
	public boolean equals(Animal a) {
		return name.equalsIgnoreCase(a.getName()) && age == a.getAge() && acquatic == a.isAcquatic();
	}
	public String toString() {
		return String.format("\tName: %s\n\tAge: %s\n\tAcquatic: %s", name,age,acquatic);
	}
	public abstract void makeNoise();
	
	
}
