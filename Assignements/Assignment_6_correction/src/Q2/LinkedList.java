package Q2;


public class LinkedList {
	private Node header;
	public LinkedList(){
		header=null;
	}
	public void setHeader(Node h){
		header=h;
	}
	public Node getHeader(){
		return header;
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
	public int size(){
		Node current=header;
		int size=0;
		if(current==null){
			return 0;
		}
		while(current!=null){
			size++;
			current=current.getNext();
		}
		return size;
	}
	public void remove(int i){
		if(header==null){
			System.out.println("Empty list");
			return;
		}
		if(header.getInfo()==i){
			Node temp=header;
			header=header.getNext();
			temp.setNext(null);
		}else{
			if(find(i)!=null){
				Node current=header;
				Node prev=null;
				while(current!=null&&current.getInfo()!=i){
					System.out.println(current.getInfo());
					prev=current;
					current=current.getNext();
				}
				prev.setNext(current.getNext());
				current.setNext(null);
			}
		}
	}
	public Node find(int i){
		if(header==null){
			return null;
		}else if(header.getInfo()==i){
			return header;
		}else{
			Node current=header;
			while(current!=null&&current.getInfo()!=i){
				current=current.getNext();
			}
			return current;
		}
	}
	public void print(){
		Node current=header;
		while(current!=null){
			System.out.print(current.getInfo()+" -> ");
			current=current.getNext();
		}
		System.out.println();
	}
}
