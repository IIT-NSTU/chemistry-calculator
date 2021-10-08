package ChemistryCalculator.frontend;

import ChemistryCalculator.backend.EquationBalancer;
import ChemistryCalculator.backend.History;
import ChemistryCalculator.backend.InvalidAtomException;
import ChemistryCalculator.backend.InvalidEquationException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EquationBalancePanel extends JPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", 1, 14);
    private static final Color MAIN_COLOR = new Color(64, 43, 100);
    private static final Color MAIN_COLOR_LITE = new Color(85, 65, 118);
    private static final Color GRAY = new Color(204, 204, 204);

    private final JLabel labelForReactantsTextfield = new JLabel();
    private final JTextField reactantsTextfield = new JTextField();
    private final JLabel labelForProductsTextfield = new JLabel();
    private final JTextField productsTextfield = new JTextField();

    private final JButton balanceButton = new JButton();
    private final JButton historyButton = new JButton();
    private final JButton clearButton = new JButton();

    private final JPanel errorMessagePanel = new JPanel();
    private final JLabel errorMessageLabel = new JLabel();

    private final JPanel ansPanel = new JPanel();
    private final JLabel labelForBalancedEquation = new JLabel();
    private final JLabel balancedEquationLabel = new JLabel();
    private final JScrollPane balancedEquationScrollPane = new JScrollPane();
    private final JLabel labelForGivenEquation = new JLabel();
    private final JLabel givenEquationLabel = new JLabel();
    private final JScrollPane givenEquationScrollPane = new JScrollPane();


    public EquationBalancePanel() {
        initComponent();
        setComponentLayout();
    }

    private void initComponent() {

        labelForReactantsTextfield.setFont(SEGOE_UI);
        labelForReactantsTextfield.setForeground(MAIN_COLOR);
        labelForReactantsTextfield.setText("Reactants : ");


        labelForProductsTextfield.setFont(SEGOE_UI);
        labelForProductsTextfield.setForeground(MAIN_COLOR);
        labelForProductsTextfield.setText("Products  :");

        errorMessagePanel.setBackground(Color.red);
        errorMessagePanel.setVisible(false);

        errorMessageLabel.setFont(SEGOE_UI);
        errorMessageLabel.setForeground(Color.white);
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        balanceButton.setBackground(MAIN_COLOR);
        balanceButton.setFont(SEGOE_UI);
        balanceButton.setForeground(GRAY);
        balanceButton.setText("Balance");
        balanceButton.setAutoscrolls(true);
        balanceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        balanceButton.addActionListener(this::balanceButtonActionPerformed);

        historyButton.setBackground(MAIN_COLOR);
        historyButton.setFont(SEGOE_UI);
        historyButton.setForeground(GRAY);
        historyButton.setText("History");
        historyButton.setAutoscrolls(true);
        historyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        historyButton.addActionListener(this::historyButtonActionPerformed);

        clearButton.setBackground(MAIN_COLOR);
        clearButton.setFont(SEGOE_UI); // NOI18N
        clearButton.setForeground(GRAY);
        clearButton.setText("Clear");
        clearButton.setAutoscrolls(true);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this::clearButtonActionPerformed);

        ansPanel.setBackground(MAIN_COLOR_LITE);
        ansPanel.setVisible(false);

        labelForBalancedEquation.setFont(SEGOE_UI); // NOI18N
        labelForBalancedEquation.setForeground(GRAY);
        labelForBalancedEquation.setText("Balanced Equation :");

        labelForGivenEquation.setFont(SEGOE_UI); // NOI18N
        labelForGivenEquation.setForeground(GRAY);
        labelForGivenEquation.setText("Given Equation :");

        balancedEquationScrollPane.setBackground(MAIN_COLOR_LITE);
        balancedEquationScrollPane.setBorder(null);
        balancedEquationScrollPane.setForeground(MAIN_COLOR_LITE);
        balancedEquationScrollPane.setAutoscrolls(true);

        balancedEquationLabel.setBackground(MAIN_COLOR_LITE);
        balancedEquationLabel.setFont(SEGOE_UI); // NOI18N
        balancedEquationLabel.setForeground(Color.white);
        balancedEquationLabel.setOpaque(true);
        balancedEquationScrollPane.setViewportView(balancedEquationLabel);

        givenEquationScrollPane.setBackground(MAIN_COLOR_LITE);
        givenEquationScrollPane.setBorder(null);
        givenEquationScrollPane.setForeground(MAIN_COLOR_LITE);
        givenEquationScrollPane.setAutoscrolls(true);

        givenEquationLabel.setBackground(MAIN_COLOR_LITE);
        givenEquationLabel.setFont(SEGOE_UI); // NOI18N
        givenEquationLabel.setForeground(Color.white);
        givenEquationLabel.setOpaque(true);
        givenEquationScrollPane.setViewportView(givenEquationLabel);


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
                                .addContainerGap()
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(ansPanelLayout.createSequentialGroup()
                                                .addComponent(labelForBalancedEquation)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(balancedEquationScrollPane))
                                        .addGroup(ansPanelLayout.createSequentialGroup()
                                                .addComponent(labelForGivenEquation)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(givenEquationScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addGap(20, 20, 20))
        );
        ansPanelLayout.setVerticalGroup(
                ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ansPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelForGivenEquation, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(givenEquationScrollPane))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelForBalancedEquation, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addComponent(balancedEquationScrollPane))
                                .addContainerGap())
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
                                                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(Layout.createSequentialGroup()
                                                                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(labelForReactantsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(labelForProductsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(reactantsTextfield, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                                                                                .addComponent(productsTextfield))))
                                                        .addGroup(Layout.createSequentialGroup()
                                                                .addComponent(balanceButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 134, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        Layout.setVerticalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(reactantsTextfield, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                        .addComponent(labelForReactantsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(productsTextfield, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(labelForProductsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(balanceButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                .addComponent(ansPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }



    private void balanceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String reactants = reactantsTextfield.getText();
        String products = productsTextfield.getText();
        if (!reactants.isEmpty() || !products.isEmpty()) {
            String balancedEquation;
            EquationBalancer balancer = new EquationBalancer(reactants, products);

            try {
                balancedEquation = balancer.balance();
                errorMessagePanel.setVisible(false);
                givenEquationLabel.setText(Formater.formatEquation(reactants) + " = " + Formater.formatEquation(products));
                balancedEquationLabel.setText(Formater.formatEquation(balancedEquation));
                ansPanel.setVisible(true);

                new History() {
                }.add(balancedEquation);

            } catch (InvalidAtomException | InvalidEquationException | FileNotFoundException e) {
                errorMessageLabel.setText(e.getMessage());
                errorMessagePanel.setVisible(true);
                ansPanel.setVisible(false);
            }
        } else {
            errorMessageLabel.setText("Both fields are required !");
            errorMessagePanel.setVisible(true);
            ansPanel.setVisible(false);
        }

    }


    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        HistoryFrame history;
        try {
            history = new HistoryFrame();

        } catch (IOException e) {
            errorMessageLabel.setText("History panel is empty");
            errorMessagePanel.setVisible(true);
            ansPanel.setVisible(false);
            return;
        }

        history.toFront();
        history.requestFocus();
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        reactantsTextfield.setText(null);
        productsTextfield.setText(null);
        errorMessagePanel.setVisible(false);
        ansPanel.setVisible(false);

    }

}
