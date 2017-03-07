package arcade.frenzy.controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.model.load_save.Highscores;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.game.Collect_The_Coins;
import arcade.frenzy.view.game.Frenzy_Mode;
import arcade.frenzy.view.game.Frogger;
import arcade.frenzy.view.game.Get_Down;
import arcade.frenzy.view.game.Jump_The_Car;
import arcade.frenzy.view.game.Tree_Climber;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Main_Controller {
	private String playersName;

	private Player player;

	private Collect_The_Coins coins;

	private Tree_Climber climber;

	private Frogger frogger;

	private Get_Down down;

	private Jump_The_Car carJumper;

	private Frenzy_Mode frenzy;

	private Main_Menu game;

	private Highscores highscore;

	private Game_UI gui;

	public void start() {
		game = new Main_Menu();
		game.init(this);
		player = new Player();
		gui = new Game_UI(game);

	}

	public void handleButtonClicked(GameNames buttonClicked) throws InterruptedException, IOException {
		if (game.getMainPanel().isVisible())
			game.getMainPanel().setVisible(false);
		switch (buttonClicked) {
		case Collect_The_Coins:
			this.coins = new Collect_The_Coins(game, player, gui,
					ImageIO.read(new File("Collect the coin/background.jpg")));
			coins.setFocusable(true);
			coins.requestFocusInWindow();
			break;
		case Tree_Climber:
			this.climber = new Tree_Climber(game, player, gui);
			climber.setFocusable(true);
			climber.requestFocusInWindow();
			break;
		case Frogger:
			this.frogger = new Frogger(game, gui, player);
			frogger.setFocusable(true);
			frogger.requestFocusInWindow();
			break;
		case Get_Down:
			this.down = new Get_Down(game, gui, player, ImageIO.read(new File("GetDown/background.png")));
			down.setFocusable(true);
			down.requestFocusInWindow();
			break;
		case Jump_The_Car:
			this.carJumper = new Jump_The_Car(game, player, gui, ImageIO.read(new File("Jump The car/road2big.gif")));
			carJumper.setFocusable(true);
			carJumper.requestFocusInWindow();
			break;
		case Frenzy_Mode:
			this.frenzy = new Frenzy_Mode(this, game);
			break;
		case Highscores:
			this.highscore = new Highscores(game);
			highscore.setFocusable(true);
			highscore.requestFocusInWindow();
		default:
			break;
		}

	}

	/**
	 * @return the playersName
	 */
	public String getPlayersName() {
		return playersName;
	}

	/**
	 * @param playersName
	 *            the playersName to set
	 */
	public void setPlayersName(String playersName) {
		this.playersName = playersName;
		this.getPlayer().setName(this.playersName);
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the coins
	 */
	public Collect_The_Coins getCoins() {
		return coins;
	}

	/**
	 * @param coins
	 *            the coins to set
	 */
	public void setCoins(Collect_The_Coins coins) {
		this.coins = coins;
	}

	/**
	 * @return the climber
	 */
	public Tree_Climber getClimber() {
		return climber;
	}

	/**
	 * @param climber
	 *            the climber to set
	 */
	public void setClimber(Tree_Climber climber) {
		this.climber = climber;
	}

	/**
	 * @return the frogger
	 */
	public Frogger getFrogger() {
		return frogger;
	}

	/**
	 * @param frogger
	 *            the frogger to set
	 */
	public void setFrogger(Frogger frogger) {
		this.frogger = frogger;
	}

	/**
	 * @return the down
	 */
	public Get_Down getDown() {
		return down;
	}

	/**
	 * @param down
	 *            the down to set
	 */
	public void setDown(Get_Down down) {
		this.down = down;
	}

	/**
	 * @return the carJumper
	 */
	public Jump_The_Car getCarJumper() {
		return carJumper;
	}

	/**
	 * @param carJumper
	 *            the carJumper to set
	 */
	public void setCarJumper(Jump_The_Car carJumper) {
		this.carJumper = carJumper;
	}

	/**
	 * @return the frenzy
	 */
	public Frenzy_Mode getFrenzy() {
		return frenzy;
	}

	/**
	 * @param frenzy
	 *            the frenzy to set
	 */
	public void setFrenzy(Frenzy_Mode frenzy) {
		this.frenzy = frenzy;
	}

	/**
	 * @return the game
	 */
	public Main_Menu getGame() {
		return game;
	}

	/**
	 * @param game
	 *            the game to set
	 */
	public void setGame(Main_Menu game) {
		this.game = game;
	}

	/**
	 * @return the highscore
	 */
	public Highscores getHighscore() {
		return highscore;
	}

	/**
	 * @param highscore
	 *            the highscore to set
	 */
	public void setHighscore(Highscores highscore) {
		this.highscore = highscore;
	}

	public void frenzyOver() {
		this.getGame().getMainPanel().setVisible(true);
		this.getGame().getMainPanel().setFocusable(true);
		this.getGame().getMainPanel().requestFocusInWindow();
		this.getGame().setFrenzy(false);
	}

}
