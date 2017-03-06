package arcade.frenzy.view.game;

import arcade.frenzy.UI.Games.Game_UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acade.frenzy.model.object_creation.Object_Creator;
import arcade.frenzy.model.player.Player;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frogger extends Base_Game {

	private Object_Creator Car1, Car2, Car3, start, firstRoad, firstGrass, secondRoad, secondGrass, thirdRoad, finish;
	
	private Image currentImage;

	public Frogger(Main_Menu game, Game_UI gui, Player player) throws IOException {
		this.setGame(game);
		this.setPlayer(player);
		this.getPlayer().setxLoc(game.getMainPanel().getWidth() / 2);
		this.getPlayer().setyLoc(game.getMainPanel().getHeight() / 2);
		this.getPlayer().setWidth(this.getGame().getMainPanel().getHeight() / 10);
		this.getPlayer().setHeight(this.getGame().getMainPanel().getHeight() / 10);
		this.getPlayer().setxVel(this.getGame().getMainPanel().getHeight() / 10);
		this.getPlayer().setyVel(this.getGame().getMainPanel().getHeight() / 10);
		
		finish = new Object_Creator(this.getGame().getMainPanel().getHeight() / 10,
				this.getGame().getMainPanel().getWidth(), 0, 0, 0, 0, Color.GREEN);
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
		
		currentImage = ImageIO.read(new File("Frogger/frogUp.png"));
		

		game.getMainScreen().add(this);
		game.getMainScreen().setVisible(true);
		this.addKeyListener(this);
	}

	public void Winner() {
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(finish.getColor());
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
		g.drawImage(currentImage, this.getPlayer().getxLoc(),
				this.getPlayer().getyLoc(), this.getPlayer().getWidth(), this.getPlayer().getHeight(), this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			try {
				currentImage = ImageIO.read(new File("Frogger/frogUp.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.getPlayer().setyLoc(this.getPlayer().getyLoc() - this.getPlayer().getyVel());
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			try {
				currentImage = ImageIO.read(new File("Frogger/frogDown.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.getPlayer().setyLoc(this.getPlayer().getyLoc() + this.getPlayer().getyVel());
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			try {
				currentImage = ImageIO.read(new File("Frogger/frogLeft.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.getPlayer().setxLoc(this.getPlayer().getxLoc() - this.getPlayer().getxVel());
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				currentImage = ImageIO.read(new File("Frogger/frogRight.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.getPlayer().setxLoc(this.getPlayer().getxLoc() + this.getPlayer().getxVel());
		}
		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyPressed(e);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
