package games.space_invader;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Space Invader.
 * 
 * This is the Bullet class.
 * 
 * @author bambrow
 *
 */

public class Bullet implements ISpaceInvador{

	private double rx;
	private double ry;
	private double vx;
	private double vy;
	private final double radius;

	/**
	 * initiator.
	 * @param rx
	 * @param ry
	 */
	public Bullet(double rx, double ry) {
		this.rx = rx;
		this.ry = ry;
		this.vx = 0.02;
		this.vy = 0;
		this.radius = 0.005;
	}
	
	/**
	 * initiator.
	 * @param rx
	 * @param ry
	 * @param vx
	 * @param vy
	 */
	public Bullet(double rx, double ry, double vx, double vy) {
		this.rx = rx;
		this.ry = ry;
		this.vx = vx;
		this.vy = vy;
		this.radius = 0.005;
	}
	
	/**
	 * update the position of bullet.
	 */
	public void update() {
		rx += vx;
		ry += vy;
	}

	/**
	 * draw the bullet.
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledCircle(rx, ry, radius);
	}

	/**
	 * getters and setters.
	 */
	public double getRx() {
		return rx;
	}

	public double getRy() {
		return ry;
	}

	public double getVx() {
		return vx;
	}

	public double getVy() {
		return vy;
	}

	public double getRadius() {
		return radius;
	}
	
}
