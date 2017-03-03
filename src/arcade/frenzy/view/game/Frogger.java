package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.GameNames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frogger extends Base_Game {
	private int width = 50, height = 50, xVel = 25, yVel = 25;

	public Frogger(Main_Menu game, Game_UI gui, Player player) {
		super.setGame(game);
		super.setPlayer(player);
		super.getPlayer().setxLoc(game.getMainScreen().getWidth() / 2);
		super.getPlayer().setyLoc(game.getMainScreen().getHeight() / 2);
		super.getPlayer().setWidth(width);
		super.getPlayer().setHeight(height);
		super.getPlayer().setxVel(xVel);
		super.getPlayer().setyVel(yVel);
		
		//gui.setGameBackGround(GameNames.Frogger);
		this.setBackground(Color.BLACK);
		game.getMainScreen().add(gui.getPanel());
		game.getMainScreen().setVisible(true);
	}

	
	public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(), this.getPlayer().getHeight());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
