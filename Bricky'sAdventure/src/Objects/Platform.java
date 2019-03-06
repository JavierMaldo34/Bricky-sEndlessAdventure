package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Rects.Point;

public class Platform extends Objects.Object{

	private static final long serialVersionUID = 1L;
	
	public Random generator;


	public Platform(int x, int y, int width, int height, float speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
		
		
		
		generator = new Random();
		this.y = this.generator.nextInt(100) + 400;
		
	}
	
	public void draw(Graphics g) {
		
		
		
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
		g.setColor(Color.green);
		g.fillRect(x+5, y+5, width - 10, height-10);
		g.setColor(Color.BLACK);
		g.fillRect(x+8, y+7, width - 15, height-15);
		g.setColor(Color.GREEN);
		g.fillRect(x+10, y+9, width-18, height-19);
		
	}
	
	public void movement() {
		
		
		this.x = (int) (this.x - this.speed);
		
		if(this.x <= 0 - this.width) {
			
			this.y = this.generator.nextInt(100) + 250;

			this.x = 800;
			
			
		}
		
		bottomLeft = new Point(this.x, this.y + this.height);
		
		topRight = new Point (this.x + this.width, this.y);
	}
	
	
	

}
