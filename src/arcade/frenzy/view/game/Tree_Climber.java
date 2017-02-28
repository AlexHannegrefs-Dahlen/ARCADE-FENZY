package arcade.frenzy.view.game;


import arcade.frenzy.view.main.menu.Main_Menu;
import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.ButtonNames;
import arcade.frenzy.model.player.Player;

public class Tree_Climber extends Base_Game {
	private Player player;

	/**
	 * 
	 * @param game
	 *            - The Main_Menu instance
	 * @param player
	 *            - The Player instance
	 * @param gui 
	 */
	public Tree_Climber(Main_Menu game, Player player, Game_UI gui) {
		gui.setGameBackGround(ButtonNames.Tree_Climber);
		game.getMainScreen().add(gui.getPanel());
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
