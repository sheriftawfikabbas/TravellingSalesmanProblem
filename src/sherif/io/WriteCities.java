package sherif.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * Write cities in TSPLIB format
 * Upload on khalli3andak3elm.org, then cite them in publications.
 */

public class WriteCities {

	public static void writeCities(String filesname, double[][] cities,
			int numCities) {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filesname));
			out.write(numCities + "\n");
			out.flush();
			for (int i = 0; i < numCities; i++) {
				int cityNum = i + 1;
				out.write(cityNum + "\t" + cities[i][0] + "\t" + cities[i][1]
						+ "\n");
				out.flush();
			}
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void writeOptimalPath(String filesname, int[] cities) {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filesname));

			for (int i = 0; i < cities.length; i++) {
				out.write(cities[i] + "\n");
				out.flush();
			}
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
