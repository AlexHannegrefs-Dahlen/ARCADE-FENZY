package arcade.frenzy.model.player;

/**
 * 
 * @author Alex
 *
 */
public class Player {
	int xLoc, yLoc, width, height, xVel, yVel;

	/**
	 * 
	 * @param xLoc
	 *            - the x location of the player object
	 * @param yLoc
	 *            - the y location of the player object
	 * @param width
	 *            - the width of the player object
	 * @param height
	 *            - the height of the player object
	 * @param xVel
	 *            - the xVel of the player object
	 * @param yVel
	 *            - the yVel of the player object
	 */
	public Player(int xLoc, int yLoc, int width, int height, int xVel, int yVel) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.width = width;
		this.height = height;
		this.xVel = xVel;
		this.yVel = yVel;
	}

	/**
	 * @return the xLoc
	 */
	public int getxLoc() {
		return xLoc;
	}

	/**
	 * @param xLoc
	 *            the xLoc to set
	 */
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	/**
	 * @return the yLoc
	 */
	public int getyLoc() {
		return yLoc;
	}

	/**
	 * @param yLoc
	 *            the yLoc to set
	 */
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
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
	 * @return the xVel
	 */
	public int getxVel() {
		return xVel;
	}

	/**
	 * @param xVel
	 *            the xVel to set
	 */
	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	/**
	 * @return the yVel
	 */
	public int getyVel() {
		return yVel;
	}

	/**
	 * @param yVel
	 *            the yVel to set
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
}
