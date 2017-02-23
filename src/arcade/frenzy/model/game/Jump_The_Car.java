package arcade.frenzy.model.game;

import java.awt.Color;

import arcade.frenzy.model.main.menu.Main_Menu;

public class Jump_The_Car extends Base_Game {

	public Jump_The_Car(Main_Menu game) {
		this.setBackground(Color.ORANGE);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
