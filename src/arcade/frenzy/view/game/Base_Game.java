package arcade.frenzy.view.game;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public abstract class Base_Game extends JPanel
		/* Backgroundpanel */ implements Game_Interface, KeyListener, ActionListener {
	private Player player;

	private Main_Menu game;

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
	public boolean detectCollisionPlayerInsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (OxLoc >= this.getPlayer().getxLoc())
			return true;
		else
			return false;

	}

	@Override
	public boolean detectCollisionPlayerInsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getxLoc() + this.getPlayer().getWidth() >= OxLoc + Owidth)
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerInsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getyLoc() <= OyLoc)
			return true;
		else
			return false;

	}

	@Override
	public boolean detectCollisionPlayerInsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= OyLoc + Oheight)
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (OyLoc + Oheight >= this.getPlayer().getyLoc())
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= OyLoc)
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (OxLoc + Owidth >= this.getPlayer().getxLoc())
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getxLoc() + this.getPlayer().getWidth() >= OxLoc)
			return true;
		else
			return false;
	}

	public Main_Menu getGame() {
		return game;
	}

	public void setGame(Main_Menu game) {
		this.game = game;
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
