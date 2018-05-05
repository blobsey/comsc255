//Assignment #: 7

//Student Name:  Blake Randall

 //Class:  COMSC-255

//Section: 8306


package test;

import javax.swing.*;

import Statistics;

import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class StringTokenizerStatistics {
	public static void main(String[] args)
	{
		String input = JOptionPane.showInputDialog(null, "Enter Data <separated by commas>: ");
		StringTokenizer st = new StringTokenizer(input, ",");
		
		
		int numValues = st.countTokens();
		System.out.println(numValues);
		double[] data = new double[numValues];
		
		for(int i = 0; i < numValues; i++)
			data[i] = Double.parseDouble(st.nextToken());
				
		Statistics stats = new Statistics(data, numValues);
		double[] statsData = stats.getOrigData(), statsSdata = stats.getSortedData();
		String printData = "" + statsData[0], printSdata = "" + statsSdata[0];
		for(int i = 1; i < numValues; i++)
		{
			printData += ", " + statsData[i];
			printSdata += ", " + statsSdata[i];
		}
		
		DecimalFormat df = new DecimalFormat("#0.000");
		
		JOptionPane.showMessageDialog(null, "Original Data:\n" + 
				printData +
				"\nSorted Data:\n" +
				printSdata +
				"\nMin Value: " + df.format(stats.findMin()) +
				"\nMax Value: " + df.format(stats.findMax()) +
				"\nMean: " + df.format(stats.findMean()) + 
				"\nMedian: " + df.format(stats.findMedian()));
		
		
	}
}
