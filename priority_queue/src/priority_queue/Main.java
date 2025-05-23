package priority_queue;
import java.util.Comparator;

public class Main {
	
	public static class PriorityQueue{
		private Object[] queue;
		private int front = -1;
		private int rear=-1;
		//Rear is always 0, so it does not change
		//One of the size and count variables may not be used if desired
		private int size= 0;
		private int count =0;
		
	
		public PriorityQueue(int size) {
			this.size = size;
			queue = new Object[size];
		}
		
		public boolean isFull() {
			return count == size;
		}
		
		public boolean isEmpty() {
			return count==0;
		}
		public void insert(Object o) throws Exception{
			if (isFull()) {
				throw new Exception("Queue is full!");
			}
			if (isEmpty()) {
			     front = rear = 0;
			     queue[front] = o;
			     count++;
			     return;
			}
			//Check if the queue is empty or if the element has higher priority than the current front
			if (((Comparable) o).compareTo(queue[front]) < 0) {
			    front = (front - 1 + size) % size;
			    queue[front] = o;
			}else {
				// Otherwise, find the appropriate position to insert the element based on priority
				int index =(rear + 1)%size;
				while (index != front && ((Comparable) o).compareTo(queue[front]) >=0) {
					index = (index+1)%size;
				}
				
				//Shift elements to make space for the new element
				int i=rear;
				while(i != index) {
					queue[(i+1)%size]=queue[i];
					i= (i-1+size)%size;
				}
				
				//Insert the new element at the correct position
				queue[index]=o;
				rear= (rear+1)%size;
				
			}
			count++;
		}
		public Object remove() throws Exception{
			if (isEmpty()){
				throw new Exception("Queue is empty");
			}
			
			//Retrieve the element at the front
			Object removedItem= queue[front];
			
			//Remove the element by setting its position to null
			queue[front]=null;
			
			//Update front pointer to point to the next element
			front=(front+1)%size;
			
			//Decrement the count of elements in the queue
			count--;
			
			return removedItem;
		}
		
		public void display() {
			for(int i =front; i <=rear; i--) {
				System.out.println(queue[i]);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		try {
			
			PriorityQueue queue = new PriorityQueue(6);
			
			queue.insert(3);
			queue.insert(2);
			queue.insert(5);
			
			queue.display();
		}catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	
	}

}
