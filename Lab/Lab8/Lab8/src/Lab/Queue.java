package Lab;

public class Queue {
	private Stack stack;
	
	public Queue(){
		stack = new Stack();
	}
	
	public Stack getStack() {
		return stack;
	}
	public void setStack(Stack stack) {
		this.stack = stack;
	}
	
	public void queue(String i){
		stack.push(i);
	}
	
	public String deque(){
		if(stack.isEmpty()){
			return "";
		}
		else{
			Stack myCoolStack = new Stack();
			while(!stack.isEmpty()){
				myCoolStack.push(stack.pop());
			}
			String returnVal = myCoolStack.pop();
			
			while(!myCoolStack.isEmpty()){
				stack.push(myCoolStack.pop());
			}
			
			return returnVal;
		}
	}
}
