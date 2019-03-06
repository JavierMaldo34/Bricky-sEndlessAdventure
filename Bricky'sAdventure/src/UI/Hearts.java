package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Hearts {
	
	public Font font = new Font("arial", 30, 30);

	public int maxHP, currentHP;

	public Hearts(int maxHP, int currentHP) {
		
		this.maxHP = maxHP;
		
		this.currentHP = currentHP;
		
	}
	
	public void renew(int maxHP, int currentHP) {
		
		this.maxHP = maxHP;
		
		this.currentHP = currentHP;
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.red);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setFont(font);
		
		g2d.drawString("HP", 360, 40);
		
		if(currentHP == 3) {
			
			g.fillRect(300, 50, 40, 40);
			g.fillRect(350, 50, 40, 40);
			g.fillRect(400, 50, 40, 40);

		}
	
		if(currentHP == 2) {
			
			g.fillRect(300, 50, 40, 40);
			g.fillRect(350, 50, 40, 40);
			//g.fillRect(380, 50, 40, 40);

		}
		
		if(currentHP == 1) {
			
			g.fillRect(300, 50, 40, 40);
			//g.fillRect(330, 50, 40, 40);
			//g.fillRect(380, 50, 40, 40);

		}
		
		g.setColor(Color.gray);
		g.drawRect(300, 50, 40, 40);
		g.drawRect(350, 50, 40, 40);
		g.drawRect(400, 50, 40, 40);
		g.setColor(Color.orange);
		g.drawRect(302, 52, 35, 35);
		g.drawRect(352, 52, 35, 35);
		g.drawRect(402, 52, 35, 35);
		
	}
	
	
}
