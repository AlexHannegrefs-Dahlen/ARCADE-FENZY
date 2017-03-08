package arcade.frenzy.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.view.main.menu.Main_Menu;
import arcade.frenzy.model.player.Player;

public class Tree_Climber extends Base_Game {

	private Object_Creator tree, branch, hole;

	private Image squirrel;

	/**
	 * 
	 * @param game
	 *            - The Main_Menu instance
	 * @param player
	 *            - The Player instance
	 * @param gui
	 * @throws IOException
	 */
	public Tree_Climber(Main_Menu game, Player player) throws IOException {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainPanel().getWidth() / 11 * 5);
		this.getPlayer().setyLoc(game.getMainPanel().getHeight() / 5 * 4 + 26);
		this.getPlayer().setWidth(game.getMainPanel().getWidth() / 11);
		this.getPlayer().setHeight(game.getMainPanel().getWidth() / 11);
		this.getPlayer().setxVel(game.getMainPanel().getWidth() / 11);
		this.getPlayer().setyVel(game.getMainPanel().getWidth() / 11);

		tree = new Object_Creator(this.getGame().getMainPanel().getHeight(),
				this.getGame().getMainPanel().getWidth() / 11 * 3, this.getGame().getMainPanel().getWidth() / 11 * 4, 0,
				0, 0, "Tree Climber/Anc_talltree.gif");
		// branch = new Object_Creator(height, width, x_location, y_location,
		// x_velocity, y_velocity, img_url);

		squirrel = ImageIO.read(new File("Tree Climber/squirrel.png"));

		// gui.setGameBackGround(GameNames.Tree_Climber);
		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.CYAN);
		g.fillRect(this.getGame().getMainPanel().getWidth() / 11 * 3, 0, this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getHeight());

		g.setColor(Color.RED);
		g.drawImage(tree.getPicture(), this.getGame().getMainPanel().getWidth() / 11 * 4, 0,
				this.getGame().getMainPanel().getWidth() / 11 * 3, this.getGame().getMainPanel().getHeight(), this);

		g.setColor(Color.CYAN);
		g.fillRect(this.getGame().getMainPanel().getWidth() / 11 * 7, 0, this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getHeight());

		g.setColor(Color.WHITE);
		g.drawImage(squirrel, this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
				this.getPlayer().getHeight(), this);

		g.setColor(Color.WHITE);
		g.fillRect(this.getGame().getMainPanel().getWidth() / 11 * 4, this.getGame().getMainPanel().getHeight() / 2,
				this.getGame().getMainPanel().getWidth() / 11, this.getGame().getMainPanel().getWidth() / 11);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
		}

		/*else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
		}*/

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
		}

		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
