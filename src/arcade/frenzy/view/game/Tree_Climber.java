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

/**
 * 
 * @author Alex Tree Climber game
 */
public class Tree_Climber extends Base_Game {

	private Object_Creator tree, branch, flippedBranch, hole;

	private Image squirrel;

	/**
	 * 
	 * @param game
	 *            - The Main_Menu instance
	 * @param player
	 *            - The Player instance
	 * @throws IOException
	 */
	public Tree_Climber(Main_Menu game, Player player, Image image) throws IOException {
		super(image);
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainPanel().getWidth() / 11 * 5);
		this.getPlayer().setyLoc(game.getMainPanel().getHeight() - (game.getMainPanel().getWidth() / 11));
		this.getPlayer().setWidth(game.getMainPanel().getWidth() / 11);
		this.getPlayer().setHeight(game.getMainPanel().getWidth() / 11);
		this.getPlayer().setxVel(game.getMainPanel().getWidth() / 11);
		this.getPlayer().setyVel(game.getMainPanel().getWidth() / 75);

		tree = new Object_Creator(this.getGame().getMainPanel().getHeight(),
				this.getGame().getMainPanel().getWidth() / 11 * 3 + 1020,
				this.getGame().getMainPanel().getWidth() / 11 * 4 - 572, 0, 0, 0, "Tree Climber/Anc_talltree.gif");

		branch = new Object_Creator(this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getWidth() / 11, this.getGame().getMainPanel().getWidth() / 11 * 4,
				this.getGame().getMainPanel().getHeight() / 2 - 100, 0, 0, "Tree Climber/Branch.gif");

		flippedBranch = new Object_Creator(this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getWidth() / 11, this.getGame().getMainPanel().getWidth() / 11 * 6,
				this.getGame().getMainPanel().getHeight() / 2 - 50, 0, 0, "Tree Climber/BranchFlipped.gif");

		hole = new Object_Creator(this.getGame().getMainPanel().getWidth() / 11,
				this.getGame().getMainPanel().getHeight() / 11, this.getGame().getMainPanel().getWidth() / 11 * 5 + 50,
				this.getGame().getMainPanel().getHeight() / 2 + 100, 0, 0, "Tree Climber/Hole.gif");

		squirrel = ImageIO.read(new File("Tree Climber/squirrel.png"));

		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);

	}

	/**
	 * draws out the game objects and the player
	 */
	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(tree.getObjectImage(), tree.getxLocation(), tree.getyLocation(), tree.getWidth(), tree.getHeight(),
				this);

		g.drawImage(branch.getObjectImage(), branch.getxLocation(), branch.getyLocation(), branch.getWidth(),
				branch.getHeight(), this);

		g.drawImage(flippedBranch.getObjectImage(), flippedBranch.getxLocation(), flippedBranch.getyLocation(),
				flippedBranch.getWidth(), flippedBranch.getHeight(), this);

		g.drawImage(hole.getObjectImage(), hole.getxLocation(), hole.getyLocation(), hole.getWidth(), hole.getHeight(),
				this);

		g.drawImage(squirrel, this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!super.detectCollisionPlayerInsideTopWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().moveUp();
			} else {
				playerWin();
			}
		}
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void playerWin() {
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
	 * @return the tree
	 */
	public Object_Creator getTree() {
		return tree;
	}

	/**
	 * @param tree
	 *            the tree to set
	 */
	public void setTree(Object_Creator tree) {
		this.tree = tree;
	}

	/**
	 * @return the branch
	 */
	public Object_Creator getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(Object_Creator branch) {
		this.branch = branch;
	}

	/**
	 * @return the flippedBranch
	 */
	public Object_Creator getFlippedBranch() {
		return flippedBranch;
	}

	/**
	 * @param flippedBranch
	 *            the flippedBranch to set
	 */
	public void setFlippedBranch(Object_Creator flippedBranch) {
		this.flippedBranch = flippedBranch;
	}

	/**
	 * @return the hole
	 */
	public Object_Creator getHole() {
		return hole;
	}

	/**
	 * @param hole
	 *            the hole to set
	 */
	public void setHole(Object_Creator hole) {
		this.hole = hole;
	}

	/**
	 * @return the squirrel
	 */
	public Image getSquirrel() {
		return squirrel;
	}

	/**
	 * @param squirrel
	 *            the squirrel to set
	 */
	public void setSquirrel(Image squirrel) {
		this.squirrel = squirrel;
	}

}
