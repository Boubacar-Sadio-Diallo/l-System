package tortue;

import java.awt.*;
import java.util.Stack;

/**
 * Classe représentant une tortue qui dessine
 */
public class Tortue implements InterfaceTortue{

	private Point position;
	private int longueurTrait;
	private Stack<Point> pile_xy;
	private double angle;
	//private Graphics2D g2d;
	private Graphics g2d;


	//private static final int LONGUEUR_TRAIT_DFT=50;
	private static final double ANGLE_DFT=0;
	private static final Point POSITION_DFT=new Point(20,600,ANGLE_DFT);

	/**
	 * Crée une instance de Tortue
	 * @param position Position de départ de la tortue
	 * @param angle angle de départ de la position
	 * @param g2d une instance de graphics pour dessiner
	 */
	public Tortue(Point position, double angle, Graphics g2d ) {
		this.position = position;
		this.pile_xy = new Stack<Point>();
		this.angle = angle;
		this.g2d=g2d;
		this.position.setAngle(this.angle);
	}

	public Tortue(Graphics g2d) {
		this(POSITION_DFT,ANGLE_DFT,g2d);
	}

	public Tortue(Point position,Graphics g2d){
		this(position, position.getAngle(), g2d);
	}

	/**
	 * Getter de la position actuelle
	 * @return La position actuelle
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Renvoie la pile de position sauvegardée
	 * @return La pile de position
	 */
	public Stack<Point> getPile_xy() {
		return pile_xy;
	}

	/**
	 * Renvoie l'angle de position actuelle
	 * @return L'angle de position actuelle
	 */
	public double getAngle() {
		return this.angle;
	}

	/**
	 * Modifie la position actuelle
	 * @param position La nouvelle position voulue
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Modifie la pile de Position
	 * @param pile_xy une pile de Point
	 */
	public void setPile_xy(Stack<Point> pile_xy) {
		this.pile_xy = pile_xy;
	}

	/**
	 * Modifie l'angle de la tortue
	 * @param angle nouvel angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
		this.position.setAngle(this.angle);
	}

	/**
	 * Renvoie la position du point d'arrivée pour une translation d'un certain angle et d'une certaine distance
	 * @param distance longueur de la translation
	 * @return Point de la coordonnée d'arrivée
	 */
	public Point positionFuture(int distance) {
		//Formule de calcule de coordonnée à partir d'un angle, d'une distance et d'un autre point
		double newX =Math.round((this.position.getX() + distance * Math.cos(Math.toRadians(angle)))*100.0)/100.0;
		double newY =Math.round((this.position.getY() + distance * Math.sin(Math.toRadians(angle)))*100.0)/100.0;
		return new Point((int)newX,(int)newY,angle);
	}

	/**
	 * Avance la tortue d'une longueur
	 * @param longueurTrait longueur d'avancement
	 */
	@Override
	public void avancerSansTracer(int longueurTrait) {//f
		this.position=this.positionFuture(longueurTrait);

	}

	/**
	 * Dessine un segment d'une certaine longueur
	 * @param longueurTrait longueur du segment
	 */
	@Override
	public void avancerEtTracer(int longueurTrait) {//F
		Point newPosition=this.positionFuture(longueurTrait);
		this.g2d.drawLine(this.position.getX(), this.position.getY(), newPosition.getX(), newPosition.getY());
		this.position=newPosition;
	}

	/**
	 * Incrémente l'angle de la tortue
	 * @param angleSymbole angle à ajouter
	 */
	@Override
	public void tourner(double angleSymbole) {//-
		this.angle = (this.angle + angleSymbole)%360;
		this.position.setAngle(this.angle);

	}

	/**
	 * Ne fais rien
	 */
	@Override
	public void stay() {//alphabets -> constantes
	}

	/**
	 * Ajoute la position actuelle à la pile
	 */
	@Override
	public void sauverPosition() {// [
		this.pile_xy.push(this.position);
	}

	/**
	 * Restaure la position sauvegardée dans la pile à la tortue
	 */
	@Override
	public void restaurerPosition() { // ]
		this.position=this.pile_xy.pop();
		this.angle=this.position.getAngle();
	}



}
