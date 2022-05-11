package Questions;

public class Q1 {
	public static int evaluate(String s){
		String[] c=s.split(" ");
		Stack oprts=new Stack();
		for(int i=0;i<c.length;i++){
			if(c[i].equals("(")){
				oprts.push(new Node(c[i]));
			}else if(c[i].equals(")")){
				int op2=Integer.parseInt(oprts.pop().getInfo());
				String opd=oprts.pop().getInfo();
				int op1=Integer.parseInt(oprts.pop().getInfo());
				oprts.pop();
				int ans=0;
				switch(opd){
				case "+":
					ans=op1+op2;
					oprts.push(new Node(""+ans));
					break;
				case "-":
					ans=op1-op2;
					oprts.push(new Node(""+ans));
					break;
				case "*":
					ans=op1*op2;
					oprts.push(new Node(""+ans));
					break;
				case "/":
					ans=op1/op2;
					oprts.push(new Node(""+ans));
					break;
				case "%":
					ans=op1%op2;
					oprts.push(new Node(""+ans));
					break;
				}
			}else{
				oprts.push(new Node(c[i]));
			}
		}
		return Integer.parseInt(oprts.pop().getInfo());
	}
	public static void main(String[] args){
		System.out.println(evaluate("( ( 9 + 7 ) * 6 )"));
		System.out.println(evaluate("( ( 5 - 3 ) + ( 9 - 8 ) )"));
		System.out.println(evaluate("( ( ( 9 + 8 ) - ( 9 * 70 ) ) - ( 17 + 2 ) )"));
	}
}
