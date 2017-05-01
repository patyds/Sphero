package ds;

import sphero.Sphero;

public class DoubleLinkList<T>{
	protected Node<T> head;
	protected Node<T> tail;
	protected long size;

	public DoubleLinkList(){
		head= null;
		tail= null;
		size=0;
	}
	public void addFirst(Node<T> newNode){
		if (size==0) {
			newNode.setNext(null);
			newNode.setPrev(null);
			head = newNode;
			tail = newNode;


		} else {
			head.setPrev(newNode);
			newNode.setNext(head);
			newNode.setPrev(null);
			head = newNode;
        }
        size++;


	}
	public void addAfter(Node<T> rightNow, Node<T> newNode){
		if(rightNow==tail){
			addLast(newNode);
		}else{
			newNode.setNext(rightNow.getNext());
			rightNow.setNext(newNode);
			newNode.setPrev(newNode.getNext().getPrev());
			newNode.getNext().setPrev(newNode);
			size++;

		}
	}
	public void addLast(Node<T> newNode){
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
	public void removeFirst(){
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
	public void removeLast(){
		Node<T> Prev;
		Node<T> ToRemove;

		// Make sure we have something to remove
		if (size == 0)
			System.err.println("Error:  Attempt to remove fron an empty list");

		// Save the node before the last Node
		Prev = tail.getPrev();
		// Save the last Node
		ToRemove = tail;

		if ( head == tail ) { /* Is the last Node in the list */
			head = null;
			tail = null;
		}
		else {
			// Let's do the pointer manipulation
			Prev.setNext(null);
			tail = Prev;
		}
		ToRemove.setPrev(null);
		ToRemove.setNext(null);
		size--;

	}
	public void remove(Node<T> removing){
		Node<T> nodeBefore;
		Node<T> currentNode;
		if(size==0){
			System.out.println("Error: Empty list");
		}
		currentNode=getFirst();
		if(currentNode.getElement().equals(removing.getElement())){
			removeFirst();
		}
		currentNode=getLast();
		if(currentNode.getElement().equals(removing.getElement())){
			removeLast();
		}
		if(size-2>0){
			nodeBefore = removing.getPrev();
			nodeBefore.setNext(removing.getNext());
			currentNode = removing.getNext();
			currentNode.setPrev(removing.getPrev());

			removing.setPrev(null);
			removing.setNext(null);
            size--;
		}
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