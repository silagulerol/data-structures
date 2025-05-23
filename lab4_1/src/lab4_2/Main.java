package lab4_2;

public class Main {
	public static  class PriorityQueue{
		public int[] queue;
		public int front=-1;
		public int rear=-1;
		public int size;
		public int count=0;
		
		public PriorityQueue(int size) {
			this.size=size;
			queue= new int[size];
		}
		
		public boolean isEmpty() {
			return count==0;
		}
		
		public boolean isFull() {
			return count==size;
		}
		
		public void enqueue(int value) {
			if(isEmpty()) {
				front=0;
				rear=0;
				queue[front]=value;
				count++;
			}
			
			else {
				// if I want to change the queue even it is full
				if(isFull()) {
					System.out.println("Queue is full");
					if(queue[rear] <= value) {
						return;
					}
					else {
						rear--;
					}
				}
				
				int i=rear;
				// queue[i] > value means at position i there is bigger element than value
				// if it returns false that means value should be at position i+1, because queue[i]<value
				// and always smallest value is in the front
				while(i >= front && queue[i] > value){
					queue[i+1]=queue[i];
					i--;
				}
				queue[i+1]=value;
				rear++;
				count++;
			}
		}
		
		public int dequeue() {
			if(isEmpty()) {
				System.out.println("Queue is empty");
			}
			int temp=queue[front];
			front++;
			return temp;
		}
		
		public int peek() {
			return queue[front];
		}
		
		
	}
	
	public static void main(String[] args) {
		 PriorityQueue pq1 = new PriorityQueue(5);
		 pq1.enqueue(10);
		 pq1.enqueue(30);
		 pq1.enqueue(20);
		 System.out.println(pq1.dequeue()); // should print 10
		 System.out.println(pq1.peek()); // should print 20
		 System.out.println(pq1.isEmpty()); // should print false
		 
		 PriorityQueue pq2 = new PriorityQueue(3);
		 pq2.enqueue(5);
		 pq2.enqueue(3);
		 pq2.enqueue(7);
		 pq2.enqueue(1); // should print "Priority queue is full"
		 System.out.println(pq2.dequeue()); // should print 1
		 System.out.println(pq2.peek()); // should print 3
		 System.out.println(pq2.isEmpty()); // should print false
	}
	

	
}
