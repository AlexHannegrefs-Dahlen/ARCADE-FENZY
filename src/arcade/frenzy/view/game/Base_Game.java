package arcade.frenzy.view.game;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import arcade.frenzy.model.player.Player;

public abstract class Base_Game extends JPanel implements Game_Interface, KeyListener, ActionListener {
	private Player player;

	private Timer timer = new Timer(5, this);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Base_Game() {

	}

	public Base_Game(Player player) {
		this.player = player;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void detectCollision() {

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
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer
	 *            the timer to set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
