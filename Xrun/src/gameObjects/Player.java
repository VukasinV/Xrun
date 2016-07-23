package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import window.Handler;

public class Player extends GameObject {

	private static final double MAX_SPEED = 10;
	private double height = 96;
	private double width = 48;
	private double gravity = 0.5;
	private Handler handler;

	public Player(double x, double y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;

		if (falling || jumping) {
			velY += gravity;
			if (velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
		Collision(object);
	}

	private void Collision(LinkedList<GameObject> object) {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ObjectId.Block) {
				if (this.getBoundsTop().intersects(tempObj.getBounds())) {
					y = tempObj.getY() + 32;
					velY = 0;
				}
				if (this.getBounds().intersects(tempObj.getBounds())) {
					y = tempObj.getY() - height;
					velY = 0;
					jumping = false;
					falling = false;
				} else {
					falling = false;
				}
				//Right
				if (this.getBoundsRight().intersects(tempObj.getBounds())) {
					y = tempObj.getX() - width;
					velY = 0;
				}
				//Left
				if (this.getBoundsLeft().intersects(tempObj.getBounds())) {
					y = tempObj.getX() + 40;
					velY = 0;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, (int) width, (int) height);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int) x + (width / 4)), (int) ((int) y + (height / 2)), (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int) x + (width / 4)), (int) y, (int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

}
