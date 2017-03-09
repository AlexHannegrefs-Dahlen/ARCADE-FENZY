package arcade.frenzy.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

/**
 * 
 * @author Alex Get Down Game
 */
public class Get_Down extends Base_Game {
	private Timer gravityTimer = new Timer(50, this);

	private Object_Creator TopPlatFormLeft, TopPlatFormRight, MidPlatFormLeft, MidPlatFormRight, BotPlatFormLeft,
			BotPlatFormRight, FinishLine;

	private int width = 210, height = 105, xvel = 15, yvel = 20;

	private final int TopRightPlatFormHight = 45, TopRightPlatFormWidth = 900, TopRightPlatFrom_Xloc = 0,
			TopRightPlatForm_Yloc = 200;

	private final int TopLeftPlatFormHight = 45, TopLeftPlatFormWidth = 1500, TopLeftPlatFrom_Xloc = 1150,
			TopLeftPlatForm_Yloc = 200;

	private final int MidLeftHight = 45, MidLeftWidth = 1500, MidLeftXloc = 0, MidLeftYloc = 500;

	private final int MidRightHight = 45, MidRightWidth = 850, MidRightXloc = 1750, MidRightYloc = 500;

	private final int BotRightHight = 45, BotRightWidth = 150, BotRightXloc = 0, BotRightYloc = 820;

	private final int BotLeftHight = 45, BotLeftWidth = 2200, BotLeftXloc = 400, BotLeftYloc = 820;

	private Image playerImage = ImageIO.read(new File("GetDown/blobeLeft.gif"));

	public Get_Down(Main_Menu game, Player player, Image Image) throws IOException {
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
				TopLeftPlatForm_Yloc, 0, 0, "GetDown/platform.png");

		TopPlatFormRight = new Object_Creator(TopRightPlatFormHight, TopRightPlatFormWidth, TopRightPlatFrom_Xloc,
				TopRightPlatForm_Yloc, 0, 0, "GetDown/platform.png");

		MidPlatFormLeft = new Object_Creator(MidLeftHight, MidLeftWidth, MidLeftXloc, MidLeftYloc, 0, 0,
				"GetDown/platform.png");

		MidPlatFormRight = new Object_Creator(MidRightHight, MidRightWidth, MidRightXloc, MidRightYloc, 0, 0,
				"GetDown/platform.png");

		BotPlatFormRight = new Object_Creator(BotRightHight, BotRightWidth, BotRightXloc, BotRightYloc, 0, 0,
				"GetDown/platform.png");

		BotPlatFormLeft = new Object_Creator(BotLeftHight, BotLeftWidth, BotLeftXloc, BotLeftYloc, 0, 0,
				"GetDown/platform.png");

		FinishLine = new Object_Creator(150, 3000, 0, game.getMainPanel().getHeight() - 150, 0, 0,
				"GetDown/water1.jpg");

		this.setBackground(Color.BLUE);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
		gravityTimer.start();
	}

	private boolean Winner() {
		if (this.getPlayer().getyLoc() + this.getPlayer().getHeight() >= this.FinishLine.getyLocation()) {
			gravityTimer.stop();
			return true;
		} else
			return false;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * paints the player and game objects
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(playerImage, this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), width, height, this);

		g.drawImage(TopPlatFormLeft.getObjectImage(), TopPlatFormLeft.getxLocation(), TopPlatFormLeft.getyLocation(),
				TopPlatFormLeft.getWidth(), TopPlatFormLeft.getHeight(), this);

		g.drawImage(TopPlatFormRight.getObjectImage(), TopPlatFormRight.getxLocation(), TopPlatFormRight.getyLocation(),
				TopPlatFormRight.getWidth(), TopPlatFormRight.getHeight(), this);

		g.drawImage(MidPlatFormLeft.getObjectImage(), MidPlatFormLeft.getxLocation(), MidPlatFormLeft.getyLocation(),
				MidPlatFormLeft.getWidth(), MidPlatFormLeft.getHeight(), this);

		g.drawImage(MidPlatFormRight.getObjectImage(), MidPlatFormRight.getxLocation(), MidPlatFormRight.getyLocation(),
				MidPlatFormRight.getWidth(), MidPlatFormRight.getHeight(), this);

		g.drawImage(BotPlatFormRight.getObjectImage(), BotPlatFormRight.getxLocation(), BotPlatFormRight.getyLocation(),
				BotPlatFormRight.getWidth(), BotPlatFormRight.getHeight(), this);

		g.drawImage(BotPlatFormLeft.getObjectImage(), BotPlatFormLeft.getxLocation(), BotPlatFormLeft.getyLocation(),
				BotPlatFormLeft.getWidth(), BotPlatFormLeft.getHeight(), this);

		g.drawImage(FinishLine.getObjectImage(), FinishLine.getxLocation(), FinishLine.getyLocation(),
				FinishLine.getWidth(), FinishLine.getHeight(), this);
	}

	/**
	 * player movement
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			try {
				playerImage = ImageIO.read(new File("GetDown/blobeLeft.gif"));
			} catch (IOException e1) {
			}
			if (!super.detectCollisionPlayerInsideLeftWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().moveLeft();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				playerImage = ImageIO.read(new File("GetDown/blobeRight.gif"));
			} catch (IOException e1) {
			}
			if (!super.detectCollisionPlayerInsideRightWall(this.getGame().getMainPanel().getX(),
					this.getGame().getMainPanel().getY(), this.getGame().getMainPanel().getWidth(),
					this.getGame().getMainPanel().getHeight())) {
				this.getPlayer().moveRight();
			}
		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyPressed(e);

	}

	/**
	 * called by the timer to act as gravity
	 */
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
		if (Winner()) {
			try {
				playerImage = ImageIO.read(new File("GetDown/Happy.gif"));
			} catch (IOException e1) {
			}
			repaint();
			this.gameOver();
		}
	}

	private void gameOver() {
		super.gameEndScreen("Thanks for getting me to water");
	}

}