package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Score {

	
	public ScoreKeeper keeper;
	
	public int score, lastMinute;
	
	public Score(ScoreKeeper keeper) {
		
		this.keeper = keeper;
		
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.blue);
		
		g2d.drawString("SCORE:",500, 50);
		
		g2d.drawString(String.valueOf(score), 650, 50);
		
		lastMinute = 0;
		
		
		
	}
	
	public void renew() {
		
		
		if(keeper.seconds == 30) {
			
			this.score = this.score + 50;
			lastMinute = keeper.minutes;
			
		}
		
		if(keeper.seconds == 59) {
			
			this.score = this.score + 50;
			lastMinute = keeper.minutes;
			
		}
		
	}
	
	
	
	
	
}
