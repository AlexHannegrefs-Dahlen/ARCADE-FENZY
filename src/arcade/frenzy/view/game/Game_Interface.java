package arcade.frenzy.view.game;

public interface Game_Interface {

	boolean detectCollisionPlayerInsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerInsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerOutsideBottomWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerOutsideTopWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerOutsideRightWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

	boolean detectCollisionPlayerOutsideLeftWall(int OxLoc, int OyLoc, int Owidth, int Oheight);

}
