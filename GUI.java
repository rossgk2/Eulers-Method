import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class GUI extends GBFrame
{
	private JTextField x0y0input = addTextField("(0, 1)", 1, 2, 1, 1);
	private IntegerField subintervalInput = addIntegerField(2, 2, 2, 1, 1);
	private DoubleField  xninput = addDoubleField(1, 3, 2, 1, 1);
	private JTextField diffEqInput = addTextField("", 4, 2, 1, 1);
	
	private JButton calculate = addButton("CALCULATE", 4, 1, 1, 1);
	private JList guilist = addList(5, 1, 1, 1);
	
	public GUI()
	{
		addLabel("enter the inital condition of the form (x0, y0):", 1, 1, 1, 1);
		
		addLabel("enter the number of subintervals (must be an integer):", 2, 1, 1, 1);
		
		addLabel("enter the final x-value (must be a number):", 3, 1, 1, 1);
		
		addLabel("dy/dx =", 4, 1, 1, 1);
	    
	    setTitle("Euler's Method Calculator");
		setSize(600, 600);
		setVisible(true);
	}
	
	public void buttonClicked(JButton b)
	{
		if (b == calculate)
		{
			respond();	
		}
	}
	
	public void respond()
	{
		double[] x0y0info = extractOrderedPair(x0y0input.getText());
		double x0 = x0y0info[0], y0 = x0y0info[1];
		int subintervals = subintervalInput.getNumber();
		double xn = xninput.getNumber();
		String diffEq = diffEqInput.getText();
		
		double[][] values = EulersMethod.euler(diffEq, x0, y0, subintervals, xn);
		
		double dx = (xn - x0) / subintervals;
		DefaultListModel<String> listContents = new DefaultListModel<>();
		for (int i = 0; i < values.length; i ++)
		{
			listContents.addElement("(" + (x0 + dx * i)  + ", " + values[i][1] + ")");
		}
		
		guilist.setModel(listContents);
		revalidate();
		repaint();
	}
	
	private static double[] extractOrderedPair(String text)
	{
		int begin = text.contains("(") ? 1 : 0;
        int end = text.contains(")") ? text.length() - 1 : text.length();
        String textWithoutBrackets = text.substring(begin, end);

        //extracting x
        begin = 0;
        end = textWithoutBrackets.indexOf(",");
        String x = textWithoutBrackets.substring(begin, end).trim();
        double extractedX = Double.valueOf(x);

        //extracting y
        begin = end + 1;
        end = textWithoutBrackets.length();
        String y = textWithoutBrackets.substring(begin, end).trim();
        double extractedY = Double.valueOf(y);
        
        return new double[] {extractedX, extractedY};
	}
}
