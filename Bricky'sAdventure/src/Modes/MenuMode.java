package Modes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Buttons.MenuPlayButton;
import Main.Window;

public class MenuMode {
	
	public Window window;
	
	public Font font;
	
	public MenuPlayButton buttonPlay;
	
	
	public MenuMode(Window window) {
		
		this.window = window;
		
		buttonPlay = new MenuPlayButton(250,300,100,100, this.window);
		
		font = new Font("arial", 1, 40);
		
		buttonPlay.selected = true;
		
		
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.pink);
		
		g.fillRect(0, 0, 800,200);
		
		g.setColor(Color.GRAY);
		
		g.fillRect(25, 25, 750, 150);
		
		g.setColor(Color.black);
		
		g.fillRect(50, 50, 700, 100);
		
		g.setFont(font);
	
		g.setColor(Color.pink);
		
		g.drawString("Bricky's Endless Adventure", 150, 120);
		
		g.setColor(Color.BLACK);
		
		g.fillRect(0,200,800, 700);
		
		//g.setColor(Color.pink);
		
		//g.fillRoundRect(250, 300, 300, 100, 10, 10);
		
		g.setColor(Color.pink);
		
		g.drawString("PRESS E TO PLAY!", 210, 365);
		
	}
	
	public void renew() {
		
		
		
		if(window.menu) {
			
			if(this.buttonPlay.selected) {
		
				buttonPlay.renew();
			
			}
			
		}
	}

}
