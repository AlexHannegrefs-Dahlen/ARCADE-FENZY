package arcade.frenzy.view.main.menu;

import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author Alex, used to put an image on the background of a JPanel and still
 *         draw stuff on top of it
 */
public class BackgroundPanel extends JPanel {
	private static final long serialVersionUID = 1145771829950305492L;
	private Image image;

	/**
	 * basic constructor
	 */
	public BackgroundPanel() {
	}

	/**
	 * 
	 * @param image
	 *            - the image to be the background
	 */
	public BackgroundPanel(Image image) {
		setImage(image);
		setLayout(new BorderLayout());
	}

	/**
	 * Set the image used as the background and paint it
	 */
	public void setImage(Image image) {
		this.image = image;
		repaint();
	}

	/**
	 * paints the background image
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (this.image == null) {
			return;
		} else {
			Dimension d = getSize();
			g.drawImage(this.image, 0, 0, d.width, d.height, null);
		}
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

}