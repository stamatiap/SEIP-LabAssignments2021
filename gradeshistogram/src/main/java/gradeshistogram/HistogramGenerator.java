package gradeshistogram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class HistogramGenerator {
	/***
	 * Receives a single dimension Integer array. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart
	 * is generated with the use of the aforementioned dataset and then
	 * presented in the screen.
	 * 
	 * @param dataValues Single dimension integer array
	 */
	public void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}
	
	public ArrayList<Integer> readFile(File file) {
		ArrayList<Integer> fileData = new ArrayList<Integer>();
		// read the file
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextInt()) {
				fileData.add(sc.nextInt());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		return fileData;
	}

	public static void main(String[] args) {
		
		if(args.length == 0) {
	        System.out.println("Proper Usage is: java program filename");
	    } else {
	    	File file = new File(args[0]);
	    	HistogramGenerator gen = new HistogramGenerator();
			ArrayList<Integer> grades = gen.readFile(file);
	
			int[] gradesFrequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			//count frequency
			for (int grade: grades) {
				gradesFrequency[grade]++;
			}
			gen.generateChart(gradesFrequency);
	    }
	}

}
