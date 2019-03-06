package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Floor extends Object{

	private static final long serialVersionUID = 1L;
	
	public int speedMult = 0;

	public Floor(int x, int y, int width, int height, float speed) {
		super(x, y, width, height, speed);
		
	}
	
	public void move() {
		
		this.x = (int) ((int) this.x - (this.speed + this.speed * this.speedMult));
		
	}
	
	public void draw(Graphics g) {
		
		
			g.setColor(Color.GRAY);
			g.fillRect(this.x, this.y, this.width, this.height);
			g.setColor(Color.black);
			g.drawRect(this.x, this.y+5, this.width, this.height);
			g.drawRect(this.x, this.y+10, this.width, this.height);
			g.drawRect(this.x, this.y+15, this.width, this.height);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(x, y+70, width, height);
			g.setColor(Color.black);
			g.fillRect(x, y+90, width, height);


			
			
			
		
	}

}
