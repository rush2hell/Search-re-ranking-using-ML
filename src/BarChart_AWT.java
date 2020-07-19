import java.awt.Dimension;
import java.awt.Toolkit;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart_AWT extends ApplicationFrame
{
	public BarChart_AWT(String applicationTitle, String chartTitle, double tf[], String t1, String t2)
	{
		super(applicationTitle);
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, t1, t2, createDataset(tf), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);

		// chartPanel.setExtendedState(this.MAXIMIZED_BOTH);
		chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));
		setContentPane(chartPanel);
		this.pack();
	}

	private CategoryDataset createDataset(double tf[])
	{
		final String l1 = "Link 1";
		final String l2 = "Link 2";
		final String l3 = "Link 3";
		final String l4 = "Link 4";
		final String l5 = "Link 5";
		final String speed = "Rating - Ranking";

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(tf[0], l1, speed);

		dataset.addValue(tf[1], l2, speed);

		dataset.addValue(tf[2], l3, speed);

		dataset.addValue(tf[3], l4, speed);

		dataset.addValue(tf[4], l5, speed);

		return dataset;
	}

	public static void main(String[] args)
	{
		// BarChart_AWT chart = new BarChart_AWT("Result",
		// "Word Result");

		// RefineryUtilities.centerFrameOnScreen( chart );
		// chart.setVisible( true );
	}
}