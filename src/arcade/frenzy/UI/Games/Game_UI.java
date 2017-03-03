package arcade.frenzy.UI.Games;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import arcade.frenzy.controller.GameNames;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Game_UI {
	private Main_Menu game;
	private JLabel background;
	private JPanel panel;

	public Game_UI() {
	}

	public Game_UI(Main_Menu game) {
		this.setGame(game);
		panel = new JPanel();
	}

	public void setGameBackGround(GameNames gamePlaying) {
		switch (gamePlaying) {
		case Collect_The_Coins:
			panel.removeAll();
			ImageIcon rawIMGC = new ImageIcon("Collect_the_coin/background.jpg");
			Image smallC = rawIMGC.getImage();
			Image FullsizeC = smallC.getScaledInstance(game.getMainPanel().getWidth(), game.getMainPanel().getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon BIMGC = new ImageIcon(FullsizeC);
			background = new JLabel(BIMGC);
			panel.add(background);
			break;
		case Frogger:
			panel.removeAll();
			ImageIcon rawIMGF = new ImageIcon("LoactionOfIMG");
			Image smallF = rawIMGF.getImage();
			Image FullsizeF = smallF.getScaledInstance(game.getMainPanel().getWidth(), game.getMainPanel().getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon BIMGF = new ImageIcon(FullsizeF);
			background = new JLabel(BIMGF);
			panel.add(background);
			break;
		case Get_Down:
			panel.removeAll();
			ImageIcon rawIMGG = new ImageIcon("LoactionOfIMG");
			Image smallG = rawIMGG.getImage();
			Image FullsizeG = smallG.getScaledInstance(game.getMainPanel().getWidth(), game.getMainPanel().getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon BIMGG = new ImageIcon(FullsizeG);
			background = new JLabel(BIMGG);
			panel.add(background);
			break;
		case Tree_Climber:
			panel.removeAll();
			ImageIcon rawIMGT = new ImageIcon("LoactionOfIMG");
			Image smallT = rawIMGT.getImage();
			Image FullsizeT = smallT.getScaledInstance(game.getMainPanel().getWidth(), game.getMainPanel().getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon BIMGT = new ImageIcon(FullsizeT);
			background = new JLabel(BIMGT);
			panel.add(background);
			break;
		case Jump_The_Car:
			panel.removeAll();
			ImageIcon rawIMGJ = new ImageIcon("LoactionOfIMG");
			Image smallJ = rawIMGJ.getImage();
			Image FullsizeJ = smallJ.getScaledInstance(game.getMainPanel().getWidth(), game.getMainPanel().getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon BIMGJ = new ImageIcon(FullsizeJ);
			background = new JLabel(BIMGJ);
			panel.add(background);
			break;
		default:
			break;
		}
	}

	public Main_Menu getGame() {
		return game;
	}

	public void setGame(Main_Menu game) {
		this.game = game;
	}

	public JPanel getPanel() {
		return this.panel;
	}
}
