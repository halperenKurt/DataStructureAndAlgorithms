//Queue with Linked List
public class Service_2 {
    Service_1 queue; // Your queue. Use this

    // Constructor to initialize a queue
    Service_2() {
        this.queue = new Service_1();
    }

    // Utility function to dequeue the front element
    public Patient dequeue() {
        if(isEmpty())
            return null;
        Patient tmp=queue.head;
        queue.head=queue.head.next;
        if(queue.head==null)
            queue.tail=null;
        return tmp;
    } 

    // Utility function to add an item to the queue
    public void enqueue(Patient p) {
        if(queue.head==null)
            queue.head=queue.tail=p;
        else
            queue.tail.next=p;
            queue.tail=p;
        
    }

    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
    
        return queue.head==null; 
    }

    // Utility function to return the size of the queue
    public int size() {
        int count=0;
        Patient patient=queue.head;
        while(patient!=null){
            patient=patient.next;
            count++;
        }
        return count;
    }

}
