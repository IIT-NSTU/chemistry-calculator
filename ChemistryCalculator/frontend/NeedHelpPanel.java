package ChemistryCalculator.frontend;

import javax.swing.*;
import java.awt.*;

public class NeedHelpPanel extends JPanel {

    private final JPanel contentHolderPanel = new JPanel();
    private final JScrollPane contentHolderScrollPane = new JScrollPane();

    private final JLabel eqBalanceDesLabel =  new JLabel();
    private final JLabel eqBalanceHeaderLabel =  new JLabel();
    private final JSeparator eqBalanceSeparator =  new JSeparator();

    private final JLabel concentrationHeaderLabel =  new JLabel();
    private final JLabel concentrationDesLabel =  new JLabel();
    private final JSeparator concentrationSeparator = new JSeparator();

    private final JLabel mlrMass_elConfig_pOfComDes =  new JLabel();
    private final JLabel mlrMass_elConfig_pOfComDesHeader =  new JLabel();
    private final JSeparator mlrMass_elConfig_pOfComSeparator =  new JSeparator();

    private final JLabel titrationDesLabel =  new JLabel();
    private final JLabel titrationHeaderLabel =  new JLabel();
    private final JSeparator titrationSeparator =  new JSeparator();



    public NeedHelpPanel() {
        initComponent();
        setComponentLayout();
    }

    private void initComponent() {

        contentHolderScrollPane.setBorder(null);
        contentHolderScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentHolderScrollPane.setPreferredSize(new Dimension(787, 634));

        eqBalanceHeaderLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        eqBalanceHeaderLabel.setForeground(new Color(64, 43, 100));
        eqBalanceHeaderLabel.setIcon(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_document_header_30px_1.png"))); // NOI18N
        eqBalanceHeaderLabel.setText("Equation Balancer : ");

        eqBalanceDesLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        eqBalanceDesLabel.setForeground(new Color(102, 102, 102));
        eqBalanceDesLabel.setText("<html>\n1. Enter an equation of a chemical reaction and click 'Balance'.The answer will appear below.\n<br/>\n2. Always use the upper case for the first character in the element name and the lower case for the second character.\n<br/><br/>\n<pre>\n\tExamples:  Fe, Au, Co, Br, C, O, N, F.\n\tCompare: Co - cobalt and CO - carbon monoxide.\n</pre>\n<br/><br/>\n3. Compound states [like (s) (aq) or (g)] are not required.\n<br/>\n4. Both Reactants and Products fields are required.\n<br/>\n5. There's support 3 pattern of equation. Such as --\n<pre>\n\n\ti.   H2 + O2 = H2O\n\tii.  Zn + AgNO3 = Zn(NO3)2 +  Ag\n\tiii. CaHPO4*2H2O + NaOH + H2O = Na2HPO4*12H2O + Ca(OH)2 \n</pre>\n</html>");

        concentrationHeaderLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        concentrationHeaderLabel.setForeground(new Color(64, 43, 100));
        concentrationHeaderLabel.setIcon(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_document_header_30px_1.png"))); // NOI18N
        concentrationHeaderLabel.setText("Concentration : ");

        mlrMass_elConfig_pOfComDes.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        mlrMass_elConfig_pOfComDes.setForeground(new Color(102, 102, 102));
        mlrMass_elConfig_pOfComDes.setText("<html> 1.The description of the compound pattern is similar to the description of the equation balance section. <br/> 2.Click the corresponding button to get the result. </html>");

        mlrMass_elConfig_pOfComDesHeader.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        mlrMass_elConfig_pOfComDesHeader.setForeground(new Color(64, 43, 100));
        mlrMass_elConfig_pOfComDesHeader.setIcon(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_document_header_30px_1.png"))); // NOI18N
        mlrMass_elConfig_pOfComDesHeader.setText("Molar mass, Electron config & Percent of completion: ");

        concentrationDesLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        concentrationDesLabel.setForeground(new Color(102, 102, 102));
        concentrationDesLabel.setText("<html> 1. Compound , compound's mass, volume of solution these 3 fields are required. \n <br/> 2. Equivalent number is required only for Normality. If you check Molarity and Molality in the format then this field should be blank. <br/> 3. Compound states [like (s) (aq) or (g)] are not required.\n <br/> 4. Click 'Get Concentration' button. The result will appear below.\n</html>");

        titrationDesLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        titrationDesLabel.setForeground(new Color(102, 102, 102));
        titrationDesLabel.setText("<html> 1.The description of the compound pattern is similar to the description of the equation balance section. <br/> 2.The Number of moles of acid and base denotes the number of moles of acid or base that are required to neutralize each other.  For example --\n<pre>\t\n\n\tBalanced Equation : <u>1</u> Ba(OH)2  +  <u>2</u> HNO3 = 1 Ba(NO3)2  +  2 H2O\n\n\tHere,   \n\t        The Number of moles of acid = 2\n\t        The Number of moles of base = 1\n</pre>\n </html>");

        titrationHeaderLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        titrationHeaderLabel.setForeground(new Color(64, 43, 100));
        titrationHeaderLabel.setIcon(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_document_header_30px_1.png"))); // NOI18N
        titrationHeaderLabel.setText("Titration: ");

        contentHolderScrollPane.setViewportView(contentHolderPanel);

    }

    private void setComponentLayout() {
        //adding all elements to the contentHolderPanel
        GroupLayout contentHolderPanelLayout = new GroupLayout(contentHolderPanel);
        contentHolderPanel.setLayout(contentHolderPanelLayout);
        contentHolderPanelLayout.setHorizontalGroup(
                contentHolderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(contentHolderPanelLayout.createSequentialGroup()
                                .addGroup(contentHolderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(contentHolderPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(contentHolderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(contentHolderPanelLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(eqBalanceDesLabel, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(eqBalanceSeparator, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eqBalanceHeaderLabel)))
                                        .addGroup(contentHolderPanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(contentHolderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(concentrationHeaderLabel)
                                                        .addComponent(concentrationSeparator, GroupLayout.PREFERRED_SIZE, 754, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mlrMass_elConfig_pOfComDesHeader)
                                                        .addComponent(mlrMass_elConfig_pOfComSeparator, GroupLayout.PREFERRED_SIZE, 754, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(titrationHeaderLabel)
                                                        .addComponent(titrationSeparator, GroupLayout.PREFERRED_SIZE, 754, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentHolderPanelLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addGroup(contentHolderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(concentrationDesLabel, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(mlrMass_elConfig_pOfComDes, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(titrationDesLabel, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        contentHolderPanelLayout.setVerticalGroup(
                contentHolderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(contentHolderPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(eqBalanceHeaderLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eqBalanceSeparator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eqBalanceDesLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(concentrationHeaderLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(concentrationSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(concentrationDesLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mlrMass_elConfig_pOfComDesHeader, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mlrMass_elConfig_pOfComSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mlrMass_elConfig_pOfComDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(titrationHeaderLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titrationSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titrationDesLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(163, Short.MAX_VALUE))
        );

        //main Layout
        GroupLayout Layout = new GroupLayout(this);
        this.setLayout(Layout);
        Layout.setHorizontalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 838, Short.MAX_VALUE)
                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(contentHolderScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Layout.setVerticalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 634, Short.MAX_VALUE)
                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(contentHolderScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
    }
}
