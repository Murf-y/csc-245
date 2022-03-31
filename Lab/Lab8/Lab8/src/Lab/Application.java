package Lab;

public class Application {
	
	
	public String infixToPostfix(String exp){
		Stack op = new Stack();
		String[] parts = exp.split(" ");
		String res="";
		String operators = "+-/*";
		String strong_operators = "*/";
		String para = "()";
		for(int i =0 ; i< parts.length; i++){
			if( parts[i].equals("(")){
				op.push(parts[i]);
			}
			else if(parts[i].equals(")")){
				while(!op.isEmpty()){
					if(op.peek().equals("(")){
						op.pop();
						break;
					}else
						res += op.pop() + " ";
				}
			}
			else if (operators.contains(parts[i])){
				if(op.isEmpty()){
					op.push(parts[i]);
				}else{
					if(!strong_operators.contains(op.peek()) && strong_operators.contains(parts[i])){
						op.push(parts[i]);
					}else{
						while(!op.isEmpty() && 
								(((parts[i].equals("+") || parts[i].equals("-")) && !para.contains(op.peek())))
								|| 
								(strong_operators.contains(parts[i])) && strong_operators.contains(op.peek())){
							res += op.pop() + " ";
						}
						op.push(parts[i]);
					}
				}
			}else{
				res += parts[i] + " ";
			}
		}
		while(!op.isEmpty()){
			res += op.pop() + " ";
		}
		return res;
	}
	
	public boolean isPalindrome(String s){
		Stack coolStack = new Stack();
		for(int i = 0, j = s.length() -1; i < s.length()/2 && j > s.length()/2 ; i++, j--){
			coolStack.push(String.valueOf(s.charAt(i)));
			coolStack.push(String.valueOf(s.charAt(j)));
		}
		while(!coolStack.isEmpty()){
			if(!coolStack.pop().equals(coolStack.pop())){
				return false;
			}
		}
		return true;
	}
	public int evaluate(String exp){
		Stack ints = new Stack();
		
		for(int i =0; i < exp.length() ; i ++){
			String c = String.valueOf(exp.charAt(i));
			if(c.equals(" ")) continue;
			try{
				int x = Integer.parseInt(c);
				ints.push(x+"");
			}catch(NumberFormatException e){
				int right = Integer.parseInt(ints.pop());
				int left = Integer.parseInt(ints.pop());
				int res = 0;
				switch(c){
					case "+":{
						res = left + right;
						break;
					}
					case "-":{
						res = left - right;
						break;
					}
					case "*":{
						res = left * right;
						break;
					}
					case "/":{
						res = left / right;
						break;
					}
				}
				ints.push(res+"");
			}
		}
		return Integer.parseInt(ints.pop());
	}
	public void run(){
		System.out.println(infixToPostfix("1 + 2 * 5"));
		System.out.println();
		System.out.println(isPalindrome("aba"));
		System.out.println();
		Queue q = new Queue();
		q.queue("a");
		q.queue("b");
		q.queue("c");
		q.getStack().displayMe();
		q.deque();
		System.out.println();
		q.getStack().displayMe();
		System.out.println();
		System.out.println(evaluate(infixToPostfix("( 2 - 3 + 4 ) * ( 5 + 6 * 7 )")));
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
}
