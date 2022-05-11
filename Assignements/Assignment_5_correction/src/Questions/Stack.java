package Questions;

public class Stack {
	private LinkedList l;
	public Stack(){
		l=new LinkedList();
	}
	public void push(Node n){
		l.add(n);
	}
	public Node pop(){
		return l.delB();
	}
	public Node peek(){
		return l.getHeader();
	}
	public LinkedList getL() {
		return l;
	}
	public void setL(LinkedList l) {
		this.l = l;
	}
	public boolean isEmpty(){
		if(l.getHeader()==null)
			return true;
		return false;
	}
}
