package sphero;

public class Line {
	private int x;
	private int y;
	private int by;
	private int bx;
	
	public Line(int x, int y, int by, int bx) {
		this.x = x;
		this.y = y;
		this.by = by;
		this.bx = bx;
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
