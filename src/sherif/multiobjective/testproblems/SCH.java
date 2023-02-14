package sherif.multiobjective.testproblems;

import sherif.multiobjective.ObjectiveFunctions;

public class SCH implements ObjectiveFunctions {

	String name="SCH";
	String reference;
	
	public int numberOfObjectives=2;
	public int numberOfVariables=1;

	@Override
	public double function(int a_index, double[] x) {
		if (a_index==0)
			return x[0]*x[0];
		else
			return (x[0]-2)*(x[0]-2);
	}
	
}
