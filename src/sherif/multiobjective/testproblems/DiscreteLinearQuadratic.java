package sherif.multiobjective.testproblems;

import sherif.multiobjective.ObjectiveFunctions;
public class DiscreteLinearQuadratic  implements ObjectiveFunctions {
	String name="FON";
	String reference;
	
	public int numberOfObjectives=2;
	public int numberOfVariables;
	
	public int N;
	
	@Override
	public double function(int a_index, double[] x) {
		double v[]=new double[N];
		for(int i=1;i<N;i++)
			v[i]=v[i-1]*v[i-1];
		double sum1=0,sum2=0;
	}

}
