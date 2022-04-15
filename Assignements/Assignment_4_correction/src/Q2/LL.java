package Q2;


public class LL {
	private Node head;
	public LL(){
		head=null;
	}
	public void setHead(Node h){
		head=h;
	}
	public Node getHead(){
		return head;
	}
	public void add(Node n,Animal d){
		if(head==null){
			head=new Node(d);
			return;}
		if (n.getNext() != null) {
		    add(n.getNext(), d);      
		  } else {
			  n.setNext(new Node(d));
		  }
	}
	public void deleteAll(int c){
		if(head==null)
			System.out.println("Empty List");
		else{
			Node current=head;
			Node prev=null;
			while(current!=null){
				if(current.getAnimal().getConsumption()>c){
					if(prev==null&&current.getNext()==null){
						head=null;
						current=head;
					}else if(current.getNext()==null){
						prev.setNext(null);
						current=current.getNext();
					}else{
						if(prev!=null){
							prev.setNext(current.getNext());
							current.setNext(null);
							current=prev.getNext();
							}
						else{
							prev=current.getNext();
							current.setNext(null);
							current=prev;
							head=prev;
							prev=null;
						}
					}
				}else{
					prev=current;
					current=current.getNext();
				}
			}
		}
	}
	public void sort(){
		Node current = head, index = null;
		 
        int temp;
 
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.getNext();
                while (index != null) {
                    if (current.getAnimal().getConsumption() > index.getAnimal().getConsumption()) {
                        temp = current.getAnimal().getConsumption();
                        current.getAnimal().setConsumption(index.getAnimal().getConsumption());
                        index.getAnimal().setConsumption(temp);
                    }
 
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
		
	}
	public void printAll(Node n){
		if(head==null){
			System.out.println("Empty");
			return;
		}
		if(n==null){
			return;
		}
		System.out.println(n.toString());
		printAll(n.getNext());
	}
	public int findAll(Node n,String t,int i){
		if(head==null){
			System.out.println("Empty List. Not found");
			return 0;
		}
		if(n==null){
			return i;
		}
		else if(n.getAnimal().getClass().getSimpleName().equals(t)){
			System.out.println(n.toString());
			return findAll(n.getNext(),t,1);
		}else{
			return findAll(n.getNext(),t,i);
		}
		
	}
	
}
