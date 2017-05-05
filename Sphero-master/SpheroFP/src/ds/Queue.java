package ds;

public class Queue<T>{
	protected Node<T> head;
	protected Node<T> tail;
	protected long size;

	public Queue(){
		head= null;
		tail= null;
		size=0;
	}

	public void add(Node<T> newNode){
		if (size==0) {
			newNode.setNext(null);
			newNode.setPrev(null);
			head = newNode;
			tail = newNode;
		} else{
			newNode.setNext(null);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail=newNode;
		}
		size++;
	}
	public void remove(){
		if (head == null)
			System.err.println("Error:  Attempt to remove from an empty list");

		// save the one to return
		Node<T> temp = head;

		if ( head == tail ) { /* Is the last Node in the list */
			head = null;
			tail = null;
		}
		else {
			// do reference manipulation
			head = head.getNext();
			head.setPrev(null);
		}
		temp.setNext(null);
		temp.setPrev(null);
        size--;
	}
	public Node<T> getFirst(){
		return head;
	}
	public Node<T> getLast(){
		return tail;
	}
	public long getSize(){
		return size;
	}

}