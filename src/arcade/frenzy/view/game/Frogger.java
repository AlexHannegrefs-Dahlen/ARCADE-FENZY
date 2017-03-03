package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frogger extends Base_Game {
	private int width = 50, height = 50, xVel = 25, yVel = 25;

	private Object_Creator Car1, Car2, Car3;

	public Frogger(Main_Menu game, Game_UI gui, Player player) {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainScreen().getWidth() / 2 - 5);
		this.getPlayer().setyLoc(game.getMainScreen().getHeight() / 2 + 500);
		this.getPlayer().setWidth(width);
		this.getPlayer().setHeight(height);
		this.getPlayer().setxVel(xVel);
		this.getPlayer().setyVel(yVel);

		Car1 = new Object_Creator(100, 200, 0, 975, 25, 0, Color.CYAN);
		Car2 = new Object_Creator(100, 200, 2360, 575, 25, 0, Color.MAGENTA);
		Car3 = new Object_Creator(100, 200, 0, 200, 25, 0, Color.RED);

		this.setBackground(Color.BLACK);
		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
	}

	public void Winner() {
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// finish
		g.setColor(Color.green);
		g.fillRect(0, 0, 15000, 150);
		// thrdroaid
		g.setColor(Color.gray);
		g.fillRect(0, 150, 15000, 250);
		// thrdgrass
		g.setColor(Color.green);
		g.fillRect(0, 350, 15000, 150);
		// secRoad
		g.setColor(Color.gray);
		g.fillRect(0, 500, 15000, 250);
		// secGrass
		g.setColor(Color.green);
		g.fillRect(0, 750, 15000, 150);
		// firstRoad
		g.setColor(Color.gray);
		g.fillRect(0, 900, 15000, 250);
		;
		// start grass
		g.setColor(Color.green);
		g.fillRect(0, 1150, 15000, 150);

		// thrdCar
		g.setColor(Car3.getColor());
		g.fillRect(Car3.getX_Location(), Car3.getY_Location(), Car3.getWidth(), Car3.getHeight());

		// secCar
		g.setColor(Car2.getColor());
		g.fillRect(Car2.getX_Location(), Car2.getY_Location(), Car2.getWidth(), Car2.getHeight());
		// firstcar
		g.setColor(Car1.getColor());
		g.fillRect(Car1.getX_Location(), Car1.getY_Location(), Car1.getWidth(), Car1.getHeight());

		// palyer
		g.setColor(Color.WHITE);
		g.fillOval(this.getPlayer().getxLoc(), this.getPlayer().getyLoc(), this.getPlayer().getWidth(),
				this.getPlayer().getHeight());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
