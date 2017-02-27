package arcade.frenzy.view.main.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import arcade.frenzy.controller.ButtonNames;
import arcade.frenzy.controller.Main_Controller;

/**
 * 
 * @author Alex
 *
 */
public class Main_Menu implements ActionListener {
	private Main_Controller con;

	private JFrame mainScreen;

	private JPanel mainPanel, buttonPanelLeft, buttonPanelRight;

	private JButton collectTheCoins, frogger, getDown, jumpTheCar, treeClimber, frenzyMode, getName;

	private JTextArea nameEntry;

	/**
	 * Makes the Main Screen JFrame and JPanel, sets the JFrame to visible
	 * 
	 * @param controller
	 *            - the main controller of the program
	 */
	public void init(Main_Controller controller) {
		this.con = controller;

		mainScreen = new JFrame("Arcade Frenzy");
		mainPanel = new JPanel(new BorderLayout());

		buttonPanelLeft = new JPanel();
		buttonPanelLeft.setLayout(new BoxLayout(buttonPanelLeft, BoxLayout.Y_AXIS));

		collectTheCoins = new JButton("Collect the Coins");
		collectTheCoins.addActionListener(this);
		buttonPanelLeft.add(collectTheCoins);

		nameEntry = new JTextArea();
		buttonPanelLeft.add(nameEntry);

		getName = new JButton("Update name");
		getName.addActionListener(this);
		buttonPanelLeft.add(getName);

		buttonPanelRight = new JPanel();
		buttonPanelRight.setLayout(new BoxLayout(buttonPanelRight, BoxLayout.Y_AXIS));

		frogger = new JButton("Frogger");
		frogger.addActionListener(this);
		buttonPanelRight.add(frogger);

		getDown = new JButton("Get Down");
		getDown.addActionListener(this);
		buttonPanelRight.add(getDown);

		jumpTheCar = new JButton("Jump the Car");
		jumpTheCar.addActionListener(this);
		buttonPanelRight.add(jumpTheCar);

		treeClimber = new JButton("Tree Climber");
		treeClimber.addActionListener(this);
		buttonPanelRight.add(treeClimber);

		frenzyMode = new JButton("Frenzy Mode");
		frenzyMode.addActionListener(this);
		buttonPanelRight.add(frenzyMode);

		mainPanel.add(buttonPanelLeft, BorderLayout.WEST);
		mainPanel.add(buttonPanelRight, BorderLayout.EAST);

		mainScreen.add(mainPanel);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setLocationRelativeTo(null);
		mainScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainScreen.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == collectTheCoins)
			try {
				this.con.handleButtonClicked(ButtonNames.Collect_The_Coins);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (e.getSource() == frogger)
			try {
				this.con.handleButtonClicked(ButtonNames.Frogger);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (e.getSource() == getDown)
			try {
				this.con.handleButtonClicked(ButtonNames.Get_Down);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (e.getSource() == jumpTheCar)
			try {
				this.con.handleButtonClicked(ButtonNames.Jump_The_Car);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		else if (e.getSource() == treeClimber)
			try {
				this.con.handleButtonClicked(ButtonNames.Tree_Climber);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (e.getSource() == frenzyMode)
			try {
				this.con.handleButtonClicked(ButtonNames.Frenzy_Mode);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (e.getSource() == getName) {
			this.con.setPlayersName(nameEntry.getText());
		}

	}

	/**
	 * @return the con
	 */
	public Main_Controller getCon() {
		return con;
	}

	/**
	 * @param con
	 *            the con to set
	 */
	public void setCon(Main_Controller con) {
		this.con = con;
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
	public void setMainPanel(JPanel mainPanel) {
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

}
