package ChemistryCalculator.frontend;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    private final JPanel backgroundPanel = new JPanel();
    private final JPanel bodyPanel = new JPanel();
    private final Sidebar sidebarPanel = new Sidebar();


    //body panels
    private final JPanel equationBalancePanel = new EquationBalancePanel();
    private final JPanel concentrationPanel = new ConcentrationPanel();
    private final JPanel molarMassPanel = new MolarMassPanel();
    private final JPanel electronConfigPanel = new ElectronConfigPanel();
    private final JPanel needHelpPanel = new NeedHelpPanel();
    private final JPanel percentOfCompletionPanel = new PercentOfCompletionPanel();
    private final JPanel titrationPanel = new TitrationPanel();


    public Home() {
        buildSidebar();
        buildBodyPanels();
        buildBackgroundPanel();
        setFrameProperty();
    }

    public static void main(String[] args) {
        // Set the Nimbus look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the form
        EventQueue.invokeLater(() -> new Home().setVisible(true));
    }

    private void buildBackgroundPanel() {
        //attaching body panel and sidebar panel to the background panel

        GroupLayout backgroundPanelLayout = new GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
                backgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addComponent(sidebarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sidebarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void buildBodyPanels() {
        //adding all body panels to a single panel (bodyPanel)

        bodyPanel.setLayout(new CardLayout());

        bodyPanel.add(equationBalancePanel);
        bodyPanel.add(concentrationPanel);
        bodyPanel.add(molarMassPanel);
        bodyPanel.add(electronConfigPanel);
        bodyPanel.add(titrationPanel);
        bodyPanel.add(needHelpPanel);
        bodyPanel.add(percentOfCompletionPanel);
    }

    private void buildSidebar() {
        // creating sidebar. Every single body panel should have a single menu bar for navigation. Don't creates duplicates.

        sidebarPanel.addMenu(
                "Equation Balance",
                new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_scales_25px_1.png")),
                equationBalancePanel
        );
        sidebarPanel.addMenu(
                "Concentration",
                new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_dna_helix_25px.png")),
                concentrationPanel
        );
        sidebarPanel.addMenu(
                "Electron config",
                new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_physics_25px.png")),
                electronConfigPanel
        );
        sidebarPanel.addMenu(
                "Molar mass",
                new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_weightlifting_25px.png")),
                molarMassPanel
        );
        sidebarPanel.addMenu(
                "Percent of completion",
                new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_percentage_25px.png")),
                percentOfCompletionPanel
        );
        sidebarPanel.addMenu(
                "Titration",
                new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_test_tube_25px.png")),
                titrationPanel
        );
        sidebarPanel.addMenu(
                "Need help ?",
                new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_inquiry_25px_1.png")),
                needHelpPanel
        );


        sidebarPanel.build();
    }

    private void setFrameProperty() {
        //attaching background Panel to the main ContentPane.

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        //setting frame properties

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chemistry Calculator");
        setAlwaysOnTop(true);
        setIconImage(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_biohazard_120px.png")).getImage());
        setLocationByPlatform(true);
        setResizable(false);
        setAlwaysOnTop(false);
        pack();
        setLocationRelativeTo(null);
    }

}
