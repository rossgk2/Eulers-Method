import org.nfunk.jep.JEP;

public class EulersMethod
{
	public static void main(String[] args)
	{
		new GUI();
	}
	
	public static double[][] euler(String dydx, double x0, double y0, int subintervals, double xn)
	{
		JEP parser = new JEP();
		parser.addStandardConstants();
		parser.addStandardFunctions();
		
		double deltaX = (xn - x0) / subintervals; // (3-1)/4 = 1/2	1, 1.5, 2, 2.5, 3
		double[][] values = new double[subintervals + 1][2];
		values[0][0] = x0;
		values[0][1] = y0;
		
		for (int i = 1; i < values.length; i ++)
		{
			parser.addVariable("x", values[i - 1][0]);
			parser.addVariable("y", values[i - 1][1]);
			parser.parseExpression(dydx);
			
			values[i][0] = values[i - 1][0] + deltaX; //the value of values[i][0] is only important for the next iteration
			values[i][1] = values[i - 1][1] + parser.getValue()*deltaX;
			
			parser.removeVariable("x");
			parser.removeVariable("y");
		}
		
		return values;
	}
	
	public static double[] valuesOfFunction(String fxn, double start, double end, double step)
	{
		JEP parser = new JEP();
		parser.addStandardConstants();
		parser.addStandardFunctions();
		
		double proposedLength = (end - start) / step;
		int length = noAccuracyLoss(proposedLength) ? (int) proposedLength : -1;
		
		if (length == -1)
			throw new IllegalArgumentException("invalid arguments in valuesOfFunction() method call");
		
		double[] values = new double[length + 1];
	
		double x = start;
		for (int i = 0; i < values.length; x += step, i ++)
		{
			parser.addVariable("x", x);
			parser.parseExpression(fxn);
			values[i] = parser.getValue();
		}
		return values;
	}
	
	public static boolean noAccuracyLoss(double num)
	{
		return (int) num == Math.floor(num);
	}
	
	public static void printArr(double[] arr)
	{
		for (double d : arr)
		{
			System.out.print(d + "\t");
		}
	}
}
