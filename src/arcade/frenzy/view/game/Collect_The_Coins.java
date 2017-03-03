package arcade.frenzy.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.UI.Games.Game_UI;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Collect_The_Coins extends Base_Game {

	private int width = 50, height = 50, xVel = 5, yVel = 5;

	private Object_Creator center, topLeft, topRight, botLeft, botRight, top, left, right, bot, Coin1, Coin2, Coin3;

	public Collect_The_Coins(Main_Menu game, Player player, Game_UI gui) {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainScreen().getWidth() / 2 - 25);
		this.getPlayer().setyLoc(game.getMainScreen().getHeight() / 2 + 100);
		this.getPlayer().setWidth(width);
		this.getPlayer().setHeight(height);
		this.getPlayer().setxVel(xVel);
		this.getPlayer().setyVel(yVel);
		
		

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
		
		Coin1 = new Object_Creator(30, 30, game.getMainScreen().getWidth() / 2 - 312,
				game.getMainScreen().getHeight() / 2 - 250, 0, 0, Color.YELLOW, false);
		Coin2 = new Object_Creator(30, 30, game.getMainScreen().getWidth() / 2,
				game.getMainScreen().getHeight() / 2, 0, 0, Color.YELLOW, false);
		Coin3 = new Object_Creator(30, 30, game.getMainScreen().getWidth() / 2,
				game.getMainScreen().getHeight() / 2, 0, 0, Color.YELLOW, false);

		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);

	}
// move to game_UI eventually 
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillOval(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), width, height);

		g.setColor(center.getColor());
		g.drawRect(center.getX_Location(), center.getY_Location(), center.getWidth(), center.getHeight());
		
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
		
		g.setColor(Coin1.getColor());
		g.fillOval(Coin1.getX_Location(), Coin1.getY_Location(), Coin1.getWidth(), Coin1.getHeight());
		g.setColor(Coin2.getColor());
		g.fillOval(Coin2.getX_Location(), Coin2.getY_Location(), Coin2.getWidth(), Coin2.getHeight());
		g.setColor(Coin3.getColor());
		g.fillOval(Coin3.getX_Location(), Coin3.getY_Location(), Coin3.getWidth(), Coin3.getHeight());
		
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
					this.getGame().getMainPanel().getHeight())
					&& !super.detectCollisionPlayerOutsideBottomWall(center.getX_Location(), center.getY_Location(),
							center.getWidth(), center.getHeight()))
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
			else {
				this.getPlayer().setyLoc(center.getY_Location() + center.getHeight());
				this.repaint();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (!super.detectCollisionPlayerInsideBottomWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())
					&& !super.detectCollisionPlayerOutsideTopWall(center.getX_Location(), center.getY_Location(),
							center.getWidth(), center.getHeight()))
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
			else {
				this.getPlayer().setyLoc(center.getY_Location() - this.getPlayer().getHeight());
				this.repaint();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (!super.detectCollisionPlayerInsideLeftWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())
					&& !super.detectCollisionPlayerOutsideRightWall(center.getX_Location(), center.getY_Location(),
							center.getWidth(), center.getHeight()))
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
			this.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!super.detectCollisionPlayerInsideRightWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())
					&& !super.detectCollisionPlayerOutsideLeftWall(center.getX_Location(), center.getY_Location(),
							center.getWidth(), center.getHeight()))
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
			this.repaint();
		}
		this.repaint();

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

}
