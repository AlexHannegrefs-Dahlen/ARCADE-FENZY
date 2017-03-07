package arcade.frenzy.model.load_save;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Load {
	BufferedReader in;

	public Load() {
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("scores.txt")));
		} catch (FileNotFoundException e) {
		}
	}

	public String loadScores() throws IOException {
		if (in.readLine() != null) {
			String load = in.readLine();
			while (in.ready()) {
				load += "\n " + in.readLine();
			}
			return load;
		} else
			return "No scores";
	}
}
