package grafos;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ds.DoubleLinkList;

public class Vertice {
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	public DoubleLinkList<Vertice> aristas;
	private boolean visited;
	
	public Vertice(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		width = 26;
		height = 26;
		visited=false;
		aristas=new DoubleLinkList<Vertice>();
	}
	
	public void drawV(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
		
	}
	public void Visited(Graphics g){
		g.setColor(Color.red);
		g.fillOval(x, y, width, height);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.black);
		g2.drawOval(x, y, width, height);
		
	}
	public void drawO(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.black);
		g2.drawOval(x, y, width, height);
	}
	public void drawName(Graphics g){
		g.setColor(Color.black);
		g.drawString(name, x, y-5);
		
	}
	public void draw(Graphics g){
		drawName(g);
		drawV(g);
		drawO(g);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return height;
	}
	public void setLength(int length) {
		this.height = length;
	}

	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	
	

}
