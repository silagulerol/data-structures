package queue;

public class Main {
	public interface IQueue{
		void insert(Object o) throws Exception;
		Object remove() throws Exception;
		Object peek() throws Exception;
		boolean isEmpty();
	}
	
	public class SimpleArrayTypedQueue implements IQueue{
		private Object[] queue;
		private int front= -1;
		private int rear =-1;
		private int size;
		private int count=0;
		
		//Constructor
		public SimpleArrayTypedQueue(int size){
			this.size=size;
			queue=new Object[size];
		}
		
		public void insert(Object o) throws Exception{
			if (count == size || rear == size -1) {
				throw new Exception("Queue full.");
			}
			
			if(front==-1)
				front=0;
			
			queue[++rear]= o;
			count++;
		}
		
		public Object remove() throws Exception{
			if(isEmpty())
				throw new Exception("Queue is empty.");
			
			Object temp = queue[front];
			queue[front]=null;
			front++;
			count--;
			
			return temp;
		}
		
		public boolean isEmpty() {
			return count == 0;
		}
		
		public Object peek() throws Exception{
			if(isEmpty())
				throw new Exception("Queue is empty.");
			
			return queue[front];
		}
	}
	
	
	public static void main(String[] args) {
	    try {
	        // Since SimpleArrayTypedQueue is not static, we must create an instance of Main to access it
	        Main mainInstance = new Main();
	        SimpleArrayTypedQueue queue = mainInstance.new SimpleArrayTypedQueue(5);

	        // Insert elements
	        queue.insert("Apple");
	        queue.insert("Banana");
	        queue.insert("Cherry");

	        // Peek at the front element
	        System.out.println("Front of queue: " + queue.peek());

	        // Remove elements
	        System.out.println("Removed: " + queue.remove());
	        System.out.println("Removed: " + queue.remove());

	        // Peek again
	        System.out.println("Front after removals: " + queue.peek());

	        // Check if empty
	        System.out.println("Is queue empty? " + queue.isEmpty());

	        // Remove remaining elements
	        System.out.println("Removed: " + queue.remove());

	        // Try removing from empty queue to test exception
	        System.out.println("Removed: " + queue.remove()); // This will throw an exception

	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	    }
	
	}
}
