package window;

import java.awt.Graphics;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import gameObjects.Block;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<>();

	private GameObject tempObject;

	public void tick() {

		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);

			tempObject.tick(object);
		}
	}

	public void render(Graphics g) {

		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);

			tempObject.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

	// Creating a temporary level with blocks for testing purposes
	public void createLevel() {
		// Create Bottom Section
		for (int x = 0; x < Game.WIDTH * 2; x += 32) {
			addObject(new Block(x, Game.HEIGHT - 32, ObjectId.Block));
		}
		// Second row of block for jumping
		for (int x = 200; x < 600; x += 32) {
			addObject(new Block(x, 400, ObjectId.Block));
		}
		// Create Left Section
		for (int y = 0; y < Game.HEIGHT + 32; y += 32) {
			addObject(new Block(0, y, ObjectId.Block));
		}
	}
}
