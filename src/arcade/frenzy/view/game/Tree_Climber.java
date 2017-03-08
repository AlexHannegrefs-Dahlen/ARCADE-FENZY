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

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.view.main.menu.Main_Menu;
import arcade.frenzy.model.player.Player;

public class Tree_Climber extends Base_Game {

	private Object_Creator tree, leftWall, rightWall, branch, flippedBranch, hole, playerSpaces;

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
	public Tree_Climber(Main_Menu game, Player player, Image image) throws IOException {
		super(image);
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainPanel().getWidth() / 11 * 5);
		this.getPlayer().setyLoc(game.getMainPanel().getHeight() / 5 * 4 + 26);
		this.getPlayer().setWidth(game.getMainPanel().getWidth() / 12);
		this.getPlayer().setHeight(game.getMainPanel().getWidth() / 12);
		this.getPlayer().setxVel(game.getMainPanel().getWidth() / 11);
		this.getPlayer().setyVel(game.getMainPanel().getWidth() / 550);

		tree = new Object_Creator(this.getGame().getMainPanel().getHeight(),
				this.getGame().getMainPanel().getWidth() / 11 * 3 + 1020,
				this.getGame().getMainPanel().getWidth() / 11 * 4 - 572, 0, 0, 0, "Tree Climber/Anc_talltree.gif");

		leftWall = new Object_Creator(this.getGame().getMainPanel().getHeight(),
				this.getGame().getMainPanel().getWidth() / 11, this.getGame().getMainPanel().getWidth() / 11 * 3, 0, 0,
				0, Color.CYAN);
		rightWall = new Object_Creator(this.getGame().getMainPanel().getHeight(),
				this.getGame().getMainPanel().getWidth() / 11, this.getGame().getMainPanel().getWidth() / 11 * 7, 0, 0,
				0, Color.CYAN);

		playerSpaces = new Object_Creator(this.getGame().getMainPanel().getHeight(),
				this.getGame().getMainPanel().getWidth() / 11 * 3, this.getGame().getMainPanel().getWidth() / 11 * 3, 0,
				0, 0, Color.cyan);

		branch = new Object_Creator(this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getWidth() / 11 - 1, this.getGame().getMainPanel().getWidth() / 11 * 4,
				this.getGame().getMainPanel().getHeight() / 2 - 100, 0, 0, "Tree Climber/Branch.gif");

		flippedBranch = new Object_Creator(this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getWidth() / 11, this.getGame().getMainPanel().getWidth() / 11 * 6,
				this.getGame().getMainPanel().getHeight() / 2 - 400, 0, 0, "Tree Climber/BranchFlipped.gif");

		hole = new Object_Creator(this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getHeight() / 11, this.getGame().getMainPanel().getWidth() / 11 * 5 + 50,
				this.getGame().getMainPanel().getHeight() / 2 + 100, 0, 0, "Tree Climber/Hole.gif");

		squirrel = ImageIO.read(new File("Tree Climber/squirrel.png"));

		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);

	}

	public void paint(Graphics g) {
		super.paint(g);

		/*
		 * g.setColor(leftWall.getColor()); g.fillRect(leftWall.getX_Location(),
		 * leftWall.getY_Location(), leftWall.getWidth(), leftWall.getHeight());
		 */
		/*
		 * g.setColor(rightWall.getColor());
		 * g.fillRect(rightWall.getX_Location(), rightWall.getY_Location(),
		 * rightWall.getWidth(), rightWall.getHeight());
		 */

		g.drawImage(tree.getPicture(), tree.getX_Location(), tree.getY_Location(), tree.getWidth(), tree.getHeight(),
				this);

		g.setColor(Color.WHITE);
		g.fillRect(branch.getX_Location(), branch.getY_Location(), branch.getWidth(), branch.getHeight());

		g.drawImage(flippedBranch.getPicture(), flippedBranch.getX_Location(), flippedBranch.getY_Location(),
				flippedBranch.getWidth(), flippedBranch.getHeight(), this);

		g.drawImage(hole.getPicture(), hole.getX_Location(), hole.getY_Location(), hole.getWidth(), hole.getHeight(),
				this);

		g.setColor(Color.WHITE);
		g.fillRect(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
				this.getPlayer().getHeight());

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
				if (super.detectCollisionPlayerOutsideBottomWall(hole))
					this.getPlayer().setyLoc(this.hole.getY_Location() + this.hole.getHeight());
				if (super.detectCollisionPlayerOutsideBottomWall(branch))
					this.getPlayer().setyLoc(this.branch.getY_Location() + this.branch.getHeight());
				if (super.detectCollisionPlayerOutsideBottomWall(flippedBranch))
					this.getPlayer().setyLoc(this.flippedBranch.getY_Location() + this.flippedBranch.getHeight());
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (super.detectCollisionPlayerInsideLeftWall(playerSpaces.getX_Location(), playerSpaces.getY_Location(),
					playerSpaces.getWidth(), playerSpaces.getHeight())) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
				if (super.detectCollisionPlayerOutsideRightWall(hole))
					this.getPlayer().setxLoc(this.hole.getX_Location() + this.hole.getWidth() + 1);
				if (super.detectCollisionPlayerOutsideRightWall(branch))
					this.getPlayer().setxLoc(this.branch.getX_Location() + this.branch.getWidth());
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!super.detectCollisionPlayerOutsideLeftWall(rightWall)) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
				if (super.detectCollisionPlayerOutsideLeftWall(rightWall)) {
					this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
				}
			}
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
