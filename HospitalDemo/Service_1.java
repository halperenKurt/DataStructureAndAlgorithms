//**************Double Linked List************************//

public class Service_1 {
    Patient head; //head of list
    Patient tail; //tail of list

    //Constructor
    public Service_1() {
        head=tail=null;

    }

    //Check list is empty or not
    public boolean isEmpty() {
        return head==null;
    }

    //This function first builds new patient with the given data
    //than adds it to the LinkedList
    //new nodes are added to the tail of LinkedList
    public void insert(String name) {
        Patient patient = new Patient(name);
        if(isEmpty()){
            head=patient;
            tail=patient;
        }   
        else{
            patient.previous=tail;
            tail.next=patient;
            tail=patient;
        }
    }

    // overload this method as new nodes are added to given position (int pos)
    // fill the rest
    public void insert(String name, int pos) {
        Patient patient = new Patient(name);
        if (pos<=0){
            patient.next=head;
            head.previous=patient;
            head=patient;
        }
        else{
            Patient patient1=head;
            int index=0;
            while(patient1!=null && index<pos-1){
                patient1=patient1.next;
                index++;
            }
            if(patient1!=null){
                patient.next=patient1.next;
                if(patient1.next!=null){
                    patient1.next.previous=patient;
                }
                patient1.next=patient;
                patient.previous=patient1;
                
            }
        }
        
    }
    
    //This method finds how many patients are exist in LinkedList
    public int size() {
        int count=0;
        Patient patient=head;
        while(patient!=null){
            patient=patient.next;
            count++;
        }
        return count;
    }

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion
    public Patient deleteByName(String name) {
        Patient patient=head;
        while(patient!= null && !patient.getName().equals(name)){
            patient=patient.next;
        }
        if(patient==null)
            return null; 
        
        if (patient.previous != null) {
            patient.previous.next = patient.next;
        } else {
            head = patient.next;
        }

        if (patient.next != null) {
            patient.next.previous = patient.previous;
        } else {
            tail = patient.previous;
        }

        return patient;
    }

    // This functions delete a node in the LinkedList by a given position
    public Patient deleteByPosition(int pos) {
        if (pos < 0 || pos >= size()) {
            return null;
        }
        Patient patient = head;

        for (int i = 0; i < pos; i++) {
            patient = patient.next;
        }

        if (patient.previous != null) {
            patient.previous.next = patient.next;
        } else {
            head = patient.next;
        }

        if (patient.next != null) {
            patient.next.previous = patient.previous;
        } else {
            tail = patient.previous;
        }

        return patient;
    } 
    

    //This function get the node in the given index
    //*********************DO NOTHING*********************
    public Patient getByPosition(int pos){
        if(this.isEmpty())
            return new Patient("empty");
        Patient current = this.head;
        int index = 0;

        while (current != null){
            if(index++ == pos)
                break;
            current = current.next;
        }

        if(current == null)
            return new Patient("empty");

        return current;
    }

    // This function prints  the LinkenList
    //*********************DO NOTHING*********************
    public void print() {

        if(this.isEmpty())
            return;
        Patient patient = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (patient != null) {
            System.out.println(index++ + ". " + patient.getName());

            patient = patient.next;  // iterate to next node
        }

    }

}
