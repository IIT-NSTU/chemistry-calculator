package ChemistryCalculator.frontend;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class HistoryFrame extends JFrame {
    private static final Font SEGOE_UI = new Font("Segoe UI", 1, 14);
    private static final Color MAIN_COLOR = new Color(64, 43, 100);
    private static final Color GRAY = new Color(204, 204, 204);
    
    private final JPanel mainPanel = new JPanel();
    private final JScrollPane mainScrollPane = new JScrollPane();
    private final JTextArea HistoryTextArea = new JTextArea();
    private final JButton clearButton = new JButton();
    private final String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + File.separator
            + "Chemistry Calculator" + File.separator
            + "history.txt";
    

    public HistoryFrame() throws IOException {
        initComponents();
        setComponentLayout();
        collectHistory();
    }

    private void setComponentLayout() {
        //mainpanel Layout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(mainScrollPane, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE)
                                .addGap(20, 20, 20))

        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainScrollPane, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
        );

        //adding ainPanel to the frame
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );
    }


    private void initComponents() throws IOException {
        mainPanel.setBackground(Color.white);
        mainScrollPane.setBorder(null);


        HistoryTextArea.setFont(new Font("Segoe UI", 0, 15));
        HistoryTextArea.setLineWrap(true);

        clearButton.setBackground(MAIN_COLOR);
        clearButton.setFont(SEGOE_UI);
        clearButton.setForeground(GRAY);
        clearButton.setText("Clear History");
        clearButton.setAutoscrolls(true);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(actionEvent -> {
            try {
                clearButtonActionPerformed(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        HistoryTextArea.setWrapStyleWord(true);
        HistoryTextArea.setBorder(null);
        HistoryTextArea.setMargin(new Insets(3, 5, 3, 3));
        mainScrollPane.setViewportView(HistoryTextArea);




        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 900, 500);
        setIconImage(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_biohazard_120px.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equation Balance - History");
    }

    private void clearButtonActionPerformed(ActionEvent actionEvent) throws IOException {
        File file= new File(filePath);
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        HistoryTextArea.setText("");

    }

    public void collectHistory() throws IOException {
        //sorting by date & time
        ArrayList<String> temp =new ArrayList<>();
        Files.lines(Paths.get(filePath)).forEach(line ->temp.add(line));
        if (temp.isEmpty()){
            clearButton.setVisible(false);
            return;
        }
        for(int i=temp.size()-1;i>=0;i--) {
            HistoryTextArea.append(temp.get(i) +"\n");
        }
    }





}
