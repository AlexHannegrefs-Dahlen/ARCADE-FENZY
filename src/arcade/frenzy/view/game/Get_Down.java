package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.ButtonNames;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Get_Down extends Base_Game {

	public Get_Down(Main_Menu game, Game_UI gui, Player player) {
		super.setPlayer(player);
		gui.setGameBackGround(ButtonNames.Get_Down);
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
