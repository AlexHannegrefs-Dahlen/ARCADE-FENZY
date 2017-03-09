package arcade.frenzy.driver;

import arcade.frenzy.controller.Main_Controller;

public class Driver {
	/**
	 * main method starts the controller
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Main_Controller con = new Main_Controller();
		con.start();
	}

}
