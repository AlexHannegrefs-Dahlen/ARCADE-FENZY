package arcade.frenzy.model.load_save;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Load {
	private BufferedReader in;

	/**
	 * loads the scores from a preset text file
	 */
	public Load() {
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("scores.txt")));
		} catch (FileNotFoundException e) {
		}
	}

	/**
	 * 
	 * @return the previous scores or "no scores" if there are no scores
	 * @throws IOException
	 */
	public String loadScores() throws IOException {
		in = new BufferedReader(new InputStreamReader(new FileInputStream("scores.txt")));
		String load = in.readLine();
		if (load != null) {
			while (in.ready()) {
				load += "\n" + in.readLine();
			}
			in.close();
			return load;
		} else {
			in.close();
			return "No scores";
		}
	}
}
