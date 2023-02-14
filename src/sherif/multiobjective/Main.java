/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package sherif.multiobjective;

import java.util.*;
import org.jgap.*;
import org.jgap.impl.*;
import org.jgap.util.*;

/**
 * Example for a multiobjective problem. Here, we have a function F with one
 * input parameter t and two output values F1 and F2, with F1 = t² and F2 = (t -
 * 2)². The input value is restricted from -10 to 10. We are looking for a t
 * where F1 and F2 get minimal. This example is from Goldberg (pp. 199), who
 * adapted it from Schaffer (1984).
 * 
 * 
 * @author Klaus Meffert
 * @since 2.6
 */
public class Main {
	/** String containing the CVS revision. Read out via reflection! */
	private final static String CVS_REVISION = "$Revision: 1.8 $";

	/**
	 * The total number of times we'll let the population evolve.
	 */
	private static final int MAX_ALLOWED_EVOLUTIONS = 200;

	MultiObjectiveFitnessFunction multiObjectiveFitnessFunction;
	ObjectiveFunctions objectiveFunctions;

	public int functionDimension;
	public int variableDimension;

	public double minX[];
	public double maxX[];

	/**
	 * Executes the genetic algorithm.
	 * 
	 * @throws Exception
	 * 
	 * @author Klaus Meffert
	 * @since 2.6
	 */

	public Main(int variableDimension, int functionDimension, double minX[],
			double maxX[], ObjectiveFunctions objectiveFunctions) {
		this.functionDimension = functionDimension;
		this.variableDimension = variableDimension;
		this.minX = minX.clone();
		this.maxX = maxX.clone();
		this.objectiveFunctions = objectiveFunctions;

		System.out.println("Problem specs:");
		System.out.println("functionDimension: "+functionDimension);
		System.out.println("variableDimension: "+variableDimension);
	}

	public void execute() throws Exception {
		// Start with a DefaultConfiguration, which comes setup with the
		// most common settings.
		// -------------------------------------------------------------
		Configuration conf = new DefaultConfiguration();
		// Add BestChromosomesSelector with doublettes allowed.
		// ----------------------------------------------------
		conf.removeNaturalSelectors(true);
		BestChromosomesSelector bestChromsSelector = new BestChromosomesSelector(
				conf, 0.95d);
		bestChromsSelector.setDoubletteChromosomesAllowed(true);
		conf.addNaturalSelector(bestChromsSelector, true);
		conf.reset();
		// Set the fitness function we want to use, which is our
		// MultiObjectiveFitnessFunction. We construct it with
		// the target amount of change passed in to this method.
		// -----------------------------------------------------
		multiObjectiveFitnessFunction = new MultiObjectiveFitnessFunction(
				variableDimension, functionDimension, minX, maxX,
				objectiveFunctions);
		conf.setBulkFitnessFunction(multiObjectiveFitnessFunction);
		conf.setFitnessEvaluator(new MOFitnessEvaluator(multiObjectiveFitnessFunction));
		conf.setPreservFittestIndividual(false);
		conf.setKeepPopulationSizeConstant(false);

		// Set sample chromosome.
		// ----------------------
		Gene[] sampleGenes = new Gene[variableDimension];

		for (int i = 0; i < variableDimension; i++)
			sampleGenes[i] = new DoubleGene(conf, minX[i], maxX[i]);

		IChromosome sampleChromosome = new Chromosome(conf, sampleGenes);
		conf.setSampleChromosome(sampleChromosome);
		// Finally, we need to tell the Configuration object how many
		// Chromosomes we want in our population. The more Chromosomes,
		// the larger number of potential solutions (which is good for
		// finding the answer), but the longer it will take to evolve
		// the population (which could be seen as bad).
		// ------------------------------------------------------------
		conf.setPopulationSize(500);
		// Create random initial population of Chromosomes.
		// ------------------------------------------------
		Genotype population = Genotype.randomInitialGenotype(conf);
		// Evolve the population. Since we don't know what the best answer
		// is going to be, we just evolve the max number of times.
		// ---------------------------------------------------------------
		for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
			population.evolve();
		}
		// Now we have at least one solution.
		// ----------------------------------
		List chroms = population.getPopulation().getChromosomes();
		MOFitnessComparator comp = new MOFitnessComparator();
		// Remove all duplicate solutions.
		// -------------------------------
		Collections.sort(chroms, comp);
		int index = 0;
		while (index < chroms.size() - 1) {
			// First solution to compare.
			Chromosome aSolution1 = (Chromosome) chroms.get(index);
			Vector<Double> v1 = multiObjectiveFitnessFunction
					.getVector(aSolution1);

			Double x1[] = new Double[variableDimension];
			for (int i = 0; i < variableDimension; i++)
				x1[i] = v1.get(i);
			// Second solution to compare.
			Chromosome aSolution2 = (Chromosome) chroms.get(index + 1);
			Vector<Double> v2 = multiObjectiveFitnessFunction
					.getVector(aSolution2);
			Double x2[] = new Double[variableDimension];
			for (int i = 0; i < variableDimension; i++)
				x2[i] = v2.get(i);

			boolean exp = (Math.abs(x1[0] - x2[0]) < 0.000001);
			for (int i = 1; i < variableDimension; i++)
				exp = exp && (Math.abs(x1[i] - x2[i]) < 0.000001);

			if (exp) {
				// Duplicate solution found
				chroms.remove(index);
			} else {
				index++;
			}
		}
		// Print all Pareto-optimal solutions.
		// -----------------------------------
		System.out.println("Formula F1(x) = x²");
		System.out.println("Formula F2(x) = (x-2)²");
		System.out.println("\nFound pareto-optimal solutions:");
		System.out.println("===============================\n");
		System.out.println("Input value x  F1(x)          F2(x)"
				+ "          Difference from optimum");
		System.out.println("=============  =====          ====="
				+ "          =======================");
		for (int k = 0; k < chroms.size(); k++) {
			Chromosome bestSolutionSoFar = (Chromosome) chroms.get(k);
			String s = "";
			Vector<Double> v = multiObjectiveFitnessFunction
					.getVector(bestSolutionSoFar);
			for (int j = 0; j < (functionDimension+variableDimension)+1; j++) {
				
				Double d = v.get(j);
				//System.out.print(d.doubleValue()+",,");
				String t = NumberKit.niceDecimalNumber(d, 9);
				t = StringKit.fill(t, 15, ' ');
				s += t;
			}
			System.out.println(s);
		}
	}

	/**
	 * Main method to run the example.
	 * 
	 * @param args
	 *            ignored
	 * @throws Exception
	 * 
	 * @author Klaus Meffert
	 * @since 2.6
	 */

	/**
	 * @author Klaus Meffert
	 * @since 2.6
	 */
	public class MOFitnessComparator implements java.util.Comparator {
		public int compare(final Object a_chrom1, final Object a_chrom2) {
			List v1 = ((Chromosome) a_chrom1).getMultiObjectives();
			List v2 = ((Chromosome) a_chrom2).getMultiObjectives();
			int size = v1.size();
			if (size != v2.size()) {
				throw new RuntimeException("Size of objectives inconsistent!");
			}
			double d1Total = 0;
			double d2Total = 0;
			for (int i = 0; i < size; i++) {
				double d1 = ((Double) v1.get(i)).doubleValue();
				double d2 = ((Double) v2.get(i)).doubleValue();
				d1Total += d1;
				d2Total += d2;
			}
			if (d1Total < d2Total) {
				return -1;
			} else {
				if (d1Total > d2Total) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
}
