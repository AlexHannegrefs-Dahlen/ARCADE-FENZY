package arcade.frenzy.model.load_save;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Save {
	static PrintStream out;

	public static void save(String highscore) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(new File("scores.txt"));
		PrintStream ps = new PrintStream(fileStream);
		out = ps;
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("scores.txt")));
		while (in.ready())
			in.readLine();
		out.append(highscore);
		ps.close();
		in.close();
	}

	public static void reset() throws FileNotFoundException {
		FileOutputStream fileStream = new FileOutputStream(new File("scores.txt"));
		PrintStream ps = new PrintStream(fileStream);
		out = ps;
		out.print("");
	}
}
