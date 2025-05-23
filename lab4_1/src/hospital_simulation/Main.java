package hospital_simulation;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
	/* What Happens in Each Time Step:
	1) A new patient arrives, randomly assigned a priority between 1 and 5.
	2) Try to admit them:
		 If there’s an empty bed → assign them to that bed.
   		 Else → put them in the waiting room.
	3) Try to fill empty beds from the waiting room (based on highest priority).
	4) Randomly discharge one patient from a bed.
	5) Print what’s happening for visibility.
	*/
	
	/*Methods of priority queue
	 * PriorityQueue(Comparator<? super E> comparator):	Creates a PriorityQueue with the default initial capacity 
	   and whose elements are ordered according to the specified comparator.
	   
	   poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
	   offer(E e):	Inserts the specified element into this priority queue.
	   clear(): Removes all of the elements from this priority queue.
	   iterator():	Returns an iterator over the elements in this queue.
	   peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	   remove(Object o): Removes a single instance of the specified element from this queue, if it is present.
	   size(): Returns the number of elements in this collection.
	   toArray(): Returns an array containing all of the elements in this queue.
	 **/
	public static class Patient{
		public String name;
		public int priority;
		
		public Patient(String name, int priority) {
			this.name=name;
			this.priority=priority;
		}
	}
	
	public static class Hospital{
		private static final int NUM_BEDS =10;
		private PriorityQueue<Patient> waitingRoom;
		private Patient beds[];
		
		public Hospital() {
			this.waitingRoom= new PriorityQueue<Patient>((p1,p2) -> p2.priority - p1.priority);
			this.beds= new Patient[NUM_BEDS];
			for(int i=0;i<beds.length;i++) {
				beds[i]=null;
			}
		}
		
		public void admitPatient(Patient p) {
			boolean admitted=false;
			for(int i=0; i< beds.length;i++) {
				if(beds[i]==null) {
					beds[i]=p;
					admitted=true;
					System.out.println(p.name + " has been admitted to bed " + i);
					break;
				}
			}
			if(admitted==false) {
				waitingRoom.offer(p);
			    System.out.println("All beds are full, " + p.name + " is added to the waiting room.");
			}
		}
		
		public void dischargePatient(int bedNumber) {
			/*check if bed is null
			if (beds[bedNumber] == null) {
				System.out.println("Bed is empty");
			}*/
			//if it is not null discharge the patient and add new patient from highest priority from waitigRoom
			if (beds[bedNumber] != null) {
				System.out.println(beds[bedNumber].name +" has been discharged from bed "+ bedNumber);
				beds[bedNumber]=null;
				if (!waitingRoom.isEmpty()) {
					beds[bedNumber]= waitingRoom.poll();
					System.out.println(beds[bedNumber].name +" has been admitted to bed "+ bedNumber);
				}
			}
		}
		
		
		public void runSimulation(int numSteps) {
			Random rand =new Random();
			for(int i=0; i<numSteps;i++) {
				//create random priority
				int priority =rand.nextInt(5)+1;
				Patient p= new Patient("Patient"+i, priority);
				System.out.println("New patient arrived: " + p.name + " (priority " + p.priority + ")");
				// if there is a empty bed place the patient or place to the waitingroom
				admitPatient(p);
				
				//print every patient who is placed in a bed
				for(int j=0; j<beds.length; j++) {
					if(beds[j]!=null) {
						System.out.println("Patient" + beds[j].name +" is in bed"+j);
					}
				}
				
				//randomly choose a bed number to discharge
				int bedToDischarge= rand.nextInt(beds.length);
				dischargePatient(bedToDischarge);
			}
		}
		
		public static void main(String[] args) {
			Hospital hospital= new Hospital();
			hospital.runSimulation(100);
		}
	}
}











