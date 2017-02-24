package arcade.frenzy.controller;

import arcade.frenzy.model.game.Collect_The_Coins;
import arcade.frenzy.model.game.Frenzy_Mode;
import arcade.frenzy.model.game.Frogger;
import arcade.frenzy.model.game.Get_Down;
import arcade.frenzy.model.game.Jump_The_Car;
import arcade.frenzy.model.game.Tree_Climber;
import arcade.frenzy.model.main.menu.Main_Menu;
import arcade.frenzy.model.player.Player;

public class Main_Controller {
	Player player;
	Collect_The_Coins coins;
	Tree_Climber climber;
	Frogger frogger;
	Get_Down down;
	Jump_The_Car carJumper;
	Frenzy_Mode frenzy;
	Main_Menu game;

	public void start() {
		game = new Main_Menu();
		player = new Player(0, 0, 0, 0, 0, 0);
		game.init(this);
	}

	public void handleButtonClicked(ButtonNames buttonClicked) throws InterruptedException {
		if (game.getMainPanel().isVisible())
			game.getMainPanel().setVisible(false);

		switch (buttonClicked) {
		case Collect_The_Coins:
			coins = new Collect_The_Coins(game);
			break;
		case Tree_Climber:
			climber = new Tree_Climber(game, player);
			break;
		case Frogger:
			frogger = new Frogger(game);
			break;
		case Get_Down:
			down = new Get_Down(game);
			break;
		case Jump_The_Car:
			carJumper = new Jump_The_Car(game, player);
			break;
		case Frenzy_Mode:
			frenzy = new Frenzy_Mode(this, game);
			break;
		default:
			break;
		}

	}

}
