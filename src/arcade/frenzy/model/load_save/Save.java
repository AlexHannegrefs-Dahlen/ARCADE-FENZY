package arcade.frenzy.model.load_save;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Save {
	static PrintStream out;

	public static void save(String highscore) throws FileNotFoundException {
		FileOutputStream fileStream = new FileOutputStream(new File("scores.txt"));
		PrintStream ps = new PrintStream(fileStream);
		out = ps;

		out.append(highscore);
		ps.close();
	}

	public static void reset() throws FileNotFoundException {
		FileOutputStream fileStream = new FileOutputStream(new File("scores.txt"));
		PrintStream ps = new PrintStream(fileStream);
		out = ps;
		out.print("");
	}
}
