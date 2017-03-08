package arcade.frenzy.view.main.menu;

import java.awt.*;

import javax.swing.*;

public class BackgroundPanel extends JPanel {
	private static final long serialVersionUID = 1145771829950305492L;
	private Image image;

	public BackgroundPanel() {
	}

	public BackgroundPanel(Image image) {
		setImage(image);
		setLayout(new BorderLayout());
	}

	/*
	 * Set the image used as the background
	 */
	public void setImage(Image image) {
		this.image = image;
		repaint();
	}

	
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

}