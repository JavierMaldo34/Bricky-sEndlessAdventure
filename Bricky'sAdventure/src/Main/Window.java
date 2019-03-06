package Main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import Inputs.KeyManager;
import Inputs.MouseManager;

public class Window{
	
	private static final long serialVersionUID = 1L;
	
	public Canvas canvas;

	public KeyManager keyManager;
	
	public MouseManager mouseManager;
	
	public JFrame frame;
	
	public boolean game, menu, dead;
	
	public int finalScore;
	
	public Window(int width, int height, String title) {
		
		game = false;
		menu = true;
		dead = false;
		
		
		frame = new JFrame(title);
		
		//Initializing Components
		
		this.canvas = new Canvas();
		
		this.keyManager = new KeyManager();
		
		this.mouseManager = new MouseManager();
		
		//Adding to Frame
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Dimension canvasDim = new Dimension(width,height);
		
		canvas.setPreferredSize(canvasDim);
		
		canvas.setMaximumSize(canvasDim);
		
		canvas.setMinimumSize(canvasDim);
		
		canvas.setFocusable(false);
		
		frame.add(canvas);
		
		frame.addKeyListener(keyManager);
		
		frame.addMouseListener(mouseManager);
		
		frame.pack();
		frame.setFocusable(true);
		
	}
	
	public void renewal() {
		
		
		this.keyManager.renew();
		
		
	}

	public boolean isGame() {
		return game;
	}

	public void setGame(boolean game) {
		this.game = game;
	}

	public boolean isMenu() {
		return menu;
	}

	public void setMenu(boolean menu) {
		this.menu = menu;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	
}
