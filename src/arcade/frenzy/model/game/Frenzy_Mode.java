package arcade.frenzy.model.game;

import arcade.frenzy.controller.ButtonNames;
import arcade.frenzy.controller.Main_Controller;
import arcade.frenzy.model.main.menu.Main_Menu;

public class Frenzy_Mode {

	public Frenzy_Mode(Main_Controller main_Controller, Main_Menu game) throws InterruptedException {
		game.getMainScreen().remove(game.getMainPanel());
		main_Controller.handleButtonClicked(ButtonNames.Collect_The_Coins);
		Thread.sleep(1000);
		main_Controller.handleButtonClicked(ButtonNames.Frogger);
		Thread.sleep(1000);
	}

}
