package ChemistryCalculator.frontend;

import ChemistryCalculator.backend.Atom;
import ChemistryCalculator.backend.InvalidAtomException;

import javax.swing.*;
import java.awt.*;

public class ElectronConfigPanel extends JPanel {

    private final JButton getElectronConfigButton = new JButton();
    private final JButton clearButton = new JButton();

    private final JPanel errorMessagePanel = new JPanel();
    private final JLabel errorMessageLabel = new JLabel();

    private final JLabel labelForNumOrSymbolTextfield = new JLabel();
    private final JTextField numOrSymbolTextfield = new JTextField();

    private final JPanel ansPanel = new JPanel();

    private final JLabel labelForAtomicMassAns = new JLabel();
    private final JLabel labelForAtomicNameAns = new JLabel();
    private final JLabel labelForAtomicNumAns = new JLabel();
    private final JLabel labelForElectronConfigAns = new JLabel();

    private final JLabel atomicNumAnsLabel = new JLabel();
    private final JLabel atomicNameAnsLabel = new JLabel();
    private final JLabel massOfAtomAnsLabel = new JLabel();
    private final JLabel ElectronConfigAnsLabel = new JLabel();

    public ElectronConfigPanel() {
        initComponent();
        setComponentLayout();
    }

    private void initComponent() {
        labelForNumOrSymbolTextfield.setFont(new Font("Segoe UI", 1, 14));
        labelForNumOrSymbolTextfield.setForeground(new Color(64, 43, 100));
        labelForNumOrSymbolTextfield.setText("Enter Atomic Number or Symbol :");

        getElectronConfigButton.setBackground(new Color(64, 43, 100));
        getElectronConfigButton.setFont(new Font("Segoe UI", 1, 14));
        getElectronConfigButton.setForeground(new Color(204, 204, 204));
        getElectronConfigButton.setText("Get Config.");
        getElectronConfigButton.setAutoscrolls(true);
        getElectronConfigButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getElectronConfigButton.addActionListener(this::getElectronConfigButtonActionPerformed);

        ansPanel.setBackground(new Color(85, 65, 118));
        ansPanel.setBorder(BorderFactory.createEtchedBorder());
        ansPanel.setVisible(false);

        labelForAtomicMassAns.setFont(new Font("Segoe UI", 1, 14));
        labelForAtomicMassAns.setForeground(new Color(204, 204, 204));
        labelForAtomicMassAns.setText("Atomic Mass :");

        labelForAtomicNameAns.setFont(new Font("Segoe UI", 1, 14));
        labelForAtomicNameAns.setForeground(new Color(204, 204, 204));
        labelForAtomicNameAns.setText("Atom Name :");

        labelForAtomicNumAns.setFont(new Font("Segoe UI", 1, 14));
        labelForAtomicNumAns.setForeground(new Color(204, 204, 204));
        labelForAtomicNumAns.setText("Atomic Number :");

        labelForElectronConfigAns.setFont(new Font("Segoe UI", 1, 14));
        labelForElectronConfigAns.setForeground(new Color(204, 204, 204));
        labelForElectronConfigAns.setText("Electron Config :");

        atomicNumAnsLabel.setFont(new Font("Segoe UI", 1, 14));
        atomicNumAnsLabel.setForeground(new Color(255, 255, 255));

        atomicNameAnsLabel.setFont(new Font("Segoe UI", 1, 14));
        atomicNameAnsLabel.setForeground(new Color(255, 255, 255));

        ElectronConfigAnsLabel.setFont(new Font("Segoe UI", 1, 14));
        ElectronConfigAnsLabel.setForeground(new Color(255, 255, 255));

        massOfAtomAnsLabel.setFont(new Font("Segoe UI", 1, 14));
        massOfAtomAnsLabel.setForeground(new Color(255, 255, 255));


        errorMessagePanel.setBackground(new Color(255, 0, 0));
        errorMessagePanel.setVisible(false);

        errorMessageLabel.setBackground(new Color(255, 0, 0));
        errorMessageLabel.setFont(new Font("Segoe UI", 1, 14));
        errorMessageLabel.setForeground(new Color(255, 255, 255));
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);


        clearButton.setBackground(new Color(64, 43, 100));
        clearButton.setFont(new Font("Segoe UI", 1, 14));
        clearButton.setForeground(new Color(204, 204, 204));
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
                                        .addComponent(labelForAtomicMassAns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelForAtomicNumAns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelForAtomicNameAns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelForElectronConfigAns, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(ElectronConfigAnsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(atomicNameAnsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(atomicNumAnsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(massOfAtomAnsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        ansPanelLayout.setVerticalGroup(
                ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ansPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelForAtomicNameAns, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(atomicNameAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForAtomicNumAns, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(atomicNumAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForAtomicMassAns, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(massOfAtomAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelForElectronConfigAns, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ElectronConfigAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(32, Short.MAX_VALUE))
        );


        //Main panel layout
        GroupLayout Layout = new GroupLayout(this);
        this.setLayout(Layout);
        Layout.setHorizontalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout.createSequentialGroup()
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(ansPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(Layout.createSequentialGroup()
                                                                .addComponent(getElectronConfigButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(clearButton))
                                                        .addGroup(Layout.createSequentialGroup()
                                                                .addComponent(labelForNumOrSymbolTextfield)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(numOrSymbolTextfield, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 83, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        Layout.setVerticalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelForNumOrSymbolTextfield, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numOrSymbolTextfield, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(getElectronConfigButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                                .addComponent(ansPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    private void getElectronConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String atom_text = numOrSymbolTextfield.getText();

        if (!atom_text.isEmpty()) {
            Atom atom;
            try {
                int atomicNumber = Integer.parseInt(atom_text);
                try {
                    atom = Atom.getInstance(atomicNumber);

                    atomicNameAnsLabel.setText(atom.getName());
                    massOfAtomAnsLabel.setText(String.valueOf(atom.getAtomicMass()));
                    labelForAtomicNumAns.setText("Atomic symbol :");
                    atomicNumAnsLabel.setText(String.valueOf(atom.getSymbol()));
                    ElectronConfigAnsLabel.setText(atom.getElectronConfig());
                    ansPanel.setVisible(true);

                    errorMessagePanel.setVisible(false);


                } catch (InvalidAtomException e) {
                    errorMessageLabel.setText(e.getMessage());
                    errorMessagePanel.setVisible(true);
                    ansPanel.setVisible(false);

                }


            } catch (NumberFormatException e) {
                try {
                    atom = Atom.getInstance(atom_text);
                    atomicNameAnsLabel.setText(atom.getName());
                    massOfAtomAnsLabel.setText(String.valueOf(atom.getAtomicMass()));
                    labelForAtomicNumAns.setText("Atomic Number :");
                    atomicNumAnsLabel.setText(String.valueOf(atom.getAtomicNumber()));
                    ElectronConfigAnsLabel.setText(atom.getElectronConfig());
                    ansPanel.setVisible(true);

                    errorMessagePanel.setVisible(false);
                } catch (InvalidAtomException invalidAtomException) {
                    errorMessageLabel.setText(invalidAtomException.getMessage());
                    errorMessagePanel.setVisible(true);
                    ansPanel.setVisible(false);
                }

            }


        } else {
            errorMessageLabel.setText("Enter atom's symbol or atomic number!");
            errorMessagePanel.setVisible(true);
            ansPanel.setVisible(false);
        }
    }


    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ansPanel.setVisible(false);
        errorMessagePanel.setVisible(false);
        numOrSymbolTextfield.setText(null);
    }
}
