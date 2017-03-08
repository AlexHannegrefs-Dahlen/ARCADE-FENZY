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

	public void Winner() {
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(finish.getPicture(), finish.getX_Location(), finish.getY_Location(), finish.getWidth(),
				finish.getHeight(), this);
		g.drawImage(thirdRoad.getPicture(), thirdRoad.getX_Location(), thirdRoad.getY_Location(), thirdRoad.getWidth(),
				thirdRoad.getHeight(), this);
		g.drawImage(secondGrass.getPicture(), secondGrass.getX_Location(), secondGrass.getY_Location(),
				secondGrass.getWidth(), secondGrass.getHeight(), this);
		g.drawImage(secondRoad.getPicture(), secondRoad.getX_Location(), secondRoad.getY_Location(),
				secondRoad.getWidth(), secondRoad.getHeight(), this);
		g.drawImage(firstGrass.getPicture(), firstGrass.getX_Location(), firstGrass.getY_Location(),
				firstGrass.getWidth(), firstGrass.getHeight(), this);
		g.drawImage(firstRoad.getPicture(), firstRoad.getX_Location(), firstRoad.getY_Location(), firstRoad.getWidth(),
				firstRoad.getHeight(), this);
		g.drawImage(start.getPicture(), start.getX_Location(), start.getY_Location(), start.getWidth(),
				start.getHeight(), this);

		g.drawImage(topCar.getPicture(), topCar.getX_Location(), topCar.getY_Location(), topCar.getWidth(),
				topCar.getHeight(), this);
		g.drawImage(midCar.getPicture(), midCar.getX_Location(), midCar.getY_Location(), midCar.getWidth(),
				midCar.getHeight(), this);
		g.drawImage(botCar.getPicture(), botCar.getX_Location(), botCar.getY_Location(), botCar.getWidth(),
				botCar.getHeight(), this);

		g.setColor(Color.WHITE);
		g.drawImage(frogger, this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
				this.getPlayer().getHeight(), this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {

	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carTimer) {
			if (this.topCar.getX_Location() > this.getGame().getMainPanel().getWidth() - 200) {
				this.topCar.setX_Velocity(this.topCar.getX_Velocity() * -1);
				try {
					topCar.setPicture(ImageIO.read(new File("Frogger/topCarFlipped.gif")));
				} catch (IOException e1) {
				}
			}
			if (this.topCar.getX_Location() < 20) {
				this.topCar.setX_Velocity(this.topCar.getX_Velocity() * -1);
				try {
					topCar.setPicture(ImageIO.read(new File("Frogger/topCar.gif")));
				} catch (IOException e1) {
				}
			}
			if (this.midCar.getX_Location() > this.getGame().getMainPanel().getWidth() - 200) {
				this.midCar.setX_Velocity(this.midCar.getX_Velocity() * -1);
				try {
					midCar.setPicture(ImageIO.read(new File("Frogger/midCar.png")));
				} catch (IOException e1) {
				}
			}
			if (this.midCar.getX_Location() < 20) {
				this.midCar.setX_Velocity(this.midCar.getX_Velocity() * -1);
				try {
					midCar.setPicture(ImageIO.read(new File("Frogger/midCarFlipped.png")));
				} catch (IOException e1) {
				}
			}
			if (this.botCar.getX_Location() > this.getGame().getMainPanel().getWidth() - 200) {
				this.botCar.setX_Velocity(this.botCar.getX_Velocity() * -1);
				try {
					botCar.setPicture(ImageIO.read(new File("Frogger/botCarFlipped.gif")));
				} catch (IOException e1) {
				}
			}
			if (this.botCar.getX_Location() < 20) {
				this.botCar.setX_Velocity(this.botCar.getX_Velocity() * -1);
				try {
					botCar.setPicture(ImageIO.read(new File("Frogger/botCar.gif")));
				} catch (IOException e1) {
				}
			}
			this.topCar.setX_Location(this.topCar.getX_Location() + this.topCar.getX_Velocity());
			this.midCar.setX_Location(this.midCar.getX_Location() + this.midCar.getX_Velocity());
			this.botCar.setX_Location(this.botCar.getX_Location() + this.botCar.getX_Velocity());

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
		} else
			try {
				this.getGame().getCon().getFrenzy().gameOver(this);
			} catch (InterruptedException | IOException e1) {
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

}
