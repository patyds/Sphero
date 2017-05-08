package grafos;

import ds.Node;
import ds.Queue;

public class Espa�a<K, D> extends Grafo<K, D>{
	public Queue<Arista> aristas = new Queue<Arista>();
	public Espa�a(int size) {
		super(size);
		fillEdges();
		fill();;
		
	}
	
	public void fillCarreterras(Espa�a<Integer, Vertice> espa�a){
		espa�a.put(5, (new Vertice("Coru�a",87,63)));
		espa�a.put(15, (new Vertice("Vigo",65,156)));
		espa�a.put(14, (new Vertice("Valladolid",223,168)));
		espa�a.put(9, (new Vertice("Madrid",303,234)));
		espa�a.put(1, (new Vertice("Badajoz",128,320)));
		espa�a.put(8, (new Vertice("Ja�n",276,356)));
		espa�a.put(12, (new Vertice("Sevilla",199,436)));
		espa�a.put(4, (new Vertice("C�diz",124,470)));
		espa�a.put(7, (new Vertice("Granada",322,446)));
		espa�a.put(10, (new Vertice("Murcia",447,381)));
		espa�a.put(0, (new Vertice("Albacete",387,307)));
		espa�a.put(13, (new Vertice("Valencia",506,286)));
		espa�a.put(2, (new Vertice("Barcelona",573,177)));
		espa�a.put(6, (new Vertice("Gerona",632,127)));
		espa�a.put(16, (new Vertice("Zaragoza",420,164)));
		espa�a.put(3, (new Vertice("Bilbao",343,65)));
		espa�a.put(11, (new Vertice("Oviedo",196,63)));
		for(int i=0;i<espa�a.edges.length;i++){
			for(int j=0; j<espa�a.edges.length;j++){
				if(espa�a.edges[i][j]>0){
					Arista a = new Arista(espa�a.edges[i][j],espa�a.get(i),espa�a.get(j));
					Vertice v = espa�a.get(j);
					espa�a.get(i).aristas.addLast(new Node<Vertice>(v));
					espa�a.aristas.add(new Node<Arista>(a));
				}
			}
		}
	}
	public void fill(){
		edges[0][9]=251;
		edges[0][10]=150;
		edges[0][13]=191;
		
		edges[1][9]=403;
		
		edges[2][6]=100;
		edges[2][13]=349;
		edges[2][16]=296;

		edges[3][9]=325;
		edges[3][11]=304;
		edges[3][14]=280;
		edges[3][16]=324;
		
		edges[4][12]=125;
		
		edges[5][14]=455;
		edges[5][15]=171;
		
		edges[6][2]=100;
		
		edges[7][8]=99;
		edges[7][10]=278;
		edges[7][12]=256;
		
		edges[8][7]=99;
		edges[8][9]=335;
		edges[8][12]=242;
		
		edges[9][0]=251;
		edges[9][1]=403;
		edges[9][3]=325;
		edges[9][8]=335;
		edges[9][14]=193;
		edges[9][16]=325;
		
		edges[10][0]=150;
		edges[10][7]=278;
		edges[10][13]=241;
		
		edges[11][3]=304;
		
		edges[12][4]=125;
		edges[12][7]=256;
		edges[12][8]=242;
		
		edges[13][0]=191;
		edges[13][2]=349;
		edges[13][10]=241;
		
		edges[14][3]=280;
		edges[14][5]=455;
		edges[14][9]=193;
		edges[14][15]=356;
		
		edges[15][5]=171;
		edges[15][14]=356;
		
		edges[16][2]=296;
		edges[16][3]=324;
		edges[16][9]=325;
	}
	
	
	public void drawEdges(){
		
	}
	

}