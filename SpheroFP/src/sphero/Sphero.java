package sphero;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ds.DoubleLinkList;
import ds.Node;
import ds.Queue;

public class Sphero {
	private int x;
	private int y;
	private int id;
	private int angleR;
	private int angleG=0;
	private int tangle;
	private Image image;
	private int axis=0;
	public Queue<String> queue = new Queue<>();
	public Queue<Line> lines = new Queue<Line>();
	
	public Sphero(int id, int x, int y, String SpheroImage) {
		super();
		this.x = x;
		this.y = y;
		this.id = id;
		try {
			image= ImageIO.read(this.getClass().getResource(SpheroImage));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void paintSphero(Graphics g){
		g.drawImage(image,x,y,50,50, null);
		if(lines.getSize()>0){
			Node<Line> aux = lines.getFirst();
			for(int i=0;i<lines.getSize();i++){
				Line ln = aux.getElement();
				
					g.drawLine(ln.getBx(), ln.getBy(), ln.getX(), ln.getY());
				
				aux=aux.getNext();
			}
		}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public int getAngleR() {
		return angleR;
	}

	public void setAngleR(int angleR) {
		this.angleR = angleR;
	}

	public int getAngleG() {
		return angleG;
	}

	public void setAngleG(int angleG) {
		this.angleG = angleG;
	}

	public int getAxis() {
		return axis;
	}

	public void setAxis(int axis) {
		this.axis = axis;
	}

	public int getTangle() {
		return tangle;
	}

	public void setTangle(int tangle) {
		this.tangle = tangle;
	}

	
	
}
