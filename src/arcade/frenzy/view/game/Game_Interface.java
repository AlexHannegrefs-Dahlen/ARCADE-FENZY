package arcade.frenzy.view.game;

import arcade.frenzy.model.player.Player;

public interface Game_Interface {
	Player player = null;
	
	default void detectCollision() {

	}
}
