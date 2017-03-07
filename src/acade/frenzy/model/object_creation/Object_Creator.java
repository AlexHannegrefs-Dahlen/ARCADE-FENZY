package acade.frenzy.model.object_creation;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Object_Creator {
	private int Height;
	private int Width;
	private int X_Location;
	private int Y_Location;
	private int X_Velocity;
	private int Y_Velocity;
	private String Img_URL;
	private BufferedImage picture;
	private Color color;
	private boolean taken;

	public Object_Creator() {

	}

	/**
	 * 
	 * @param height
	 * @param width
	 * @param x_location
	 * @param y_location
	 * @param x_velocity
	 * @param y_velocity
	 * @param color
	 * @param taken
	 */
	public Object_Creator(int height, int width, int x_location, int y_location, int x_velocity, int y_velocity,
			Color color, boolean taken) {
		this.setHight(height);
		this.setWidth(width);
		this.setX_Location(x_location);
		this.setY_Location(y_location);
		this.setX_Velocity(x_velocity);
		this.setY_Velocity(y_velocity);
		this.setColor(color);
		this.setTaken(taken);
	}

	/**
	 * 
	 * @param height
	 * @param width
	 * @param x_location
	 * @param y_location
	 * @param x_velocity
	 * @param y_velocity
	 * @param img_url
	 * @param taken
	 * @throws IOException
	 */
	public Object_Creator(int height, int width, int x_location, int y_location, int x_velocity, int y_velocity,
			String img_url, boolean taken) throws IOException {
		this.setHight(height);
		this.setWidth(width);
		this.setX_Location(x_location);
		this.setY_Location(y_location);
		this.setX_Velocity(x_velocity);
		this.setY_Velocity(y_velocity);
		this.setPicture(ImageIO.read(new File(img_url)));
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
	 *            String of the location of the file
<<<<<<< HEAD
	 * @throws IOException 
=======
	 * @throws IOException
>>>>>>> 3eb6081514a112dc7944e3ca360edc9e937c710f
	 */
	public Object_Creator(int height, int width, int x_location, int y_location, int x_velocity, int y_velocity,
			String img_url) throws IOException {
		this.setHight(height);
		this.setWidth(width);
		this.setX_Location(x_location);
		this.setY_Location(y_location);
		this.setX_Velocity(x_velocity);
		this.setY_Velocity(y_velocity);
		this.setPicture(ImageIO.read(new File(img_url)));
		this.setImg_URL(img_url);

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
		this.setHight(height);
		this.setWidth(width);
		this.setX_Location(x_location);
		this.setY_Location(y_location);
		this.setX_Velocity(x_velocity);
		this.setY_Velocity(y_velocity);
		this.setColor(color);

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
	 * @return the height
	 */
	public int getHeight() {
		return Height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHight(int height) {
		if (height < 0) {
			return;
		}
		this.Height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return Width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		if (width < 0) {
			return;
		}
		this.Width = width;
	}

	/**
	 * @return the x_Loaction
	 */
	public int getX_Location() {
		return X_Location;
	}

	/**
	 * @param x_Location
	 *            the x_Location to set
	 */
	public void setX_Location(int x_Location) {
		if (x_Location < 0) {
			return;
		}
		this.X_Location = x_Location;
	}

	/**
	 * @return the y_Location
	 */
	public int getY_Location() {
		return Y_Location;
	}

	/**
	 * @param y_Location
	 *            the y_Location to set
	 */
	public void setY_Location(int y_Location) {
		if (y_Location < 0) {
			return;
		}
		this.Y_Location = y_Location;
	}

	/**
	 * @return the x_Velocity
	 */
	public int getX_Velocity() {
		return X_Velocity;
	}

	/**
	 * @param x_Velocity
	 *            the x_Velocity to set
	 */
	public void setX_Velocity(int x_Velocity) {
		this.X_Velocity = x_Velocity;
	}

	/**
	 * @return the y_Velocity
	 */
	public int getY_Velocity() {
		return Y_Velocity;
	}

	/**
	 * @param y_Velocity
	 *            the y_Velocity to set
	 */
	public void setY_Velocity(int y_Velocity) {
		this.Y_Velocity = y_Velocity;
	}

	/**
	 * @return the img_URL
	 */
	public String getImg_URL() {
		return Img_URL;
	}

	/**
	 * @param img_URL
	 *            the img_URL to set
	 */
	public void setImg_URL(String img_URL) {
		if (img_URL == null) {
			return;
		}
		if (!(img_URL.contains(".jpg") || img_URL.contains(".png"))) {
			return;
		}
		this.Img_URL = img_URL;
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

	/**
	 * @return the picture
	 */
	public BufferedImage getPicture() {
		return picture;
	}

	/**
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(BufferedImage picture) {
		this.picture = picture;
	}

}
