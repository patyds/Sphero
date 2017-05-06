package grafos;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Arista {
	private int weigth;
	private Vertice v1,v2;
	
	
	public Arista(int weigth, Vertice v1, Vertice v2) {
		this.weigth = weigth;
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public void drawA(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawLine(v1.getX()+13, v1.getY()+13, v2.getX()+13, v2.getY()+13);
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
