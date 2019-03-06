package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class ScoreKeeper {
	
	public Font font = new Font("arial", 30, 30);
	
	public int currentScore;
	
	public long firstTime, currentTime;	
	
	public int hours, minutes, seconds;
	
	public String score;
	
	public ScoreKeeper() {
		
		this.firstTime = System.currentTimeMillis() ;
		this.minutes = 0;
		this.hours = 0;
		
	}
	
	public void display(Graphics g) {
		
	
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setFont(font);
		
		g2d.setColor(Color.blue);
		
		if(minutes>9 && seconds > 9) {
		
			g2d.drawString(hours+":"+minutes+":"+seconds, 140, 50);
		
		}
		if(minutes<10 && seconds > 9) {
			
			g2d.drawString(hours+":"+"0"+minutes+":"+seconds, 140, 50);

		}
		if(minutes > 9 && seconds < 10 ) {
			
			g2d.drawString(hours+":"+minutes+":"+"0"+seconds, 140, 50);
			
		}
		if(minutes< 10 && seconds < 10) {
			
			g2d.drawString(hours+":"+"0"+minutes+":"+"0"+seconds, 140, 50);

		}
		
		score= (hours+":"+minutes+":"+seconds);
		
		g2d.drawString("TIME:", 50, 50);
		
	}
	
	public void renew() {
		
		this.currentTime = System.currentTimeMillis() ;
		
		seconds = (int)((this.currentTime - this.firstTime) / 1000);
		if(seconds == 60) {
			
			this.firstTime = this.currentTime;
			this.minutes = this.minutes + 1;
			
		}
		if(minutes == 60) {
			
			hours = hours + 1;
			
		}
	}
}
