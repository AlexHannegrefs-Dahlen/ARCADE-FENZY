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

/**
 * 
 * @author Alex Get Down game
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

	/**
	 * 
	 * @param game
	 *            - game instance
	 * @param player
	 *            - player instance
	 * @param Image
	 * @throws IOException
	 */
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
	 * paints game objects and the player
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
				this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				playerImage = ImageIO.read(new File("GetDown/blobeRight.gif"));
			} catch (IOException e1) {
			}
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
	 * @return the gravityTimer
	 */
	public Timer getGravityTimer() {
		return gravityTimer;
	}

	/**
	 * @param gravityTimer
	 *            the gravityTimer to set
	 */
	public void setGravityTimer(Timer gravityTimer) {
		this.gravityTimer = gravityTimer;
	}

	/**
	 * @return the topPlatFormLeft
	 */
	public Object_Creator getTopPlatFormLeft() {
		return TopPlatFormLeft;
	}

	/**
	 * @param topPlatFormLeft
	 *            the topPlatFormLeft to set
	 */
	public void setTopPlatFormLeft(Object_Creator topPlatFormLeft) {
		TopPlatFormLeft = topPlatFormLeft;
	}

	/**
	 * @return the topPlatFormRight
	 */
	public Object_Creator getTopPlatFormRight() {
		return TopPlatFormRight;
	}

	/**
	 * @param topPlatFormRight
	 *            the topPlatFormRight to set
	 */
	public void setTopPlatFormRight(Object_Creator topPlatFormRight) {
		TopPlatFormRight = topPlatFormRight;
	}

	/**
	 * @return the midPlatFormLeft
	 */
	public Object_Creator getMidPlatFormLeft() {
		return MidPlatFormLeft;
	}

	/**
	 * @param midPlatFormLeft
	 *            the midPlatFormLeft to set
	 */
	public void setMidPlatFormLeft(Object_Creator midPlatFormLeft) {
		MidPlatFormLeft = midPlatFormLeft;
	}

	/**
	 * @return the midPlatFormRight
	 */
	public Object_Creator getMidPlatFormRight() {
		return MidPlatFormRight;
	}

	/**
	 * @param midPlatFormRight
	 *            the midPlatFormRight to set
	 */
	public void setMidPlatFormRight(Object_Creator midPlatFormRight) {
		MidPlatFormRight = midPlatFormRight;
	}

	/**
	 * @return the botPlatFormLeft
	 */
	public Object_Creator getBotPlatFormLeft() {
		return BotPlatFormLeft;
	}

	/**
	 * @param botPlatFormLeft
	 *            the botPlatFormLeft to set
	 */
	public void setBotPlatFormLeft(Object_Creator botPlatFormLeft) {
		BotPlatFormLeft = botPlatFormLeft;
	}

	/**
	 * @return the botPlatFormRight
	 */
	public Object_Creator getBotPlatFormRight() {
		return BotPlatFormRight;
	}

	/**
	 * @param botPlatFormRight
	 *            the botPlatFormRight to set
	 */
	public void setBotPlatFormRight(Object_Creator botPlatFormRight) {
		BotPlatFormRight = botPlatFormRight;
	}

	/**
	 * @return the finishLine
	 */
	public Object_Creator getFinishLine() {
		return FinishLine;
	}

	/**
	 * @param finishLine
	 *            the finishLine to set
	 */
	public void setFinishLine(Object_Creator finishLine) {
		FinishLine = finishLine;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the xvel
	 */
	public int getXvel() {
		return xvel;
	}

	/**
	 * @param xvel
	 *            the xvel to set
	 */
	public void setXvel(int xvel) {
		this.xvel = xvel;
	}

	/**
	 * @return the yvel
	 */
	public int getYvel() {
		return yvel;
	}

	/**
	 * @param yvel
	 *            the yvel to set
	 */
	public void setYvel(int yvel) {
		this.yvel = yvel;
	}

	/**
	 * @return the playerImage
	 */
	public Image getPlayerImage() {
		return playerImage;
	}

	/**
	 * @param playerImage
	 *            the playerImage to set
	 */
	public void setPlayerImage(Image playerImage) {
		this.playerImage = playerImage;
	}

	/**
	 * @return the topRightPlatFormHight
	 */
	public int getTopRightPlatFormHight() {
		return TopRightPlatFormHight;
	}

	/**
	 * @return the topRightPlatFormWidth
	 */
	public int getTopRightPlatFormWidth() {
		return TopRightPlatFormWidth;
	}

	/**
	 * @return the topRightPlatFrom_Xloc
	 */
	public int getTopRightPlatFrom_Xloc() {
		return TopRightPlatFrom_Xloc;
	}

	/**
	 * @return the topRightPlatForm_Yloc
	 */
	public int getTopRightPlatForm_Yloc() {
		return TopRightPlatForm_Yloc;
	}

	/**
	 * @return the topLeftPlatFormHight
	 */
	public int getTopLeftPlatFormHight() {
		return TopLeftPlatFormHight;
	}

	/**
	 * @return the topLeftPlatFormWidth
	 */
	public int getTopLeftPlatFormWidth() {
		return TopLeftPlatFormWidth;
	}

	/**
	 * @return the topLeftPlatFrom_Xloc
	 */
	public int getTopLeftPlatFrom_Xloc() {
		return TopLeftPlatFrom_Xloc;
	}

	/**
	 * @return the topLeftPlatForm_Yloc
	 */
	public int getTopLeftPlatForm_Yloc() {
		return TopLeftPlatForm_Yloc;
	}

	/**
	 * @return the midLeftHight
	 */
	public int getMidLeftHight() {
		return MidLeftHight;
	}

	/**
	 * @return the midLeftWidth
	 */
	public int getMidLeftWidth() {
		return MidLeftWidth;
	}

	/**
	 * @return the midLeftXloc
	 */
	public int getMidLeftXloc() {
		return MidLeftXloc;
	}

	/**
	 * @return the midLeftYloc
	 */
	public int getMidLeftYloc() {
		return MidLeftYloc;
	}

	/**
	 * @return the midRightHight
	 */
	public int getMidRightHight() {
		return MidRightHight;
	}

	/**
	 * @return the midRightWidth
	 */
	public int getMidRightWidth() {
		return MidRightWidth;
	}

	/**
	 * @return the midRightXloc
	 */
	public int getMidRightXloc() {
		return MidRightXloc;
	}

	/**
	 * @return the midRightYloc
	 */
	public int getMidRightYloc() {
		return MidRightYloc;
	}

	/**
	 * @return the botRightHight
	 */
	public int getBotRightHight() {
		return BotRightHight;
	}

	/**
	 * @return the botRightWidth
	 */
	public int getBotRightWidth() {
		return BotRightWidth;
	}

	/**
	 * @return the botRightXloc
	 */
	public int getBotRightXloc() {
		return BotRightXloc;
	}

	/**
	 * @return the botRightYloc
	 */
	public int getBotRightYloc() {
		return BotRightYloc;
	}

	/**
	 * @return the botLeftHight
	 */
	public int getBotLeftHight() {
		return BotLeftHight;
	}

	/**
	 * @return the botLeftWidth
	 */
	public int getBotLeftWidth() {
		return BotLeftWidth;
	}

	/**
	 * @return the botLeftXloc
	 */
	public int getBotLeftXloc() {
		return BotLeftXloc;
	}

	/**
	 * @return the botLeftYloc
	 */
	public int getBotLeftYloc() {
		return BotLeftYloc;
	}

}
