
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {
        private T element;
        QueueElement<T> front,rear;
    	//TODO:  You need some data to store the queue.  Put the attributes here.
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
               this.front = this.rear = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
            if(front == null)
                return true;
            else
                return false;
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		return front == null?null:front.getElement(); 
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
	    //Dequeue code is neede here
            if(front == null){
                System.out.println("No Elements");
            }
            else{
                front = front.getNext();             
            }
       	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
            System.out.println(element);
            QueueElement newperson = new QueueElement(element,null);
            if(front == null){
                front = newperson;
            }
            else{
                if(front.getNext() == null){
                    front.setNext(newperson);
                }
                else{
                    rear.setNext(newperson);
                }
                
                rear = newperson;
            }
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
	    //Code to print the code is needed here
            if(front == null){
                System.out.println("No elements");
            }
            else{
                System.out.println(front.getElement());
            }
	}
}
