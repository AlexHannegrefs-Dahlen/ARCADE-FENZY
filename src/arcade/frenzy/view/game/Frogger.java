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

public class Frogger extends Base_Game {

	private Object_Creator topCar, midCar, botCar, start, firstRoad, firstGrass, secondRoad, secondGrass, thirdRoad,
			finish;

	private Image frogger;

	private Timer carTimer = new Timer(50 / 3, this);

	/**
	 * 
	 * @param game
	 *            - game instance
	 * @param player
	 *            - current player
	 * @throws IOException
	 */
	public Frogger(Main_Menu game, Player player) throws IOException {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainPanel().getWidth() / 2);
		this.getPlayer().setyLoc(game.getMainPanel().getHeight() / 10 * 9);
		this.getPlayer().setWidth(this.getGame().getMainPanel().getHeight() / 10);
		this.getPlayer().setHeight(this.getGame().getMainPanel().getHeight() / 10);
		this.getPlayer().setxVel(this.getGame().getMainPanel().getHeight() / 10);
		this.getPlayer().setyVel(this.getGame().getMainPanel().getHeight() / 10);

		finish = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, 0, 0, 0, "Frogger/grass.jpg");
		thirdRoad = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10 * 2,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight(), 0, 0, "Frogger/road.jpg");
		secondGrass = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 3, 0, 0, "Frogger/grass.jpg");
		secondRoad = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10 * 2,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 4, 0, 0, "Frogger/road.jpg");
		firstGrass = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 6, 0, 0, "Frogger/grass.jpg");
		firstRoad = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10 * 2,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 7, 0, 0, "Frogger/road.jpg");
		start = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 9, 0, 0, "Frogger/grass.jpg");

		topCar = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10, 200, 0,
				this.finish.getHeight() * 3 / 2, 75, 0, "Frogger/topCar.gif");
		midCar = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10, 200,
				this.getGame().getMainPanel().getWidth() - 200, this.finish.getHeight() * 9 / 2, -40, 0,
				"Frogger/midCar.png");
		botCar = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10, 200, 0,
				this.finish.getHeight() * 15 / 2, 25, 0, "Frogger/botCar.gif");

		frogger = ImageIO.read(new File("Frogger/frogUp.png"));

		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
		this.getCarTimer().start();
	}

	/**
	 * Paints the objects and player of the game
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(finish.getObjectImage(), finish.getxLocation(), finish.getyLocation(), finish.getWidth(),
				finish.getHeight(), this);
		g.drawImage(thirdRoad.getObjectImage(), thirdRoad.getxLocation(), thirdRoad.getyLocation(),
				thirdRoad.getWidth(), thirdRoad.getHeight(), this);
		g.drawImage(secondGrass.getObjectImage(), secondGrass.getxLocation(), secondGrass.getyLocation(),
				secondGrass.getWidth(), secondGrass.getHeight(), this);
		g.drawImage(secondRoad.getObjectImage(), secondRoad.getxLocation(), secondRoad.getyLocation(),
				secondRoad.getWidth(), secondRoad.getHeight(), this);
		g.drawImage(firstGrass.getObjectImage(), firstGrass.getxLocation(), firstGrass.getyLocation(),
				firstGrass.getWidth(), firstGrass.getHeight(), this);
		g.drawImage(firstRoad.getObjectImage(), firstRoad.getxLocation(), firstRoad.getyLocation(),
				firstRoad.getWidth(), firstRoad.getHeight(), this);
		g.drawImage(start.getObjectImage(), start.getxLocation(), start.getyLocation(), start.getWidth(),
				start.getHeight(), this);

		g.drawImage(topCar.getObjectImage(), topCar.getxLocation(), topCar.getyLocation(), topCar.getWidth(),
				topCar.getHeight(), this);
		g.drawImage(midCar.getObjectImage(), midCar.getxLocation(), midCar.getyLocation(), midCar.getWidth(),
				midCar.getHeight(), this);
		g.drawImage(botCar.getObjectImage(), botCar.getxLocation(), botCar.getyLocation(), botCar.getWidth(),
				botCar.getHeight(), this);

		g.setColor(Color.WHITE);
		g.drawImage(frogger, this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
				this.getPlayer().getHeight(), this);

	}

	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {

	}

	/**
	 * Player movement
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			try {
				frogger = ImageIO.read(new File("Frogger/frogUp.png"));
			} catch (IOException e1) {
			}
			if (!super.detectCollisionPlayerInsideTopWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
			} else {
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
				this.repaint();
				this.getCarTimer().stop();
				this.playerWon();
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			try {
				frogger = ImageIO.read(new File("Frogger/frogDown.png"));
			} catch (IOException e1) {
			}
			if (!super.detectCollisionPlayerInsideBottomWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
			}

		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			try {
				frogger = ImageIO.read(new File("Frogger/frogLeft.png"));
			} catch (IOException e1) {
			}
			if (!super.detectCollisionPlayerInsideLeftWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				frogger = ImageIO.read(new File("Frogger/frogRight.png"));
			} catch (IOException e1) {
			}
			if (!super.detectCollisionPlayerInsideRightWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
			}
		}
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * car movement
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carTimer) {
			if (this.topCar.getxLocation() > this.getGame().getMainPanel().getWidth() - 200) {
				this.topCar.setxVelocity(this.topCar.getxVelocity() * -1);
				try {
					topCar.setObjectImage(ImageIO.read(new File("Frogger/topCarFlipped.gif")));
				} catch (IOException e1) {
				}
			}
			if (this.topCar.getxLocation() < 20) {
				this.topCar.setxVelocity(this.topCar.getxVelocity() * -1);
				try {
					topCar.setObjectImage(ImageIO.read(new File("Frogger/topCar.gif")));
				} catch (IOException e1) {
				}
			}
			if (this.midCar.getxLocation() > this.getGame().getMainPanel().getWidth() - 200) {
				this.midCar.setxVelocity(this.midCar.getxVelocity() * -1);
				try {
					midCar.setObjectImage(ImageIO.read(new File("Frogger/midCar.png")));
				} catch (IOException e1) {
				}
			}
			if (this.midCar.getxLocation() < 20) {
				this.midCar.setxVelocity(this.midCar.getxVelocity() * -1);
				try {
					midCar.setObjectImage(ImageIO.read(new File("Frogger/midCarFlipped.png")));
				} catch (IOException e1) {
				}
			}
			if (this.botCar.getxLocation() > this.getGame().getMainPanel().getWidth() - 200) {
				this.botCar.setxVelocity(this.botCar.getxVelocity() * -1);
				try {
					botCar.setObjectImage(ImageIO.read(new File("Frogger/botCarFlipped.gif")));
				} catch (IOException e1) {
				}
			}
			if (this.botCar.getxLocation() < 20) {
				this.botCar.setxVelocity(this.botCar.getxVelocity() * -1);
				try {
					botCar.setObjectImage(ImageIO.read(new File("Frogger/botCar.gif")));
				} catch (IOException e1) {
				}
			}
			this.topCar.setxLocation(this.topCar.getxLocation() + this.topCar.getxVelocity());
			this.midCar.setxLocation(this.midCar.getxLocation() + this.midCar.getxVelocity());
			this.botCar.setxLocation(this.botCar.getxLocation() + this.botCar.getxVelocity());

			this.repaint();

			if (checkForlose()) {
				this.getCarTimer().stop();
				playerLost();
			}
		}
	}

	private boolean checkForlose() {
		if (super.detectCollisionPlayerOutsideBottomWall(botCar) || super.detectCollisionPlayerOutsideTopWall(botCar)
				|| super.detectCollisionPlayerOutsideLeftWall(botCar)
				|| super.detectCollisionPlayerOutsideRightWall(botCar))
			return true;
		if (super.detectCollisionPlayerOutsideBottomWall(midCar) || super.detectCollisionPlayerOutsideTopWall(midCar)
				|| super.detectCollisionPlayerOutsideLeftWall(midCar)
				|| super.detectCollisionPlayerOutsideRightWall(midCar))
			return true;
		if (super.detectCollisionPlayerOutsideBottomWall(topCar) || super.detectCollisionPlayerOutsideTopWall(topCar)
				|| super.detectCollisionPlayerOutsideLeftWall(topCar)
				|| super.detectCollisionPlayerOutsideRightWall(topCar))
			return true;
		return false;
	}

	private void playerLost() {
		if (!this.getGame().isFrenzy()) {
			JOptionPane.showMessageDialog(this, "You are dead!");
			super.gameOver(this);
		} else {
			this.getPlayer().setxLoc(this.getGame().getMainPanel().getWidth() / 2);
			this.getPlayer().setyLoc(this.getGame().getMainPanel().getHeight() / 10 * 9);
			this.getCarTimer().start();
		}

	}

	private void playerWon() {
		if (!this.getGame().isFrenzy()) {
			JOptionPane.showMessageDialog(this, "You won!");
			super.gameOver(this);
		} else
			try {
				this.getGame().getCon().getFrenzy().gameOver(this);
			} catch (InterruptedException | IOException e1) {
			}
	}

	/**
	 * @return the carTimer
	 */
	public Timer getCarTimer() {
		return carTimer;
	}

	/**
	 * @param carTimer
	 *            the carTimer to set
	 */
	public void setCarTimer(Timer carTimer) {
		this.carTimer = carTimer;
	}

	/**
	 * @return the topCar
	 */
	public Object_Creator getTopCar() {
		return topCar;
	}

	/**
	 * @param topCar
	 *            the topCar to set
	 */
	public void setTopCar(Object_Creator topCar) {
		this.topCar = topCar;
	}

	/**
	 * @return the midCar
	 */
	public Object_Creator getMidCar() {
		return midCar;
	}

	/**
	 * @param midCar
	 *            the midCar to set
	 */
	public void setMidCar(Object_Creator midCar) {
		this.midCar = midCar;
	}

	/**
	 * @return the botCar
	 */
	public Object_Creator getBotCar() {
		return botCar;
	}

	/**
	 * @param botCar
	 *            the botCar to set
	 */
	public void setBotCar(Object_Creator botCar) {
		this.botCar = botCar;
	}

	/**
	 * @return the start
	 */
	public Object_Creator getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Object_Creator start) {
		this.start = start;
	}

	/**
	 * @return the firstRoad
	 */
	public Object_Creator getFirstRoad() {
		return firstRoad;
	}

	/**
	 * @param firstRoad
	 *            the firstRoad to set
	 */
	public void setFirstRoad(Object_Creator firstRoad) {
		this.firstRoad = firstRoad;
	}

	/**
	 * @return the firstGrass
	 */
	public Object_Creator getFirstGrass() {
		return firstGrass;
	}

	/**
	 * @param firstGrass
	 *            the firstGrass to set
	 */
	public void setFirstGrass(Object_Creator firstGrass) {
		this.firstGrass = firstGrass;
	}

	/**
	 * @return the secondRoad
	 */
	public Object_Creator getSecondRoad() {
		return secondRoad;
	}

	/**
	 * @param secondRoad
	 *            the secondRoad to set
	 */
	public void setSecondRoad(Object_Creator secondRoad) {
		this.secondRoad = secondRoad;
	}

	/**
	 * @return the secondGrass
	 */
	public Object_Creator getSecondGrass() {
		return secondGrass;
	}

	/**
	 * @param secondGrass
	 *            the secondGrass to set
	 */
	public void setSecondGrass(Object_Creator secondGrass) {
		this.secondGrass = secondGrass;
	}

	/**
	 * @return the thirdRoad
	 */
	public Object_Creator getThirdRoad() {
		return thirdRoad;
	}

	/**
	 * @param thirdRoad
	 *            the thirdRoad to set
	 */
	public void setThirdRoad(Object_Creator thirdRoad) {
		this.thirdRoad = thirdRoad;
	}

	/**
	 * @return the finish
	 */
	public Object_Creator getFinish() {
		return finish;
	}

	/**
	 * @param finish
	 *            the finish to set
	 */
	public void setFinish(Object_Creator finish) {
		this.finish = finish;
	}

	/**
	 * @return the frogger
	 */
	public Image getFrogger() {
		return frogger;
	}

	/**
	 * @param frogger
	 *            the frogger to set
	 */
	public void setFrogger(Image frogger) {
		this.frogger = frogger;
	}

}
