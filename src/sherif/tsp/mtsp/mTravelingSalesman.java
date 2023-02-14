/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package sherif.tsp.mtsp;

import org.jgap.*;
import org.jgap.impl.*;
import org.jgap.impl.salesman.*;

public class mTravelingSalesman extends Salesman {

	/** String containing the CVS revision. Read out via reflection! */
	private static final String CVS_REVISION = "$Revision: 1.14 $";
	/** The number of cities to visit */
	public int CITIES;
	public int m;
	public double[][] CITYARRAY;

	public mTravelingSalesman(double[][] CITYARRAY, int CITIES,int m) {
		this.CITIES = CITIES;
		this.m=m;
		this.CITYARRAY = new double[CITIES][2];
		for (int i = 0; i < CITIES; i++)
			for (int j = 0; j < 2; j++)
				this.CITYARRAY[i][j] = CITYARRAY[i][j];
	}

	/**
	 * Create an array of the given number of integer genes. The first gene is
	 * always 0, this is the city where the salesman starts the journey.
	 * 
	 * @param a_initial_data
	 *            ignored
	 * @return Chromosome
	 * 
	 * @author Audrius Meskauskas
	 * @since 2.0
	 */
	public IChromosome createSampleChromosome(Object a_initial_data) {
		try {
			Gene[] genes = new Gene[CITIES];
			for (int i = 0; i < genes.length; i++) {
				genes[i] = new IntegerGene(getConfiguration(), 0, CITIES - 1);
				genes[i].setAllele(new Integer(i));
			}
			IChromosome sample = new Chromosome(getConfiguration(), genes);
			return sample;
		} catch (InvalidConfigurationException iex) {
			throw new IllegalStateException(iex.getMessage());
		}
	}

	/**
	 * Distance is equal to the difference between city numbers, except the
	 * distance between the last and first cities that is equal to 1. In this
	 * way, we ensure that the optimal solution is 0 1 2 3 .. n - easy to check.
	 * 
	 * @param a_from
	 *            first gene, representing a city
	 * @param a_to
	 *            second gene, representing a city
	 * @return the distance between two cities represented as genes
	 * 
	 * @author Audrius Meskauskas
	 * @since 2.0
	 */
	public double distance(Gene a_from, Gene a_to) {
		IntegerGene geneA = (IntegerGene) a_from;
		IntegerGene geneB = (IntegerGene) a_to;
		int a = geneA.intValue();
		int b = geneB.intValue();
		double x1 = CITYARRAY[a][0];
		double y1 = CITYARRAY[a][1];
		double x2 = CITYARRAY[b][0];
		double y2 = CITYARRAY[b][1];
		// if (A == 0 && B == CITIES - 1) {
		// return 1;
		// }
		// if (B == 0 && A == CITIES - 1) {
		// return 1;
		// }
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
