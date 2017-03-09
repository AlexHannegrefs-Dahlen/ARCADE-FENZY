package arcade.frenzy.view.game;

import acade.frenzy.model.object_creation.Object_Creator;

/**
 * 
 * @author Alex Collision detections that are in every game
 */
public interface Game_Interface {

	boolean detectCollisionPlayerInsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerOutsideBottomWall(Object_Creator object);

	boolean detectCollisionPlayerOutsideTopWall(Object_Creator object);

	boolean detectCollisionPlayerOutsideRightWall(Object_Creator object);

	boolean detectCollisionPlayerOutsideLeftWall(Object_Creator object);

}
