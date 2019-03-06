package Bricky;

import java.awt.Color;
import java.awt.Graphics;

import Main.Window;
import Rects.Point;
import UI.Hearts;
import UI.ScoreKeeper;

public class Bricky extends Objects.Object{


	private static final long serialVersionUID = 1L;
	
	public int hearts, currentHearts;
	
	public boolean inAir, ableJump, jumping, falling, intersecting ;
	
	public int fall, rise;
	
	public Window window;
	
	public Hearts hpSystem;
	
	public ScoreKeeper timer = new ScoreKeeper();;
	
	public boolean invincible = false;
	
	public Bricky(int x, int y, int width, int height, float speed, Window window) {
		
		super(x, y, width, height, speed);
		
		inAir = false;
		
		intersecting = false;
		
		ableJump = true;
		
		jumping = false;
		
		falling = false;
		
		this.window = window;
		
		fall = 4;
		
		rise = 4;
		
		hearts = 3;
		
		currentHearts = 3;
		
		hpSystem = new Hearts(currentHearts, currentHearts);
		
	}

	public void jump() {
		
		this.die();
		
		timer.renew();
		
		hpSystem.renew(currentHearts, currentHearts);
		
		this.invincibleTemp();
		
		if(window.keyManager.right) {
			if(x < 760) {
				
				this.x = x + 4;
				
			}
		}
		
		if(window.keyManager.left) {
			if(x > 10) {
				
				this.x = this.x - 4;
		
			}
		}
		
		if(window.keyManager.up && ableJump) {
			
			jumping = true;
			ableJump = false;
			
		}
		
		if(jumping) {
			
			this.y = this.y - rise;
	
		}
		
		if(this.y < 206) {
			
			this.jumping = false;
			this.falling = true;
			
		}
		
		if(falling && !intersecting) {
			
			if(this.y < 466) {
				
				this.y = this.y + fall;
			
			}else {
			
				this.falling = false;
				this.ableJump = true;
			
			}
		}
	}
	
	public void draw(Graphics g) {
		
		Color green = new Color(20, 201, 123);
		
		hpSystem.draw(g);
		if(invincible) {
			
			g.setColor(Color.red);
			g.drawRect(this.x+2, this.y+2, this.width-5, this.height-5);
			g.drawRect(this.x+4, this.y+4, this.width-10, this.height-10);

		}else {
		
		g.setColor(green);
		g.fillRect(this.x, this.y, this.width, this.height);
		
		}
		
		g.setColor(Color.GRAY);
		g.drawRect(x, y, width, height);
		
		if(!jumping && !falling) {
			
			g.setColor(Color.cyan);
			g.fillOval(x+9, y+10, (width/5), (height/3));
			g.fillOval(x+29, y+10, (width/5), (height/3));
			g.setColor(Color.darkGray);
			g.drawOval(x+9, y+10, width/5, height/3);
			g.drawOval(x+29, y+10, width/5, height/3);
		
		}
		if(jumping) {
			
			
			g.setColor(Color.cyan);
			g.fillOval(x+9, y+5, (width/5), (height/4));
			g.fillOval(x+29, y+5, (width/5), (height/4));
			g.setColor(Color.darkGray);
			g.drawOval(x+9, y+5, width/5, height/4);
			g.drawOval(x+29, y+5, width/5, height/4);
		
		}
			
		if(falling){
			
			g.setColor(Color.cyan);
			g.fillOval(x+8, y+5, (int) (width/4.8), (int) (height/2.8));
			g.fillOval(x+28, y+5, (int) (width/4.8), (int) (height/2.8));
			g.setColor(Color.darkGray);
			g.drawOval(x+8, y+5, (int) (width/4.8), (int) (height/2.8));
			g.drawOval(x+28, y+5, (int) (width/4.8), (int) (height/2.8));
				
		}
		
		g.setColor(Color.pink);
		g.fillOval(x+3, y+15, width/6, height/6);
		g.fillOval(x+37, y+15, width/6, height/6);

		
		if(!falling) {
//			g.setColor(Color.gray);
//			
//			g.fillOval(x+20, y+30, width/3, height/16);
//			
//			g.setColor(Color.darkGray);
//			
//			g.drawOval(x+20, y+30, width/3, height/16);
		}else {
			g.setColor(Color.red);
			
			g.fillOval(x+20, y+30, width/3, height/3);
			
			g.setColor(Color.darkGray);
			
			g.drawOval(x+20, y+30, width/3, height/3);
		}
		if(jumping) {
			
			g.setColor(Color.red);
			
			g.fillOval(x+20, y+25, width/3, height/3);
			
			g.setColor(Color.darkGray);
			
			g.drawOval(x+20, y+25, width/3, height/3);
			
			
		}
		
		
		bottomLeft = new Point(this.x, this.y + this.height);
		
		topRight = new Point (this.x + this.width, this.y);
	}

	
	public void die() {
		
		if(this.currentHearts == 0) {
			
			window.setDead(true);
			window.setGame(false);
			
		}
		
		
	}

	public int getCurrentHearts() {
		return currentHearts;
	}

	public void setCurrentHearts(int currentHearts) {
		
		if(invincible == false) {
			
			this.invincible = true;
		
			this.currentHearts = currentHearts;
			
		}
	}
	
	public boolean flag = false;

	public int lastSeconds = timer.seconds;
	
	public void invincibleTemp() {
		
		if(!flag && this.invincible) {
			
			lastSeconds = timer.seconds;
			
			this.flag = true;
		}
		
		if(this.invincible) {
			if(timer.seconds == lastSeconds + 2) {
				
				this.invincible = false;
				this.flag = false;
				
			}
		}
		
		
	}
	
	
	
}
