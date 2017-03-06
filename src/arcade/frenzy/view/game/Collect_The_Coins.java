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
import javax.swing.JOptionPane;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Collect_The_Coins extends Base_Game {

	private final int WIDTH = 60, HEIGHT = 60, xVEL = 15, yVEL = 15;

	private int coinCount = 3;

	private Object_Creator center, topLeft, topRight, botLeft, botRight, top, left, right, bot, Coin1, Coin2, Coin3;

	public Collect_The_Coins(Main_Menu game, Player player, Game_UI gui, Image image) throws IOException {
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

		Coin1 = new Object_Creator(60, 60, game.getMainScreen().getWidth() / 2 - 312,
				game.getMainScreen().getHeight() / 2 - 250, 0, 0, "Collect the coin/coin.gif", false);
		Coin2 = new Object_Creator(60, 60, game.getMainScreen().getWidth() / 2 - 100,
				game.getMainScreen().getHeight() / 2 - 125, 0, 0, "Collect the coin/coin.gif", false);
		Coin3 = new Object_Creator(60, 60, game.getMainScreen().getWidth() / 2 + 250,
				game.getMainScreen().getHeight() / 2 + 285, 0, 0, "Collect the coin/coin.gif", false);

		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);

	}

	// move to game_UI eventually
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		// g.fillOval(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(),
		// width, height);
		try {
			g.drawImage(ImageIO.read(new File("Collect the coin/pot of gold.gif")), this.getPlayer().getxLoc(),
					this.getPlayer().getyLoc(), WIDTH, HEIGHT, this);
		} catch (IOException e) {
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(8));
		g2.setColor(center.getColor());
		g2.drawRect(center.getX_Location(), center.getY_Location(), center.getWidth(), center.getHeight());

		g.setColor(topLeft.getColor());
		g.drawRect(topLeft.getX_Location(), topLeft.getY_Location(), topLeft.getWidth(), topLeft.getHeight());
		g.setColor(topRight.getColor());
		g.drawRect(topRight.getX_Location(), topRight.getY_Location(), topRight.getWidth(), topRight.getHeight());
		g.setColor(botLeft.getColor());
		g.drawRect(botLeft.getX_Location(), botLeft.getY_Location(), botLeft.getWidth(), botLeft.getHeight());
		g.setColor(botRight.getColor());
		g.drawRect(botRight.getX_Location(), botRight.getY_Location(), botRight.getWidth(), botRight.getHeight());

		g.setColor(top.getColor());
		g.drawRect(top.getX_Location(), top.getY_Location(), top.getWidth(), top.getHeight());
		g.setColor(bot.getColor());
		g.drawRect(bot.getX_Location(), bot.getY_Location(), bot.getWidth(), bot.getHeight());
		g.setColor(left.getColor());
		g.drawRect(left.getX_Location(), left.getY_Location(), left.getWidth(), left.getHeight());
		g.setColor(right.getColor());
		g.drawRect(right.getX_Location(), right.getY_Location(), right.getWidth(), right.getHeight());

		if (!Coin1.isTaken()) {
			g.drawImage(Coin1.getPicture(), Coin1.getX_Location(), Coin1.getY_Location(), Coin1.getWidth(),
					Coin1.getHeight(), this);
		}
		if (!Coin2.isTaken()) {
			g.drawImage(Coin2.getPicture(), Coin2.getX_Location(), Coin2.getY_Location(), Coin2.getWidth(),
					Coin2.getHeight(), this);
		}
		if (!Coin3.isTaken()) {
			g.drawImage(Coin3.getPicture(), Coin3.getX_Location(), Coin3.getY_Location(), Coin3.getWidth(),
					Coin3.getHeight(), this);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (!super.detectCollisionPlayerInsideTopWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
				if (super.detectCollisionPlayerOutsideBottomWall(center))
					this.getPlayer().setyLoc(center.getY_Location() + center.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(topLeft))
					this.getPlayer().setyLoc(topLeft.getY_Location() + topLeft.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(topRight))
					this.getPlayer().setyLoc(topRight.getY_Location() + topRight.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(botLeft))
					this.getPlayer().setyLoc(botLeft.getY_Location() + botLeft.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(botRight))
					this.getPlayer().setyLoc(botRight.getY_Location() + botRight.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(top))
					this.getPlayer().setyLoc(top.getY_Location() + top.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(right))
					this.getPlayer().setyLoc(right.getY_Location() + right.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(left))
					this.getPlayer().setyLoc(left.getY_Location() + left.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(bot))
					this.getPlayer().setyLoc(bot.getY_Location() + bot.getHeight() + 5);
				if (super.detectCollisionPlayerOutsideBottomWall(Coin1)) {
					if (!Coin1.isTaken()) {
						Coin1.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideBottomWall(Coin2)) {
					if (!Coin2.isTaken()) {
						Coin2.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideBottomWall(Coin3)) {
					if (!Coin3.isTaken()) {
						Coin3.setTaken(true);
						coinCount -= 1;
					}
				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (!super.detectCollisionPlayerInsideBottomWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
				if (super.detectCollisionPlayerOutsideTopWall(center))
					this.getPlayer().setyLoc(center.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(topLeft))
					this.getPlayer().setyLoc(topLeft.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(topRight))
					this.getPlayer().setyLoc(topRight.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(botLeft))
					this.getPlayer().setyLoc(botLeft.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(botRight))
					this.getPlayer().setyLoc(botRight.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(top))
					this.getPlayer().setyLoc(top.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(right))
					this.getPlayer().setyLoc(right.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(left))
					this.getPlayer().setyLoc(left.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(bot))
					this.getPlayer().setyLoc(bot.getY_Location() - this.getPlayer().getHeight() - 5);
				if (super.detectCollisionPlayerOutsideTopWall(Coin1)) {
					if (!Coin1.isTaken()) {
						Coin1.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideTopWall(Coin2)) {
					if (!Coin2.isTaken()) {
						Coin2.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideTopWall(Coin3)) {
					if (!Coin3.isTaken()) {
						Coin3.setTaken(true);
						coinCount -= 1;
					}
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (!super.detectCollisionPlayerInsideLeftWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
				if (super.detectCollisionPlayerOutsideRightWall(center))
					this.getPlayer().setxLoc(center.getX_Location() + center.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(topLeft))
					this.getPlayer().setxLoc(topLeft.getX_Location() + topLeft.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(botRight))
					this.getPlayer().setxLoc(botRight.getX_Location() + botRight.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(topRight))
					this.getPlayer().setxLoc(topRight.getX_Location() + topRight.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(botLeft))
					this.getPlayer().setxLoc(botLeft.getX_Location() + botLeft.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(top))
					this.getPlayer().setxLoc(top.getX_Location() + top.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(bot))
					this.getPlayer().setxLoc(bot.getX_Location() + bot.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(left))
					this.getPlayer().setxLoc(left.getX_Location() + left.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(right))
					this.getPlayer().setxLoc(right.getX_Location() + right.getWidth() + 5);
				if (super.detectCollisionPlayerOutsideRightWall(Coin1)) {
					if (!Coin1.isTaken()) {
						Coin1.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideRightWall(Coin2)) {
					if (!Coin2.isTaken()) {
						Coin2.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideRightWall(Coin3)) {
					if (!Coin3.isTaken()) {
						Coin3.setTaken(true);
						coinCount -= 1;
					}
				}
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!super.detectCollisionPlayerInsideRightWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
				if (super.detectCollisionPlayerOutsideLeftWall(center))
					this.getPlayer().setxLoc(center.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(topLeft))
					this.getPlayer().setxLoc(topLeft.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(botRight))
					this.getPlayer().setxLoc(botRight.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(topRight))
					this.getPlayer().setxLoc(topRight.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(botLeft))
					this.getPlayer().setxLoc(botLeft.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(top))
					this.getPlayer().setxLoc(top.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(bot))
					this.getPlayer().setxLoc(bot.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(left))
					this.getPlayer().setxLoc(left.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(right))
					this.getPlayer().setxLoc(right.getX_Location() - this.getPlayer().getWidth() - 5);
				if (super.detectCollisionPlayerOutsideLeftWall(Coin1)) {
					if (!Coin1.isTaken()) {
						Coin1.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideLeftWall(Coin2)) {
					if (!Coin2.isTaken()) {
						Coin2.setTaken(true);
						coinCount -= 1;
					}
				}
				if (super.detectCollisionPlayerOutsideLeftWall(Coin3)) {
					if (!Coin3.isTaken()) {
						Coin3.setTaken(true);
						coinCount -= 1;
					}
				}
			}
		}
		this.repaint();
		if (this.checkForWin()) {
			if (!this.getGame().isFrenzy()) {
				JOptionPane.showMessageDialog(this, "You won!");
				super.gameOver(this);
			} else
				try {
					this.getGame().getCon().getFrenzy().gameOver(this);
				} catch (InterruptedException | IOException e1) {
				}
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

	private boolean checkForWin() {
		if (coinCount == 0) {
			return true;
		} else {
			return false;
		}
	}
}
