package arcade.frenzy.model.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import arcade.frenzy.model.player.Player;

public class Base_Game extends JPanel implements Game_Interface, KeyListener {
	Player player;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Base_Game() {

	}

	public Base_Game(Player player) {
		this.player = player;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void detectCollision() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
