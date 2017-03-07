package arcade.frenzy.view.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.BackgroundPanel;
import arcade.frenzy.view.main.menu.Main_Menu;

public abstract class Base_Game extends BackgroundPanel implements Game_Interface, KeyListener, ActionListener {
	private Player player;

	private Main_Menu game;

	private Timer timer = new Timer(50 / 3, this);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Base_Game() {

	}

	public Base_Game(Image image) {
		super(image);
	}

	public Base_Game(Player player, Image image) {
		super(image);
		this.player = player;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public boolean detectCollisionPlayerInsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (OxLoc >= this.getPlayer().getxLoc() - this.getPlayer().getxVel())
			return true;
		else
			return false;

	}

	@Override
	public boolean detectCollisionPlayerInsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getxLoc() + this.getPlayer().getWidth()  + this.getPlayer().getxVel() >= OxLoc + Owidth)
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerInsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getyLoc() - this.getPlayer().getyVel() <= OyLoc)
			return true;
		else
			return false;

	}

	@Override
	public boolean detectCollisionPlayerInsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight) {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() + this.getPlayer().getyVel() >= OyLoc + Oheight)
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideBottomWall(Object_Creator object) {
		if (object.getX_Location() <= this.getPlayer().getxLoc() + this.getPlayer().getWidth()
				&& object.getX_Location() + object.getWidth() >= this.getPlayer().getxLoc())
			if (this.getPlayer().getyLoc() <= object.getY_Location() + object.getHeight()
					&& this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getY_Location())
				return true;
			else
				return false;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideTopWall(Object_Creator object) {
		if (this.getPlayer().getyLoc() > object.getY_Location())
			return false;
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getY_Location()
				&& this.getPlayer().getyLoc() + this.getPlayer().getHeight() + this.getPlayer().getyVel() > object
						.getY_Location()
				&& object.getX_Location() <= this.getPlayer().getxLoc() + this.getPlayer().getWidth()
				&& object.getX_Location() + object.getWidth() >= this.getPlayer().getxLoc())
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideRightWall(Object_Creator object) {
		if (this.getPlayer().getxLoc() < object.getX_Location())
			return false;
		if (object.getX_Location() + object.getWidth() >= this.getPlayer().getxLoc()
				&& this.getPlayer().getxLoc() - this.getPlayer().getxVel() < object.getX_Location() + object.getWidth()
				&& this.getPlayer().getxLoc() <= object.getX_Location() + object.getWidth()
				&& this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getY_Location()
				&& this.getPlayer().getyLoc() <= object.getY_Location() + object.getHeight())
			return true;
		else
			return false;
	}

	@Override
	public boolean detectCollisionPlayerOutsideLeftWall(Object_Creator object) {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= object.getY_Location()
				&& this.getPlayer().getyLoc() <= object.getY_Location() + object.getHeight())
			if (this.getPlayer().getxLoc() + this.getPlayer().getWidth() >= object.getX_Location()
					&& this.getPlayer().getxLoc() + this.getPlayer().getWidth() <= object.getX_Location()
							+ object.getWidth())
				return true;
			else
				return false;
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

	public void gameOver(Base_Game gamePlayed) {
		this.getGame().getMainScreen().remove(gamePlayed);
		this.getGame().getMainPanel().setVisible(true);
		this.getGame().getMainPanel().setFocusable(true);
		this.getGame().getMainPanel().requestFocusInWindow();
	}

}
