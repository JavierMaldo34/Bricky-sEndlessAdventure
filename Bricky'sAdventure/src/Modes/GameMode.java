package Modes;

import java.awt.Color;
import java.awt.Graphics;

import Bricky.Bricky;
import Main.Window;
import Objects.Coin;
import Objects.Enemy;
import Objects.EnemyTwo;
import Objects.Floor;
import Objects.Pitfall;
import Objects.Platform;
import Objects.Spear;
import UI.Score;
import UI.ScoreKeeper;

public class GameMode {
	
	public Bricky player;
	
	public Floor firstFloor, secondFloor;
	
	public ScoreKeeper keeper;
	
	public Pitfall pit;

	public Platform platform;
	
	public Enemy enemy;
	
	public Score score;
	
	public Spear spear;
	
	public Coin coin;
	
	public Window window;
	
	public EnemyTwo enemyTwo;
	
	public int coinCount = 0;
	
	public boolean firstInc, secondInc, thirdInc, fourthInc, fifthInc;
	
	public GameMode(Window window) {
		
		this.window = window;
		
		player = new Bricky(80, 466, 40, 40, 0, window);
		
		coin = new Coin(500, 466, 25, 25, 3);
		
		pit = new Pitfall(600, 500, 80, 220, 2);
		
		enemy = new Enemy(800, 466, 40, 40, 5);
		
		enemyTwo = new EnemyTwo(900, 500, 30, 30, 5);
		
		this.keeper = new ScoreKeeper();
		
		this.platform = new Platform(800, 12, 200, 20, 2);
		
		this.spear = new Spear(1000, 190, 150, 8, 6);
		
		firstFloor = new Floor(0, 500, 800, 200, 2);
		
		score = new Score (keeper);
		
		this.firstInc = false;
		this.secondInc = false;
		this.thirdInc = false;
		this.fourthInc = false;
		this.fifthInc = false;
		
	}
	
	public void coinAdd() {
		
		if(coinCount < 3 && coin.caught) {
			
			coinCount = coinCount + 1;


			if(coinCount >= 3) {

				if(player.currentHearts  < 3) {

					player.currentHearts  = player.currentHearts + 1;

				}

				coinCount = 0;

			}

		}
	}
	
	public void renew() {
		
		if(window.dead) {
			
			window.finalScore = score.score;
			
		}

		if(window.game) {
			
			if(this.enemyTwo.active) {
				
				this.enemyTwo.movement();
				
			}

			coin.reset();

			coin.movement();

			enemy.movement();

			floorMaker();

			player.jump();

			this.keeper.renew();

			this.platform.movement();

			this.interaction();

			score.renew();

			this.spear.movement();
			

		}
		
	}
	
	public void interaction() {
		
		if(window.game) {
			
			if((player.x <= pit.x + pit.width && player.x >= pit.x)  && (pit.y <= player.y + player.height)){

				this.player.setCurrentHearts(player.currentHearts - 1);

			}

			if((player.x <= enemy.x + enemy.width && player.x + player.width >= enemy.x)  && (enemy.y <= player.y + player.height && enemy.y + enemy.height >= player.y )){

				this.player.setCurrentHearts(player.currentHearts - 1);

			}
			if((player.x <= enemyTwo.x + enemyTwo.width && player.x + player.width >= enemyTwo.x)  && (enemyTwo.y <= player.y + player.height && enemyTwo.y + enemyTwo.height >= player.y )){

				this.player.setCurrentHearts(player.currentHearts - 1);

			}
			if((player.x <= coin.x + coin.width && player.x + player.width >= coin.x)  && (coin.y <= player.y + player.height && coin.y + coin.height >= player.y )){

				if(!coin.caught) {
								
					score.score= score.score + 200;
					coin.caught = true;
					this.coinAdd();
				}

			}
			
			if((player.x <= spear.x + spear.width && player.x + player.width >= spear.x)  && (spear.y <= player.y + player.height && spear.y + spear.height >= player.y )){

				this.player.setCurrentHearts(player.currentHearts - 1);

			}
			if((player.x <= platform.x + platform.width && player.x + player.width>= platform.x)  && (platform.y <= player.y + player.height && platform.y + platform.height >= player.y && platform.y + platform.height > player.y)){

				this.player.intersecting = true;


			}else {

				this.player.intersecting = false;

			}

			if(player.height + player.y < pit.y && (player.x <= pit.x + pit.width && player.x >= pit.x)) {

				score.score = score.score + 1;

			}	

		}

	}

	public void floorMaker() {
		
		if(window.game) {
			
			pit.renew();
			this.increase();
			this.progression();
		
		}
	}

	public void progression() {
		
		if(window.game) {
			
			if(this.firstInc) {

				pit.speed = 3;

			}

			if(this.secondInc) {

				this.enemy.speed = 6;

			}

			if(this.thirdInc) {

				this.platform.speed = 3;
				
				this.spear.speed = 7;

			}

			if(this.fourthInc) {

				this.pit.speed = 4;

			}

			if(this.fifthInc) {

				this.enemy.speed = 7;

			}

		}

	}

	public void increase() {

		if(window.game) {

			if(keeper.seconds == 30) {

				this.firstInc = true;

			}

			if(keeper.minutes == 1) {

				this.secondInc = true;
				this.enemyTwo.active = true;

			}

			if(keeper.minutes == 1 && keeper.seconds == 30) {

				this.thirdInc = true;

			}

			if(keeper.minutes == 2) {

				this.fourthInc = true;

			}

			if(keeper.minutes == 3) {

				this.fifthInc = true;

			}

		}
	}

	public void draw(Graphics g) {
		
		if(window.game) {
			
			g.setColor(Color.black);

			g.fillRect(0, 0, 900, 900);
			
			g.setColor(Color.darkGray);
			g.fillRect(5, 5, 790, 130);
			g.setColor(Color.gray);
			g.fillRect(10, 10, 780, 120);
			g.setColor(Color.lightGray);
			g.fillRect(15, 15, 770, 110);
			
			this.firstFloor.draw(g);

			this.player.draw(g);

			keeper.display(g);

			pit.draw(g);

			this.platform.draw(g);

			this.enemy.draw(g);

			this.coin.draw(g);

			score.draw(g);

			this.spear.draw(g);
			
			if(this.enemyTwo.active) {
				
				this.enemyTwo.draw(g);
				
			}
			
			

		}
		
	}
	
}