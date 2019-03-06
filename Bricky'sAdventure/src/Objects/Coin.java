package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Coin extends Objects.Object{

	private static final long serialVersionUID = 1L;
	
	public boolean caught;
	
	public Random random = new Random();

	public Coin(int x, int y, int width, int height, float speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}
	
	public void movement() {
		
		this.x = (int) (x - speed);
		
	}
	
	public void reset() {
		
		if(this.x < -this.width) {
			
			caught = false;
			this.x = this.width + 800;
			this.y = random.nextInt(80)+300;
			
		}		
	}
	
	public void draw(Graphics g) {
		
		if(!caught) {
			
			Color darkYellow = new Color(198, 201, 0);
			g.setColor(Color.yellow);
			g.fillOval(x, y, width, height);
			g.setColor(darkYellow);
			g.drawOval(x, y, width, height);
			g.fillRect(x + 10, y +5 , width/6, height/2);
			g.fillRect(x + 5, y +5 , width/6, height/2);
			g.fillRect(x + 15, y +5 , width/6, height/2);
	
		}
		
	}	

}