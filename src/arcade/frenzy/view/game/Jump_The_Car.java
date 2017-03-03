package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.GameNames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Jump_The_Car extends Base_Game {
	private Player player;
	private final int width = 50, height = 125, Xloc = 2200, Yloc = 950, Xvel = 5, Yvel = 5;

	private Object_Creator Car;

	/**
	 * 
	 * @param game
	 *            - The Main_Menu instance
	 * @param player
	 *            - The player instance
	 * @param gui
	 */
	public Jump_The_Car(Main_Menu game, Player player, Game_UI gui) {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setHeight(height);
		this.getPlayer().setWidth(width);
		this.getPlayer().setxLoc(Xloc);
		this.getPlayer().setyLoc(Yloc);
		this.getPlayer().setxVel(Xvel);
		this.getPlayer().setyVel(Yvel);

		Car = new Object_Creator(100, 200, 200, 1000, 25, 0, Color.ORANGE);

		this.setBackground(Color.cyan);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);

	}

	public void Winner() {
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// sun
		g.setColor(Color.yellow);
		g.fillOval(2200, 0, 150, 150);

		// grass
		g.setColor(Color.green);
		g.fillRect(0, 800, 20000, 200);

		// road
		g.setColor(Color.gray);
		g.fillRect(0, 900, 20000, 400);

		// Car
		g.setColor(Car.getColor());
		g.fillRect(Car.getX_Location(), Car.getY_Location(), Car.getWidth(), Car.getHeight());

		// CarPanel
		g.setColor(Color.gray);
		g.fillRect(Car.getX_Location() + 155, Car.getY_Location() - 10, 50, 50);

		// left wheel
		g.setColor(Color.BLACK);
		g.fillOval(Car.getX_Location() - 15, Car.getY_Location() + 70, 50, 50);

		// right wheel
		g.setColor(Color.BLACK);
		g.fillOval(Car.getX_Location() + 165, Car.getY_Location() + 70, 50, 50);

		// player
		g.setColor(Color.WHITE);
		g.fillRect(this.player.getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
				this.getPlayer().getHeight());

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

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
