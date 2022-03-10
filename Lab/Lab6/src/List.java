
public class List {
	private Node header;
	
	public List(Node n) {
		header = n;
	}
	public List() {
		header = null;
	}
	public void setHeader(Node n) {
		header = n;
	}
	public Node getHeader() {
		return header;
	}

	public void addElement(int i) {
		addElement(new Node(i));
	}
	public void addElement(Node n) {
		addElement(n, header);
	}
	public void addElement(Node n , Node current) {
		if(current == null) {
			header = n;
		}
		else if(current.getNext() == null) {
			current.setNext(n);
		}
		else {
			addElement(n, current.getNext());
		}
	}
	
	public int size() {
		return size(header);
	}
	public int size(Node curr) {
		if(curr == null) {
			return 0;
		}
		else if(curr.getNext() == null) {
			return 1;
		}
		else {
			return 1 + size(curr.getNext());
		}
	}
	
	public int sum() {
		return sum(header, 0);
	}
	public int sum(Node curr, int sum) {
		if(curr == null) {
			return 0;
		}
		else if(curr.getNext() == null) {
			return curr.getValue() + sum;
		}
		else {
			return  sum(curr.getNext(), curr.getValue() + sum);
		}
	}
	
	public int countOccurences(int i) {
		return countOccurences(new Node(i));
	}
	public int countOccurences(Node n) {
		return countOccurences(n, header, 0);
	}
	public int countOccurences(Node n, Node curr, int s) {
		if(curr == null) {
			return 0;
		}
		else if(curr.getNext() == null) {
			if(curr.getValue() == n.getValue()) {
				return s + 1;
			}
			else {
				return s;
			}
		}
		else {
			return countOccurences(n, curr.getNext(), s + (n.getValue() == curr.getValue()? 1 : 0));
		}
	}
	
	
	public void reverseList() {
		reverseList(header, 0);
	}
	public Node reverseList(Node curr, int n) {
		if( size() % 2 == 0) {
			if(n == (size()/2 )- 1) {
				int temp = curr.getValue();
				curr.setValue(curr.getNext().getValue());
				curr.getNext().setValue(temp);
				return curr.getNext();
			}
			else {
				Node node =  reverseList(curr.getNext(), ++n);
				int temp = curr.getValue();
				curr.setValue(node.getNext().getValue());
				node.getNext().setValue(temp);
				return node.getNext();
			}
		}else{
			if(n == size()/2) {
				int temp = curr.getValue();
				curr.setValue(curr.getNext().getValue());
				curr.setValue(temp);
				return curr;
			}
			else {
				Node node =  reverseList(curr.getNext(), ++n);
				int temp = curr.getValue();
				curr.setValue(node.getNext().getValue());
				node.getNext().setValue(temp);
				return node.getNext();
			}
			
		}
	}
	
	public void displayList() {
		if(header == null) {
			System.out.println("Empty Linked List");
		}
		else {
			String linker = "|_";
			String null_representation = "//";
			String repeat = " ";
			String new_line = "\n";
			
			String result = "head\n";
			
			int count = 1;
			for(Node current = header; current != null ; current = current.getNext(), count++) {
				result += repeat.repeat(count);
				result += linker;
				result += current.getValue();
				result += new_line;
			}
			result += repeat.repeat(count);
			result += linker;
			result += null_representation;
			
			System.out.println(result);
		}
	}
	
	public void displayWithRecursion() {
		displayWithRecursion(header);
	}
	public void displayWithRecursion(Node curr) {
		if(curr == null) {
			System.out.println("Empty list");
			return ;
		}
		else if(curr.getNext() == null) {
			System.out.println(curr.getValue() + " ");
			return;
		}
		else {
			System.out.print(curr.getValue() + " ");
			displayWithRecursion(curr.getNext());
		}
	}
	
}
