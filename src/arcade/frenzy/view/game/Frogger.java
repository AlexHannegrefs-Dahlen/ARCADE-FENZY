package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frogger extends Base_Game {
	private int width = 50, height = 50, xVel = 25, yVel = 25;

	private Object_Creator Car1, Car2, Car3, start, firstRoad, firstGrass, secondRoad, secondGrass, thirdRoad, finish;

	public Frogger(Main_Menu game, Game_UI gui, Player player) {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainScreen().getWidth() / 2 - 5);
		this.getPlayer().setyLoc(game.getMainScreen().getHeight() / 2 + 500);
		this.getPlayer().setWidth(width);
		this.getPlayer().setHeight(height);
		this.getPlayer().setxVel(xVel);
		this.getPlayer().setyVel(yVel);
		
		finish = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, 0, 0, 0, "GetDown/platform.png");
		thirdRoad = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10 * 2,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight(), 0, 0, Color.GRAY);
		secondGrass = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 3, 0, 0, Color.GREEN);
		secondRoad = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10 * 2,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 4, 0, 0, Color.GRAY);
		firstGrass = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 6, 0, 0, Color.GREEN);
		firstRoad = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10 * 2,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 7, 0, 0, Color.GRAY);
		start = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, finish.getHeight() * 9, 0, 0, Color.GREEN);

		Car1 = new Object_Creator(100, 200, 0, 975, 25, 0, Color.CYAN);
		Car2 = new Object_Creator(100, 200, 2360, 600, 25, 0, Color.MAGENTA);
		Car3 = new Object_Creator(100, 200, 0, this.thirdRoad.getHeight(), 25, 0, Color.RED);
		

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
		/*g.drawImage(finish.getImg_URL(), finish.getX_Location(), finish.getY_Location(),
				finish.getX_Location() + this.getGame().getMainPanel().getWidth(), finish.getY_Location() + this.getGame().getMainPanel().getHeight(),
				finish.getX_Location(), finish.getY_Location(),
				finish.getX_Location() + this.getGame().getMainPanel().getWidth(), finish.getY_Location() + this.getGame().getMainPanel().getHeight()
				, ImageObserver.);*/
		g.fillRect(finish.getX_Location(), finish.getY_Location(), finish.getWidth(), finish.getHeight());

		g.setColor(thirdRoad.getColor());
		g.fillRect(thirdRoad.getX_Location(), thirdRoad.getY_Location(), thirdRoad.getWidth(), thirdRoad.getHeight());
		
		g.setColor(secondGrass.getColor());
		g.fillRect(secondGrass.getX_Location(), secondGrass.getY_Location(), secondGrass.getWidth(), secondGrass.getHeight());
		
		g.setColor(secondRoad.getColor());
		g.fillRect(secondRoad.getX_Location(), secondRoad.getY_Location(), secondRoad.getWidth(), secondRoad.getHeight());
		
		g.setColor(firstGrass.getColor());
		g.fillRect(firstGrass.getX_Location(), firstGrass.getY_Location(), firstGrass.getWidth(), firstGrass.getHeight());
		
		g.setColor(firstRoad.getColor());
		g.fillRect(firstRoad.getX_Location(), firstRoad.getY_Location(), firstRoad.getWidth(), firstRoad.getHeight());
		
		g.setColor(start.getColor());
		g.fillRect(start.getX_Location(), start.getY_Location(), start.getWidth(), start.getHeight());
		
		
		g.setColor(Car3.getColor());
		g.fillRect(Car3.getX_Location(), Car3.getY_Location(), Car3.getWidth(), Car3.getHeight());

		g.setColor(Car2.getColor());
		g.fillRect(Car2.getX_Location(), Car2.getY_Location(), Car2.getWidth(), Car2.getHeight());

		g.setColor(Car1.getColor());
		g.fillRect(Car1.getX_Location(), Car1.getY_Location(), Car1.getWidth(), Car1.getHeight());

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
