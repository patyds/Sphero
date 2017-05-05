package grafos;
import java.awt.Color;
import java.awt.Graphics;

public class Vertice {
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Vertice(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		width = 30;
		height = 30;
	}
	
	public void drawV(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
		
	}
	public void drawName(Graphics g){
		g.setColor(Color.black);
		g.drawString(name, x, y-15);
		
	}
	public void draw(Graphics g){
		drawName(g);
		drawV(g);
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

}
