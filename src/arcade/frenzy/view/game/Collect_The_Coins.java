package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.ButtonNames;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Collect_The_Coins extends Base_Game {

	public Collect_The_Coins(Main_Menu game, Game_UI gui) {
		gui.setGameBackGround(ButtonNames.Collect_The_Coins);
		game.getMainPanel().add(gui.getPanel());
		game.getMainScreen().setVisible(true);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
