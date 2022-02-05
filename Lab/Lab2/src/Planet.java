import java.util.ArrayList;

public class Planet {
	
	private static ArrayList<Person> people;
	
	public Planet() {
		people = new ArrayList<Person>();
	}
	
	public boolean isPersonAlreadyExists(Person p) {
		for(Person person: people) {
			if(p.equals(person)) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<Person>  getPeople() {
		return people;
	}
	public void setPeople(ArrayList<Person> people){
		this.people = people;
	}
	public void addPerson(Person p) {
		people.add(p);
	}
	
	public void deletePerson(Person p) {
		people.remove(p);
	}
	
}
