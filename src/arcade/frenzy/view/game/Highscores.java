package arcade.frenzy.view.game;

import java.awt.Color;

import javax.swing.JPanel;

import arcade.frenzy.view.main.menu.Main_Menu;

public class Highscores extends JPanel {

	public Highscores(Main_Menu game) {
		this.setBackground(Color.PINK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
