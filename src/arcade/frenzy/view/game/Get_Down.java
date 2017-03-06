package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;
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

public class Get_Down extends Base_Game {
	private Timer gravityTimer = new Timer(50 / 1, this);

	private Object_Creator TopPlatFormLeft, TopPlatFormRight, MidPlatFormLeft, MidPlatFormRight, BotPlatFormLeft,
			BotPlatFormRight, FinishLine;

	private int width = 210, height = 105, xvel = 15, yvel = 20;

	private final int TopRightPlatFormHight = 45, TopRightPlatFormWidth = 900, TopRightPlatFrom_Xloc = 0,
			TopRightPlatForm_Yloc = 200;

	private final int TopLeftPlatFormHight = 45, TopLeftPlatFormWidth = 1500, TopLeftPlatFrom_Xloc = 1150,
			TopLeftPlatForm_Yloc = 200;

	private final int MidLeftHight = 45, MidLeftWidth = 1500, MidLeftXloc = 0, MidLeftYloc = 500;

	private final int MidRightHight = 45, MidRightWidth = 850, MidRightXloc = 1735, MidRightYloc = 500;

	private final int BotRightHight = 45, BotRightWidth = 150, BotRightXloc = 0, BotRightYloc = 820;

	private final int BotLeftHight = 45, BotLeftWidth = 2200, BotLeftXloc = 400, BotLeftYloc = 820;

	public Get_Down(Main_Menu game, Game_UI gui, Player player, Image Image) {
		super(Image);
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainScreen().getWidth() / 2);
		this.getPlayer().setyLoc(yvel);
		this.getPlayer().setWidth(width);
		this.getPlayer().setHeight(height);
		this.getPlayer().setxVel(xvel);
		this.getPlayer().setyVel(yvel);

		TopPlatFormLeft = new Object_Creator(TopLeftPlatFormHight, TopLeftPlatFormWidth, TopLeftPlatFrom_Xloc,
				TopLeftPlatForm_Yloc, 0, 0, Color.GREEN);

		TopPlatFormRight = new Object_Creator(TopRightPlatFormHight, TopRightPlatFormWidth, TopRightPlatFrom_Xloc,
				TopRightPlatForm_Yloc, 0, 0, Color.GREEN);

		MidPlatFormLeft = new Object_Creator(MidLeftHight, MidLeftWidth, MidLeftXloc, MidLeftYloc, 0, 0, Color.GREEN);

		MidPlatFormRight = new Object_Creator(MidRightHight, MidRightWidth, MidRightXloc, MidRightYloc, 0, 0,
				Color.GREEN);

		BotPlatFormRight = new Object_Creator(BotRightHight, BotRightWidth, BotRightXloc, BotRightYloc, 0, 0,
				Color.GREEN);

		BotPlatFormLeft = new Object_Creator(BotLeftHight, BotLeftWidth, BotLeftXloc, BotLeftYloc, 0, 0, Color.GREEN);

		FinishLine = new Object_Creator(45, 3000, 0, 1245, 0, 0, Color.WHITE, false);

		this.setBackground(Color.BLUE);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
		gravityTimer.start();
	}

	public void Winner() {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= this.FinishLine.getY_Location()) {
			gravityTimer.stop();
			gameOver();
		}
	}

	/**
	 * 
	 */
	// Move to Game Ui eventuly
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// g.setColor(Color.WHITE);
		// g.fillRect(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(),
		// width, height);

		try {
			g.drawImage(ImageIO.read(new File("GetDown/blobe.gif")), this.getPlayer().getxLoc(),
					this.getPlayer().getyLoc(), width, height, this);
		} catch (IOException e) {
		}

		g.setColor(TopPlatFormLeft.getColor());
		g.fillRect(TopPlatFormLeft.getX_Location(), TopPlatFormLeft.getY_Location(), TopPlatFormLeft.getWidth(),
				TopPlatFormLeft.getHeight());

		g.setColor(TopPlatFormRight.getColor());
		g.fillRect(TopPlatFormRight.getX_Location(), TopPlatFormRight.getY_Location(), TopPlatFormRight.getWidth(),
				TopPlatFormRight.getHeight());

		g.setColor(MidPlatFormLeft.getColor());
		g.fillRect(MidPlatFormLeft.getX_Location(), MidPlatFormLeft.getY_Location(), MidPlatFormLeft.getWidth(),
				MidPlatFormLeft.getHeight());

		g.setColor(MidPlatFormRight.getColor());
		g.fillRect(MidPlatFormRight.getX_Location(), MidPlatFormRight.getY_Location(), MidPlatFormRight.getWidth(),
				MidPlatFormRight.getHeight());

		g.setColor(BotPlatFormRight.getColor());
		g.fillRect(BotPlatFormRight.getX_Location(), BotPlatFormRight.getY_Location(), BotPlatFormRight.getWidth(),
				BotPlatFormRight.getHeight());

		g.setColor(BotPlatFormLeft.getColor());
		g.fillRect(BotPlatFormLeft.getX_Location(), BotPlatFormLeft.getY_Location(), BotPlatFormLeft.getWidth(),
				BotPlatFormLeft.getHeight());

		g.setColor(FinishLine.getColor());
		g.fillRect(FinishLine.getX_Location(), FinishLine.getY_Location(), FinishLine.getWidth(),
				FinishLine.getHeight());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (!super.detectCollisionPlayerInsideLeftWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!super.detectCollisionPlayerInsideRightWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
			}
		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyPressed(e);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
		if (super.detectCollisionPlayerOutsideTopWall(TopPlatFormRight))
			this.getPlayer().setyLoc(TopRightPlatForm_Yloc - this.getPlayer().getHeight());
		if (super.detectCollisionPlayerOutsideTopWall(TopPlatFormLeft))
			this.getPlayer().setyLoc(TopLeftPlatForm_Yloc - this.getPlayer().getHeight());
		if (super.detectCollisionPlayerOutsideTopWall(MidPlatFormLeft))
			this.getPlayer().setyLoc(MidLeftYloc - this.getPlayer().getHeight());
		if (super.detectCollisionPlayerOutsideTopWall(MidPlatFormRight))
			this.getPlayer().setyLoc(MidRightYloc - this.getPlayer().getHeight());
		if (super.detectCollisionPlayerOutsideTopWall(BotPlatFormRight))
			this.getPlayer().setyLoc(BotRightYloc - this.getPlayer().getHeight());
		if (super.detectCollisionPlayerOutsideTopWall(BotPlatFormLeft))
			this.getPlayer().setyLoc(BotLeftYloc - this.getPlayer().getHeight());

		repaint();
		Winner();
	}

	private void gameOver() {
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
