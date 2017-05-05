package ds;


/**
 * Based on Crunchify.com
 * @author MCC. Jorge Isaac V. Moran
 */
public class Stack<V> {
    // Instance Variables. Add the tail reference.
    private Node<V> head;
    private  Node<V> tail;
    protected long size;
 
    // Empty list constructor first
    public Stack() {
        head = null;
        tail = null;
        size = 0;
    } 
 
    /**
     * Method to add Nodes to the list.
     * Storage space for the Node is already allocated in the calling method
     */
    public void push(Node<V> newNode) {
        // Set the tail only if this is the very first Node
        if (tail == null && head == null) addVeryFirst(newNode);
        else {
            newNode.setNext(head); // Make next of the new Node refer to the head
            head = newNode; // Give head a new value
        }
        // change the size
        size++;
    } 
 
    /**
     * Methods to remove Nodes from the list.
     */
    public Node<V> pop() {
        if (head == null)
            System.err.println("Error:  Attempt to remove from an empty list");
 
        // save the one to return
        Node<V> temp = head;
 
        // do reference manipulation
        head = head.getNext();
        temp.setNext(null);
        size--;
 
        return temp;
    }

    // Add very first node in the single list
    private void addVeryFirst(Node<V> newNode) {
        head = newNode; // Give head a new value
        newNode.setNext(null);
        tail = newNode; // Give tail a new value
    }
    
    // The gets to return the head and/or tail Nodes and size of the list
    public Node<V> peek() {
        return head;
    }
 
    public long getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return ( size == 0 )?true:false;
    }

	public Node<V> getFirst() {
		return head;
	}

	public Node<V> getLast() {
		return tail;
	}


}