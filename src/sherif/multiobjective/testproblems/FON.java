package sherif.multiobjective.testproblems;

import sherif.multiobjective.ObjectiveFunctions;

public class FON implements ObjectiveFunctions {

	String name="FON";
	String reference;
	
	public int numberOfObjectives=2;
	public int numberOfVariables;

	public FON(int numberOfVariables)
	{
		this.numberOfVariables=numberOfVariables;
	}
	
	@Override
	public double function(int a_index, double[] x) {
		double sum1=0,sum2=0;
		
		if (a_index==0)
		{
			for(int i=0;i<numberOfVariables;i++)
			{
				sum1+=(x[i]-1.0D/Math.sqrt(3))*(x[i]-1.0D/Math.sqrt(3));
			}
			return 1-Math.exp(-sum1);
		}
		else
		{
			for(int i=0;i<numberOfVariables;i++)
			{
				sum2+=(x[i]+1.0D/Math.sqrt(3))*(x[i]+1.0D/Math.sqrt(3));
			}
			return 1-Math.exp(-sum2);
		}
	}
	
}
