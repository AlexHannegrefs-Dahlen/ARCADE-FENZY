package arcade.frenzy.view.game;

import java.awt.Color;

import arcade.frenzy.view.main.menu.Main_Menu;

public class Get_Down extends Base_Game {

	public Get_Down(Main_Menu game) {
		this.setBackground(Color.red);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
