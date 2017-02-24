package arcade.frenzy.model.game;

import java.awt.Color;

import arcade.frenzy.model.main.menu.Main_Menu;
import arcade.frenzy.model.player.Player;

public class Jump_The_Car extends Base_Game {
	private Player player;

	/**
	 * 
	 * @param game
	 *            - The Main_Menu instance
	 * @param player
	 *            - The player instance
	 */
	public Jump_The_Car(Main_Menu game, Player player) {
		this.setBackground(Color.ORANGE);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.player = player;
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

}
