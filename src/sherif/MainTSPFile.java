/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sherif;

import org.jgap.Chromosome;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;

import sherif.io.ReadCities;

/**
 * 
 * @author kadersh
 */
public class MainTSPFile {

	TravellingSalesmanGUI t;

	public MainTSPFile(String file, String optFile) {
		try {
			AbstractTSPData rc = new ReadCities(file, optFile);
			// t = new TravellingSalesmanGUI(rc.coordinateArray, rc.counter);
			t = new TravellingSalesman_Smoothing(rc.coordinateArray,
					rc.counter, new double[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
			((TravellingSalesman_Smoothing) t).smoothingFunction = SmoothingFunctions.EXPONENTIAL;

			t.setMaxEvolution(4000);
			t.setPopulationSize(1000);

			TSPIndicatorsGUI tspInd = new TSPIndicatorsGUI();
			tspInd.setSize(700, 500);
			tspInd.setVisible(true);

			TSPRoutePlotter theTSPRoutePlotter = new TSPRoutePlotter(rc);
			theTSPRoutePlotter.setSize(700, 500);
			theTSPRoutePlotter.setVisible(true);

			theTSPRoutePlotter.getTSPPane().setOptimalRoute(
					((ReadCities) rc).optimal);

			IChromosome optimal = t.findOptimalPath(null, tspInd.getChart(),
					theTSPRoutePlotter.getTSPPane());

			System.out.println("Solution: ");
			for (int i = 0; i < rc.counter; i++) {
				System.out.println(optimal.getGenes()[i]);
			}
			System.out.println("Score "
					+ (Integer.MAX_VALUE / 2 - optimal.getFitnessValue()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// new MainTSPFile("bays29.tsp","bays29.opt.tour");
		new MainTSPFile("pr2392.tsp", "pr2392.opt.tour");
	}
}
