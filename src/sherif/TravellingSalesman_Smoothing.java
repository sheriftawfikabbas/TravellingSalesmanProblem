package sherif;

import java.util.Arrays;

import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jgap.Chromosome;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.Population;
import org.jgap.impl.IntegerGene;

/*
 * Source: 
 * "A computational study of smoothing heuristics for the traveling salesman problem"
 * European Journal of Operational Research 124 (1999) 15-27
 * 
 * In this work, the five smoothing methods are implemented.
 */

public class TravellingSalesman_Smoothing extends TravellingSalesmanGUI {

	double alpha;
	double averageIntercityDistanceVal;
	double smoothingSchedule[];
	double distances[][];
	double normalizedDistances[][];

	public int smoothingFunction;

	public TravellingSalesman_Smoothing(double[][] CITYARRAY, int CITIES,
			double[] smoothingSchedule) {
		super(CITYARRAY, CITIES);

		distances = new double[CITIES][CITIES];
		normalizedDistances = new double[CITIES][CITIES];

		precomputeAndNormalizeDistances();

		averageIntercityDistanceVal = averageIntercityDistance();

		this.smoothingSchedule = Arrays.copyOf(smoothingSchedule,
				smoothingSchedule.length);
	}

	public IChromosome findOptimalPath(final Object a_initial_data,
			JFreeChart _chart, TSPPane pane) throws Exception {
		JFreeChart chart = _chart;
		XYSeriesCollection sc = (XYSeriesCollection) chart.getXYPlot()
				.getDataset();
		XYSeries series = sc.getSeries(0);
		series.clear();
		m_config = createConfiguration(a_initial_data);
		FitnessFunction myFunc = createFitnessFunction(a_initial_data);
		m_config.setFitnessFunction(myFunc);
		// Now we need to tell the Configuration object how we want our
		// Chromosomes to be setup. We do that by actually creating a
		// sample Chromosome and then setting it on the Configuration
		// object.
		// --------------------------------------------------------------
		IChromosome sampleChromosome = createSampleChromosome(a_initial_data);
		m_config.setSampleChromosome(sampleChromosome);
		// Finally, we need to tell the Configuration object how many
		// Chromosomes we want in our population. The more Chromosomes,
		// the larger number of potential solutions (which is good for
		// finding the answer), but the longer it will take to evolve
		// the population (which could be seen as bad). We'll just set
		// the population size to 500 here.
		// ------------------------------------------------------------
		m_config.setPopulationSize(getPopulationSize());
		// Create random initial population of Chromosomes.
		// ------------------------------------------------

		// As we cannot allow the normal mutations if this task,
		// we need multiple calls to createSampleChromosome.
		// -----------------------------------------------------
		IChromosome[] chromosomes = new IChromosome[m_config
				.getPopulationSize()];
		Gene[] samplegenes = sampleChromosome.getGenes();
		for (int i = 0; i < chromosomes.length; i++) {
			Gene[] genes = new Gene[samplegenes.length];
			for (int k = 0; k < genes.length; k++) {
				genes[k] = samplegenes[k].newGene();
				genes[k].setAllele(samplegenes[k].getAllele());
			}
			chromosomes[i] = new Chromosome(m_config, genes);
		}
		// Create the genotype. We cannot use Genotype.randomInitialGenotype,
		// Because we need unique gene values (representing the indices of the
		// cities of our problem).
		// -------------------------------------------------------------------
		Genotype population = new Genotype(m_config, new Population(m_config,
				chromosomes));
		IChromosome best = null;
		// Evolve the population. Since we don't know what the best answer
		// is going to be, we just evolve the max number of times.
		// ---------------------------------------------------------------
		System.out
				.println("Evolution starts-------------------------------------");
		System.out.println("averageIntercityDistance = "
				+ averageIntercityDistance());
		Evolution: for (int i = 0; i < smoothingSchedule.length; i++) {
			alpha = smoothingSchedule[i];
			System.out.println(" ####### alpha = " + smoothingSchedule[i]
					+ " ######## ");
			population.evolve();

			best = population.getFittestChromosome();

			series.add(m_config.getGenerationNr(),
					Integer.MAX_VALUE / 2 - best.getFitnessValue());

			pane.setRoute(best);
			pane.repaint();

			System.out.println("Current chromosome details:-------");
			System.out.println(" Fitness  = " + best.getFitnessValue());
			System.out.println(" Distance = "
					+ -(best.getFitnessValue() - Integer.MAX_VALUE / 2));
			System.out.println(" String   = " + best.toString());
		}
		// Return the best solution we found.
		// ----------------------------------
		return best;
	}

	public double averageIntercityDistance() {
		double totalDist = 0;
		for (int a = 0; a < CITIES; a++) {
			for (int b = 0; b < CITIES; b++) {
				if (a != b) {

					totalDist += normalizedDistances[a][b];
				}
			}
		}
		return totalDist / (CITIES * (CITIES - 1));
	}

	public void precomputeAndNormalizeDistances() {
		double maxDistance = 0;
		for (int a = 0; a < CITIES; a++) {
			for (int b = 0; b < CITIES; b++) {
				double x1 = CITYARRAY[a][0];
				double y1 = CITYARRAY[a][1];
				double x2 = CITYARRAY[b][0];
				double y2 = CITYARRAY[b][1];
				distances[a][b] = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2)
						* (y1 - y2));
				if (distances[a][b] > maxDistance)
					maxDistance = distances[a][b];
			}
		}
		for (int a = 0; a < CITIES; a++) {
			for (int b = 0; b < CITIES; b++) {
				normalizedDistances[a][b] = distances[a][b] / maxDistance;
			}
		}
	}

	public double getNormalizedDistance(Gene a_from, Gene a_to) {
		IntegerGene geneA = (IntegerGene) a_from;
		IntegerGene geneB = (IntegerGene) a_to;
		int a = geneA.intValue();
		int b = geneB.intValue();

		return normalizedDistances[a][b];
	}

	public double distance(Gene a_from, Gene a_to) {
		switch (smoothingFunction) {
		case SmoothingFunctions.CONCAVE:
			return Math.pow(getNormalizedDistance(a_from, a_to), 1.0D / alpha);
		case SmoothingFunctions.CONVEX:
			return Math.pow(getNormalizedDistance(a_from, a_to), alpha);
		case SmoothingFunctions.HYPERBOLIC:
			return averageIntercityDistanceVal
					+ (getNormalizedDistance(a_from, a_to) - averageIntercityDistanceVal)
					/ alpha;
		case SmoothingFunctions.LOGARITHMIC:
			if (getNormalizedDistance(a_from, a_to) >= averageIntercityDistanceVal)
				return averageIntercityDistanceVal
						+ Math.log(1
								+ alpha
								* (getNormalizedDistance(a_from, a_to) - averageIntercityDistanceVal))
						/ alpha;
			else
				return averageIntercityDistanceVal
						- Math.log(1
								+ alpha
								* (averageIntercityDistanceVal - getNormalizedDistance(
										a_from, a_to))) / alpha;
		default:
			if (getNormalizedDistance(a_from, a_to) >= averageIntercityDistanceVal)

				return averageIntercityDistanceVal
						+ Math.pow(getNormalizedDistance(a_from, a_to)
								- averageIntercityDistanceVal, alpha);
			else
				return averageIntercityDistanceVal
						- Math.pow(averageIntercityDistanceVal
								- getNormalizedDistance(a_from, a_to), alpha);
		}
	}
}
