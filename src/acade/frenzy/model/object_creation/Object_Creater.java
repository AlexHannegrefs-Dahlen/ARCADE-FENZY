package acade.frenzy.model.object_creation;

import java.awt.Color;

public class Object_Creater {
	private int Hight;
	private int Width;
	private int X_Loaction;
	private int Y_Loaction;
	private int X_Velocity;
	private int Y_Velocity;
	private String Img_URL;
	private Color color;

	public Object_Creater() {

	}

	/**
	 * @param hight
	 *            of the object
	 * @param width
	 *            of the object
	 * @param x_loaction
	 *            of the object
	 * @param y_loaction
	 *            of the object
	 * @param x_velocity
	 *            of the object
	 * @param y_velocity
	 *            of the object
	 * @param img_url
	 *            String of the location of the file
	 */
	public Object_Creater(int hight, int width, int x_loaction, int y_loaction, int x_velocity, int y_velocity,
			String img_url) {
		this.setHight(hight);
		this.setWidth(width);
		this.setX_Loaction(x_loaction);
		this.setY_Loaction(y_loaction);
		this.setX_Velocity(x_velocity);
		this.setY_Velocity(y_velocity);
		this.setImg_URL(img_url);

	}

	/**
	 * 
	 * @param hight
	 *            of the object
	 * @param width
	 *            of the object
	 * @param x_loaction
	 *            of the object
	 * @param y_loaction
	 *            of the object
	 * @param x_velocity
	 *            of the object
	 * @param y_velocity
	 *            of the object
	 * @param color
	 *            of the object
	 */

	public Object_Creater(int hight, int width, int x_loaction, int y_loaction, int x_velocity, int y_velocity,
			Color color) {
		this.setHight(hight);
		this.setWidth(width);
		this.setX_Loaction(x_loaction);
		this.setY_Loaction(y_loaction);
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
	 * @return the hight
	 */
	public int getHight() {
		return Hight;
	}

	/**
	 * @param hight
	 *            the hight to set
	 */
	public void setHight(int hight) {
		if (hight < 0) {
			return;
		}
		this.Hight = hight;
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
	public int getX_Loaction() {
		return X_Loaction;
	}

	/**
	 * @param x_Loaction
	 *            the x_Loaction to set
	 */
	public void setX_Loaction(int x_Loaction) {
		if (x_Loaction < 0) {
			return;
		}
		this.X_Loaction = x_Loaction;
	}

	/**
	 * @return the y_Loaction
	 */
	public int getY_Loaction() {
		return Y_Loaction;
	}

	/**
	 * @param y_Loaction
	 *            the y_Loaction to set
	 */
	public void setY_Loaction(int y_Loaction) {
		if (y_Loaction < 0) {
			return;
		}
		this.Y_Loaction = y_Loaction;
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

}
