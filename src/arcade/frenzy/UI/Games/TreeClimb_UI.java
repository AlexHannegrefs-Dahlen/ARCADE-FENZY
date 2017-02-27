package arcade.frenzy.UI.Games;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import arcade.frenzy.model.main.menu.Main_Menu;

public class TreeClimb_UI {
	private JPanel Tpanel;
	private ImageIcon backgroundImg;
	private JLabel BG;

	public TreeClimb_UI(Main_Menu game) {
		Tpanel = new JPanel();
		backgroundImg = new ImageIcon("background.jpg");
		Image sizing = backgroundImg.getImage();
		Image newsize = sizing.getScaledInstance(game.getMainPanel().getWidth(),game.getMainPanel().getHeight(), Image.SCALE_SMOOTH);
		ImageIcon background = new ImageIcon(newsize);
		BG = new JLabel(background);
		Tpanel.add(BG);
	}

	public JPanel getGamePanel() {
		return this.Tpanel;
	}
}
