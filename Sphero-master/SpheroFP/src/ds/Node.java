package ds;

public class Node<T>{
	protected T element;
	private Node<T> next;
	private Node<T> prev;

	public Node(){
		this(null);
	}
	public Node(T element){
		this.element=element;
		next=null;
	}

	public T getElement(){
		return element;
	}
	public Node<T> getNext(){
		return next;  
	}
	public void setElement(T element){
		this.element=element;
	}
	public void setPrev(Node<T> prev){
		this.prev=prev;
	}
	public Node<T> getPrev(){
		return prev;
	}
	public void setNext(Node<T> next){
		this.next=next;
	}
}