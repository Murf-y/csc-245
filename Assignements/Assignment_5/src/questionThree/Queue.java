/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 * 
 * Date: Mar 30, 2022
 * LastModified: Mar 30, 2022
 * FileName: Queue.java
 *****************************************************
 */
package questionThree;

/* This queue work by adding to the end of the array i.e to the right
 * And Removing from the front of the array, i.e the left
 * It is optimized, that it only increases the array size 
 * if and only if the array is full totally*/
public class Queue {
	private int[] data;
	private final int initial_size = 5;
	
	private int enqueue_pointer;
	private int dequeue_pointer;
	
	private int count;
	
	public Queue() {
		data = new int[initial_size];
		
		// Represent the index where to add the element
		enqueue_pointer = 0;
		// Represent the index where to pop the element
		dequeue_pointer = 0;
		// Represent the number of items in the queue 
		// We need because we cannot calculate it on the fly from enqueue_pointer and dequeue_pointer.
		count = 0;
	}
	
	private void ensureCapacity() {
		int[] new_data = new int[initial_size + data.length];
		int last_index = 0;
		for(int i = dequeue_pointer; i < data.length; i++) {
			new_data[i - dequeue_pointer] = data[i];
			last_index = i - dequeue_pointer;
		}
		
		// Increasing the size when the enqueue pointer has already cycled back
		if(enqueue_pointer == dequeue_pointer) {
			for(int i = 0, j = data.length - dequeue_pointer; i < enqueue_pointer; i++, j++) {
				new_data[j] = data[i];
				last_index = j;
			}
		}
		
		enqueue_pointer = last_index + 1;
		dequeue_pointer = 0;
		data = new_data;
	}
	
	public void enqueue(int i) {
		
		// If there is no more space, increase the size
		if(count == data.length) {
			ensureCapacity();
		}
		// If we cannot enqueue
		// this only will happen if count < data.length && 
		// we have free space in the start, thus we need to fill them first
		if(enqueue_pointer >= data.length) {
			enqueue_pointer = 0;
		}
		// Add the element and increment the enqueue_pointer
		data[enqueue_pointer++] = i;
		// Increment the count of items in the queue
		count++;
	}
	public int dequeue() {
		
		// Here we should throw and EmptyQueueException()
		// But for assignment sack, just return a sentinel value 0
		if(isEmpty()) return 0;
		
		// Pop and return the dequeued value
		int popped = data[dequeue_pointer];
		data[dequeue_pointer++] = 0;
		count--;
		
		// recycle the pointer back to 0
		if(dequeue_pointer >= data.length) {
			dequeue_pointer = 0;
		}
		return popped;
	}

	public boolean isEmpty() {
		return count == 0;
	}
	
	
	// Not usually included in a Queue, but it is here for extra points! joking :)
	public int peek() {
		// No need to check for dequeue_pointer >= data.length , since it cannot be
		// We are checking for it in the dequeue method already 
		return data[dequeue_pointer];
	}
	
	// This is not supposed to be in a queue
	// but for debugging purposes (so you can visualize what is actually happening)
	public void displayMe() {
		System.out.println("Enqueue pointer : "+ enqueue_pointer);
		System.out.println("Dequeue pointer : "+ dequeue_pointer);
		System.out.println("Count           : "+ count);
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
