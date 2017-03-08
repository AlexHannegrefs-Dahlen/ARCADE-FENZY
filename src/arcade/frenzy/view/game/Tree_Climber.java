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

	private Object_Creator tree, branch, flippedBranch, hole;

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

	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(tree.getPicture(), tree.getX_Location(), tree.getY_Location(), tree.getWidth(), tree.getHeight(),
				this);

		g.drawImage(branch.getPicture(), branch.getX_Location(), branch.getY_Location(), branch.getWidth(),
				branch.getHeight(), this);

		g.drawImage(flippedBranch.getPicture(), flippedBranch.getX_Location(), flippedBranch.getY_Location(),
				flippedBranch.getWidth(), flippedBranch.getHeight(), this);

		g.drawImage(hole.getPicture(), hole.getX_Location(), hole.getY_Location(), hole.getWidth(), hole.getHeight(),
				this);

		g.drawImage(squirrel, this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!super.detectCollisionPlayerInsideTopWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
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
		// TODO Auto-generated method stub

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

}
