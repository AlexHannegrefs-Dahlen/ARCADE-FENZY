package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.ButtonNames;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Get_Down extends Base_Game {

	public Get_Down(Main_Menu game, Game_UI gui) {
		gui.setGameBackGround(ButtonNames.Get_Down);
		game.getMainScreen().add(gui.getPanel());
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
