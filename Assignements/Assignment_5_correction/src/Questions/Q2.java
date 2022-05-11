package Questions;

public class Q2 {
	// Tags do not need to be after each other with the opening following the closing tag. They can be in this form <b> <i> </b> </i>
	public static boolean tagging(String s){
		Stack s1=new Stack();
		Stack s2=new Stack();
		String[] c=s.split(" ");
		if(!(c[0].equals("<html>")&&c[c.length-1].equals("</html>")))
			return false;
		else{
			for(int i=1;i<c.length-1;i++){
				if(c[i].equals("<b>")||c[i].equals("<i>")||c[i].equals("<h1>")){
					s1.push(new Node(c[i]));
				}else if(c[i].equals("</b>")||c[i].equals("</i>")||c[i].equals("</h1>")){
					switch(c[i]){
					case "</b>":
						while(!s1.isEmpty()&&!s1.peek().getInfo().equals("<b>")){
							s2.push(s1.pop()); //using a second stack to keep the elements we went through just to be able to get the opening tag we need
						}
						if(s1.isEmpty())
							return false;
						else{
							s1.pop();
							while(!s2.isEmpty()){
								s1.push(s2.pop());
							}
						}
						break;
					case "</i>":
						while(!s1.isEmpty()&&!s1.peek().getInfo().equals("<i>")){
							s2.push(s1.pop());
						}
						if(s1.isEmpty())
							return false;
						else{
							s1.pop();
							while(!s2.isEmpty()){
								s1.push(s2.pop());
							}
						}
						break;
					case "</h1>":
						while(!s1.isEmpty()&&!s1.peek().getInfo().equals("<h1>")){
							s2.push(s1.pop());
						}
						if(s1.isEmpty())
							return false;
						else{
							s1.pop();
							while(!s2.isEmpty()){
								s1.push(s2.pop());
							}
						}
						break;
					}
					
				}
			}
			if(s1.isEmpty())
				return true;
			else
				return false;
		}
	}
	public static void main(String[] args){
		System.out.println(tagging("<html> <b> <i> hhh </b> aaa <h1> </h2> </i> </html>"));
	}
}
