package arcade.frenzy.model.player;

/**
 * 
 * @author Alex
 *
 */
public class Player {
	int xLoc, yLoc, width, height, xVel, yVel;
	String name;

	/**
	 * Basic Constructor
	 */
	public Player() {

	}

	/**
	 * Overloaded constructor
	 * 
	 * @param xLoc
	 *            - the xLocation of the player
	 * @param yLoc
	 *            - the y location of the player
	 * @param width
	 *            - the width of the player
	 * @param height
	 *            - the height of the player
	 * @param xVel
	 *            - the x velocity of the player
	 * @param yVel
	 *            - the y velocity of the player
	 * @param name
	 *            - the name of the player
	 */
	public Player(int xLoc, int yLoc, int width, int height, int xVel, int yVel, String name) {
		this.setxLoc(xLoc);
		this.setyLoc(yLoc);
		this.setWidth(width);
		this.setHeight(height);
		this.setxVel(xVel);
		this.setyVel(yVel);
		this.setName(name);
	}

	/**
	 * 
	 * @return the players name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
