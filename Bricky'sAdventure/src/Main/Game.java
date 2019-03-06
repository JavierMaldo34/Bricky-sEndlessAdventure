package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Modes.DeadMenu;
import Modes.GameMode;
import Modes.MenuMode;

public class Game implements Runnable{

	private Thread thread; 
	
	private boolean run = false;
	
	private Graphics graphics;
	
	private BufferStrategy buffer;
	
	public Window window = new Window(800, 600, "Bricky");
	
	public GameMode game = new GameMode(window);
	
	public MenuMode menu = new MenuMode(window);
	
	public DeadMenu dead = new DeadMenu(window);
	
	public boolean gameMode, deadMode, menuMode;
	
	public Game() {
		
		this.menuMode = true;
		this.gameMode = false;
		this.deadMode = false;
	
	}
	
	public void renewal() {
		
		
		
		if(menuMode) {
			
			menu.renew();
			
		}
		
		this.window.renewal();
		
		if(deadMode) {
			
			this.dead.renew();
			
			if(window.keyManager.interact) {
				
				game = new GameMode(window);
			
			}
		}
		
		this.deadMode = this.window.dead;
		this.gameMode = this.window.game;
		this.menuMode = this.window.menu;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int fps = 60;
		
		double timePerTick = 1000000000 / fps;
		
		double delta = 0;
		
		long now;
		
		long lastTime = System.nanoTime();
		
		long timer = 0;
		
		int ticks  = 0;
		
		while(run) {
			
			now = System.nanoTime();
			
			delta = delta + ( now -lastTime) / timePerTick;
			
			timer = timer + now - lastTime;
			
			lastTime = now;

			if(delta >= 1) {	

				game.renew();
				
				this.renewal();

				this.draw();
				ticks++;

				delta--;

			}
			if(timer >= 1000000000) {

				ticks = 0;
				timer = 0;
			}



		}

		end();    

	}

	public void begin() {

		if(run) { return; }

		run = true;

		thread = new Thread(this);

		thread.start();

	}

	public void end() {

		if(!run) { return; }

		run = false;

		try {

			thread.join();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}	

	}	


	public void draw() {



		buffer = window.canvas.getBufferStrategy();

		if(buffer == null) {

			window.canvas.createBufferStrategy(3);

			return;
		}

		graphics = buffer.getDrawGraphics();
		
		graphics.clearRect(0, 0, 800, 600);
		
		if(gameMode) {
		
			game.draw(graphics);
		
		}
		
		if(menuMode) {
			
			menu.draw(graphics);
			
		}
		
		if(deadMode) {
			
			dead.draw(graphics);
			
			
		}
			
		buffer.show();
		graphics.dispose();
		
	}

	public boolean isGameMode() {
		return gameMode;
	}

	public void setGameMode(boolean gameMode) {
		this.gameMode = gameMode;
		this.window.game = gameMode;
	}

	public boolean isDeadMode() {
		return deadMode;
	}

	public void setDeadMode(boolean deadMode) {
		this.deadMode = deadMode;
		this.window.dead = deadMode;
	}

	public boolean isMenuMode() {
		return menuMode;
	}

	public void setMenuMode(boolean menuMode) {
		this.menuMode = menuMode;
		this.window.menu = menuMode;
	}
	
	
	
	

}
