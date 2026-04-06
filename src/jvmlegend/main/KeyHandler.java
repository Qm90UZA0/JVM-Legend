package jvmlegend.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean leftPressed, rightPressed;
	public boolean isJumping = false, startJumping = false;

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (!isJumping && code == KeyEvent.VK_K) {
			startJumping = true;
		}
		
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		else if (code == KeyEvent.VK_D) {
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		else if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}
}
