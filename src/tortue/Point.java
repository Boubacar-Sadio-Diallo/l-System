package tortue;

/**
 * Classe représentant une coordonnée ainsi que son angle
 */
public class Point {
	private int x;
	private int y;
	private double angle;

	/**
	 * Crée une insatnce de Point
	 * @param x abscisse
	 * @param y ordonnée
	 * @param angle angle de position
	 */
	public Point(int x,int y,double angle) {
		this.x=x;
		this.y=y;
		this.angle=angle;
	}

	/**
	 * Getter d'abscisse
	 * @return l'abscisse
	 */
	public int getX() {
		return x;
	}
	/**
	 * Getter d'ordonnée
	 * @return l'ordonnée
	 */
	public int getY() {
		return y;
	}

	/**
	 * Modifie l'abscisse
	 * @param x nouvel abscisse
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Modifie l'ordonnée
	 * @param y nouvelle ordonnée
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Getter de l'angle de position
	 * @return L'angle
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Setter de l'angle de position
	 * @param angle nouvel angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * Renvoie une représentation d'une position
	 * @return Représentation du point
	 */
	@Override
	public String toString() {
		return "("+this.x+","+this.y+"), angle : "+this.angle;
	}
	

}
