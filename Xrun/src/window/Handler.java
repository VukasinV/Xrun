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

	public void createLevel() {
		// Create Bottom Section
		for (int x = 0; x <= Game.WIDTH; x += 32) {
			addObject(new Block(x, Game.HEIGHT - 32, ObjectId.Block));
		}
		// Create Left Section
		for (int y = 0; y <= Game.HEIGHT - 36; y += 32) {
			addObject(new Block(0, y, ObjectId.Block));
		}
		// Create Right Section
		for (int y = 0; y <= Game.HEIGHT - 36; y += 32) {
			addObject(new Block(Game.WIDTH - 32, y, ObjectId.Block));
		}

	}
}
