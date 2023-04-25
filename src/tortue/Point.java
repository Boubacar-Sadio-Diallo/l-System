package tortue;

public class Point {
	private int x;
	private int y;
	private double angle;
	public Point(int x,int y,double angle) {
		this.x=x;
		this.y=y;
		this.angle=angle;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	

}
