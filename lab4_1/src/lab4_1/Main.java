package lab4_1;

public class Main {
	public static class Queue{
		private Object[] queue;
		private int front=-1;
		private int rear=-1;
		private int size;
		private int count;
		
		public Queue(int size) {
			this.size =size;
			this.count=0;
			queue = new Object[size];
		}
		
		public boolean isEmpty() {
			return count==0;
		}
		
		public boolean isFull() {
			return count==size;
		}
		
		public void enqueue(Object value){
			if (isFull()) {
				System.out.println("Queue is full");
			}
			else if(isEmpty() ) {
				rear++;
				front++;
			}else {
				rear++;
			}
			queue[rear]=value;
			count++;
		}
		
		public Object dequeue() {
			if (isEmpty()) {
				System.out.println("Queue is empty");
			}
			Object temp= queue[front];
			queue[front]=null;
			front++;
			count--;
			return temp;
		}
		
		public Object peek(){
			if(isEmpty()) {
				System.out.println("Queue is empty");
			}
			return queue[front];
		}
		
		public static void main(String[] args) {
			 Queue queue = new Queue(5);
		     queue.enqueue(1);
		     queue.enqueue(2);
		     queue.enqueue(3);

		     System.out.println(queue.dequeue()); // 1
		     System.out.println(queue.peek());    // 2
		     System.out.println(queue.isEmpty()); // false

		    
		    Queue q2 = new Queue(3);
		    q2.enqueue(10);
		    q2.enqueue(20);
		    q2.enqueue(30);
		    q2.enqueue(40); // ❌ This will throw
		   
		    System.out.println(q2.dequeue());    // 10
		    System.out.println(q2.peek());       // 20
		    System.out.println(q2.isEmpty());    // false
		  
		}		
		
	}
}