package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Spear extends Objects.Object{

	private static final long serialVersionUID = 1L;
	
	public Random generator;

	public Spear(int x, int y, int width, int height, float speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
		
		generator = new Random();
		
	}

	public void movement() {
		
		this.x = (int) (this.x - this.speed);
		
		if(this.x <= 0 - this.width) {
			
			this.y = this.generator.nextInt(100) + 300;

			this.x = 800;
			
			
		}
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.orange);
		
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.gray);
		
		g.drawRect(x, y, width, height);
		
		g.setColor(Color.red);
		
		g.fillRect(x+5, y+3, width-10, height-5);
		
	}
}
