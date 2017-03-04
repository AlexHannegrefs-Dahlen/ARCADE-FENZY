package arcade.frenzy.view.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import arcade.frenzy.controller.GameNames;
import arcade.frenzy.controller.Main_Controller;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frenzy_Mode {
	private ArrayList<GameNames> games = new ArrayList<GameNames>(Arrays.asList(GameNames.Collect_The_Coins,
			GameNames.Frogger, GameNames.Get_Down, GameNames.Jump_The_Car, GameNames.Tree_Climber));
	private Main_Controller con;

	public Frenzy_Mode(Main_Controller main_Controller, Main_Menu game) throws InterruptedException, IOException {
		this.setCon(main_Controller);
		this.playNextGame(main_Controller);
	}

	private void playNextGame(Main_Controller main_Controller) throws InterruptedException, IOException {
		if (games.size() != 0)
			main_Controller.handleButtonClicked(games.get(0));
		else
			this.returnMainMenu();
	}

	private void returnMainMenu() {
		this.getCon().frenzyOver();
	}

	public void gameOver(Base_Game gamePlayed) throws InterruptedException, IOException {
		games.remove(0);
		this.getCon().getGame().getMainScreen().remove(gamePlayed);
		this.playNextGame(gamePlayed.getGame().getCon());
	}

	/**
	 * @return the con
	 */
	public Main_Controller getCon() {
		return con;
	}

	/**
	 * @param con
	 *            the con to set
	 */
	public void setCon(Main_Controller con) {
		this.con = con;
	}

}
