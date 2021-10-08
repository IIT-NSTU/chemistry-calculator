package ChemistryCalculator.frontend;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class FxPieChart extends JFrame {
    private static final int PANEL_WIDTH_INT = 730;
    private static final int PANEL_HEIGHT_INT = 460;
    private final JPanel chartTablePanel = new JPanel();
    private final Vector<Vector<String>> percentageOfCompletion;
    private final JFXPanel chartFxPanel = new JFXPanel();

    public FxPieChart(Vector<Vector<String>> percentageOfCompletion) {
        initComponents();
        this.percentageOfCompletion = percentageOfCompletion;
    }


    private void initComponents() {

        chartFxPanel.setPreferredSize(new Dimension(PANEL_WIDTH_INT, PANEL_HEIGHT_INT));
        chartTablePanel.add(chartFxPanel);
        add(chartTablePanel, BorderLayout.CENTER);

        setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_biohazard_120px.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Percent of Completion Pie chart");
        setResizable(false);
        setBounds(100, 100, 750, 500);


        Platform.setImplicitExit(false);
        //calling JavaFx
        Platform.runLater(this::createScene);


    }


    private void createScene() {
        PieChart chart = createPieChart();

        //adding animation
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), chart);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        chartFxPanel.setScene(new Scene(chart));
    }

    private PieChart createPieChart() {

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        //percentageOfCompletion vector comes from percentage Of Completion table data model.
        //model : {"Name", "Symbol", "Total atoms", "Atomic mass", "Percentage"};
        for (Vector<String> eachElement : percentageOfCompletion) {
            pieData.add(new PieChart.Data(eachElement.get(0) + " ( " + eachElement.get(4) + "% )",
                    Double.parseDouble(eachElement.get(4))));
        }
        return new PieChart(pieData);

    }

}
