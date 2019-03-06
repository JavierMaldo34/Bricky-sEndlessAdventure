package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	
	public boolean[] keys;
	
	public boolean up, down, left, right, interact;
	
	public KeyManager () {
		
		keys = new boolean[256];
		
		
		
	}
	
	public void renew() {
		

		
		up = keys[KeyEvent.VK_W];
		
		down = keys[KeyEvent.VK_S];
		
		right = keys[KeyEvent.VK_D];
		
		left  = keys[KeyEvent.VK_A];
		
		interact = keys[KeyEvent.VK_E];

	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keys[arg0.getKeyCode()] = true;

		return;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keys[arg0.getKeyCode()] = false;

		return;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
