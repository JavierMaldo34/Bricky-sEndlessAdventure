package Buttons;

import java.awt.Rectangle;

import Main.Window;

public class Button extends Rectangle{

	private static final long serialVersionUID = 1L;
	
	public Window window;
	
	public boolean selected;
	
	public Button(int x, int y, int width, int height, Window window) {
		
		selected = false;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.window = window;
		
	}
	
	public void renew() {
		
		if(window.keyManager.interact && selected) {
			
			this.action();
			this.selected = false;
			
		}
		
	}
	
	public boolean isSelected() {
		
		return selected;
	
	}

	public void setSelected(boolean selected) {
		
		this.selected = selected;
	
	}

	//To be overrided later on
	public void action() {
		
	}
}