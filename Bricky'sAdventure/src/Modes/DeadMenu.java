package Modes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Main.Window;

public class DeadMenu {
	
	public Window window;
	
	public DeadMenu(Window window) {
		
		this.window = window;
		
		
		
		
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, 900, 900);
	
		g.setColor(Color.gray);
		
		g2d.fillRect(80, 100, 650, 600);
		
		g.setColor(Color.pink);
		
		g2d.fillRect(105, 100, 600, 600);
		
		g.setColor(Color.gray);
		
		g.fillRoundRect(80, 5, 650, 200, 200, 200);
		
		g.setColor(Color.pink);
		
		g.fillRoundRect(90, 15, 630, 180, 200, 200);
		
		g.setColor(Color.BLACK);
		
		Font font = new Font("arial", 1, 40);
		
		g2d.setFont(font);
		
		g2d.drawString("GAME OVER", 270, 100);
		
		g2d.drawString("SCORE: ", 245, 300);
		
		g2d.drawString("PRESS E TO RETRY", 210, 500);

		g2d.drawString("-----------------------------", 210, 530);
		
		g2d.drawString(String.valueOf(this.window.finalScore), 420, 300);
		
	}
	
	public void renew() {
		
		if(window.keyManager.interact) {
			
			window.setGame(true);
			window.setDead(false);
			
			
		}
		
		
		
	}

}
