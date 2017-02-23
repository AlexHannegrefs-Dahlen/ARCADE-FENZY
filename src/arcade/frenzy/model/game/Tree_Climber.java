package arcade.frenzy.model.game;

import java.awt.Color;

import arcade.frenzy.model.main.menu.Main_Menu;

public class Tree_Climber extends Base_Game {

	public Tree_Climber(Main_Menu game) {
		this.setBackground(Color.BLUE);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
