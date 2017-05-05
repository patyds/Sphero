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
		while(aux.getNext()!=null){
			if(!aux.getElement().isVisited()){
				if(stack.getSize()>0){
					Node<Vertice> temp = stack.getFirst();
					while(temp.getNext()!=null){
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
		//System.out.println(stack.getFirst().getElement().getName());
		newOrder.add(new Node<Vertice>(stack.getFirst().getElement()));
		//System.out.println(newOrder.getLast().getElement().getName());
		int j;
		for(j=0;j<grafo.getSize();j++){
			if(grafo.get(j).getName().equals(stack.getFirst().getElement().getName())){
				break;
			}
			if(grafo.get(f).getName().equals(stack.getFirst().getElement().getName())){
				return newOrder;
			}
		}
		//System.out.println(stack.getFirst().getElement().getName());
		stack.pop();
		DFS(grafo,j,f);
		
		return newOrder;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}