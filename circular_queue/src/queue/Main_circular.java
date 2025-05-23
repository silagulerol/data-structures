package queue;

public class Main_circular {
	public interface IQueue{
		void insert(Object o) throws Exception;
		Object remove() throws Exception;
		Object peek() throws Exception;
		boolean isEmpty();
	}
	
	public class CircularQueue implements IQueue{
		public Object[] queue;
		public int front= -1;
		public int rear =-1;
		public int size;
		public int count=0;
		
		//Constructor
		public CircularQueue(int size){
			this.size=size;
			queue=new Object[size];
		}
		
		public void insert(Object o) throws Exception{
			///////////////// SORRRRRR
			/*if (count == size || rear == size -1) {
				throw new Exception("Queue full.");
			}*/
			
			if(front==-1)
				front=0;
			
			if (rear == size -1) {
				rear=0;
				queue[rear] =o;
			}else {
				queue[++rear]=o;
			}
			count++;
		}
		
		public Object remove() throws Exception{
			if(isEmpty())
				throw new Exception("Queue is empty.");
			
			Object temp = queue[front];
			queue[front]=null;
			
			if(front == size-1) {
				front = 0;
			}else {
				front++;
			}
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
	    	Main_circular mainInstance = new Main_circular();
	    	CircularQueue queue = mainInstance.new CircularQueue(5);

	        // Insert elements
	        queue.insert("Apple");
	        queue.insert("Banana");
	        queue.insert("Cherry");
	        queue.insert("hello");
	        queue.insert("hi");
	        queue.insert("my");


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
