package Questions;

public class LinkedList {
	private Node header;
	public LinkedList(){
		header=null;
	}
	public Node getHeader(){
		return header;
	}
	public void setHeader(Node h){
		header=h;
	}
	public void add(Node n){
		if(header==null){
			header=n;
		}
		else{
			n.setNext(header);
			header=n;
		}
	}
	public Node delB(){
		if(header==null){
			System.out.println("Empty");
			return null;
		}else{
			Node c=header;
			header=header.getNext();
			c.setNext(null);
			return c;
		}
	}
	public void print(){
		if(header==null){
			return;
		}else{
			Node current =header;
			while(current!=null){
				System.out.println(current.getInfo());
				current=current.getNext();
			}
		}
	}
}
