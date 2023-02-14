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

/**
 * Fitness evaluator for multi objectives example. Determines which of two
 * vectors with multiobjective values is fitter. In our example, the fitter
 * vector is the one for which the sum of the values is smaller.
 * 
 * @author Klaus Meffert
 * @since 2.6
 */
public class MOFitnessEvaluator implements FitnessEvaluator {

	/** String containing the CVS revision. Read out via reflection! */
	private final static String CVS_REVISION = "$Revision: 1.4 $";

	MultiObjectiveFitnessFunction multiObjectiveFitnessFunction;

	public MOFitnessEvaluator(
			MultiObjectiveFitnessFunction multiObjectiveFitnessFunction) {
		this.multiObjectiveFitnessFunction = multiObjectiveFitnessFunction;
	}

	/**
	 * Not to be called in multi-objectives context! Instead, oOther method
	 * below applies for multi-objectives.
	 * 
	 * @param a_fitness_value1
	 *            ignored
	 * @param a_fitness_value2
	 *            ignored
	 * @return always a RuntimeException
	 * 
	 * @author Klaus Meffert
	 * @since 2.6
	 */
	public boolean isFitter(final double a_fitness_value1,
			final double a_fitness_value2) {
		throw new RuntimeException("Not supported for multi-objectives!");
	}

	public boolean isFitter(IChromosome a_chrom1, IChromosome a_chrom2) {
		// Evaluate values and fill vector of multiobjectives with them.
		// -------------------------------------------------------------
		DoubleGene g;
		double x[] = new double[multiObjectiveFitnessFunction.variableDimension];
		double y[] = new double[multiObjectiveFitnessFunction.functionDimension];
		List l1 = new Vector();

		for (int i = 0; i < multiObjectiveFitnessFunction.variableDimension; i++) {
			g = (DoubleGene) a_chrom1.getGene(i);
			x[i] = g.doubleValue();
		}

		for (int i = 0; i < multiObjectiveFitnessFunction.functionDimension; i++) {
			y[i] = multiObjectiveFitnessFunction.formula(i, x);
			l1.add(new Double(y[i]));
		}
		
		List l2 = new Vector();
		for (int i = 0; i < multiObjectiveFitnessFunction.variableDimension; i++) {
		g = (DoubleGene) a_chrom2.getGene(i);
		x[i] = g.doubleValue();
		}
		
		for (int i = 0; i < multiObjectiveFitnessFunction.functionDimension; i++) {
			y[i] = multiObjectiveFitnessFunction.formula(i, x);
			l2.add(new Double(y[i]));
		}
		
		int size = l1.size();
		if (size != l2.size()) {
			throw new RuntimeException("Size of objectives inconsistent!");
		}
		double d1Total = 0;
		double d2Total = 0;
		for (int i = 0; i < size; i++) {
			double d1 = ((Double) l1.get(i)).doubleValue();
			double d2 = ((Double) l2.get(i)).doubleValue();
			d1Total += d1;
			d2Total += d2;
		}
		if (d1Total < d2Total) {
			return true;
		} else {
			return false;
		}
	}
}
