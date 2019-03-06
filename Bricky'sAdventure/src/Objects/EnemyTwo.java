package Objects;

import java.awt.Color;
import java.awt.Graphics;

public class EnemyTwo extends Objects.Object{
private static final long serialVersionUID = 1L;
	
	public int upDown = 0;
	
	public boolean falling = false;
	
	public boolean active = false;
	
	public EnemyTwo(int x, int y, int width, int height, float speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}
	public void movement() {
		
		this.x = this.x - (int)this.speed;
		
		if(!falling) {
			
			this.y = this.y - 1;
			
		}
		
		if(falling){
			
			this.y = this.y + 1;
			
		}
		
		if(this.y <= 400) {
			
			falling = true;
			
		}
		if(this.y == 500) {
			
			falling = false;
			
		}
		
		
		
		
		if(this.x <= 0 - this.width) {
			
			this.x = 800;
			
		}
	}
	
	public void draw(Graphics g) {
		
		

		
		
		g.setColor(Color.orange);
		g.fillOval(x, y, width, height);
		g.setColor(Color.red);
		g.fillOval(x+5, y+5, width-10, height-10);
		g.setColor(Color.orange);
		g.fillOval(x+10, y+10, width-20, height-20);
		g.setColor(Color.cyan);
		g.fillOval(x+15, y+15, width-30, height-30);
		g.setColor(Color.black);
		g.fillOval(x+5, y+5, width/4, height/4);
		g.fillOval(x+20, y+5, width/4, height/4);
		g.setColor(Color.orange);
		g.drawRect(x+width, y+10, 8, 1);
		g.drawRect(x+width, y+(height/2), 8, 1);
		g.drawRect(x+width, y+(height/2)+10, 8, 1);
		
	}
	
	
	
}
