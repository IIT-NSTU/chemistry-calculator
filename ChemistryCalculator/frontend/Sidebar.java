package ChemistryCalculator.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Sidebar extends JPanel {
    private final JLabel developer_sign_label = new JLabel();
    private final JLabel logoPanel = new JLabel();
    private final JSeparator logoSeparator = new JSeparator();
    private final JScrollPane menuHolderScrollPane = new JScrollPane();
    private final JPanel menuHolder = new JPanel();

    ArrayList<JPanel> menuPanels = new ArrayList<>();
    ArrayList<JLabel> menuLabels = new ArrayList<>();
    ArrayList<JPanel> bodyPanels = new ArrayList<>();


    Color active_menu_color = new Color(255, 255, 153);
    Font active_menu_font = new Font("Segoe UI", 1, 15);
    Color normal_menu_color = new Color(221, 221, 221);
    Font normal_menu_font = new Font("Segoe UI", 1,  14);
    Cursor pointer = new Cursor(Cursor.HAND_CURSOR);


    public void addMenu(String name, ImageIcon icon, JPanel mainPanel) {
        JPanel menuPanel = new JPanel();
        JLabel menuIcon = new JLabel();
        JLabel menuLabel = new JLabel();

        menuPanel.setBackground(new Color(64, 43, 100));
        menuPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                menuMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                menuMouseExited(evt);
            }
        });


        menuIcon.setHorizontalAlignment(SwingConstants.CENTER);
        menuIcon.setIcon(icon);

        menuLabel.setFont(normal_menu_font);
        menuLabel.setForeground(new Color(221, 221, 221));
        menuLabel.setText(name);


        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(menuIcon, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(menuLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menuIcon, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(menuLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        this.menuPanels.add(menuPanel);
        this.bodyPanels.add(mainPanel);
        this.menuLabels.add(menuLabel);
    }

    //after adding all menus, this method must be called to create a sidebar.
    public void build() {
        initComponent();
        setComponentLayout();
    }


    private void initComponent() {
        this.setBackground(new Color(54, 33, 89));
        menuHolderScrollPane.setBorder(null);
        menuHolderScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuHolder.setBackground(new Color(54, 33, 89));
        menuHolderScrollPane.setViewportView(menuHolder);

        logoPanel.setFont(new Font("Segoe UI", 1, 24));
        logoPanel.setForeground(new Color(221, 221, 221));
        logoPanel.setHorizontalAlignment(SwingConstants.CENTER);
        logoPanel.setText("ChemCal");


        developer_sign_label.setFont(new Font("Segoe UI", 1, 12));
        developer_sign_label.setForeground(new Color(221, 221, 221));
        developer_sign_label.setHorizontalAlignment(SwingConstants.CENTER);
        developer_sign_label.setText("Developed by - HumbleFooL");
    }

    private void setComponentLayout() {


        GroupLayout menuHolderLayout = new GroupLayout(menuHolder);
        menuHolder.setLayout(menuHolderLayout);
        GroupLayout.ParallelGroup parallelGroup = menuHolderLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        menuPanels.forEach(eachPanel -> {
            parallelGroup.addComponent(eachPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        });


        menuHolderLayout.setHorizontalGroup(parallelGroup);

        GroupLayout.SequentialGroup sequentialGroup = menuHolderLayout.createSequentialGroup();

        menuPanels.forEach(eachPanel -> {
            sequentialGroup.addComponent(eachPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0);
        });

        menuHolderLayout.setVerticalGroup(
                menuHolderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sequentialGroup)
        );


        //main layout
        GroupLayout sidebar_panelLayout = new GroupLayout(this);
        this.setLayout(sidebar_panelLayout);
        sidebar_panelLayout.setHorizontalGroup(
                sidebar_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(developer_sign_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuHolderScrollPane)
                        .addGroup(sidebar_panelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(sidebar_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(logoPanel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logoSeparator, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE))

        );
        sidebar_panelLayout.setVerticalGroup(
                sidebar_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebar_panelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(logoPanel)
                                .addGap(18, 18, 18)
                                .addComponent(logoSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(menuHolderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(developer_sign_label, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        );

    }

    private void menuMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
        //when a certain menu is clicked , corresponding bodyPanel will be visible.
        IntStream.range(0, menuPanels.size()).forEach(i -> {
            if (evt.getSource().equals(menuPanels.get(i))) {
                bodyPanels.get(i).setVisible(true);
                menuLabels.get(i).setForeground(active_menu_color);
                menuLabels.get(i).setFont(active_menu_font);

            } else {
                bodyPanels.get(i).setVisible(false);
                menuLabels.get(i).setForeground(normal_menu_color);
                menuLabels.get(i).setFont(normal_menu_font);
            }
        });


    }

    private void menuMouseEntered(MouseEvent evt) {
        // TODO add your handling code here:
        JPanel getPanel = (JPanel) evt.getSource();
        getPanel.setBackground(new Color(85, 65, 118));
        getPanel.setCursor(pointer);
    }

    private void menuMouseExited(MouseEvent evt) {
        // TODO add your handling code here:
        JPanel getPanel = (JPanel) evt.getSource();
        getPanel.setBackground(new Color(64, 43, 100));

    }
}
