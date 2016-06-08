/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbtool.gui;

/**
 *
 * @author pkoch
 */
public class ToplevelDisplay2 extends javax.swing.JFrame {

    /**
     * Creates new form TopLevelDisplay
     */
    public ToplevelDisplay2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollBar1 = new javax.swing.JScrollBar();
        TopLevelSplitPane = new javax.swing.JSplitPane();
        LeftTabbedPane = new javax.swing.JTabbedPane();
        UtilitiesTab = new javax.swing.JPanel();
        optionsPane = new javax.swing.JPanel();
        logLabel = new javax.swing.JLabel();
        logLevelComboBox = new javax.swing.JComboBox();
        utilitiesOutside = new javax.swing.JPanel();
        utilitiesScrollPane = new javax.swing.JScrollPane();
        ControlTab = new javax.swing.JPanel();
        fileSystemPanel = new javax.swing.JPanel();
        pathComboBox = new javax.swing.JComboBox();
        loadButton = new javax.swing.JButton();
        chooseButton = new javax.swing.JButton();
        connectPanel = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        editableAddressBox = new javax.swing.JComboBox();
        retainLogsCheckBox = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        controlPanel = new javax.swing.JPanel();
        controlScrollPane = new javax.swing.JScrollPane();
        LogsTab = new javax.swing.JPanel();
        sortAndSearchPanel = new javax.swing.JPanel();
        obLabel = new javax.swing.JLabel();
        sortByBox = new javax.swing.JComboBox();
        reversedCheckBox = new javax.swing.JCheckBox();
        showOnlyLabel = new javax.swing.JLabel();
        showOnlyField = new javax.swing.JTextField();
        logChooserScrollPane = new javax.swing.JScrollPane();
        logChooserTree = new javax.swing.JTree();
        DisplayPane = new javax.swing.JPanel();
        mainLogDisplayPanel = new javax.swing.JPanel();
        footerPanel = new javax.swing.JPanel();
        memSpaceBar = new javax.swing.JProgressBar();
        memLabel = new javax.swing.JLabel();
        fsLabel = new javax.swing.JLabel();
        fsSpaceBar = new javax.swing.JProgressBar();
        eventLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("nbtool8-thingsup-yayayay");
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledText"));

        TopLevelSplitPane.setBackground(new java.awt.Color(242, 242, 242));
        TopLevelSplitPane.setDividerLocation(300);
        TopLevelSplitPane.setDividerSize(5);
        TopLevelSplitPane.setForeground(new java.awt.Color(255, 255, 255));

        LeftTabbedPane.setBackground(new java.awt.Color(242, 242, 242));
        LeftTabbedPane.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.disabledText"));
        LeftTabbedPane.setOpaque(true);

        UtilitiesTab.setBackground(new java.awt.Color(242, 242, 242));

        optionsPane.setBackground(new java.awt.Color(242, 242, 242));
        optionsPane.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 1, 14))); // NOI18N

        logLabel.setFont(new java.awt.Font("PT Serif", 0, 13)); // NOI18N
        logLabel.setText("tool printing level");

        logLevelComboBox.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        logLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        logLevelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logLevelComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionsPaneLayout = new javax.swing.GroupLayout(optionsPane);
        optionsPane.setLayout(optionsPaneLayout);
        optionsPaneLayout.setHorizontalGroup(
            optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        optionsPaneLayout.setVerticalGroup(
            optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(optionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logLabel)))
        );

        utilitiesOutside.setBackground(new java.awt.Color(242, 242, 242));
        utilitiesOutside.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "utilities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 1, 14))); // NOI18N

        utilitiesScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout utilitiesOutsideLayout = new javax.swing.GroupLayout(utilitiesOutside);
        utilitiesOutside.setLayout(utilitiesOutsideLayout);
        utilitiesOutsideLayout.setHorizontalGroup(
            utilitiesOutsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(utilitiesScrollPane)
        );
        utilitiesOutsideLayout.setVerticalGroup(
            utilitiesOutsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(utilitiesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout UtilitiesTabLayout = new javax.swing.GroupLayout(UtilitiesTab);
        UtilitiesTab.setLayout(UtilitiesTabLayout);
        UtilitiesTabLayout.setHorizontalGroup(
            UtilitiesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(utilitiesOutside, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        UtilitiesTabLayout.setVerticalGroup(
            UtilitiesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UtilitiesTabLayout.createSequentialGroup()
                .addComponent(optionsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utilitiesOutside, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LeftTabbedPane.addTab("utilities", UtilitiesTab);

        ControlTab.setBackground(new java.awt.Color(242, 242, 242));

        fileSystemPanel.setBackground(new java.awt.Color(242, 242, 242));
        fileSystemPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "load from filesystem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 1, 14))); // NOI18N

        pathComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pathComboBox.setToolTipText("");

        loadButton.setText("load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        chooseButton.setText("select");

        javax.swing.GroupLayout fileSystemPanelLayout = new javax.swing.GroupLayout(fileSystemPanel);
        fileSystemPanel.setLayout(fileSystemPanelLayout);
        fileSystemPanelLayout.setHorizontalGroup(
            fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileSystemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fileSystemPanelLayout.createSequentialGroup()
                        .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(fileSystemPanelLayout.createSequentialGroup()
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        fileSystemPanelLayout.setVerticalGroup(
            fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileSystemPanelLayout.createSequentialGroup()
                .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadButton)
                    .addComponent(chooseButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        connectPanel.setBackground(new java.awt.Color(242, 242, 242));
        connectPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "connect to robot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 1, 14))); // NOI18N

        connectButton.setText("connect");

        editableAddressBox.setEditable(true);
        editableAddressBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        retainLogsCheckBox.setFont(new java.awt.Font("PT Serif", 0, 14)); // NOI18N
        retainLogsCheckBox.setText("retain");
        retainLogsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retainLogsCheckBoxActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout connectPanelLayout = new javax.swing.GroupLayout(connectPanel);
        connectPanel.setLayout(connectPanelLayout);
        connectPanelLayout.setHorizontalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addComponent(editableAddressBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(retainLogsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        connectPanelLayout.setVerticalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editableAddressBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retainLogsCheckBox)
                    .addComponent(connectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        controlPanel.setBackground(new java.awt.Color(242, 242, 242));
        controlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "control robot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans", 0, 14))); // NOI18N

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlScrollPane)
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ControlTabLayout = new javax.swing.GroupLayout(ControlTab);
        ControlTab.setLayout(ControlTabLayout);
        ControlTabLayout.setHorizontalGroup(
            ControlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(connectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fileSystemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE)
        );
        ControlTabLayout.setVerticalGroup(
            ControlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlTabLayout.createSequentialGroup()
                .addComponent(fileSystemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LeftTabbedPane.addTab("control", ControlTab);

        sortAndSearchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "sort and search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Serif", 1, 14))); // NOI18N

        obLabel.setFont(new java.awt.Font("PT Serif", 0, 14)); // NOI18N
        obLabel.setText("order by:");

        sortByBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sortByBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByBoxActionPerformed(evt);
            }
        });

        reversedCheckBox.setFont(new java.awt.Font("PT Serif", 0, 14)); // NOI18N
        reversedCheckBox.setText("(reversed)");
        reversedCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        reversedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reversedCheckBoxActionPerformed(evt);
            }
        });

        showOnlyLabel.setFont(new java.awt.Font("PT Serif", 0, 14)); // NOI18N
        showOnlyLabel.setText("show only:");

        showOnlyField.setText("jTextField1");

        javax.swing.GroupLayout sortAndSearchPanelLayout = new javax.swing.GroupLayout(sortAndSearchPanel);
        sortAndSearchPanel.setLayout(sortAndSearchPanelLayout);
        sortAndSearchPanelLayout.setHorizontalGroup(
            sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                        .addComponent(showOnlyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showOnlyField)
                        .addContainerGap())
                    .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                        .addComponent(obLabel)
                        .addGap(18, 18, 18)
                        .addComponent(sortByBox, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reversedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        sortAndSearchPanelLayout.setVerticalGroup(
            sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obLabel)
                    .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sortByBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reversedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sortAndSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sortAndSearchPanelLayout.createSequentialGroup()
                        .addComponent(showOnlyLabel)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sortAndSearchPanelLayout.createSequentialGroup()
                        .addComponent(showOnlyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        logChooserScrollPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        logChooserScrollPane.setViewportView(logChooserTree);

        javax.swing.GroupLayout LogsTabLayout = new javax.swing.GroupLayout(LogsTab);
        LogsTab.setLayout(LogsTabLayout);
        LogsTabLayout.setHorizontalGroup(
            LogsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sortAndSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logChooserScrollPane)
        );
        LogsTabLayout.setVerticalGroup(
            LogsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogsTabLayout.createSequentialGroup()
                .addComponent(sortAndSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logChooserScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );

        LeftTabbedPane.addTab("logs", LogsTab);

        TopLevelSplitPane.setLeftComponent(LeftTabbedPane);

        DisplayPane.setBackground(new java.awt.Color(242, 242, 242));
        DisplayPane.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.disabledText"));

        mainLogDisplayPanel.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout mainLogDisplayPanelLayout = new javax.swing.GroupLayout(mainLogDisplayPanel);
        mainLogDisplayPanel.setLayout(mainLogDisplayPanelLayout);
        mainLogDisplayPanelLayout.setHorizontalGroup(
            mainLogDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        mainLogDisplayPanelLayout.setVerticalGroup(
            mainLogDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DisplayPaneLayout = new javax.swing.GroupLayout(DisplayPane);
        DisplayPane.setLayout(DisplayPaneLayout);
        DisplayPaneLayout.setHorizontalGroup(
            DisplayPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainLogDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DisplayPaneLayout.setVerticalGroup(
            DisplayPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayPaneLayout.createSequentialGroup()
                .addComponent(mainLogDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        TopLevelSplitPane.setRightComponent(DisplayPane);

        footerPanel.setBackground(new java.awt.Color(204, 204, 204));

        memLabel.setText("MEM");

        fsLabel.setText("FS");

        eventLabel.setText("jLabel3");

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memSpaceBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fsSpaceBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventLabel)
                    .addComponent(fsSpaceBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fsLabel)
                    .addGroup(footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(memSpaceBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(memLabel))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TopLevelSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TopLevelSplitPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortByBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortByBoxActionPerformed

    private void logLevelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logLevelComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logLevelComboBoxActionPerformed

    private void retainLogsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retainLogsCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retainLogsCheckBoxActionPerformed

    private void reversedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reversedCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reversedCheckBoxActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ToplevelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToplevelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToplevelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToplevelDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToplevelDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel ControlTab;
    public javax.swing.JPanel DisplayPane;
    public javax.swing.JTabbedPane LeftTabbedPane;
    public javax.swing.JPanel LogsTab;
    public javax.swing.JSplitPane TopLevelSplitPane;
    public javax.swing.JPanel UtilitiesTab;
    public javax.swing.JButton chooseButton;
    public javax.swing.JButton connectButton;
    public javax.swing.JPanel connectPanel;
    public javax.swing.JPanel controlPanel;
    public javax.swing.JScrollPane controlScrollPane;
    public javax.swing.JComboBox editableAddressBox;
    public javax.swing.JLabel eventLabel;
    public javax.swing.JPanel fileSystemPanel;
    public javax.swing.JPanel footerPanel;
    public javax.swing.JLabel fsLabel;
    public javax.swing.JProgressBar fsSpaceBar;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JProgressBar jProgressBar1;
    public javax.swing.JScrollBar jScrollBar1;
    public javax.swing.JButton loadButton;
    public javax.swing.JScrollPane logChooserScrollPane;
    public javax.swing.JTree logChooserTree;
    public javax.swing.JLabel logLabel;
    public javax.swing.JComboBox logLevelComboBox;
    public javax.swing.JPanel mainLogDisplayPanel;
    public javax.swing.JLabel memLabel;
    public javax.swing.JProgressBar memSpaceBar;
    public javax.swing.JLabel obLabel;
    public javax.swing.JPanel optionsPane;
    public javax.swing.JComboBox pathComboBox;
    public javax.swing.JCheckBox retainLogsCheckBox;
    public javax.swing.JCheckBox reversedCheckBox;
    public javax.swing.JTextField showOnlyField;
    public javax.swing.JLabel showOnlyLabel;
    public javax.swing.JPanel sortAndSearchPanel;
    public javax.swing.JComboBox sortByBox;
    public javax.swing.JPanel utilitiesOutside;
    public javax.swing.JScrollPane utilitiesScrollPane;
    // End of variables declaration//GEN-END:variables
}