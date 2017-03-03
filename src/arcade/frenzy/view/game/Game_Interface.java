package arcade.frenzy.view.game;

import acade.frenzy.model.object_creation.Object_Creater;

public interface Game_Interface {

	boolean detectCollisionPlayerInsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerOutsideBottomWall(Object_Creater object);

	boolean detectCollisionPlayerOutsideTopWall(Object_Creater object);

	boolean detectCollisionPlayerOutsideRightWall(Object_Creater object);

	boolean detectCollisionPlayerOutsideLeftWall(Object_Creater object);

}
