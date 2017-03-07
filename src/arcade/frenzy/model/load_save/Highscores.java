package arcade.frenzy.model.load_save;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import arcade.frenzy.view.main.menu.Main_Menu;

public class Highscores extends JPanel implements ActionListener {
	private Main_Menu game;

	private JButton load, mainMenu;

	private JTextPane scores;

	private Load scoreLoader;

	public Highscores(Main_Menu game) {
		this.setGame(game);
		this.setBackground(Color.WHITE);

		load = new JButton("Load Scores");
		load.addActionListener(this);
		mainMenu = new JButton("Go to Main Menu");
		mainMenu.addActionListener(this);
		this.add(load);
		this.add(mainMenu);

		setScoreLoader(new Load());

		scores = new JTextPane();
		try {
			scores.setText(scoreLoader.loadScores());
		} catch (IOException e) {
		}
		this.add(scores);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
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
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainMenu) {
			this.getGame().getMainScreen().remove(this);
			this.getGame().getMainPanel().setVisible(true);
			this.getGame().getMainPanel().setFocusable(true);
			this.getGame().getMainPanel().requestFocusInWindow();
		} else if (e.getSource() == load) {
			try {
				this.getScores().setText(this.getScoreLoader().loadScores());
			} catch (IOException e1) {
			}
		}

	}

	/**
	 * @return the scoreLoader
	 */
	public Load getScoreLoader() {
		return scoreLoader;
	}

	/**
	 * @param scoreLoader
	 *            the scoreLoader to set
	 */
	public void setScoreLoader(Load scoreLoader) {
		this.scoreLoader = scoreLoader;
	}

	/**
	 * @return the load
	 */
	public JButton getLoad() {
		return load;
	}

	/**
	 * @param load
	 *            the load to set
	 */
	public void setLoad(JButton load) {
		this.load = load;
	}

	/**
	 * @return the mainMenu
	 */
	public JButton getMainMenu() {
		return mainMenu;
	}

	/**
	 * @param mainMenu
	 *            the mainMenu to set
	 */
	public void setMainMenu(JButton mainMenu) {
		this.mainMenu = mainMenu;
	}

	/**
	 * @return the scores
	 */
	public JTextPane getScores() {
		return scores;
	}

	/**
	 * @param scores
	 *            the scores to set
	 */
	public void setScores(JTextPane scores) {
		this.scores = scores;
	}

}
