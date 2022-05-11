package Q1;

public class BST {
	private Node root;
	public BST(){
		root=null;
	}
	public int compare(String w1,String w2){
		int j=w1.length();
		if(w1.length()>w2.length())
			j=w2.length();
		for(int i=0;i<j;i++){
			if(w1.charAt(i)>w2.charAt(i))
				return 1;
			else if(w1.charAt(i)<w2.charAt(i))
				return -1;
		}
		return 0;
	}
	public void add(Node r,Node n){
		if(root==null){
			root=n;
		}else if(compare(r.getWord().toLowerCase(),n.getWord().toLowerCase())==0){
			System.out.println("Word already in system");
			return;
		}else if(compare(r.getWord().toLowerCase(),n.getWord().toLowerCase())==1){
			if(r.getLeft()==null){
				r.setLeft(n);
				return;
			}
			else{
				add(r.getLeft(),n);
			}
		}else{
			if(r.getRight()==null){
				r.setRight(n);
				return;
			}
			else{
				add(r.getRight(),n);
			}
		}
	}
	public Node getParent(Node r,Node n){
		if(r.getLeft()==null&&r.getRight()==null)
			return null;
		if((r.getLeft()!=null&&r.getLeft().equals(n))||(r.getRight()!=null&&r.getRight().equals(n))){
			return r;
		}else if(compare(r.getWord().toLowerCase(),n.getWord().toLowerCase())==1)
			return getParent(r.getLeft(),n);
		else 
			return getParent(r.getRight(),n);
	}
	public Node getMax(Node r){
		if(r.getRight()==null)
			return r;
		return getMax(r.getRight());
	}
	public void remove(String w){//need to check for all cases, if it is a root, if the node is a leaf or if it has one child or two children, if two children then take the maximum of the left subtree and replace the
		//node to be removed with it while keeping into consideration the children of the moved or removed nodes.
		if(root.getWord().equalsIgnoreCase(w)){
			if(root.getLeft()!=null){
				Node max=getMax(root.getLeft());
				if(!max.equals(root.getLeft())){
					Node p=getParent(root,max);
					System.out.println(max.getWord());
					System.out.println(p);
					if(max.getLeft()==null){
						p.setRight(null);
					}else{
						p.setRight(max.getLeft());
					}
						max.setLeft(root.getLeft());
						max.setRight(root.getRight());
						root.setLeft(null);
						root.setRight(null);
						root=max;
					
				}else{
					max.setRight(root.getRight());
					root.setLeft(null);
					root.setRight(null);
					root=max;
				}
			}else if(root.getRight()!=null){
				Node temp=root.getRight();
				root.setRight(null);
				root=temp;
			}else{
				root=null;
			}
		}else{
			Node n=find(root,w);
			Node p=getParent(root,n);
			if(n.getLeft()==null&&n.getRight()==null){
				if(p.getLeft()!=null&&p.getLeft().equals(n))
					p.setLeft(null);
				else {
					p.setRight(null);
				}
			}else if(n.getLeft()!=null&&n.getRight()==null){
				if(p.getLeft()!=null&&p.getLeft().equals(n))
					p.setLeft(n.getLeft());
				else {
					p.setRight(n.getLeft());
				}
				n.setLeft(null);
			}else if(n.getRight()!=null&&n.getLeft()==null){
				if(p.getLeft()!=null&&p.getLeft().equals(n))
					p.setLeft(n.getRight());
				else {
					p.setRight(n.getRight());
				}
				n.setRight(null);
			}else{
				System.out.println("HEYYYY");
				Node max=getMax(n.getLeft());
				System.out.println(max.getWord());
				Node parent=getParent(root,max);
				System.out.println(parent.getWord());
				if(!max.equals(n.getLeft())){
					if(max.getLeft()==null){
						parent.setRight(null);
					}else{
						parent.setRight(max.getLeft());
					}
					max.setLeft(n.getLeft());
					max.setRight(n.getRight());
					n.setLeft(null);
					n.setRight(null);
					if(p.getLeft()!=null&&p.getLeft().equals(n))
						p.setLeft(max);
					else
						p.setRight(max);
				}else{
					p.setLeft(max);
					n.setLeft(null);
					max.setRight(n.getRight());
					n.setRight(null);
				}
			}
		}
	}
	public void print(Node r){
		if(r==null)
			return;
		print(r.getLeft());
		System.out.println(r.toString());
		print(r.getRight());
	}
	public Node find(Node r,String w){
		if(r==null)
			return null;
		if(r.getWord().equalsIgnoreCase(w)){
			return r;
		}else if(compare(r.getWord().toLowerCase(),w.toLowerCase())==1)
			return find(r.getLeft(),w);
		else 
			return find(r.getRight(),w);
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
}
