
/**
 * You must use this class when constructing your Queue.  This class represents a link of the
 * linked list.  Your queue will be composed of these links.
 * @author archam
 *
 */
public class QueueElement<E> {
	private E element; //the element contained in this linked list
	private QueueElement<E> next; //the next element of the linked list
	
	public QueueElement (E e, QueueElement<E> n) {
		this.element = e;//present 
		this.next = n;//next
	}
	
	/**
	 * Method to set the element
	 */
	public void setElement (E e) {
		this.element = e;
	}
	
	/**
	 * Method to set the next linked list element
	 */
	public void setNext (QueueElement<E> e) {
		this.next = e;
	}
	
	/**
	 * Method to get the element.
	 */
	public E getElement () {
		return this.element;
	}
	
	/**
	 * Method to get the next linked list element
	 */
	public QueueElement<E> getNext () {
		return this.next;
	}    	
}
