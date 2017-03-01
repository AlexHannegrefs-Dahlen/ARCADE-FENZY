package arcade.frenzy.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Collect_The_Coins extends Base_Game {
	
	private int width = 50, height = 50, xVel = 25, yVel = 25;


	public Collect_The_Coins(Main_Menu game, Player player, Game_UI gui) {
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainScreen().getWidth() / 2);
		this.getPlayer().setyLoc(game.getMainScreen().getHeight() / 2);
		this.getPlayer().setWidth(width);
		this.getPlayer().setHeight(height);
		this.getPlayer().setxVel(xVel);
		this.getPlayer().setyVel(yVel);
		
		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillOval(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), width, height);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
			this.repaint();
			detectCollision(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(), this.getPlayer().getHeight(), height, height, height, height);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
			this.repaint();
		}
		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyPressed(e);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
