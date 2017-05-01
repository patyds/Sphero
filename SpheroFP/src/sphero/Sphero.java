package sphero;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ds.Queue;

public class Sphero {
	private int x;
	private int y;
	private int id;
	private int angle;
	private int tangle;
	private Image image;
	private int axis=0;
	private int by;
	private int bx;
	public Queue<String> queue = new Queue<>();
	
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
		if(y==0){
			g.drawLine(0, 25, x, 25);
		}else{
			g.drawLine(bx, by, x, y);
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
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getTangle() {
		return tangle;
	}

	public void setTangle(int tangle) {
		this.tangle = tangle;
	}

	public int getAxis() {
		return axis;
	}

	public void setAxis(int axis) {
		this.axis = axis;
	}

	public int getBy() {
		return by;
	}

	public void setBy(int by) {
		this.by = by;
	}

	public int getBx() {
		return bx;
	}

	public void setBx(int bx) {
		this.bx = bx;
	}
	
	
}
