package Objects;

import java.awt.Rectangle;

import Rects.Point;

public class Object extends Rectangle{

	private static final long serialVersionUID = 1L;
	
	public int height, width, x, y;
	
	public float speed;
	
	public Point bottomLeft, topRight;
	
	public Object (int x, int y, int width, int height, float speed) {
		
		this.x = x;
		
		this.y = y;
		
		this.width = width;
		
		this.height = height;
		
		this.speed = speed;

		bottomLeft = new Point(this.x, this.y + this.height);
		
		topRight = new Point (this.x + this.width, this.y);
		
	}
	
	public boolean isOverlapping(Objects.Object other) {
		
		if (this.topRight.getY() < other.bottomLeft.getY() 
			      || this.bottomLeft.getY() > other.topRight.getY()) {
			        return false;
			    }
			    if (this.topRight.getX() < other.bottomLeft.getX() 
			      || this.bottomLeft.getX() > other.topRight.getX()) {
			    	System.out.println("wrong");
			        return false;
			    }
			    System.out.println("True");
			    return true;
		
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
}
