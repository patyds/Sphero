package grafos;
import java.awt.Color;
import java.awt.Graphics;

public class Arista {
	private int weigth;
	private Vertice v1,v2;
	
	
	public Arista(int weigth, Vertice v1, Vertice v2) {
		this.weigth = weigth;
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public void drawA(Graphics g){
		g.setColor(Color.BLACK);
		g.drawLine(v1.getX()+15, v1.getY()+15, v2.getX()+15, v2.getY()+15);
	}
	public void drawWeight(Graphics g){
		g.setColor(Color.black);
		g.drawString(String.valueOf(weigth), (v1.getX()+v2.getX())/2,  (v1.getY()+v2.getY())/2);
	}
	public void draw(Graphics g){
		drawA(g);
		drawWeight(g);
	}
	
	public int getWeigth() {
		return weigth;
	}
	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}
	public Vertice getV1() {
		return v1;
	}
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}
	public Vertice getV2() {
		return v2;
	}
	public void setV2(Vertice v2) {
		this.v2 = v2;
	} 
}
