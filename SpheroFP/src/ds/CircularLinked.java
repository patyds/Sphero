package ds;

public class CircularLinked<T>{
	protected Node<T> head;
	protected Node<T> tail;
	protected long size;

	public CircularLinked(){
		head= null;
		tail= null;
		size=0;
	}
	public void addFirst(Node<T> newNode){
		if(tail==null){
			tail=newNode;
		}
		newNode.setNext(head);
		head=newNode;
		tail.setNext(newNode);
		size++;
	}
	public void addAfter(Node<T> rightNow, Node<T> newNode){
		if(rightNow==tail){
			tail=newNode;
		}
		newNode.setNext(rightNow.getNext());
		rightNow.setNext(newNode);
		size++;
	}
	public void addLast(Node<T> newNode){
		if(head==null){
			head=newNode;
		}if(tail==null){
			tail=newNode;
		}else{
		newNode.setNext(head);
		tail.setNext(newNode);
		tail=newNode;
		}
		size++;
	}
	public Node<T> removeFirst(){
		if(head==null){
			System.out.println("Error: No head yet");
		}
		Node<T> aux = head;
		head=head.getNext();
		aux.setNext(null);
		size--;
		return aux;
	}
	public Node<T> removeLast(){
		Node<T> nodeBefore;
		Node<T> nodeRemove;
		if(size==0){
			System.out.println("Error: Empty list");
		}
		nodeBefore=getFirst();
		for( int i=0;i<size-2;i++){
			nodeBefore= nodeBefore.getNext();
		}
		nodeRemove= tail;
		nodeBefore.setNext(null);
		tail=nodeBefore;
		size--;
		return nodeRemove;
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
			nodeBefore=getFirst();
			currentNode=getFirst().getNext();
			for(int i=0;i<size-2;i++){
				if(currentNode.getElement().equals(removing.getElement())){
					nodeBefore.setNext(currentNode.getNext());
					size--;
					break;
				}
				nodeBefore=currentNode;
				currentNode=currentNode.getNext();
			}
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