package sherif.multiobjective;

import sherif.multiobjective.testproblems.*;

public class Demo {
	public static void main(String[] args) throws Exception {
		// SCH prob = new SCH();
		FON prob = new FON(3);
		// Main instance = new Main(prob.numberOfVariables,
		// prob.numberOfObjectives,new double[] { -10, -10 }, new double[] { 10,
		// 10 }, prob);
		Main instance = new Main(prob.numberOfVariables,
				prob.numberOfObjectives, new double[] { -4, -4, -4 },
				new double[] { 4, 4, 4 }, prob);
		instance.execute();
	}

}
