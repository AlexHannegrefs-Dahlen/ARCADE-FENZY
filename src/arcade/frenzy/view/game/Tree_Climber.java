package arcade.frenzy.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.view.main.menu.Main_Menu;
import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.GameNames;
import arcade.frenzy.model.player.Player;

public class Tree_Climber extends Base_Game {
	private int width = 100, height = 50, xVel = 50, yVel = 50;

	// private Object_Creator Branch,Hole,Finish;
	// private final int Lane1=0,Lane2=10,Lane3=20;
	/**
	 * 
	 * @param game
	 *            - The Main_Menu instance
	 * @param player
	 *            - The Player instance
	 * @param gui
	 */
	public Tree_Climber(Main_Menu game, Player player, Game_UI gui) {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainPanel().getWidth() / 2);
		this.getPlayer().setyLoc(game.getMainPanel().getHeight());
		this.getPlayer().setWidth(width);
		this.getPlayer().setHeight(height);
		this.getPlayer().setxVel(xVel);
		this.getPlayer().setyVel(yVel);

		// gui.setGameBackGround(GameNames.Tree_Climber);
		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, this.getGame().getMainPanel().getWidth() / 11, this.getGame().getMainPanel().getHeight());

		g.setColor(Color.RED);
		g.fillRect(this.getGame().getMainPanel().getWidth() / 11, 0, this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getHeight());

		g.setColor(Color.ORANGE);
		g.fillRect(this.getGame().getMainPanel().getWidth(), 0, this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getHeight());

		// g.setColor(Color.WHITE);
		// g.fillRect(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(),
		// this.getPlayer().getWidth(), this.getPlayer().getHeight());

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
