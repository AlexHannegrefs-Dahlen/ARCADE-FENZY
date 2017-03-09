package arcade.frenzy.view.main.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import arcade.frenzy.controller.GameNames;
import arcade.frenzy.controller.Main_Controller;

/**
 * 
 * @author Alex
 *
 */
public class Main_Menu implements ActionListener {
	private Main_Controller controller;

	private JFrame mainScreen;

	private BackgroundPanel centerPanel;

	private JPanel mainPanel, buttonPanelLeft, buttonPanelRight;

	private JButton collectTheCoins, frogger, getDown, jumpTheCar, treeClimber, frenzyMode, getName, viewScores;

	private Image backgroundImg;

	private File backgroundImgFile;

	private boolean frenzy;

	private int buttonWidth = 500;

	/**
	 * Makes the Main Screen JFrame and JPanel, sets the JFrame to visible
	 * 
	 * @param controller
	 *            - the main controller of the program
	 */
	public void init(Main_Controller controller) {
		this.controller = controller;
		Font font = new Font("sans-serif", Font.PLAIN, 20);
		Font font2 = new Font("sans-serif", Font.PLAIN, 60);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);

		mainScreen = new JFrame("Arcade Frenzy");

		backgroundImgFile = new File("MainScreen/Background.jpg");
		try {
			backgroundImg = ImageIO.read(backgroundImgFile);
		} catch (IOException e) {
			System.out.println("Not found");
		}

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		centerPanel = new BackgroundPanel(backgroundImg);
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		buttonPanelLeft = new JPanel();
		buttonPanelLeft.setLayout(new BoxLayout(buttonPanelLeft, BoxLayout.Y_AXIS));

		Dimension minSize = new Dimension(buttonWidth, 250);
		Dimension prefSize = new Dimension(buttonWidth, 250);
		Dimension maxSize = new Dimension(buttonWidth, 460);

		collectTheCoins = new JButton("Collect the Coins");
		collectTheCoins.setIcon(new ImageIcon("MainScreen/redButton.png"));
		collectTheCoins.setHorizontalTextPosition(JButton.CENTER);
		collectTheCoins.setVerticalAlignment(JButton.CENTER);
		collectTheCoins.setBackground(Color.white);
		collectTheCoins.setFont(font2);
		collectTheCoins.setMinimumSize(minSize);
		collectTheCoins.setPreferredSize(prefSize);
		collectTheCoins.setMaximumSize(maxSize);
		collectTheCoins.addActionListener(this);
		collectTheCoins.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelLeft.add(collectTheCoins);

		frogger = new JButton("Frogger");
		frogger.setIcon(new ImageIcon("MainScreen/blueButton.png"));
		frogger.setHorizontalTextPosition(JButton.CENTER);
		frogger.setVerticalAlignment(JButton.CENTER);
		frogger.setBackground(Color.white);
		frogger.setFont(font2);
		frogger.addActionListener(this);
		frogger.setMinimumSize(minSize);
		frogger.setPreferredSize(prefSize);
		frogger.setMaximumSize(maxSize);
		frogger.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelLeft.add(frogger);

		viewScores = new JButton("View Highscores");
		viewScores.setIcon(new ImageIcon("MainScreen/darkBlueButton.png"));
		viewScores.setHorizontalTextPosition(JButton.CENTER);
		viewScores.setVerticalAlignment(JButton.CENTER);
		viewScores.setBackground(Color.WHITE);
		viewScores.setFont(font2);
		viewScores.addActionListener(this);
		viewScores.setMinimumSize(minSize);
		viewScores.setPreferredSize(prefSize);
		viewScores.setMaximumSize(maxSize);
		viewScores.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelLeft.add(viewScores);

		getName = new JButton("Update Name");
		getName.setIcon(new ImageIcon("MainScreen/orangeButton.png"));
		getName.setHorizontalTextPosition(JButton.CENTER);
		getName.setVerticalAlignment(JButton.CENTER);
		getName.setBackground(Color.white);
		getName.setFont(font2);
		getName.addActionListener(this);
		getName.setMinimumSize(minSize);
		getName.setPreferredSize(prefSize);
		getName.setMaximumSize(maxSize);
		getName.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelLeft.add(getName);

		buttonPanelRight = new JPanel();
		buttonPanelRight.setLayout(new BoxLayout(buttonPanelRight, BoxLayout.Y_AXIS));

		Dimension maxSizeRight = new Dimension(buttonWidth, 460);

		getDown = new JButton("Get Down");
		getDown.setIcon(new ImageIcon("MainScreen/greenButton.png"));
		getDown.setHorizontalTextPosition(JButton.CENTER);
		getDown.setVerticalAlignment(JButton.CENTER);
		getDown.setBackground(Color.white);
		getDown.setFont(font2);
		getDown.addActionListener(this);
		getDown.setMinimumSize(minSize);
		getDown.setPreferredSize(prefSize);
		getDown.setMaximumSize(maxSizeRight);
		getDown.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelRight.add(getDown);

		jumpTheCar = new JButton("Jump the Car");
		jumpTheCar.setIcon(new ImageIcon("MainScreen/pinkButton.png"));
		jumpTheCar.setHorizontalTextPosition(JButton.CENTER);
		jumpTheCar.setVerticalAlignment(JButton.CENTER);
		jumpTheCar.setBackground(Color.white);
		jumpTheCar.setFont(font2);
		jumpTheCar.addActionListener(this);
		jumpTheCar.setMinimumSize(minSize);
		jumpTheCar.setPreferredSize(prefSize);
		jumpTheCar.setMaximumSize(maxSizeRight);
		jumpTheCar.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelRight.add(jumpTheCar);

		treeClimber = new JButton("Tree Climber");
		treeClimber.setIcon(new ImageIcon("MainScreen/whiteButton.png"));
		treeClimber.setHorizontalTextPosition(JButton.CENTER);
		treeClimber.setVerticalAlignment(JButton.CENTER);
		treeClimber.setBackground(Color.white);
		treeClimber.setFont(font2);
		treeClimber.addActionListener(this);
		treeClimber.setMinimumSize(minSize);
		treeClimber.setPreferredSize(prefSize);
		treeClimber.setMaximumSize(maxSizeRight);
		treeClimber.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelRight.add(treeClimber);

		frenzyMode = new JButton("Frenzy Mode");
		frenzyMode.setIcon(new ImageIcon("MainScreen/yellowButton.png"));
		frenzyMode.setHorizontalTextPosition(JButton.CENTER);
		frenzyMode.setVerticalAlignment(JButton.CENTER);
		frenzyMode.setBackground(Color.white);
		frenzyMode.setFont(font2);
		frenzyMode.addActionListener(this);
		frenzyMode.setMinimumSize(minSize);
		frenzyMode.setPreferredSize(prefSize);
		frenzyMode.setMaximumSize(maxSizeRight);
		frenzyMode.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		buttonPanelRight.add(frenzyMode);

		mainPanel.add(buttonPanelLeft, BorderLayout.WEST);
		mainPanel.add(buttonPanelRight, BorderLayout.EAST);

		mainScreen.add(mainPanel);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setLocationRelativeTo(null);
		mainScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainScreen.setVisible(true);
	}

	/**
	 * tells the controller when a button on the main screen was clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == collectTheCoins)
			try {
				this.controller.handleButtonClicked(GameNames.Collect_The_Coins);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
		else if (e.getSource() == frogger)
			try {
				this.controller.handleButtonClicked(GameNames.Frogger);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
		else if (e.getSource() == getDown)
			try {
				this.controller.handleButtonClicked(GameNames.Get_Down);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
		else if (e.getSource() == jumpTheCar)
			try {
				this.controller.handleButtonClicked(GameNames.Jump_The_Car);
			} catch (InterruptedException | IOException e2) {
				e2.printStackTrace();
			}
		else if (e.getSource() == treeClimber)
			try {
				this.controller.handleButtonClicked(GameNames.Tree_Climber);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
		else if (e.getSource() == frenzyMode)
			try {
				this.setFrenzy(true);
				this.controller.handleButtonClicked(GameNames.Frenzy_Mode);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}

		else if (e.getSource() == viewScores) {
			try {
				this.controller.handleButtonClicked(GameNames.Highscores);
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
		}

		else if (e.getSource() == getName) {
			this.controller.setPlayersName(JOptionPane.showInputDialog("Please enter your username"));
		}
	}

	/**
	 * @return the controller
	 */
	public Main_Controller getCon() {
		return controller;
	}

	/**
	 * @param con
	 *            the controller to set
	 */
	public void setCon(Main_Controller con) {
		this.controller = con;
	}

	/**
	 * @return the mainScreen
	 */
	public JFrame getMainScreen() {
		return mainScreen;
	}

	/**
	 * @param mainScreen
	 *            the mainScreen to set
	 */
	public void setMainScreen(JFrame mainScreen) {
		this.mainScreen = mainScreen;
	}

	/**
	 * @return the mainPanel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * @param mainPanel
	 *            the mainPanel to set
	 */
	public void setMainPanel(BackgroundPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	/**
	 * @return the buttonPanelLeft
	 */
	public JPanel getButtonPanelLeft() {
		return buttonPanelLeft;
	}

	/**
	 * @param buttonPanelLeft
	 *            the buttonPanelLeft to set
	 */
	public void setButtonPanelLeft(JPanel buttonPanelLeft) {
		this.buttonPanelLeft = buttonPanelLeft;
	}

	/**
	 * @return the buttonPanelRight
	 */
	public JPanel getButtonPanelRight() {
		return buttonPanelRight;
	}

	/**
	 * @param buttonPanelRight
	 *            the buttonPanelRight to set
	 */
	public void setButtonPanelRight(JPanel buttonPanelRight) {
		this.buttonPanelRight = buttonPanelRight;
	}

	/**
	 * @return the collectTheCoins
	 */
	public JButton getCollectTheCoins() {
		return collectTheCoins;
	}

	/**
	 * @param collectTheCoins
	 *            the collectTheCoins to set
	 */
	public void setCollectTheCoins(JButton collectTheCoins) {
		this.collectTheCoins = collectTheCoins;
	}

	/**
	 * @return the frogger
	 */
	public JButton getFrogger() {
		return frogger;
	}

	/**
	 * @param frogger
	 *            the frogger to set
	 */
	public void setFrogger(JButton frogger) {
		this.frogger = frogger;
	}

	/**
	 * @return the getDown
	 */
	public JButton getGetDown() {
		return getDown;
	}

	/**
	 * @param getDown
	 *            the getDown to set
	 */
	public void setGetDown(JButton getDown) {
		this.getDown = getDown;
	}

	/**
	 * @return the jumpTheCar
	 */
	public JButton getJumpTheCar() {
		return jumpTheCar;
	}

	/**
	 * @param jumpTheCar
	 *            the jumpTheCar to set
	 */
	public void setJumpTheCar(JButton jumpTheCar) {
		this.jumpTheCar = jumpTheCar;
	}

	/**
	 * @return the treeClimber
	 */
	public JButton getTreeClimber() {
		return treeClimber;
	}

	/**
	 * @param treeClimber
	 *            the treeClimber to set
	 */
	public void setTreeClimber(JButton treeClimber) {
		this.treeClimber = treeClimber;
	}

	/**
	 * @return the frenzyMode
	 */
	public JButton getFrenzyMode() {
		return frenzyMode;
	}

	/**
	 * @param frenzyMode
	 *            the frenzyMode to set
	 */
	public void setFrenzyMode(JButton frenzyMode) {
		this.frenzyMode = frenzyMode;
	}

	/**
	 * @return the frenzy
	 */
	public boolean isFrenzy() {
		return frenzy;
	}

	/**
	 * @param frenzy
	 *            the frenzy to set
	 */
	public void setFrenzy(boolean frenzy) {
		this.frenzy = frenzy;
	}

	/**
	 * @return the controller
	 */
	public Main_Controller getController() {
		return controller;
	}

	/**
	 * @param controller
	 *            the controller to set
	 */
	public void setController(Main_Controller controller) {
		this.controller = controller;
	}

	/**
	 * @return the centerPanel
	 */
	public BackgroundPanel getCenterPanel() {
		return centerPanel;
	}

	/**
	 * @param centerPanel
	 *            the centerPanel to set
	 */
	public void setCenterPanel(BackgroundPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	/**
	 * @return the getName
	 */
	public JButton getGetName() {
		return getName;
	}

	/**
	 * @param getName
	 *            the getName to set
	 */
	public void setGetName(JButton getName) {
		this.getName = getName;
	}

	/**
	 * @return the viewScores
	 */
	public JButton getViewScores() {
		return viewScores;
	}

	/**
	 * @param viewScores
	 *            the viewScores to set
	 */
	public void setViewScores(JButton viewScores) {
		this.viewScores = viewScores;
	}

	/**
	 * @return the backgroundImg
	 */
	public Image getBackgroundImg() {
		return backgroundImg;
	}

	/**
	 * @param backgroundImg
	 *            the backgroundImg to set
	 */
	public void setBackgroundImg(Image backgroundImg) {
		this.backgroundImg = backgroundImg;
	}

	/**
	 * @return the backgroundImgFile
	 */
	public File getBackgroundImgFile() {
		return backgroundImgFile;
	}

	/**
	 * @param backgroundImgFile
	 *            the backgroundImgFile to set
	 */
	public void setBackgroundImgFile(File backgroundImgFile) {
		this.backgroundImgFile = backgroundImgFile;
	}

	/**
	 * @return the buttonWidth
	 */
	public int getButtonWidth() {
		return buttonWidth;
	}

	/**
	 * @param buttonWidth
	 *            the buttonWidth to set
	 */
	public void setButtonWidth(int buttonWidth) {
		this.buttonWidth = buttonWidth;
	}

	/**
	 * @param mainPanel
	 *            the mainPanel to set
	 */
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

}
