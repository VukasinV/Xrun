package window;

import framework.GameObject;

public class Camera {
	private double x;
	private double y;
	
	public Camera(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick (GameObject player) {
		x--;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	
}
