package tortue;

import java.awt.Graphics2D;
import java.util.Stack;


public class Tortue implements InterfaceTortue{
	
	private Point position;
	private int longueurTrait;
	private Stack<Point> pile_xy;
	private double angle;
	private Graphics2D g2d;
	

	//private static final int LONGUEUR_TRAIT_DFT=50;
	private static final double ANGLE_DFT=270;
	private static final Point POSITION_DFT=new Point(100,800,ANGLE_DFT);
	
	public Tortue(Point position,/* int longueurTrait,*/ double angle, Graphics2D g2d) {
		this.position = position;
		//this.longueurTrait = longueurTrait;
		this.pile_xy = new Stack<Point>();
		this.angle = angle;
		this.g2d=g2d;
		this.position.setAngle(this.angle);
	}
	public Tortue(Graphics2D g2d) {
		this(POSITION_DFT,/*LONGUEUR_TRAIT_DFT,*/ANGLE_DFT,g2d);
	}

	
	
	
	public Point getPosition() {
		return position;
	}
	/*public int getLongueurTrait() {
		return longueurTrait;
	}*/
	public Stack<Point> getPile_xy() {
		return pile_xy;
	}
	public double getAngle() {
		return this.angle;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	/*public void setLongueurTrait(int longueurTrait) {
		this.longueurTrait = longueurTrait;
	}*/
	public void setPile_xy(Stack<Point> pile_xy) {
		this.pile_xy = pile_xy;
	}
	public void setAngle(double angle) {
		this.angle = angle;
		this.position.setAngle(this.angle);
	}
	
	public Point positionFuture(int distance) {
		 double newX =this.position.getX() + distance * Math.cos(Math.toRadians(angle));
		 double newY =this.position.getY() + distance * Math.sin(Math.toRadians(angle));
		 return new Point((int)newX,(int)newY,angle);
	}
	
	@Override
	public void avancerSansTracer(int longueurTrait) {//f
		this.position=this.positionFuture(longueurTrait);
		
	}
	@Override
	public void avancerEtTracer(int longueurTrait) {//F
		Point newPosition=this.positionFuture(longueurTrait);
		this.g2d.drawLine(this.position.getX(), this.position.getY(), newPosition.getX(), newPosition.getY());
		this.position=newPosition;
	}
	@Override
	public void tourner(double angleSymbole) {//-
		this.angle = (this.angle + angleSymbole)%360;
		this.position.setAngle(this.angle);

	}
	@Override
	public void stay() {//alphabets -> constantes
	}
	
	@Override
	public void sauverPosition() {// [
		this.pile_xy.push(this.position);
	}
	@Override
	public void restaurerPosition() { // ]
		this.position=this.pile_xy.pop();
		this.angle=this.position.getAngle();
	}
	public Graphics2D getG2d() {
		return g2d;
	}
	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}


	
	
	

	

}
