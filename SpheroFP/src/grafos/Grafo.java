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
	Queue<Vertice> queue = new Queue<Vertice>();
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
		Node<Vertice> aux = ar.getLast();
		boolean notsaved = true;
		for(int h=(int) ar.getSize();h>0;h--){
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
			//System.out.println(stack.getFirst().getElement().getName());
			aux=aux.getPrev();
		}
		System.out.println(stack.getFirst().getElement().getName());
		newOrder.add(new Node<Vertice>(stack.getFirst().getElement()));
		//System.out.println(newOrder.getLast().getElement().getName());
		int j;
		for(j=0;j<grafo.getSize();j++){
			if(grafo.get(f).getName().equals(stack.getFirst().getElement().getName())){
				clearStack(stack);
				//System.out.println(stack.getSize());
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
	
	public Queue<Vertice> BFS(Grafo<Integer, Vertice> grafo, int i, int f){
		Vertice v = grafo.get(i);
		v.setVisited(true);
		DoubleLinkList<Vertice> ar = v.aristas;
		Node<Vertice> aux = ar.getFirst();
		boolean notsaved = true;
		for(int h=0;h<ar.getSize();h++){
			if(!aux.getElement().isVisited()){
				notsaved=true;
				if(queue.getSize()>0){
					Node<Vertice> temp = queue.getFirst();
					for(int a=0;a<queue.getSize();a++){
						if(temp.getElement().getName().equals(aux.getElement().getName())){
							notsaved= false;
							break;
						}
						temp=temp.getNext();
					}
				}
				if(notsaved){
					queue.add(new Node<Vertice>(aux.getElement()));
				}
			}
		aux=aux.getNext();
		}
		System.out.println("1 "+queue.getFirst().getElement().getName());
		newOrder.add(new Node<Vertice>(queue.getFirst().getElement()));
		//System.out.println(newOrder.getLast().getElement().getName());
		int j;
		for(j=0;j<grafo.getSize();j++){
			if(grafo.get(f).getName().equals(queue.getFirst().getElement().getName())){
				clearQueue(queue);
				return newOrder;
			}
			if(grafo.get(j).getName().equals(queue.getFirst().getElement().getName())){
				break;
			}
		}
		//System.out.println(stack.getFirst().getElement().getName());
		queue.remove();
		BFS(grafo,j,f);
		clearV(grafo);
		return newOrder;
	}
	
	public void Dijkstra(España<Integer,Vertice> grafo,int cur){
		grafo.get(cur).setCost(0);
		Vertice v = grafo.get(cur);
		v.setVisited(true);
		DoubleLinkList<Vertice> ar = v.aristas;
		Node<Vertice> aux = ar.getFirst();
		for(int h=0;h<ar.getSize();h++){
			Node<Arista> temp = grafo.aristas.getFirst();
			for(int b=0;b<grafo.aristas.getSize();b++){
				if(temp.getElement().getV1().getName().equals(v.getName()) && temp.getElement().getV2().getName().equals(aux.getElement().getName())){
					if(aux.getElement().getCost() > v.getCost()+temp.getElement().getWeigth()){
						aux.getElement().setCost(v.getCost()+temp.getElement().getWeigth());
					}
				}
				temp=temp.getNext();
			}
		aux=aux.getNext();
		}
		Vertice min = minVertice(ar);
		newOrder.add(new Node<Vertice>(min));
	}
	
	public void computePaths(España<Integer,Vertice> grafo,int cur){
		Vertice source = grafo.get(cur);
		source.setCost(0);
		PriorityQueue<Vertice> vertexQueue = new PriorityQueue<Vertice>();
		 vertexQueue.add(source);
		 while (!vertexQueue.isEmpty()) {
		        Vertice u = vertexQueue.poll();
		       // System.out.println("Current "+u.getName());
		        DoubleLinkList<Vertice> ar = u.aristas;
				Node<Vertice> aux = ar.getFirst();
				 //System.out.println(grafo.aristas.getSize());
				for(int h=0;h<ar.getSize();h++){
					//System.out.println("veicino "+aux.getElement().getName());
					Node<Arista> temp = grafo.aristas.getFirst();
					for(int b=0;b<grafo.aristas.getSize();b++){
						if(temp.getElement().getV1().getName().equals(u.getName()) && temp.getElement().getV2().getName().equals(aux.getElement().getName())){
							if(aux.getElement().getCost() > u.getCost()+temp.getElement().getWeigth()){
								//System.out.println(aux.getElement().getCost()+" "+(u.getCost()+temp.getElement().getWeigth()));
								vertexQueue.remove(aux.getElement());
								aux.getElement().setCost(u.getCost()+temp.getElement().getWeigth());
								aux.getElement().setPrev(u);
								Vertice n = aux.getElement();
								vertexQueue.add(n);
								//System.out.println(n.getPrev().getName());
							}
						}
						temp=temp.getNext();
					}
					
					aux=aux.getNext();
				}
		 }
		 //System.out.println("fin");
	}
	
	public Stack<Vertice> shortestPath(España<Integer,Vertice> grafo,int fin){
		// System.out.println("inicio");
		Vertice target =grafo.get(fin);
		Stack<Vertice> shortest = new Stack<Vertice>();
		while(target!=null){
			
				shortest.push(new Node<Vertice>(target));
				 //System.out.println(shortest.getFirst().getElement().getName());
			
			target=target.getPrev();
		}
		return shortest;
	}
	public Vertice minVertice(DoubleLinkList<Vertice> ar){
		Vertice min =ar.getFirst().getElement();
		Node<Vertice> aux = ar.getFirst();
		for(int h=0;h<ar.getSize();h++){
			Node<Vertice> temp = ar.getFirst();
			for(int d=1;d<ar.getSize()-1;d++){
				if(temp.getElement().getCost()<min.getCost()){
					min=temp.getElement();
				}
			temp=temp.getNext();
			}
		aux=aux.getNext();
		}
		return min;
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