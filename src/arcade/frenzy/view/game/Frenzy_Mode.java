package arcade.frenzy.view.game;

import arcade.frenzy.controller.GameNames;
import arcade.frenzy.controller.Main_Controller;
import arcade.frenzy.view.main.menu.Main_Menu;

public class Frenzy_Mode {

	public Frenzy_Mode(Main_Controller main_Controller, Main_Menu game) throws InterruptedException {
		main_Controller.handleButtonClicked(GameNames.Collect_The_Coins);
	}

}
