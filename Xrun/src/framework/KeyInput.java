package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import window.Handler;

public class KeyInput extends KeyAdapter {

	Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ObjectId.Player) {
				if (key == KeyEvent.VK_D) {
					tempObj.setVelX(5);
				}
				if (key == KeyEvent.VK_A) {
					tempObj.setVelX(-5);
				}
				if (key == KeyEvent.VK_SPACE && !tempObj.isJumping()) {
					tempObj.setJumping(true);
					tempObj.setVelY(-10);
				}
			}

			if (key == KeyEvent.VK_ESCAPE) {
				System.exit(1);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ObjectId.Player) {
				if (key == KeyEvent.VK_D) {
					tempObj.setVelX(0);
				}
				if (key == KeyEvent.VK_A) {
					tempObj.setVelX(0);
				}
				if (key == KeyEvent.VK_SPACE) {
					tempObj.setVelX(0);
				}
			}
		}
	}
}
