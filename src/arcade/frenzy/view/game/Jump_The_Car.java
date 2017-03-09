package arcade.frenzy.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

/**
 * 
 * @author Alex Jump the Car game
 */
public class Jump_The_Car extends Base_Game {
	private Player player;
	private final int width = 100, height = 225, Xloc = 650, Yloc = 880, Xvel = 0, Yvel = 25;
	private Timer gravityTimer = new Timer(30, this), carTimer = new Timer(50, this);
	private Object_Creator Car, floor, celing;

	/**
	 * 
	 * @param game
	 *            - The Main_Menu instance
	 * @param player
	 *            - The player instance
	 * @param img
	 *            - the image of the background
	 * @throws IOException
	 */
	public Jump_The_Car(Main_Menu game, Player player, Image img) throws IOException {
		super(img);
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setHeight(height);
		this.getPlayer().setWidth(width);
		this.getPlayer().setxLoc(Xloc);
		this.getPlayer().setyLoc(Yloc);
		this.getPlayer().setxVel(Xvel);
		this.getPlayer().setyVel(Yvel);

		Car = new Object_Creator(200, 375, 2200, 895, 40, 0, "Jump The car/Car.gif");
		floor = new Object_Creator(1, 1000, 0, Yloc + height, 0, 0, Color.BLACK);
		celing = new Object_Creator(25, 1000, 0, floor.getyLocation() - 650, 0, 0, Color.BLACK);
		this.setBackground(Color.cyan);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
		gravityTimer.start();
		carTimer.start();
	}

	/**
	 * draws the game player and objects
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		try {
			if (player.getyLoc() == Yloc) {
				g.drawImage(ImageIO.read(new File("Jump The car/Standing.gif")), player.getxLoc(), player.getyLoc(),
						player.getWidth(), player.getHeight(), this);
			} else {
				g.drawImage(ImageIO.read(new File("Jump The car/Jumping.gif")), player.getxLoc(), player.getyLoc(),
						player.getWidth(), player.getHeight(), this);
			}
		} catch (IOException e) {

		}
		g.drawImage(Car.getObjectImage(), Car.getxLocation(), Car.getyLocation(), Car.getWidth(), Car.getHeight(),
				this);
	}

	private static final long serialVersionUID = 1L;

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
	 * player jump
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.gravityTimer.stop();
			this.player.moveUp();
			if (super.detectCollisionPlayerOutsideBottomWall(celing))
				this.player.setyLoc(celing.getyLocation() + celing.getHeight());
		}
		this.repaint();

	}

	/**
	 * makes sure that the gravity timer is running when the player is not
	 * moving up
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		this.gravityTimer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * moves the player down with the gravity timer. moves the car across with
	 * the car timer. Checks for collision.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == gravityTimer) {
			this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
			if (super.detectCollisionPlayerOutsideTopWall(floor)) {
				this.getPlayer().setyLoc(floor.getyLocation() - this.getPlayer().getHeight());
			}

		}
		if (e.getSource() == carTimer) {
			Car.setxLocation(Car.getxLocation() - Car.getxVelocity());
		}
		if (super.detectCollisionPlayerOutsideBottomWall(celing)) {
			this.getPlayer().setyLoc(celing.getyLocation() + this.celing.getHeight());
		}
		if (super.detectCollisionPlayerOutsideRightWall(Car)) {
			gravityTimer.stop();
			carTimer.stop();
			this.GotHit();
		} else if (!super.detectCollisionPlayerInsideLeftWall(Car.getxLocation() + Car.getWidth() + 230,
				Car.getyLocation(), Car.getWidth(), Car.getHeight())) {
			gravityTimer.stop();
			carTimer.stop();
			this.Winner();
		}
		this.repaint();
	}

	private void Winner() {
		if (!this.getGame().isFrenzy()) {
			JOptionPane.showMessageDialog(this, "Winner");
			super.gameOver(this);
		} else {
			try {
				this.getGame().getCon().getFrenzy().gameOver(this);
			} catch (InterruptedException | IOException e1) {

			}
		}
	}

	private void GotHit() {
		if (!this.getGame().isFrenzy()) {
			JOptionPane.showMessageDialog(this, "Hit");
			super.gameOver(this);
		} else {
			try {
				this.getGame().getCon().getFrenzy().gameOver(this);
			} catch (InterruptedException | IOException e1) {

			}
		}
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
