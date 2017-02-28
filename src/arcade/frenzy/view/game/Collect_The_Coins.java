package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.controller.ButtonNames;
import arcade.frenzy.model.player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import arcade.frenzy.view.main.menu.Main_Menu;

public class Collect_The_Coins extends Base_Game {

	public Collect_The_Coins(Main_Menu game, Player player, Game_UI gui) {
		gui.setGameBackGround(ButtonNames.Collect_The_Coins);
		game.getMainPanel().add(gui.getPanel());
		game.getMainScreen().setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void detectCollision(int PxLoc, int PyLoc, int Pwidth, int Pheight, int OxLoc, int OyLoc, int Owidth,
			int Oheight) {

	}

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
