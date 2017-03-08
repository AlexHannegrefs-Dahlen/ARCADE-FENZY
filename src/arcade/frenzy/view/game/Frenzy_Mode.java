package arcade.frenzy.view.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Timer;

import arcade.frenzy.controller.GameNames;
import arcade.frenzy.controller.Main_Controller;
import arcade.frenzy.model.load_save.Save;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frenzy_Mode implements ActionListener {
	private ArrayList<GameNames> games = new ArrayList<GameNames>(
			Arrays.asList(GameNames.Collect_The_Coins, GameNames.Frogger, GameNames.Get_Down, GameNames.Jump_The_Car));

	private Main_Controller con;

	private Timer highscore = new Timer(0, this);

	private Random gen = new Random();

	private double score = 0;

	public Frenzy_Mode(Main_Controller main_Controller, Main_Menu game) throws InterruptedException, IOException {
		this.setCon(main_Controller);
		this.highscore.start();
		this.randomize();
		this.playNextGame(main_Controller);
	}

	private void randomize() {
		for (int i = 0; i < 50; i++) {
			GameNames hold = games.get(gen.nextInt(games.size()));
			games.remove(hold);
			games.add(hold);
		}
	}

	private void playNextGame(Main_Controller main_Controller) throws InterruptedException, IOException {
		if (games.size() != 0)
			main_Controller.handleButtonClicked(games.get(0));
		else {
			this.returnMainMenu();
			this.highscore.stop();
		}
	}

	private void returnMainMenu() {
		try {
			Save.save(this.getCon().getPlayersName() + " " + String.valueOf(score));
		} catch (FileNotFoundException e) {
		}
		this.getCon().frenzyOver();
	}

	public void gameOver(Base_Game gamePlayed) throws InterruptedException, IOException {
		this.games.remove(0);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == highscore)
			score += .01;
	}

}
