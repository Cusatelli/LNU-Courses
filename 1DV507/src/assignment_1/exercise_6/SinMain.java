package assignment_1.exercise_6;

import java.util.ArrayList;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SinMain {
    // Get screen size:
	// https://stackoverflow.com/questions/1936566/how-do-you-get-the-screen-width-in-java/8101318#8101318
    static int WIDTH = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    static int HEIGHT = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	
	public static void main(String[] args) {
		
		// Generate data
	    ArrayList<Double> xData = new ArrayList<Double>();
	    ArrayList<Double> yData = new ArrayList<Double>();
	    int size = 1000;
	    
	    // Data for X && Y:
	    double x = 0;
	    xData.add(x);
	    for(double i = 1; i < size + 1; i++) {
	    	x += 0.1;
	    	xData.add(x);
	    }
	    
	    for(int i = 0; i < size + 1; i++) {
	    	yData.add(((1 + (xData.get(i) / Math.PI))) 
	    			* (Math.cos(xData.get(i))) * (Math.cos(40 * xData.get(i))));
	    }
	    
	    XYChart chart = new XYChartBuilder().width(WIDTH/2).height(HEIGHT/2).build();
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
	    chart.getStyler().setChartTitleVisible(false);
	    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
	    chart.getStyler().setMarkerSize(5);
	    chart.addSeries("y = (1 + x / pi) * cos(x) * cos(40 * x)", xData, yData);
	    
	    new SwingWrapper<XYChart>(chart).displayChart().setLocation(WIDTH/4, HEIGHT/4); // <- Places window in center of screen after displaying.
	}
}
