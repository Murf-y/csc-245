package Lab;

public class Stack {
	private Node header;
	
	public Stack(){
		header = null;
	}
	public Node getHeader() {
		return header;
	}

	public void setHeader(Node header) {
		this.header = header;
	}
	
	// add start, remove start
	public void push(String i){
		push(new Node(i));
	}
	private void push(Node n){
		if(header== null) header = n;
		else{
			n.setNext(header);
			header = n;
		}
	}
	
	public String pop(){
		if(header == null) return "";
		else{
			String value = header.getValue();
			header = header.getNext();
			return value;	
		}
	}
	
	public boolean isEmpty(){
		return header == null;
	}
	public String peek(){
		if(header == null) return "";
		else{
			String value = header.getValue();
			return value;	
		}
	}
	
	public void displayMe(){
		displayMe(header);
	}
	private void displayMe(Node curr){
		if(curr == null){
			System.out.println("Empty list");
		}else if(curr.getNext() == null){
			System.out.println("|"+curr.getValue()+"|");
			System.out.println("|_|");
		}else{
			System.out.println("|"+curr.getValue()+"|");
			displayMe(curr.getNext());
		}
	}
	private int size(){
		int total = 0;
		if(header== null) return total;
		Node curr = header;
		while(curr!= null){
			curr = curr.getNext();
			total += 1;
		}
		return total;
	}
	
}
