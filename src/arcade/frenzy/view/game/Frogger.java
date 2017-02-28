package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.ButtonNames;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frogger extends Base_Game {

	public Frogger(Main_Menu game, Game_UI gui) {
		gui.setGameBackGround(ButtonNames.Frogger);
		game.getMainScreen().add(gui.getPanel());
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
