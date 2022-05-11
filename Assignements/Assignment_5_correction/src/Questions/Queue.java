package Questions;

public class Queue {
	private int[] q;
	private int count;
	public Queue(){
		q=new int[10];
		count=0;
	}
	public void increaseCap(){
		int[] temp=new int[q.length+10];
		for(int i=0;i<=temp.length;i++){
			temp[i]=q[i];
		}
		q=temp;
	}
	public int[] getQ() {
		return q;
	}
	public void setQ(int[] q) {
		this.q = q;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void enqueue(int n){
		if(count==q.length){
			increaseCap();
		}
		q[count]=n;
		count++;
	}
	public int dequeue(){
		if(count==0){
			return -99;
		}
		int d=q[0];
		for(int i=0;i<count;i++){
			q[i]=q[i+1];
		}
		count--;
		return d;
	}
	public void print(){
		for(int i=0;i<count;i++){
			System.out.println(q[i]);
		}
	}
	public int peek(){
		if(count==0)
			return -99;
		return q[0];
	}
	public static void main(String[] args){
		Queue q=new Queue();
		System.out.println("Before enqueuing");
		System.out.println();
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		System.out.println();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println("Before dequeuing");
		q.print();
		System.out.println();
		System.out.println("Dequeued");
		System.out.println(q.dequeue());
		System.out.println("Peek");
		System.out.println(q.peek());
		System.out.println();
		System.out.println("After dequeuing");
		q.print();
	}
}
