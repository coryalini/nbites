/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbtool.gui;

import java.nio.file.Path;

import nbtool.data.ViewProfile;
import nbtool.data.log.LogSorting;
import nbtool.util.Debug;

/**
 *
 * @author pkoch
 */
public class ToolDisplay extends javax.swing.JFrame {

    /**
     * Creates new form ToolDisplay
     */
    public ToolDisplay() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        topLevelSplit = new javax.swing.JSplitPane();
        leftSideTabs = new javax.swing.JTabbedPane();
        utilitiesTab = new javax.swing.JPanel();
        optionsPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        debugLevelBox = new javax.swing.JComboBox<>();
        viewProfileBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        utilityScrollPane = new javax.swing.JScrollPane();
        controlTab = new javax.swing.JPanel();
        loadPane = new javax.swing.JPanel();
        pathBox = new javax.swing.JComboBox<>();
        selectButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        robotPane = new javax.swing.JPanel();
        robotAddressBox = new javax.swing.JComboBox<>();
        streamComboBox = new javax.swing.JComboBox<>();
        connectButton = new javax.swing.JButton();
        keepSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        rpcScrollPane = new javax.swing.JScrollPane();
        logTab = new javax.swing.JPanel();
        sortAndSearchPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        sasOrderBox = new javax.swing.JComboBox<>();
        sasStreamProfile = new javax.swing.JComboBox<>();
        logTreeScrollPane = new javax.swing.JScrollPane();
        logTree = new javax.swing.JTree();
        displayTabs = new javax.swing.JTabbedPane();
        footer = new javax.swing.JToolBar();
        diskMemoryLabel = new javax.swing.JLabel();
        diskAvailLabel = new javax.swing.JLabel();
        jvmMemoryLabel = new javax.swing.JLabel();
        jvmAvailLabel = new javax.swing.JLabel();
        footerExtraLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topLevelSplit.setBackground(new java.awt.Color(153, 153, 153));
        topLevelSplit.setDividerLocation(300);

        utilitiesTab.setBackground(new java.awt.Color(153, 153, 153));

        optionsPane.setBackground(new java.awt.Color(153, 153, 153));
        optionsPane.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 0, 14))); // NOI18N

        jLabel4.setText("debug level");

        jLabel1.setText("view profile");

        javax.swing.GroupLayout optionsPaneLayout = new javax.swing.GroupLayout(optionsPane);
        optionsPane.setLayout(optionsPaneLayout);
        optionsPaneLayout.setHorizontalGroup(
            optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPaneLayout.createSequentialGroup()
                .addGroup(optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewProfileBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(debugLevelBox, 0, 186, Short.MAX_VALUE)))
        );
        optionsPaneLayout.setVerticalGroup(
            optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPaneLayout.createSequentialGroup()
                .addGroup(optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(debugLevelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewProfileBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
        );

        utilityScrollPane.setBackground(new java.awt.Color(153, 153, 153));
        utilityScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "utility panes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 0, 14))); // NOI18N

        javax.swing.GroupLayout utilitiesTabLayout = new javax.swing.GroupLayout(utilitiesTab);
        utilitiesTab.setLayout(utilitiesTabLayout);
        utilitiesTabLayout.setHorizontalGroup(
            utilitiesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(utilityScrollPane)
        );
        utilitiesTabLayout.setVerticalGroup(
            utilitiesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utilitiesTabLayout.createSequentialGroup()
                .addComponent(optionsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utilityScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        leftSideTabs.addTab("utilities", utilitiesTab);

        controlTab.setBackground(new java.awt.Color(153, 153, 153));

        loadPane.setBackground(new java.awt.Color(153, 153, 153));
        loadPane.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "load", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 0, 14))); // NOI18N

        selectButton.setText("select");

        loadButton.setText("load");

        javax.swing.GroupLayout loadPaneLayout = new javax.swing.GroupLayout(loadPane);
        loadPane.setLayout(loadPaneLayout);
        loadPaneLayout.setHorizontalGroup(
            loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pathBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(loadPaneLayout.createSequentialGroup()
                .addComponent(selectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(loadButton))
        );
        loadPaneLayout.setVerticalGroup(
            loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadPaneLayout.createSequentialGroup()
                .addComponent(pathBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectButton)
                    .addComponent(loadButton)))
        );

        robotPane.setBackground(new java.awt.Color(153, 153, 153));
        robotPane.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "robot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 0, 14))); // NOI18N

        robotAddressBox.setEditable(true);

        connectButton.setText("connect");

        keepSlider.setMajorTickSpacing(1);
        keepSlider.setMaximum(5);
        keepSlider.setPaintLabels(true);
        keepSlider.setPaintTicks(true);
        keepSlider.setSnapToTicks(true);
        keepSlider.setToolTipText("");

        jLabel2.setText("keep");

        javax.swing.GroupLayout robotPaneLayout = new javax.swing.GroupLayout(robotPane);
        robotPane.setLayout(robotPaneLayout);
        robotPaneLayout.setHorizontalGroup(
            robotPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(robotAddressBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(streamComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(robotPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keepSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        robotPaneLayout.setVerticalGroup(
            robotPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(robotPaneLayout.createSequentialGroup()
                .addComponent(robotAddressBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(streamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(robotPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(robotPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(robotPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(connectButton)
                            .addComponent(keepSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(robotPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rpcScrollPane.setBackground(new java.awt.Color(153, 153, 153));
        rpcScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "rpc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 0, 14))); // NOI18N
        rpcScrollPane.setToolTipText("");

        javax.swing.GroupLayout controlTabLayout = new javax.swing.GroupLayout(controlTab);
        controlTab.setLayout(controlTabLayout);
        controlTabLayout.setHorizontalGroup(
            controlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(robotPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rpcScrollPane)
        );
        controlTabLayout.setVerticalGroup(
            controlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlTabLayout.createSequentialGroup()
                .addComponent(loadPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(robotPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(rpcScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        leftSideTabs.addTab("control", controlTab);

        logTab.setBackground(new java.awt.Color(153, 153, 153));

        sortAndSearchPanel.setBackground(new java.awt.Color(153, 153, 153));
        sortAndSearchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "sort and search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 0, 14))); // NOI18N

        jLabel5.setText("sort");

        sasStreamProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sasStreamProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sortAndSearchPanelLayout = new javax.swing.GroupLayout(sortAndSearchPanel);
        sortAndSearchPanel.setLayout(sortAndSearchPanelLayout);
        sortAndSearchPanelLayout.setHorizontalGroup(
            sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sasOrderBox, 0, 228, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sasStreamProfile, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sortAndSearchPanelLayout.setVerticalGroup(
            sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                .addGroup(sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sasOrderBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sasStreamProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        logTreeScrollPane.setViewportView(logTree);

        javax.swing.GroupLayout logTabLayout = new javax.swing.GroupLayout(logTab);
        logTab.setLayout(logTabLayout);
        logTabLayout.setHorizontalGroup(
            logTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sortAndSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logTreeScrollPane)
        );
        logTabLayout.setVerticalGroup(
            logTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logTabLayout.createSequentialGroup()
                .addComponent(sortAndSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logTreeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        leftSideTabs.addTab("logs", logTab);

        topLevelSplit.setLeftComponent(leftSideTabs);
        topLevelSplit.setRightComponent(displayTabs);

        footer.setFloatable(false);
        footer.setRollover(true);

        diskMemoryLabel.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        diskMemoryLabel.setText("disk ");
        footer.add(diskMemoryLabel);

        diskAvailLabel.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        diskAvailLabel.setText("jLabel2");
        footer.add(diskAvailLabel);

        jvmMemoryLabel.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jvmMemoryLabel.setText(" jvm ");
        footer.add(jvmMemoryLabel);

        jvmAvailLabel.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jvmAvailLabel.setText("jLabel3");
        footer.add(jvmAvailLabel);

        footerExtraLabel.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        footerExtraLabel.setText("----------------------------------------");
        footer.add(footerExtraLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topLevelSplit)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topLevelSplit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void sasStreamProfileActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ToolDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToolDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToolDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToolDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToolDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    protected javax.swing.JButton connectButton;
    protected javax.swing.JPanel controlTab;
    protected javax.swing.JComboBox<Debug.LogLevel> debugLevelBox;
    protected javax.swing.JLabel diskAvailLabel;
    protected javax.swing.JLabel diskMemoryLabel;
    protected javax.swing.JTabbedPane displayTabs;
    protected javax.swing.JToolBar footer;
    protected javax.swing.JLabel footerExtraLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jvmAvailLabel;
    protected javax.swing.JLabel jvmMemoryLabel;
    protected javax.swing.JSlider keepSlider;
    protected javax.swing.JTabbedPane leftSideTabs;
    protected javax.swing.JButton loadButton;
    protected javax.swing.JPanel loadPane;
    protected javax.swing.JPanel logTab;
    protected javax.swing.JTree logTree;
    protected javax.swing.JScrollPane logTreeScrollPane;
    protected javax.swing.JPanel optionsPane;
    protected javax.swing.JComboBox<Path> pathBox;
    protected javax.swing.JComboBox<String> robotAddressBox;
    protected javax.swing.JPanel robotPane;
    protected javax.swing.JScrollPane rpcScrollPane;
    protected javax.swing.JComboBox<LogSorting.Sort> sasOrderBox;
    protected javax.swing.JComboBox<String> sasStreamProfile;
    protected javax.swing.JButton selectButton;
    protected javax.swing.JPanel sortAndSearchPanel;
    protected javax.swing.JComboBox<String> streamComboBox;
    protected javax.swing.JSplitPane topLevelSplit;
    protected javax.swing.JPanel utilitiesTab;
    protected javax.swing.JScrollPane utilityScrollPane;
    protected javax.swing.JComboBox<ViewProfile> viewProfileBox;
    // End of variables declaration                   
}
