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
		espa�a.put(0, (new Vertice("Coru�a",87,63)));
		espa�a.put(1, (new Vertice("Vigo",65,126)));
		espa�a.put(2, (new Vertice("Valladolid",223,168)));
		espa�a.put(3, (new Vertice("Madrid",283,234)));
		espa�a.put(4, (new Vertice("Badajoz",128,320)));
		espa�a.put(5, (new Vertice("Ja�n",256,356)));
		espa�a.put(6, (new Vertice("Sevilla",176,416)));
		espa�a.put(7, (new Vertice("C�diz",144,470)));
		espa�a.put(8, (new Vertice("Granada",282,426)));
		espa�a.put(9, (new Vertice("Murcia",397,381)));
		espa�a.put(10, (new Vertice("Albacete",367,307)));
		espa�a.put(11, (new Vertice("Valencia",436,286)));
		espa�a.put(12, (new Vertice("Barcelona",523,177)));
		espa�a.put(13, (new Vertice("Gerona",572,127)));
		espa�a.put(14, (new Vertice("Zaragoza",400,164)));
		espa�a.put(15, (new Vertice("Bilbao",323,65)));
		espa�a.put(16, (new Vertice("Oviedo",196,63)));
		for(int i=0;i<espa�a.edges.length;i++){
			for(int j=0; j<espa�a.edges.length;j++){
				if(espa�a.edges[i][j]>0){
					Arista a = new Arista(espa�a.edges[i][j],espa�a.get(i),espa�a.get(j));
					Vertice v = espa�a.get(j);
					espa�a.get(i).aristas.addFirst(new Node<Vertice>(v));
					espa�a.aristas.add(new Node<Arista>(a));
				}
			}
		}
	}
	public void fill(){
		edges[0][1]=171;
		edges[0][2]=455;
		
		edges[1][0]=171;
		edges[1][2]=356;
		
		edges[2][0]=455;
		edges[2][1]=356;
		edges[2][3]=193;
		edges[2][15]=280;

		edges[3][2]=193;
		edges[3][4]=403;
		edges[3][5]=335;
		edges[3][10]=251;
		edges[3][14]=325;
		edges[3][15]=395;
		
		edges[4][3]=403;
		
		edges[5][3]=335;
		edges[5][6]=242;
		edges[5][8]=99;
		
		edges[6][5]=242;
		edges[6][7]=125;
		edges[6][8]=256;
		
		edges[7][6]=125;
		
		edges[8][5]=99;
		edges[8][6]=256;
		edges[8][9]=278;
		
		edges[8][5]=99;
		edges[8][6]=256;
		edges[8][9]=278;
		
		edges[9][8]=278;
		edges[9][10]=150;
		edges[9][11]=241;
		
		edges[10][3]=251;
		edges[10][9]=150;
		edges[10][11]=191;
		
		edges[11][9]=241;
		edges[11][10]=191;
		edges[11][12]=349;
		
		edges[12][11]=349;
		edges[12][13]=100;
		edges[12][14]=296;
		
		edges[13][12]=100;
		
		edges[14][3]=325;
		edges[14][12]=296;
		edges[14][15]=324;
		
		edges[15][2]=280;
		edges[15][3]=395;
		edges[15][14]=324;
		edges[15][16]=304;
		
		edges[16][15]=304;
	}
	
	
	public void drawEdges(){
		
	}
	

}