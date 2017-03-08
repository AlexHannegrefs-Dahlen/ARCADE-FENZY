package arcade.frenzy.model.load_save;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import arcade.frenzy.view.main.menu.Main_Menu;

public class Highscores extends JPanel implements ActionListener {
	private Main_Menu game;

	private JButton load, mainMenu;

	private JTextPane scores;

	private Load scoreLoader;

	private int buttonWidth = 500;

	public Highscores(Main_Menu game) {
		this.setGame(game);
		this.setBackground(Color.WHITE);

		Font font2 = new Font("sans-serif", Font.PLAIN, 60);

		Dimension minSize = new Dimension(buttonWidth, 250);
		Dimension prefSize = new Dimension(buttonWidth, 250);
		Dimension maxSize = new Dimension(buttonWidth, 460);

		load = new JButton("Load Scores");
		load.setIcon(new ImageIcon("MainScreen/redButton.png"));
		load.setHorizontalTextPosition(JButton.CENTER);
		load.setVerticalAlignment(JButton.CENTER);
		load.setBackground(Color.white);
		load.setFont(font2);
		load.setMinimumSize(minSize);
		load.setPreferredSize(prefSize);
		load.setMaximumSize(maxSize);
		load.addActionListener(this);

		mainMenu = new JButton("Go to Main Menu");
		mainMenu.setIcon(new ImageIcon("MainScreen/redButton.png"));
		mainMenu.setHorizontalTextPosition(JButton.CENTER);
		mainMenu.setVerticalAlignment(JButton.CENTER);
		mainMenu.setBackground(Color.white);
		mainMenu.setFont(font2);
		mainMenu.setMinimumSize(minSize);
		mainMenu.setPreferredSize(prefSize);
		mainMenu.setMaximumSize(maxSize);
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
