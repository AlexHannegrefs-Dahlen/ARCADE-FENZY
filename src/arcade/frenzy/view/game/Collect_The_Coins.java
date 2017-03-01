package arcade.frenzy.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Collect_The_Coins extends Base_Game {
	private int x = 500;
	private int y = 500;

	public Collect_The_Coins(Main_Menu game, Player player, Game_UI gui) {
		this.setPlayer(player);
		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 50, 50);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			y-=50;
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y+=50;
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x-=50;
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x+=50;
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
