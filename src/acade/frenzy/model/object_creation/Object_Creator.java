package acade.frenzy.model.object_creation;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Alex
 * 
 *         Object creator class for the objects in the games
 *
 */
public class Object_Creator {
	private int height;
	private int width;
	private int xLocation;
	private int yLocation;
	private int xVelocity;
	private int yVelocity;
	private String imageFilePath;
	private BufferedImage objectImage;
	private Color color;
	private boolean taken;

	/**
	 * 
	 * @param height
	 *            of the object
	 * @param width
	 *            of the object
	 * @param x_location
	 *            of the object
	 * @param y_location
	 *            of the object
	 * @param x_velocity
	 *            of the object
	 * @param y_velocity
	 *            of the object
	 * @param color
	 *            of the object
	 * @param taken
	 *            is the object visible
	 */
	public Object_Creator(int height, int width, int xLocation, int yLocation, int xVelocity, int yVelocity,
			Color color, boolean taken) {
		this.setHeight(height);
		this.setWidth(width);
		this.setxLocation(xLocation);
		this.setyLocation(yLocation);
		this.setxVelocity(xVelocity);
		this.setyVelocity(yVelocity);
		this.setColor(color);
		this.setTaken(taken);
	}

	/**
	 * 
	 * @param height
	 *            of the object
	 * @param width
	 *            of the object
	 * @param x_location
	 *            of the object
	 * @param y_location
	 *            of the object
	 * @param x_velocity
	 *            of the object
	 * @param y_velocity
	 *            of the object
	 * @param img_url
	 *            of the object
	 * @param taken
	 *            is the object visible
	 * @throws IOException
	 */
	public Object_Creator(int height, int width, int x_location, int y_location, int x_velocity, int y_velocity,
			String img_url, boolean taken) throws IOException {
		this.setHeight(height);
		this.setWidth(width);
		this.setxLocation(x_location);
		this.setyLocation(y_location);
		this.setxVelocity(x_velocity);
		this.setyVelocity(y_velocity);
		this.setObjectImage(ImageIO.read(new File(img_url)));
		this.setTaken(taken);
	}

	/**
	 * @param height
	 *            of the object
	 * @param width
	 *            of the object
	 * @param x_location
	 *            of the object
	 * @param y_location
	 *            of the object
	 * @param x_velocity
	 *            of the object
	 * @param y_velocity
	 *            of the object
	 * @param img_url
	 * 
	 * @throws IOException
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	public Object_Creator(int height, int width, int x_location, int y_location, int x_velocity, int y_velocity,
			String img_url) throws IOException {
		this.setHeight(height);
		this.setWidth(width);
		this.setxLocation(x_location);
		this.setyLocation(y_location);
		this.setxVelocity(x_velocity);
		this.setyVelocity(y_velocity);
		this.setObjectImage(ImageIO.read(new File(img_url)));
		this.setImageFilePath(img_url);

	}

	/**
	 * 
	 * @param height
	 *            of the object
	 * @param width
	 *            of the object
	 * @param x_location
	 *            of the object
	 * @param y_location
	 *            of the object
	 * @param x_velocity
	 *            of the object
	 * @param y_velocity
	 *            of the object
	 * @param color
	 *            of the object
	 */

	public Object_Creator(int height, int width, int x_location, int y_location, int x_velocity, int y_velocity,
			Color color) {
		this.setHeight(height);
		this.setWidth(width);
		this.setxLocation(x_location);
		this.setyLocation(y_location);
		this.setxVelocity(x_velocity);
		this.setyVelocity(y_velocity);
		this.setColor(color);

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
	 * @return the xLocation
	 */
	public int getxLocation() {
		return xLocation;
	}

	/**
	 * @param xLocation
	 *            the xLocation to set
	 */
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	/**
	 * @return the yLocation
	 */
	public int getyLocation() {
		return yLocation;
	}

	/**
	 * @param yLocation
	 *            the yLocation to set
	 */
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	/**
	 * @return the xVelocity
	 */
	public int getxVelocity() {
		return xVelocity;
	}

	/**
	 * @param xVelocity
	 *            the xVelocity to set
	 */
	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	/**
	 * @return the yVelocity
	 */
	public int getyVelocity() {
		return yVelocity;
	}

	/**
	 * @param yVelocity
	 *            the yVelocity to set
	 */
	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	/**
	 * @return the imageFilePath
	 */
	public String getImageFilePath() {
		return imageFilePath;
	}

	/**
	 * @param imageFilePath
	 *            the imageFilePath to set
	 */
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	/**
	 * @return the objectImage
	 */
	public BufferedImage getObjectImage() {
		return objectImage;
	}

	/**
	 * @param objectImage
	 *            the objectImage to set
	 */
	public void setObjectImage(BufferedImage objectImage) {
		this.objectImage = objectImage;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the taken
	 */
	public boolean isTaken() {
		return taken;
	}

	/**
	 * @param taken
	 *            the taken to set
	 */
	public void setTaken(boolean taken) {
		this.taken = taken;
	}

}
