package ChemistryCalculator.frontend;

import ChemistryCalculator.backend.Atom;
import ChemistryCalculator.backend.Compound;
import ChemistryCalculator.backend.InvalidAtomException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class MolarMassPanel extends JPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", 1,  14);
    private static final Color MAIN_COLOR = new Color(64, 43,  100);
    private static final Color GRAY = new Color(204, 204,  204);

    private final JLabel labelForCompoundTextfield = new JLabel();
    private final JTextField compoundTextfield = new JTextField();

    private final JButton getMolarMassButton = new JButton();
    private final JButton clearButton = new JButton();

    private final JLabel errorMessageLabel = new JLabel();
    private final JPanel errorMessagePanel= new JPanel();

    private final JLabel additionalText1 = new JLabel();
    private final JLabel additionalText2 = new JLabel();
    private final JLabel additionalText3 = new JLabel();

    private final JLabel compoundAnsLabel = new JLabel();
    private final JLabel massAnsLabel = new JLabel();

    private final JTable ansTable = new JTable();
    private DefaultTableModel dataTableModel;
    private final JScrollPane ansTableScrollPane = new JScrollPane();



    public MolarMassPanel() {
        initComponent();
        setComponentLayout();
    }

    private void  initComponent() {

        labelForCompoundTextfield.setFont(SEGOE_UI);
        labelForCompoundTextfield.setForeground(MAIN_COLOR);
        labelForCompoundTextfield.setText("Enter Compound :");

        ansTable.setBackground(MAIN_COLOR);
        ansTable.setBorder(BorderFactory.createEtchedBorder());
        ansTable.setFont(SEGOE_UI);
        ansTable.setForeground(GRAY);
        dataTableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ) {
            Class[] types = new Class[]{
                    String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        ansTable.setModel(dataTableModel);
        ansTable.setRowHeight(50);
        ansTableScrollPane.setViewportView(ansTable);
        ansTableScrollPane.setVisible(false);

        getMolarMassButton.setBackground(MAIN_COLOR);
        getMolarMassButton.setFont(SEGOE_UI);
        getMolarMassButton.setForeground(GRAY);
        getMolarMassButton.setText("Get Molar mass");
        getMolarMassButton.setAutoscrolls(true);
        getMolarMassButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getMolarMassButton.addActionListener(this::molarMassButtonActionPerformed);

        additionalText1.setFont(SEGOE_UI);
        additionalText1.setForeground(MAIN_COLOR);
        additionalText1.setText("Molar mass of given compound ");
        additionalText1.setVisible(false);

        errorMessagePanel.setBackground(Color.red);
        errorMessagePanel.setVisible(false);

        errorMessageLabel.setBackground(Color.red);
        errorMessageLabel.setFont(SEGOE_UI);
        errorMessageLabel.setForeground(Color.white);
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clearButton.setBackground(MAIN_COLOR);
        clearButton.setFont(SEGOE_UI);
        clearButton.setForeground(GRAY);
        clearButton.setText("Clear");
        clearButton.setAutoscrolls(true);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this::molerMassClearButtonActionPerformed);

        compoundAnsLabel.setFont(SEGOE_UI);
        compoundAnsLabel.setForeground(new Color(0, 102, 102));
        compoundAnsLabel.setVisible(false);

        massAnsLabel.setFont(SEGOE_UI);
        massAnsLabel.setForeground(new Color(0, 102, 102));
        massAnsLabel.setVisible(false);

        additionalText2.setFont(SEGOE_UI);
        additionalText2.setForeground(MAIN_COLOR);
        additionalText2.setText("is");
        additionalText2.setVisible(false);

        additionalText3.setFont(SEGOE_UI);
        additionalText3.setForeground(MAIN_COLOR);
        additionalText3.setText("gram. Details are given below. ");
        additionalText3.setVisible(false);
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

        //Main panel layout
        GroupLayout Layout = new GroupLayout(this);
        this.setLayout(Layout);
        Layout.setHorizontalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout.createSequentialGroup()
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(ansTableScrollPane, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
                                        .addGroup(Layout.createSequentialGroup()
                                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(Layout.createSequentialGroup()
                                                                .addGap(40, 40, 40)
                                                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(Layout.createSequentialGroup()
                                                                                .addComponent(getMolarMassButton)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(clearButton))
                                                                        .addGroup(Layout.createSequentialGroup()
                                                                                .addComponent(labelForCompoundTextfield)
                                                                                .addGap(26, 26, 26)
                                                                                .addComponent(compoundTextfield, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(additionalText1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(compoundAnsLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(additionalText2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(massAnsLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(additionalText3)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        Layout.setVerticalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(compoundTextfield, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelForCompoundTextfield, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(getMolarMassButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(additionalText1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(compoundAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(additionalText2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(massAnsLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(additionalText3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ansTableScrollPane, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
        );
    }
    private void molarMassButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String compoundText = compoundTextfield.getText();
        if (!compoundText.isEmpty()) {
            Compound compound;
            try {
                compound = new Compound(compoundText);

            } catch (InvalidAtomException e) {
                errorMessagePanel.setVisible(true);
                errorMessageLabel.setText(e.getMessage());

                additionalText1.setVisible(false);
                compoundAnsLabel.setVisible(false);
                additionalText2.setVisible(false);
                massAnsLabel.setVisible(false);
                additionalText3.setVisible(false);
                ansTableScrollPane.setVisible(false);
                return;
            }


            Atom[] atomList = compound.getAtomList();
            String[] tableHeader = new String[]{"Name", "Atomic mass"};
            String[][] tableRow = Arrays.stream(atomList).map(atom -> new String[]{atom.getName(), String.valueOf(atom.getAtomicMass())}).toArray(String[][]::new);
            dataTableModel.setDataVector(tableRow, tableHeader
            );

            compoundAnsLabel.setText(Formater.formatEquation(compound.getCompound()));
            massAnsLabel.setText(String.format("%.2f", compound.getMolarMass()));

            additionalText1.setVisible(true);
            compoundAnsLabel.setVisible(true);
            additionalText2.setVisible(true);
            massAnsLabel.setVisible(true);
            additionalText3.setVisible(true);
            ansTableScrollPane.setVisible(true);
            errorMessagePanel.setVisible(false);

        } else {
            errorMessagePanel.setVisible(true);
            errorMessageLabel.setText("Please enter a compound.");

            additionalText1.setVisible(false);
            compoundAnsLabel.setVisible(false);
            additionalText2.setVisible(false);
            massAnsLabel.setVisible(false);
            additionalText3.setVisible(false);
            ansTableScrollPane.setVisible(false);
        }
    }

    private void molerMassClearButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        errorMessagePanel.setVisible(false);
        compoundTextfield.setText(null);
        additionalText1.setVisible(false);
        compoundAnsLabel.setVisible(false);
        additionalText2.setVisible(false);
        massAnsLabel.setVisible(false);
        additionalText3.setVisible(false);
        ansTableScrollPane.setVisible(false);

    }
}
