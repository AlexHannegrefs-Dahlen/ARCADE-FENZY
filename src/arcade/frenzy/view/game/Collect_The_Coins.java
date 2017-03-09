package arcade.frenzy.view.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

/**
 * 
 * @author Alex Collect the coins game
 */
public class Collect_The_Coins extends Base_Game {

	private final int WIDTH = 60, HEIGHT = 60, xVEL = 15, yVEL = 15;

	private int coinCount = 3;

	private Object_Creator center, topLeft, topRight, botLeft, botRight, top, left, right, bot, Coin1, Coin2, Coin3;

	private Object_Creator[] objects;

	/**
	 * Constructor that sets the parameters builds the objects that are used
	 * sets the game as the background to the main frame
	 * 
	 * @param game
	 *            Reference to the main menu
	 * @param player
	 *            the player
	 * @param image
	 *            the background image
	 * @throws IOException
	 */
	public Collect_The_Coins(Main_Menu game, Player player, Image image) throws IOException {
		super(image);
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainScreen().getWidth() / 2 - 25);
		this.getPlayer().setyLoc(game.getMainScreen().getHeight() / 2 + 100);
		this.getPlayer().setWidth(WIDTH);
		this.getPlayer().setHeight(HEIGHT);
		this.getPlayer().setxVel(xVEL);
		this.getPlayer().setyVel(yVEL);

		center = new Object_Creator(100, 100, game.getMainScreen().getWidth() / 2 - 50,
				game.getMainScreen().getHeight() / 2 - 50, 0, 0, Color.WHITE);

		topLeft = new Object_Creator(100, 100, game.getMainScreen().getWidth() / 2 - 250,
				game.getMainScreen().getHeight() / 2 - 250, 0, 0, Color.WHITE);
		topRight = new Object_Creator(100, 100, game.getMainScreen().getWidth() / 2 + 150,
				game.getMainScreen().getHeight() / 2 - 250, 0, 0, Color.WHITE);
		botLeft = new Object_Creator(100, 100, game.getMainScreen().getWidth() / 2 - 250,
				game.getMainScreen().getHeight() / 2 + 150, 0, 0, Color.WHITE);
		botRight = new Object_Creator(100, 100, game.getMainScreen().getWidth() / 2 + 150,
				game.getMainScreen().getHeight() / 2 + 150, 0, 0, Color.WHITE);

		top = new Object_Creator(75, 500, game.getMainScreen().getWidth() / 2 - 250,
				game.getMainScreen().getHeight() / 2 - 425, 0, 0, Color.WHITE);
		bot = new Object_Creator(75, 500, game.getMainScreen().getWidth() / 2 - 250,
				game.getMainScreen().getHeight() / 2 + 350, 0, 0, Color.WHITE);
		left = new Object_Creator(500, 75, game.getMainScreen().getWidth() / 2 - 425,
				game.getMainScreen().getHeight() / 2 - 250, 0, 0, Color.WHITE);
		right = new Object_Creator(500, 75, game.getMainScreen().getWidth() / 2 + 350,
				game.getMainScreen().getHeight() / 2 - 250, 0, 0, Color.WHITE);

		Coin1 = new Object_Creator(60, 60, game.getMainScreen().getWidth() / 2 - 325,
				game.getMainScreen().getHeight() / 2 - 250, 0, 0, "Collect the coin/coin.gif", false);
		Coin2 = new Object_Creator(60, 60, game.getMainScreen().getWidth() / 2 - 125,
				game.getMainScreen().getHeight() / 2 - 125, 0, 0, "Collect the coin/coin.gif", false);
		Coin3 = new Object_Creator(60, 60, game.getMainScreen().getWidth() / 2 + 275,
				game.getMainScreen().getHeight() / 2 + 285, 0, 0, "Collect the coin/coin.gif", false);

		objects = new Object_Creator[] { center, topLeft, topRight, botLeft, botRight, top, left, right, bot };

		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);

	}

	/**
	 * draws the player image draws the Object images removes object if taken
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		try {
			g.drawImage(ImageIO.read(new File("Collect the coin/pot of gold.gif")), this.getPlayer().getxLoc(),
					this.getPlayer().getyLoc(), WIDTH, HEIGHT, this);
		} catch (IOException e) {
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(8));

		for (int i = 0; i < objects.length; i++) {

			g.setColor(objects[i].getColor());
			g.drawRect(objects[i].getxLocation(), objects[i].getyLocation(), objects[i].getWidth(),
					objects[i].getHeight());
		}

		if (!Coin1.isTaken()) {
			g.drawImage(Coin1.getObjectImage(), Coin1.getxLocation(), Coin1.getyLocation(), Coin1.getWidth(),
					Coin1.getHeight(), this);
		}
		if (!Coin2.isTaken()) {
			g.drawImage(Coin2.getObjectImage(), Coin2.getxLocation(), Coin2.getyLocation(), Coin2.getWidth(),
					Coin2.getHeight(), this);
		}
		if (!Coin3.isTaken()) {
			g.drawImage(Coin3.getObjectImage(), Coin3.getxLocation(), Coin3.getyLocation(), Coin3.getWidth(),
					Coin3.getHeight(), this);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Sets the coin to taken so that it doesn't get printed
	 * 
	 * @param coinToTake
	 *            - the coin the player hit
	 */
	private void takeCoin(Object_Creator coinToTake) {
		coinToTake.setTaken(true);
		coinCount -= 1;
	}

	/**
	 * logic for keyPresses
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (!super.detectCollisionPlayerInsideTopWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().moveUp();
				for (int i = 0; i < objects.length; i++) {
					if (super.detectCollisionPlayerOutsideBottomWall(objects[i]))
						this.getPlayer().setyLoc(objects[i].getyLocation() + objects[i].getHeight() + 5);
				}
				if (super.detectCollisionPlayerOutsideBottomWall(Coin1))
					if (!Coin1.isTaken())
						takeCoin(Coin1);
				if (super.detectCollisionPlayerOutsideBottomWall(Coin2))
					if (!Coin2.isTaken())
						takeCoin(Coin2);
				if (super.detectCollisionPlayerOutsideBottomWall(Coin3))
					if (!Coin3.isTaken())
						takeCoin(Coin3);
			}

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (!super.detectCollisionPlayerInsideBottomWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().moveDown();
				for (int i = 0; i < objects.length; i++) {
					if (super.detectCollisionPlayerOutsideTopWall(objects[i]))
						this.getPlayer().setyLoc(objects[i].getyLocation() - this.getPlayer().getHeight() - 5);
				}
				if (super.detectCollisionPlayerOutsideTopWall(Coin1))
					if (!Coin1.isTaken())
						takeCoin(Coin1);
				if (super.detectCollisionPlayerOutsideTopWall(Coin2))
					if (!Coin2.isTaken())
						takeCoin(Coin2);
				if (super.detectCollisionPlayerOutsideTopWall(Coin3))
					if (!Coin3.isTaken())
						takeCoin(Coin3);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (!super.detectCollisionPlayerInsideLeftWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().moveLeft();
				for (int i = 0; i < objects.length; i++) {
					if (super.detectCollisionPlayerOutsideRightWall(objects[i]))
						this.getPlayer().setxLoc(objects[i].getxLocation() + objects[i].getWidth() + 5);
				}
				if (super.detectCollisionPlayerOutsideRightWall(Coin1))
					if (!Coin1.isTaken())
						takeCoin(Coin1);
				if (super.detectCollisionPlayerOutsideRightWall(Coin2))
					if (!Coin2.isTaken())
						takeCoin(Coin2);
				if (super.detectCollisionPlayerOutsideRightWall(Coin3))
					if (!Coin3.isTaken())
						takeCoin(Coin3);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!super.detectCollisionPlayerInsideRightWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().moveRight();
				for (int i = 0; i < objects.length; i++) {
					if (super.detectCollisionPlayerOutsideLeftWall(objects[i]))
						this.getPlayer().setxLoc(objects[i].getxLocation() - this.getPlayer().getWidth() - 5);
				}
				if (super.detectCollisionPlayerOutsideLeftWall(Coin1))
					if (!Coin1.isTaken())
						takeCoin(Coin1);
				if (super.detectCollisionPlayerOutsideLeftWall(Coin2))
					if (!Coin2.isTaken())
						takeCoin(Coin2);
				if (super.detectCollisionPlayerOutsideLeftWall(Coin3))
					if (!Coin3.isTaken())
						takeCoin(Coin3);

			}
		}
		this.repaint();
		if (this.checkForWin()) {
			super.gameEndScreen("You won!");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyPressed(e);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	/**
	 * checks to see if the player has won the game
	 * 
	 * @return true if there are no coins on the board else false
	 */
	private boolean checkForWin() {
		if (coinCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the coinCount
	 */
	public int getCoinCount() {
		return coinCount;
	}

	/**
	 * @param coinCount
	 *            the coinCount to set
	 */
	public void setCoinCount(int coinCount) {
		this.coinCount = coinCount;
	}

	/**
	 * @return the center
	 */
	public Object_Creator getCenter() {
		return center;
	}

	/**
	 * @param center
	 *            the center to set
	 */
	public void setCenter(Object_Creator center) {
		this.center = center;
	}

	/**
	 * @return the topLeft
	 */
	public Object_Creator getTopLeft() {
		return topLeft;
	}

	/**
	 * @param topLeft
	 *            the topLeft to set
	 */
	public void setTopLeft(Object_Creator topLeft) {
		this.topLeft = topLeft;
	}

	/**
	 * @return the topRight
	 */
	public Object_Creator getTopRight() {
		return topRight;
	}

	/**
	 * @param topRight
	 *            the topRight to set
	 */
	public void setTopRight(Object_Creator topRight) {
		this.topRight = topRight;
	}

	/**
	 * @return the botLeft
	 */
	public Object_Creator getBotLeft() {
		return botLeft;
	}

	/**
	 * @param botLeft
	 *            the botLeft to set
	 */
	public void setBotLeft(Object_Creator botLeft) {
		this.botLeft = botLeft;
	}

	/**
	 * @return the botRight
	 */
	public Object_Creator getBotRight() {
		return botRight;
	}

	/**
	 * @param botRight
	 *            the botRight to set
	 */
	public void setBotRight(Object_Creator botRight) {
		this.botRight = botRight;
	}

	/**
	 * @return the top
	 */
	public Object_Creator getTop() {
		return top;
	}

	/**
	 * @param top
	 *            the top to set
	 */
	public void setTop(Object_Creator top) {
		this.top = top;
	}

	/**
	 * @return the left
	 */
	public Object_Creator getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Object_Creator left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Object_Creator getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Object_Creator right) {
		this.right = right;
	}

	/**
	 * @return the bot
	 */
	public Object_Creator getBot() {
		return bot;
	}

	/**
	 * @param bot
	 *            the bot to set
	 */
	public void setBot(Object_Creator bot) {
		this.bot = bot;
	}

	/**
	 * @return the coin1
	 */
	public Object_Creator getCoin1() {
		return Coin1;
	}

	/**
	 * @param coin1
	 *            the coin1 to set
	 */
	public void setCoin1(Object_Creator coin1) {
		Coin1 = coin1;
	}

	/**
	 * @return the coin2
	 */
	public Object_Creator getCoin2() {
		return Coin2;
	}

	/**
	 * @param coin2
	 *            the coin2 to set
	 */
	public void setCoin2(Object_Creator coin2) {
		Coin2 = coin2;
	}

	/**
	 * @return the coin3
	 */
	public Object_Creator getCoin3() {
		return Coin3;
	}

	/**
	 * @param coin3
	 *            the coin3 to set
	 */
	public void setCoin3(Object_Creator coin3) {
		Coin3 = coin3;
	}

	/**
	 * @return the wIDTH
	 */
	public int getWIDTH() {
		return WIDTH;
	}

	/**
	 * @return the hEIGHT
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}

	/**
	 * @return the xVEL
	 */
	public int getxVEL() {
		return xVEL;
	}

	/**
	 * @return the yVEL
	 */
	public int getyVEL() {
		return yVEL;
	}
}
