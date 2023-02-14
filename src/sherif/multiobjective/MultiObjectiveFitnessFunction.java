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
import org.jgap.gp.terminal.Variable;
import org.jgap.impl.*;

/**
 * Sample fitness function for the multiobjective problem.
 * 
 * @author Klaus Meffert
 * @since 2.6
 */
public class MultiObjectiveFitnessFunction extends BulkFitnessFunction {
	/** String containing the CVS revision. Read out via reflection! */
	private final static String CVS_REVISION = "$Revision: 1.5 $";

	public static final int MAX_BOUND = 4000;
	
	ObjectiveFunctions objectiveFunctions;

	public int functionDimension;
	public int variableDimension;

	public double minX[];
	public double maxX[];

	public MultiObjectiveFitnessFunction(int variableDimension,int functionDimension,double[] minX,double[] maxX,ObjectiveFunctions objectiveFunctions)
	{
		this.functionDimension=functionDimension;
		this.variableDimension=variableDimension;
		this.minX=minX.clone();
		this.maxX=maxX.clone();
		this.objectiveFunctions=objectiveFunctions;
	}
	
	/**
	 * Determine the fitness of the given Chromosome instance. The higher the
	 * returned value, the fitter the instance. This method should always return
	 * the same fitness value for two equivalent Chromosome instances.
	 * 
	 * @param a_subject
	 *            the population of chromosomes to evaluate
	 * 
	 * @author Klaus Meffert
	 * @since 2.6
	 */
	public void evaluate(Population a_subject) {
		Iterator it = a_subject.getChromosomes().iterator();
		while (it.hasNext()) {
			IChromosome a_chrom1 = (IChromosome) it.next();
			// Evaluate values to fill vector of multiobjectives with.
			// -------------------------------------------------------
			List l = new Vector();
			double d_x[] = new double[variableDimension];
			double y[] = new double[functionDimension];
			DoubleGene g1;

			for (int i = 0; i < variableDimension; i++) {
				g1 = (DoubleGene) a_chrom1.getGene(i);
				d_x[i] = g1.doubleValue();
				l.add(new Double(d_x[i]));
			}

			for (int i = 0; i < functionDimension; i++) {
				y[i] = formula(i, d_x);
				l.add(new Double(y[i]));
			}
			((Chromosome) a_chrom1).setMultiObjectives(l);
		}
	}

	/**
	 * @param a_chrom
	 *            the chromosome for which to obtain the result it represents
	 * 
	 * @return vector of data for output
	 */
	public Vector<Double> getVector(IChromosome a_chrom) {
		// Fill MO Vector with X (input), output F1(X), output F2(X),
		// difference of |F1(X)| + |F2(X)| from zero
		// ----------------------------------------------------------
		Vector result = new Vector();
		List mo = ((Chromosome) a_chrom).getMultiObjectives();
		
		int i;

		for (i = 0; i < variableDimension; i++) {
			Double dX = (Double) mo.get(i);
			result.add(dX);
		}

		double Fsum = 0;
		for (int j = variableDimension; j < variableDimension+functionDimension; j++) {
			Double dF = (Double) mo.get(j);
			result.add(dF);
			Fsum += Math.abs(dF);
		}
		// Difference from optimum
		result.add(Fsum);
		
		return result;
	}

	public double formula(int a_index, double x[]) {
		return objectiveFunctions.function(a_index, x);
	}

	/**
	 * @return deep clone_ICloneable of the current instance
	 * 
	 * @author Klaus Meffert
	 * @since 3.2
	 */
	public Object clone_ICloneable() {
		return new MultiObjectiveFitnessFunction(variableDimension,functionDimension,minX,maxX,objectiveFunctions);
	}
}
