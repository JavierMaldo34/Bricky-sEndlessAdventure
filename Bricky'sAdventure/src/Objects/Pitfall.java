package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Rects.Point;

public class Pitfall extends Objects.Object{

	public Random generator;
	
	public boolean renewing;
	
	public float speedMult = 0;
	
	private static final long serialVersionUID = 1L;

	public Pitfall(int x, int y, int width, int height, float speed) {
		super(x, y, width, height, speed);
		
		generator = new Random();
		
		width = 100 + generator.nextInt(200);
		
		renewing = false;
		
		// TODO Auto-generated constructor stub
	}
	
	public void renew() {
		
		this.changeDimension();
		
		this.movement();
		
		bottomLeft = new Point(this.x, this.y + this.height);
		
		topRight = new Point (this.x + this.width, this.y);
	}
	
	public void changeDimension() {
		
		if(renewing) {
		
			width = 100 + generator.nextInt(100);
			this.x = 810;
			renewing = false;
		}
		
	}
	
	public void movement() {
		
		this.x = (int) (this.x - this.speed -(this.speed*this.speedMult));
		
		if(this.x < 0 - this.width) {
			
			renewing = true;
			
		}
		
	}
	
	public void dropMovement() {
		
		
		
		
	}
	
	
	public void draw(Graphics g) {
		
		g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
		g.setColor(Color.red);
		g.fillRect(x + 5, y + 5, width - 10, height - 5);
		

	}

	public Random getGenerator() {
		return generator;
	}

	public void setGenerator(Random generator) {
		this.generator = generator;
	}

	public boolean isRenewing() {
		return renewing;
	}

	public void setRenewing(boolean renewing) {
		this.renewing = renewing;
	}

	public float getSpeedMult() {
		return speedMult;
	}

	public void setSpeedMult(float speedMult) {
		this.speedMult = speedMult;
	}
}
