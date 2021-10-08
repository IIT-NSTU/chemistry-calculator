package ChemistryCalculator.frontend;

import ChemistryCalculator.backend.Compound;
import ChemistryCalculator.backend.Concentration;
import ChemistryCalculator.backend.Converter;
import ChemistryCalculator.backend.InvalidAtomException;

import javax.swing.*;
import java.awt.*;

public class ConcentrationPanel extends JPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", 1, 14);
    private static final Color MAIN_COLOR = new Color(64, 43, 100);
    private static final Color MAIN_COLOR_LITE = new Color(85, 65, 118);
    private static final Color GRAY = new Color(204, 204, 204);


    private final JPanel errorMessagePanel = new JPanel();
    private final JLabel errorMessageLabel = new JLabel();

    private final JLabel labelForCompoundTextfield = new JLabel();
    private final JTextField compoundTextfield = new JTextField();

    private final JLabel labelForMassTextfield = new JLabel();
    private final JTextField massTextfield = new JTextField();
    private final JComboBox<String> massUnitComboBox = new JComboBox<>();

    private final JLabel labelForVolumeTextfield = new JLabel();
    private final JTextField volumeTextfield = new JTextField();
    private final JComboBox<String> volumeUnitComboBox = new JComboBox<>();

    private final JLabel labelForEquivalentNumTextfield = new JLabel();
    private final JTextField equivalentNumTextfield = new JTextField();

    private final JButton getConcentrationButton = new JButton();
    private final JButton clearButton = new JButton();

    private final JLabel formatLabel = new JLabel();
    private final JCheckBox molarityCheckBox = new JCheckBox();
    private final JCheckBox molalityCheckBox = new JCheckBox();
    private final JCheckBox normalityCheckBox = new JCheckBox();


    private final JPanel ansPanel = new JPanel();

    private final JLabel labelForNormalityAns = new JLabel();
    private final JLabel labelForMolalityAns = new JLabel();
    private final JLabel labelForMolarityAns = new JLabel();
    private final JLabel molalityAnsLabel = new JLabel();
    private final JLabel normalityAnsLabel = new JLabel();
    private final JLabel molarityAnsLabel = new JLabel();


    public ConcentrationPanel() {
        initComponent();
        setComponentLayout();
    }

    private void initComponent() {
        errorMessagePanel.setBackground(Color.red);
        errorMessagePanel.setVisible(false);

        errorMessageLabel.setFont(SEGOE_UI);
        errorMessageLabel.setForeground(Color.white);
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        labelForCompoundTextfield.setFont(SEGOE_UI);
        labelForCompoundTextfield.setForeground(MAIN_COLOR);
        labelForCompoundTextfield.setText("Compound  :");

        labelForMassTextfield.setFont(SEGOE_UI);
        labelForMassTextfield.setForeground(MAIN_COLOR);
        labelForMassTextfield.setText("Compound's mass  :");

        massUnitComboBox.setFont(SEGOE_UI);
        massUnitComboBox.setForeground(MAIN_COLOR);
        massUnitComboBox.setModel(new DefaultComboBoxModel<>(
                new String[]{
                        "kilogram",
                        "gram",
                        "milligram",
                        "pound",
                }
        ));
        massUnitComboBox.setSelectedIndex(2);

        labelForVolumeTextfield.setFont(SEGOE_UI);
        labelForVolumeTextfield.setForeground(MAIN_COLOR);
        labelForVolumeTextfield.setText("Volume of solution  :");

        labelForEquivalentNumTextfield.setFont(SEGOE_UI);
        labelForEquivalentNumTextfield.setForeground(MAIN_COLOR);
        labelForEquivalentNumTextfield.setText("Equivalent Number  :");

        equivalentNumTextfield.setEnabled(false);

        volumeUnitComboBox.setFont(SEGOE_UI);
        volumeUnitComboBox.setForeground(MAIN_COLOR);
        volumeUnitComboBox.setModel(new DefaultComboBoxModel<>(
                new String[]{
                        "deciliters",
                        "milliliters",
                        "centiliters",
                        "liters",
                        "cubic_decimeters",
                        "cubic_millimeters",
                        "cubic_centimeters",
                }
        ));
        volumeUnitComboBox.setSelectedIndex(1);


        ansPanel.setBackground(MAIN_COLOR_LITE);
        ansPanel.setVisible(false);
        ansPanel.setBorder(BorderFactory.createEtchedBorder());

        labelForNormalityAns.setFont(SEGOE_UI);
        labelForNormalityAns.setForeground(GRAY);
        labelForNormalityAns.setText("Normality  :");

        labelForMolalityAns.setFont(SEGOE_UI);
        labelForMolalityAns.setForeground(GRAY);
        labelForMolalityAns.setText("Molality   :");

        labelForMolarityAns.setFont(SEGOE_UI);
        labelForMolarityAns.setForeground(GRAY);
        labelForMolarityAns.setText("Molarity   :");

        molalityAnsLabel.setFont(SEGOE_UI);
        molalityAnsLabel.setForeground(Color.white);
        molalityAnsLabel.setText("4.5");

        normalityAnsLabel.setFont(SEGOE_UI);
        normalityAnsLabel.setForeground(Color.white);
        normalityAnsLabel.setText("5.5");


        molarityAnsLabel.setFont(SEGOE_UI);
        molarityAnsLabel.setForeground(Color.white);
        molarityAnsLabel.setText("3.5");

        formatLabel.setFont(SEGOE_UI);
        formatLabel.setForeground(MAIN_COLOR);
        formatLabel.setText("Check format  : ");

        molarityCheckBox.setFont(SEGOE_UI);
        molarityCheckBox.setForeground(MAIN_COLOR);
        molarityCheckBox.setText("Molarity");

        molalityCheckBox.setFont(SEGOE_UI);
        molalityCheckBox.setForeground(MAIN_COLOR);
        molalityCheckBox.setText("Molality");

        normalityCheckBox.setFont(SEGOE_UI);
        normalityCheckBox.setForeground(MAIN_COLOR);
        normalityCheckBox.setText("Normality");
        normalityCheckBox.addActionListener(this::normalityCheckBoxActionPerformed);

        getConcentrationButton.setBackground(MAIN_COLOR);
        getConcentrationButton.setFont(SEGOE_UI);
        getConcentrationButton.setForeground(GRAY);
        getConcentrationButton.setText("Get Concentration");
        getConcentrationButton.setAutoscrolls(true);
        getConcentrationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getConcentrationButton.addActionListener(this::getConcentrationButtonActionPerformed);

        clearButton.setBackground(MAIN_COLOR);
        clearButton.setFont(SEGOE_UI);
        clearButton.setForeground(GRAY);
        clearButton.setText("Clear");
        clearButton.setAutoscrolls(true);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this::clearButtonActionPerformed);
    }

    private void setComponentLayout() {
        //Layout for Error message panel
        GroupLayout errorMessagePanelLayout = new GroupLayout(errorMessagePanel);
        errorMessagePanel.setLayout(errorMessagePanelLayout);
        errorMessagePanelLayout.setHorizontalGroup(
                errorMessagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, errorMessagePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(errorMessageLabel, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE))
        );
        errorMessagePanelLayout.setVerticalGroup(
                errorMessagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(errorMessagePanelLayout.createSequentialGroup()
                                .addComponent(errorMessageLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );



        //Layout for ans Panel.
        GroupLayout ansPanelLayout = new GroupLayout(ansPanel);
        ansPanel.setLayout(ansPanelLayout);
        ansPanelLayout.setHorizontalGroup(
                ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ansPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelForNormalityAns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelForMolalityAns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelForMolarityAns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(molalityAnsLabel, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                                        .addComponent(normalityAnsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(molarityAnsLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ansPanelLayout.setVerticalGroup(
                ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ansPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForMolarityAns, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(molarityAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForMolalityAns, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(molalityAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForNormalityAns, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(normalityAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(32, Short.MAX_VALUE))
        );


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(ansPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(formatLabel)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(molarityCheckBox)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(molalityCheckBox)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(normalityCheckBox))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(getConcentrationButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(clearButton))
                                                        .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelForCompoundTextfield)
                                                        .addComponent(labelForMassTextfield)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelForVolumeTextfield)
                                                                        .addComponent(labelForEquivalentNumTextfield))
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(equivalentNumTextfield, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(compoundTextfield, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(volumeTextfield, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(volumeUnitComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(massTextfield, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(massUnitComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(0, 134, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForCompoundTextfield, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(compoundTextfield, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(massTextfield, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(massUnitComboBox, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(labelForMassTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(volumeTextfield, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(volumeUnitComboBox, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelForVolumeTextfield, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForEquivalentNumTextfield, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(equivalentNumTextfield, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(formatLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(molarityCheckBox)
                                        .addComponent(molalityCheckBox)
                                        .addComponent(normalityCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(getConcentrationButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(ansPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    private void getConcentrationButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String compound_text = compoundTextfield.getText();
        String givenCompoundMass_text = massTextfield.getText();
        String volumeOfSolution_text = volumeTextfield.getText();


        if (compound_text.isEmpty()) {
            errorMessagePanel.setVisible(true);
            errorMessageLabel.setText("Please, enter a compound.");
            ansPanel.setVisible(false);
            return;
        } else if (givenCompoundMass_text.isEmpty()) {
            errorMessagePanel.setVisible(true);
            errorMessageLabel.setText("Please, enter compound mass.");
            ansPanel.setVisible(false);
            return;
        } else if (volumeOfSolution_text.isEmpty()) {
            errorMessagePanel.setVisible(true);
            errorMessageLabel.setText("Please, enter volume of solution.");
            ansPanel.setVisible(false);
            return;
        }
        if (molarityCheckBox.isSelected() || molalityCheckBox.isSelected() || normalityCheckBox.isSelected()) {
            Compound compound;
            double givenCompoundMass;
            double volumeOfSolution;
            String massUnit = massUnitComboBox.getSelectedItem().toString();
            String volumeUnit = volumeUnitComboBox.getSelectedItem().toString();
            try {
                compound = new Compound(compound_text);
                givenCompoundMass = Converter.convert(massUnit, "gram", Double.parseDouble(givenCompoundMass_text));
                volumeOfSolution = Converter.convert(volumeUnit, "milliliters", Double.parseDouble(volumeTextfield.getText()));


            } catch (InvalidAtomException e) {
                errorMessagePanel.setVisible(true);
                errorMessageLabel.setText(e.getMessage());
                ansPanel.setVisible(false);
                return;
            } catch (NumberFormatException e) {
                errorMessagePanel.setVisible(true);
                errorMessageLabel.setText("Mass and volume must be number");
                ansPanel.setVisible(false);
                return;
            }


            Concentration concentration = new Concentration(compound, givenCompoundMass, volumeOfSolution);
            ansPanel.setVisible(true);
            molarityAnsLabel.setText("Not Checked !");
            molalityAnsLabel.setText("Not Checked !");
            normalityAnsLabel.setText("Not Checked !");
            if (molarityCheckBox.isSelected()) {
                errorMessagePanel.setVisible(false);
                molarityAnsLabel.setText(String.format("%.5f M", concentration.getMolarity()));
            }
            if (molalityCheckBox.isSelected()) {
                errorMessagePanel.setVisible(false);
                molalityAnsLabel.setText(String.format("%.5f m", concentration.getMolality()));
            }
            if (normalityCheckBox.isSelected()) {
                if (equivalentNumTextfield.getText().isEmpty()) {
                    errorMessagePanel.setVisible(true);
                    errorMessageLabel.setText("Equivalent Number is required for finding Normality.");
                    ansPanel.setVisible(false);
                    return;
                }
                double equivalentNumber = Double.parseDouble(equivalentNumTextfield.getText());
                errorMessagePanel.setVisible(false);
                normalityAnsLabel.setText(String.format("%.5f N", concentration.geNormality(equivalentNumber)));
            }
        } else {
            errorMessagePanel.setVisible(true);
            errorMessageLabel.setText("Please check at least one format !.");
            ansPanel.setVisible(false);
        }

    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        compoundTextfield.setText(null);
        massTextfield.setText(null);
        volumeTextfield.setText(null);
        equivalentNumTextfield.setText(null);

        molarityCheckBox.setSelected(false);
        molalityCheckBox.setSelected(false);
        normalityCheckBox.setSelected(false);
        equivalentNumTextfield.setEnabled(false);

        errorMessagePanel.setVisible(false);
        ansPanel.setVisible(false);
    }

    private void normalityCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        equivalentNumTextfield.setEnabled(normalityCheckBox.isSelected());
    }

}
