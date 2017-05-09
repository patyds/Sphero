package grafos;
import java.util.*;
import ds.DoubleLinkList;
import ds.Node;
import ds.Queue;
import ds.Stack;

public class Grafo<K,D>extends Hashtable<K,D>{
	private int size;
	protected int[][] edges;
	Queue<Vertice> newOrder = new Queue<Vertice>();
	Stack<Vertice> stack = new Stack<Vertice>();
	public Grafo(int size){
		super(size);
		this.size=size;
		edges = new int[size][size];
		fillEdges();
	}
	
	public void fillEdges(){
		for(int i=0;i<size;i++){
			for(int j=0; j<size;j++){
				edges[i][j]=0;
			}
		}
	}

	public Queue<Vertice> DFS(Grafo<Integer, Vertice> grafo, int i, int f){
		Vertice v = grafo.get(i);
		v.setVisited(true);
		DoubleLinkList<Vertice> ar = v.aristas;
		Node<Vertice> aux = ar.getFirst();
		boolean notsaved = true;
		for(int h=0;h<ar.getSize();h++){
			if(!aux.getElement().isVisited()){
				notsaved=true;
				if(stack.getSize()>0){
					Node<Vertice> temp = stack.getFirst();
					for(int a=0;a<stack.getSize();a++){
						if(temp.getElement().getName().equals(aux.getElement().getName())){
							notsaved= false;
							break;
						}
						temp=temp.getNext();
					}
				}
				if(notsaved){
					stack.push(new Node<Vertice>(aux.getElement()));
				}
			}
		aux=aux.getNext();
		}
		System.out.println(stack.getFirst().getElement().getName());
		newOrder.add(new Node<Vertice>(stack.getFirst().getElement()));
		//System.out.println(newOrder.getLast().getElement().getName());
		int j;
		for(j=0;j<grafo.getSize();j++){
			if(grafo.get(f).getName().equals(stack.getFirst().getElement().getName())){
				clearStack(stack);
				System.out.println(stack.getSize());
				return newOrder;
			}
			if(grafo.get(j).getName().equals(stack.getFirst().getElement().getName())){
				break;
			}
		}
		//System.out.println(stack.getFirst().getElement().getName());
		stack.pop();
		DFS(grafo,j,f);
		clearV(grafo);
		return newOrder;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void clearV(Grafo<Integer, Vertice> grafo){
		for(int i=0;i<grafo.getSize();i++){
			grafo.get(i).setVisited(false);
		}	
	}
	
	public void clearQueue(Queue<Vertice> newOrder){
		while(newOrder.getSize()>0){
			newOrder.remove();
		}
	}
	public void clearStack(Stack<Vertice> stack){
		while(stack.getSize()>0){
			stack.pop();
		}
	}
	
}