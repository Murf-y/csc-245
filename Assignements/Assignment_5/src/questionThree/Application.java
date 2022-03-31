/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 27, 2022
 * LastModified: Mar 27, 2022
 * FileName: Application.java
 *****************************************************
 */
package questionThree;

public class Application {

	public static void testQueue() {
		Queue q = new Queue();

		// This is not supposed to be in a queue
		// but for debugging purposes (so you can visualize what is actually happening)
		q.displayMe();
		System.out.println("\n---------------\n");

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.displayMe();
		System.out.println("\n---------------\n");

		q.dequeue();
		q.dequeue();
		q.displayMe();
		System.out.println("\n---------------\n");


		q.enqueue(4);
		q.enqueue(5);
		q.displayMe();
		System.out.println("\n---------------\n");
		
		q.enqueue(6);
		q.enqueue(7);
		q.displayMe();
		System.out.println("\n---------------\n");

		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.displayMe();
		System.out.println("\n---------------\n");

		if (q.isEmpty()) {
			System.out.println("Queue is empty!");
		} else {
			System.out.println("Queue is not empty!");
		}
		System.out.println("\n---------------\n");
		
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.enqueue(11);
		q.enqueue(12);
		q.displayMe();
		System.out.println("\n---------------\n");
		
		
		System.out.println("\n---------------\n");
		System.out.println("Test Done, Exiting . . .");
		System.exit(0);
	}

	public static void main(String[] args) {
		testQueue();
	}

}
