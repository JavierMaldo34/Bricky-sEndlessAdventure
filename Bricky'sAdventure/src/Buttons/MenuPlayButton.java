package Buttons;

import Main.Window;

public class MenuPlayButton extends Button{

	private static final long serialVersionUID = 1L;

	public MenuPlayButton(int x, int y, int width, int height, Window window) {
		super(x, y, width, height, window);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action() {
		
		System.out.println("Hellao");

		System.out.println("HEY");
		window.setGame(true);
		window.setMenu(false);
		
	
	}
	
}