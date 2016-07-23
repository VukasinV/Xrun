package framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {
	protected double x;
	protected double y;
	protected double velX;
	protected double velY;
	protected boolean falling = true;
	protected boolean jumping = false;
	
	protected ObjectId id;
	
	public GameObject(double x, double y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(LinkedList<GameObject> objectList);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

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

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
