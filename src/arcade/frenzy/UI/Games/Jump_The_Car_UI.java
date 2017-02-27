package arcade.frenzy.UI.Games;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import arcade.frenzy.view.main.menu.Main_Menu;

public class Jump_The_Car_UI {
	private JPanel JCpanel;
	private JLabel background;

	public Jump_The_Car_UI(Main_Menu game) {
		JCpanel = new JPanel();
		ImageIcon backgroundImg = new ImageIcon();
		Image rawimg = backgroundImg.getImage();
		Image sizing = rawimg.getScaledInstance(game.getMainPanel().getWidth(), game.getMainPanel().getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon BackG = new ImageIcon(sizing);
		background = new JLabel(BackG);
		JCpanel.add(background);

	}

}
