package arcade.frenzy.view.game;

import java.awt.Color;

import arcade.frenzy.view.main.menu.Main_Menu;

public class Frogger extends Base_Game {

	public Frogger(Main_Menu game) {
		this.setBackground(Color.GREEN);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
