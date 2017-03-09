package arcade.frenzy.view.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.BackgroundPanel;
import arcade.frenzy.view.main.menu.Main_Menu;

public abstract class Base_Game extends BackgroundPanel implements Game_Interface, KeyListener, ActionListener {
	private Player player;

	private Main_Menu game;

	private Timer timer = new Timer(50 / 3, this);

	private static final long serialVersionUID = 1L;

	/**
	 * Base Constructor
	 */
	public Base_Game() {

	}

	/**
	 * Background Image Constructor
	 * 
	 * @param image
	 *            background image
	 */
	public Base_Game(Image image) {
		super(image);
	}

	/**
	 * Background Image Constructor + Player Object
	 * 
	 * @param player
	 *            the player
	 * @param image
	 *            the background
	 */
	public Base_Game(Player player, Image image) {
		super(image);
		this.player = player;
	}

	/**
	 * Brings up the JOptionPane or goes to next game
	 * 
	 * @param message
	 *            the message on the JOptionPane
	 */
	public void gameEndScreen(String message) {
		if (!this.getGame().isFrenzy()) {
			JOptionPane.showMessageDialog(this, message);
			this.gameOver(this);
		} else
			try {
				this.getGame().getCon().getFrenzy().gameOver(this);
			} catch (InterruptedException | IOException e1) {
			}
	}

	/**
	 * 
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	/**
	 * returns true if the player has collided with the left wall of an object
	 * that the player is inside of else returns false
	 */
	@Override
	public boolean detectCollisionPlayerInsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (OxLoc >= this.getPlayer().getxLoc() - this.getPlayer().getxVel())
			return true;
		else
			return false;

	}

	/**
	 * returns true if the player has collided with the right wall of an object
	 * that the player is inside of else returns false
	 */
	@Override
	public boolean detectCollisionPlayerInsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getxLoc() + this.getPlayer().getWidth() + this.getPlayer().getxVel() >= OxLoc + Owidth)
			return true;
		else
			return false;
	}

	/**
	 * returns true if the player has collided with the top wall of an object
	 * that the player is inside of else returns false
	 */
	@Override
	public boolean detectCollisionPlayerInsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getyLoc() - this.getPlayer().getyVel() <= OyLoc)
			return true;
		else
			return false;

	}

	/**
	 * returns true if the player has collided with the Bottom wall of an object
	 * that the player is inside of else returns false
	 */

	@Override
	public boolean detectCollisionPlayerInsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() + this.getPlayer().getyVel() >= OyLoc + Oheight)
			return true;
		else
			return false;
	}

	/**
	 * returns true if the player has collided with the bottom wall of an object
	 * that the player is outside of else returns false
	 */
	@Override
	public boolean detectCollisionPlayerOutsideBottomWall(Object_Creator object) {
		if (object.getxLocation() <= this.getPlayer().getxLoc() + this.getPlayer().getWidth()
				&& object.getxLocation() + object.getWidth() >= this.getPlayer().getxLoc())
			if (this.getPlayer().getyLoc() <= object.getyLocation() + object.getHeight()
					&& this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getyLocation())
				return true;
			else
				return false;
		else
			return false;
	}

	/**
	 * returns true if the player has collided with the top wall of an object
	 * that the player is outside of else returns false
	 */
	@Override
	public boolean detectCollisionPlayerOutsideTopWall(Object_Creator object) {
		if (this.getPlayer().getyLoc() > object.getyLocation())
			return false;
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getyLocation()
				&& this.getPlayer().getyLoc() + this.getPlayer().getHeight() + this.getPlayer().getyVel() > object
						.getyLocation()
				&& object.getxLocation() <= this.getPlayer().getxLoc() + this.getPlayer().getWidth()
				&& object.getxLocation() + object.getWidth() >= this.getPlayer().getxLoc())
			return true;
		else
			return false;
	}

	/**
	 * returns true if the player has collided with the right wall of an object
	 * that the player is outside of else returns false
	 */
	@Override
	public boolean detectCollisionPlayerOutsideRightWall(Object_Creator object) {
		if (this.getPlayer().getxLoc() < object.getxLocation())
			return false;
		if (object.getxLocation() + object.getWidth() >= this.getPlayer().getxLoc()
				&& this.getPlayer().getxLoc() - this.getPlayer().getxVel() < object.getxLocation() + object.getWidth()
				&& this.getPlayer().getxLoc() <= object.getxLocation() + object.getWidth()
				&& this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getyLocation()
				&& this.getPlayer().getyLoc() <= object.getyLocation() + object.getHeight())
			return true;
		else
			return false;
	}

	/**
	 * returns true if the player has collided with the left wall of an object
	 * that the player is outside of else returns false
	 */
	@Override
	public boolean detectCollisionPlayerOutsideLeftWall(Object_Creator object) {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getyLocation()
				&& this.getPlayer().getyLoc() <= object.getyLocation() + object.getHeight())
			if (this.getPlayer().getxLoc() + this.getPlayer().getWidth() >= object.getxLocation()
					&& this.getPlayer().getxLoc() + this.getPlayer().getWidth() <= object.getxLocation()
							+ object.getWidth())
				return true;
			else
				return false;
		else
			return false;
	}

	/**
	 * 
	 * @return the game
	 */

	public Main_Menu getGame() {
		return game;
	}

	/**
	 * 
	 * @param game
	 *            Reference to the main menu
	 */
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

	/**
	 * changes Panel back to the main Panel called when not in frenzy mode
	 * 
	 * @param gamePlayed
	 *            active game
	 */
	public void gameOver(Base_Game gamePlayed) {
		this.getGame().getMainScreen().remove(gamePlayed);
		this.getGame().getMainPanel().setVisible(true);
		this.getGame().getMainPanel().setFocusable(true);
		this.getGame().getMainPanel().requestFocusInWindow();
	}

}
