package com.mycompany.physiccalculator;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.Timer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.*;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
/**
 *
 * @author User
 */
public class MainFrame extends javax.swing.JFrame{
    public String newParamName = null;
    public String fileName = null;
    public JTextField []paramNames = new JTextField[10];
    public JScrollPane []paramScrollPanes = new JScrollPane[10]; 
    public JList []paramLists = new JList[10]; 
    public JButton []paramButtons = new JButton[10];
    public DefaultListModel []paramModels = new DefaultListModel[10];
    public JTextField []paramMistakes = new JTextField[10];
    public int activeWindow = 0;
    public int openedWindows = 0;
    DefaultListModel editParamModel = new DefaultListModel();
    public double studentsCoefficientBeta[] = {0.70, 0.95, 0.99};
    
    public MainFrame() {
        DefaultListModel model0 = new DefaultListModel();
        DefaultListModel model1 = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
        DefaultListModel model3 = new DefaultListModel();
        DefaultListModel model4 = new DefaultListModel();
        DefaultListModel model5 = new DefaultListModel();
        DefaultListModel model6 = new DefaultListModel();
        DefaultListModel model7 = new DefaultListModel();
        DefaultListModel model8 = new DefaultListModel();
        DefaultListModel model9 = new DefaultListModel();
        
        initComponents();
        
        paramNames[0] = param0;
        paramNames[1] = param1;
        paramNames[2] = param2;
        paramNames[3] = param3;
        paramNames[4] = param4;
        paramNames[5] = param5;
        paramNames[6] = param6;
        paramNames[7] = param7;
        paramNames[8] = param8;
        paramNames[9] = param9;
        
        paramScrollPanes[0] = jScrollPane0;
        paramScrollPanes[1] = jScrollPane1;
        paramScrollPanes[2] = jScrollPane2;
        paramScrollPanes[3] = jScrollPane3;
        paramScrollPanes[4] = jScrollPane4;
        paramScrollPanes[5] = jScrollPane5;
        paramScrollPanes[6] = jScrollPane6;
        paramScrollPanes[7] = jScrollPane7;
        paramScrollPanes[8] = jScrollPane8;
        paramScrollPanes[9] = jScrollPane9;
       
        paramLists[0] = jList0;
        paramLists[1] = jList1;
        paramLists[2] = jList2;
        paramLists[3] = jList3;
        paramLists[4] = jList4;
        paramLists[5] = jList5;
        paramLists[6] = jList6;
        paramLists[7] = jList7;
        paramLists[8] = jList8;
        paramLists[9] = jList9;
        
        paramButtons[0] = editParam0;
        paramButtons[1] = editParam1;
        paramButtons[2] = editParam2;
        paramButtons[3] = editParam3;
        paramButtons[4] = editParam4;
        paramButtons[5] = editParam5;
        paramButtons[6] = editParam6;
        paramButtons[7] = editParam7;
        paramButtons[8] = editParam8;
        paramButtons[9] = editParam9;
        
        paramModels[0] = model0;
        paramModels[1] = model1;
        paramModels[2] = model2;
        paramModels[3] = model3;
        paramModels[4] = model4;
        paramModels[5] = model5;
        paramModels[6] = model6;
        paramModels[7] = model7;
        paramModels[8] = model8;
        paramModels[9] = model9;
        
        paramMistakes[0] = paramMistake0;
        paramMistakes[1] = paramMistake1;
        paramMistakes[2] = paramMistake2;
        paramMistakes[3] = paramMistake3;
        paramMistakes[4] = paramMistake4;
        paramMistakes[5] = paramMistake5;
        paramMistakes[6] = paramMistake6;
        paramMistakes[7] = paramMistake7;
        paramMistakes[8] = paramMistake8;
        paramMistakes[9] = paramMistake9;
        
        
        writeFormulas("t_\\beta (n) \\ \\beta = ", studentsCoefficientPanel, 16);
        
        for (int i = 0; i < studentsCoefficientBeta.length; i++){
            studentsCoefficientComboBox.addItem(String.valueOf(studentsCoefficientBeta[i]));
        }
        studentsCoefficientComboBox.setSelectedIndex(1);
        
        loadExample(3);
        
        for(int i = 0; i < paramLists.length; i++){
            paramLists[i].setModel(paramModels[i]);
        }
        
        // -----------------------------
        
    }
    
    public void loadExample(int type){
        switch(type){
            case -1:
                setParamVisible(3);
                paramCount.setText("3");
                paramNames[0].setText("x");
                paramNames[1].setText("y");
                paramNames[2].setText("z");

                paramMistakes[0].setText("0.005");
                paramMistakes[1].setText("0.01");
                paramMistakes[2].setText("0.5");
                for (int i = 0; i < 3; i++){
                    paramModels[i].addElement(i + 1);
                }
            break;
            case 1:
                setParamVisible(2);
                paramCount.setText("2");
                
                paramNames[0].setText("h");
                paramNames[1].setText("d");
                
                paramMistakes[0].setText("0.05");
                paramMistakes[1].setText("0.01");
                
                paramModels[0].addElement(41.15);
                paramModels[0].addElement(41.1);
                paramModels[0].addElement(41.15);
                paramModels[0].addElement(41.15);
                paramModels[0].addElement(41.2);
                paramModels[0].addElement(41.1);
                paramModels[0].addElement(41.15);
                paramModels[0].addElement(41.2);
                paramModels[0].addElement(41.15);
                paramModels[0].addElement(41.15);

                paramModels[1].addElement(12.12);
                paramModels[1].addElement(12.09);
                paramModels[1].addElement(12.08);
                paramModels[1].addElement(12.04);
                paramModels[1].addElement(12.05);
                paramModels[1].addElement(12.03);
                paramModels[1].addElement(12.03);
                paramModels[1].addElement(12.1);
                paramModels[1].addElement(12.07);
                paramModels[1].addElement(12.1);
            break;
            case 2:
                setParamVisible(1);
                paramCount.setText("1");
                
                paramNames[0].setText("t");
                
                paramMistakes[0].setText("0.001");

                paramModels[0].addElement(2.601);
                paramModels[0].addElement(2.597);
                paramModels[0].addElement(2.585);
                paramModels[0].addElement(2.587);
                paramModels[0].addElement(2.601);
                
            break;
            case 3:
                setParamVisible(10);
                paramCount.setText("10");
                
                paramNames[0].setText("a");
                paramNames[1].setText("b");
                paramNames[2].setText("c");
                paramNames[3].setText("d");
                paramNames[4].setText("e");
                paramNames[5].setText("a");
                paramNames[6].setText("b");
                paramNames[7].setText("c");
                paramNames[8].setText("d");
                paramNames[9].setText("e");
                
                for(int i = 0; i < 10; i++){
                    paramMistakes[i].setText("0.01");
                    for (int j = 0; j < 8; j++){
                        paramModels[i].addElement(j + i/10);
                    }
                }
                
            break;
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogFileChooser = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDialogEditParam = new javax.swing.JDialog();
        dispParam = new javax.swing.JScrollPane();
        dispParamList = new javax.swing.JList<>();
        editParamAdd = new javax.swing.JButton();
        removeParam = new javax.swing.JButton();
        editParamName = new javax.swing.JTextField();
        paramValue = new javax.swing.JTextField();
        editParamClose = new javax.swing.JButton();
        editParamMistake = new javax.swing.JTextField();
        jDialogCalculate = new javax.swing.JDialog();
        jScrollPane10 = new javax.swing.JScrollPane();
        calculatePanel = new javax.swing.JPanel();
        setParamCount = new javax.swing.JButton();
        paramCount = new javax.swing.JTextField();
        param0 = new javax.swing.JTextField();
        param1 = new javax.swing.JTextField();
        param2 = new javax.swing.JTextField();
        param3 = new javax.swing.JTextField();
        param4 = new javax.swing.JTextField();
        param5 = new javax.swing.JTextField();
        param6 = new javax.swing.JTextField();
        param7 = new javax.swing.JTextField();
        param8 = new javax.swing.JTextField();
        param9 = new javax.swing.JTextField();
        jScrollPane0 = new javax.swing.JScrollPane();
        jList0 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        openFile = new javax.swing.JButton();
        editParam0 = new javax.swing.JButton();
        editParam1 = new javax.swing.JButton();
        editParam2 = new javax.swing.JButton();
        editParam3 = new javax.swing.JButton();
        editParam4 = new javax.swing.JButton();
        editParam5 = new javax.swing.JButton();
        editParam6 = new javax.swing.JButton();
        editParam7 = new javax.swing.JButton();
        editParam8 = new javax.swing.JButton();
        editParam9 = new javax.swing.JButton();
        calculateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        studentsCoefficientComboBox = new javax.swing.JComboBox<>();
        studentsCoefficientPanel = new javax.swing.JPanel();
        paramMistake0 = new javax.swing.JTextField();
        paramMistake1 = new javax.swing.JTextField();
        paramMistake2 = new javax.swing.JTextField();
        paramMistake3 = new javax.swing.JTextField();
        paramMistake4 = new javax.swing.JTextField();
        paramMistake5 = new javax.swing.JTextField();
        paramMistake6 = new javax.swing.JTextField();
        paramMistake7 = new javax.swing.JTextField();
        paramMistake8 = new javax.swing.JTextField();
        paramMistake9 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jDialogFileChooser.setTitle("Open file");
        jDialogFileChooser.setMinimumSize(new java.awt.Dimension(600, 400));
        jDialogFileChooser.setSize(new java.awt.Dimension(600, 400));

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        jDialogFileChooser.getContentPane().add(jFileChooser1, java.awt.BorderLayout.CENTER);

        jDialogEditParam.setTitle("Edit");
        jDialogEditParam.setMinimumSize(new java.awt.Dimension(180, 430));
        jDialogEditParam.setResizable(false);
        jDialogEditParam.setSize(new java.awt.Dimension(200, 430));
        jDialogEditParam.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogEditParamWindowClosing(evt);
            }
        });
        jDialogEditParam.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dispParamList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dispParamListKeyPressed(evt);
            }
        });
        dispParam.setViewportView(dispParamList);

        jDialogEditParam.getContentPane().add(dispParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 340));

        editParamAdd.setText("Add");
        editParamAdd.setPreferredSize(new java.awt.Dimension(60, 23));
        editParamAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParamAddActionPerformed(evt);
            }
        });
        editParamAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editParamAddKeyPressed(evt);
            }
        });
        jDialogEditParam.getContentPane().add(editParamAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        removeParam.setText("Remove");
        removeParam.setPreferredSize(new java.awt.Dimension(60, 23));
        removeParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeParamActionPerformed(evt);
            }
        });
        removeParam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                removeParamKeyPressed(evt);
            }
        });
        jDialogEditParam.getContentPane().add(removeParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, -1));

        editParamName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editParamNameKeyPressed(evt);
            }
        });
        jDialogEditParam.getContentPane().add(editParamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        paramValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paramValueKeyPressed(evt);
            }
        });
        jDialogEditParam.getContentPane().add(paramValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 90, 20));

        editParamClose.setText("Close");
        editParamClose.setPreferredSize(new java.awt.Dimension(60, 23));
        editParamClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParamCloseActionPerformed(evt);
            }
        });
        editParamClose.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editParamCloseKeyPressed(evt);
            }
        });
        jDialogEditParam.getContentPane().add(editParamClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 90, -1));

        editParamMistake.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editParamMistakeKeyPressed(evt);
            }
        });
        jDialogEditParam.getContentPane().add(editParamMistake, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 90, 20));

        jDialogCalculate.setTitle("Calculate");
        jDialogCalculate.setMinimumSize(new java.awt.Dimension(500, 700));
        jDialogCalculate.setResizable(false);
        jDialogCalculate.setSize(new java.awt.Dimension(500, 700));
        jDialogCalculate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDialogCalculateKeyPressed(evt);
            }
        });
        jDialogCalculate.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calculatePanel.setBackground(new java.awt.Color(255, 255, 255));
        calculatePanel.setMinimumSize(new java.awt.Dimension(480, 470));
        calculatePanel.setPreferredSize(new java.awt.Dimension(480, 470));
        calculatePanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                calculatePanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout calculatePanelLayout = new javax.swing.GroupLayout(calculatePanel);
        calculatePanel.setLayout(calculatePanelLayout);
        calculatePanelLayout.setHorizontalGroup(
            calculatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        calculatePanelLayout.setVerticalGroup(
            calculatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        jScrollPane10.setViewportView(calculatePanel);

        jDialogCalculate.getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 640));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Physics Calculator");
        setMinimumSize(new java.awt.Dimension(750, 570));
        setPreferredSize(new java.awt.Dimension(750, 570));
        setResizable(false);
        setSize(new java.awt.Dimension(750, 570));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setParamCount.setText("Set");
        setParamCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setParamCountActionPerformed(evt);
            }
        });
        getContentPane().add(setParamCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        paramCount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paramCountKeyPressed(evt);
            }
        });
        getContentPane().add(paramCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 60, 20));
        getContentPane().add(param0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, -1));
        getContentPane().add(param1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 60, -1));
        getContentPane().add(param2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 60, -1));
        getContentPane().add(param3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 60, -1));
        getContentPane().add(param4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 60, -1));
        getContentPane().add(param5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 60, -1));
        getContentPane().add(param6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 60, -1));
        getContentPane().add(param7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 60, -1));
        getContentPane().add(param8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 60, -1));
        getContentPane().add(param9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 60, -1));

        jScrollPane0.setViewportView(jList0);

        getContentPane().add(jScrollPane0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 370));

        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 60, 370));

        jScrollPane2.setViewportView(jList2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 60, 370));

        jScrollPane3.setViewportView(jList3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 60, 370));

        jScrollPane4.setViewportView(jList4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 60, 370));

        jScrollPane5.setViewportView(jList5);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 60, 370));

        jScrollPane6.setViewportView(jList6);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 60, 370));

        jScrollPane7.setViewportView(jList7);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 60, 370));

        jScrollPane8.setViewportView(jList8);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 60, 370));

        jScrollPane9.setViewportView(jList9);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 60, 370));

        jLabel1.setText("Param count (max 10)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 20));

        openFile.setText("Open file");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        getContentPane().add(openFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        editParam0.setText("edit");
        editParam0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam0ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 60, -1));

        editParam1.setText("edit");
        editParam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam1ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 60, -1));

        editParam2.setText("edit");
        editParam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam2ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 60, -1));

        editParam3.setText("edit");
        editParam3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam3ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 60, -1));

        editParam4.setText("edit");
        editParam4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam4ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 60, -1));

        editParam5.setText("edit");
        editParam5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam5ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 60, -1));

        editParam6.setText("edit");
        editParam6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam6ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 60, -1));

        editParam7.setText("edit");
        editParam7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam7ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 60, -1));

        editParam8.setText("edit");
        editParam8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam8ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 60, -1));

        editParam9.setText("edit");
        editParam9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editParam9ActionPerformed(evt);
            }
        });
        getContentPane().add(editParam9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, 60, -1));

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        jLabel2.setText("Students coefficient");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 120, 20));

        getContentPane().add(studentsCoefficientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 70, -1));

        javax.swing.GroupLayout studentsCoefficientPanelLayout = new javax.swing.GroupLayout(studentsCoefficientPanel);
        studentsCoefficientPanel.setLayout(studentsCoefficientPanelLayout);
        studentsCoefficientPanelLayout.setHorizontalGroup(
            studentsCoefficientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        studentsCoefficientPanelLayout.setVerticalGroup(
            studentsCoefficientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(studentsCoefficientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 60, 20));
        getContentPane().add(paramMistake0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 60, -1));
        getContentPane().add(paramMistake1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 60, -1));
        getContentPane().add(paramMistake2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 60, -1));
        getContentPane().add(paramMistake3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 60, -1));
        getContentPane().add(paramMistake4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 60, -1));
        getContentPane().add(paramMistake5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 60, -1));
        getContentPane().add(paramMistake6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 60, -1));
        getContentPane().add(paramMistake7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 60, -1));
        getContentPane().add(paramMistake8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 60, -1));
        getContentPane().add(paramMistake9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 60, -1));

        jLabel3.setText("Measure mistakes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void setParamCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setParamCountActionPerformed
        String countS = paramCount.getText();
        try{
            int count = Integer.parseInt(countS);
            setParamVisible(count);
        } catch(Exception e){
        
        }
        
    }//GEN-LAST:event_setParamCountActionPerformed
    
    public void setParamVisible(int count){
        openedWindows = count;
        if (count > paramLists.length){
            count = paramLists.length;
        }
        setInvisible();
        for (int i = 0; i < count; i++){
            paramNames[i].setVisible(true);
            paramScrollPanes[i].setVisible(true);
            paramLists[i].setVisible(true);
            paramButtons[i].setVisible(true);
            paramMistakes[i].setVisible(true);
        }
    }
    
    private void paramCountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paramCountKeyPressed
        int key = evt.getKeyCode();
        String countS = paramCount.getText();
        int count = 0;
        try {
            count = Integer.parseInt(countS);
        } catch (Exception e){
            
        }
        
        if (key == KeyEvent.VK_ENTER){
            setParamVisible(count);
        }
    }//GEN-LAST:event_paramCountKeyPressed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV & XLSX, XLS", "csv", "xlsx", "xls"); //Change later
        jFileChooser1.setFileFilter(filter);
        fileName = jFileChooser1.getSelectedFile().getPath();
        ExcelData excelData = new ExcelData(fileName);
        int activeLists = excelData.getColumnCount();
        setParamVisible(activeLists);
        paramCount.setText(Integer.toString(activeLists));
        for (int i = 0; i < activeLists; i++){
            paramModels[i].clear();
            for (int j = 0; j < excelData.getRowCount(i); j++){
                paramModels[i].addElement(excelData.getData(j, i));
            }
        }
        
        jDialogFileChooser.setVisible(false);
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        jDialogFileChooser.setVisible(true);
    }//GEN-LAST:event_openFileActionPerformed

    private void removeParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeParamActionPerformed
        int []selectedIndices = dispParamList.getSelectedIndices();
        for (int i = 0; i < selectedIndices.length; i++){
            
        }
        try{
            if (dispParamList.getSelectedIndex() == -1){
                editParamModel.remove(0);
            }
            for (int i = 0; i < selectedIndices.length; i++){
                int index = dispParamList.getSelectedIndex();
                editParamModel.remove(index);
            }
        } catch (Exception e){
            
        }
        
    }//GEN-LAST:event_removeParamActionPerformed

    private void jDialogEditParamWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogEditParamWindowClosing
        closeEditParamDialog(activeWindow);
    }//GEN-LAST:event_jDialogEditParamWindowClosing

    private void editParamAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParamAddActionPerformed
        try{
            editParamModel.addElement(Double.parseDouble(paramValue.getText()));
        } catch (Exception e){
            
        }
        dispParamList.setModel(editParamModel);
    }//GEN-LAST:event_editParamAddActionPerformed

    private void editParamCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParamCloseActionPerformed
        closeEditParamDialog(activeWindow);
        jDialogEditParam.setVisible(false);
    }//GEN-LAST:event_editParamCloseActionPerformed

    private void paramValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paramValueKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ENTER){
            try{
                editParamModel.addElement(Double.parseDouble(paramValue.getText()));
                dispParamList.setModel(editParamModel);
                paramValue.setText("");
            } catch (Exception e){

            }
        }
        if (index == KeyEvent.VK_ESCAPE){
            closeEditParamDialog(activeWindow);
            jDialogEditParam.setVisible(false);
        }
    }//GEN-LAST:event_paramValueKeyPressed

    private void editParamNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editParamNameKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE || index == KeyEvent.VK_ENTER){
            closeEditParamDialog(activeWindow);
            jDialogEditParam.setVisible(false);
        }
    }//GEN-LAST:event_editParamNameKeyPressed

    private void editParamAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editParamAddKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE){
            closeEditParamDialog(activeWindow);
            jDialogEditParam.setVisible(false);
        }
    }//GEN-LAST:event_editParamAddKeyPressed

    private void removeParamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_removeParamKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE){
            closeEditParamDialog(activeWindow);
            jDialogEditParam.setVisible(false);
        }
    }//GEN-LAST:event_removeParamKeyPressed

    private void dispParamListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dispParamListKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE){
            closeEditParamDialog(activeWindow);
            jDialogEditParam.setVisible(false);
        }
    }//GEN-LAST:event_dispParamListKeyPressed

    private void editParamCloseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editParamCloseKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE){
            closeEditParamDialog(activeWindow);
            jDialogEditParam.setVisible(false);
        }
    }//GEN-LAST:event_editParamCloseKeyPressed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        int formulaSize = 16;
        jDialogCalculate.setVisible(true);
        JTextField activeNames[] = new JTextField[openedWindows];
        DefaultListModel activeModels[] = new DefaultListModel[openedWindows];
        double activeMistakes[] = new double[openedWindows];
        for (int i = 0; i < openedWindows; i++){
            activeNames[i] = paramNames[i];
            activeModels[i] = paramModels[i];
            activeMistakes[i] = Double.parseDouble(paramMistakes[i].getText().toString());
        }
        Formulas formulas = new Formulas(activeNames, activeModels,
                Double.parseDouble(studentsCoefficientComboBox.getSelectedItem().toString()),
                activeMistakes);
        String formula = formulas.getFormulas();
        switch (openedWindows){
            case 3:
                formulaSize = 14;
            break;
            case 4:
                formulaSize = 12;
            break;
            case 5:
                formulaSize = 10;
            break;
            case 6:
                formulaSize = 9;
            break;
            case 7:
                formulaSize = 8;
            break;
            case 8:
                formulaSize = 7;
            break;
            case 9:
                formulaSize = 6;
            break;
            case 10:
                formulaSize = 6;
            break;
        }
        writeFormulas(formula, calculatePanel, formulaSize);
    }//GEN-LAST:event_calculateButtonActionPerformed

    private void calculatePanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calculatePanelKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE){
            jDialogCalculate.setVisible(false);
        }
    }//GEN-LAST:event_calculatePanelKeyPressed

    private void jDialogCalculateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDialogCalculateKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE){
            jDialogCalculate.setVisible(false);
        }
    }//GEN-LAST:event_jDialogCalculateKeyPressed
    public void writeFormulas(String math, JPanel calculatePanel, int size){
        Timer timer = new Timer(250, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Graphics g = calculatePanel.getGraphics();
                    TeXFormula formula = new TeXFormula(math);
                    TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, size);
                    icon.paintIcon(calculatePanel, g, 0, 0);
                } catch (Exception ex){
                    System.out.println("Failed rendering");
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void setInvisible(){
        for (int i = 0; i < paramNames.length; i++){
            paramNames[i].setVisible(false);
            paramScrollPanes[i].setVisible(false);
            paramLists[i].setVisible(false);
            paramButtons[i].setVisible(false);
            paramMistakes[i].setVisible(false);
        }
    }
    
    public void loadParamData(DefaultListModel model){
        int modelSize = model.getSize();
        double []data = new double[modelSize];
        for (int i = 0; i < modelSize; i++){
            data[i] = Double.parseDouble(model.get(i).toString());
        }
        for (int i = 0; i < data.length; i++){
            editParamModel.addElement(data[i]);
        }
        dispParamList.setModel(editParamModel);
    }
    
    public void closeEditParamDialog(int x){
        paramNames[x].setText(editParamName.getText());
        paramMistakes[x].setText(editParamMistake.getText());
        paramModels[activeWindow].clear();
        for (int i = 0; i < editParamModel.getSize(); i++){
            paramModels[activeWindow].addElement(editParamModel.getElementAt(i));
        }
        paramValue.setText("");
        editParamModel.clear();
    }

    private void editParam0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam0ActionPerformed
        activeWindow = 0;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam0ActionPerformed

    private void editParam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam1ActionPerformed
        activeWindow = 1;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam1ActionPerformed

    private void editParam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam2ActionPerformed
        activeWindow = 2;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam2ActionPerformed

    private void editParam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam3ActionPerformed
        activeWindow = 3;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam3ActionPerformed

    private void editParam4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam4ActionPerformed
        activeWindow = 4;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam4ActionPerformed

    private void editParam5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam5ActionPerformed
        activeWindow = 5;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam5ActionPerformed

    private void editParam6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam6ActionPerformed
        activeWindow = 6;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam6ActionPerformed

    private void editParam7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam7ActionPerformed
        activeWindow = 7;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam7ActionPerformed

    private void editParam8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam8ActionPerformed
        activeWindow = 8;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam8ActionPerformed

    private void editParam9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editParam9ActionPerformed
        activeWindow = 9;
        editParamName.setText(paramNames[activeWindow].getText());
        editParamMistake.setText(paramMistakes[activeWindow].getText());
        loadParamData(paramModels[activeWindow]);
        jDialogEditParam.setVisible(true);
    }//GEN-LAST:event_editParam9ActionPerformed

    private void editParamMistakeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editParamMistakeKeyPressed
        int index = evt.getKeyCode();
        if (index == KeyEvent.VK_ESCAPE || index == KeyEvent.VK_ENTER){
            closeEditParamDialog(activeWindow);
            jDialogEditParam.setVisible(false);
        }
    }//GEN-LAST:event_editParamMistakeKeyPressed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculateButton;
    private javax.swing.JPanel calculatePanel;
    private javax.swing.JScrollPane dispParam;
    private javax.swing.JList<String> dispParamList;
    private javax.swing.JButton editParam0;
    private javax.swing.JButton editParam1;
    private javax.swing.JButton editParam2;
    private javax.swing.JButton editParam3;
    private javax.swing.JButton editParam4;
    private javax.swing.JButton editParam5;
    private javax.swing.JButton editParam6;
    private javax.swing.JButton editParam7;
    private javax.swing.JButton editParam8;
    private javax.swing.JButton editParam9;
    private javax.swing.JButton editParamAdd;
    private javax.swing.JButton editParamClose;
    private javax.swing.JTextField editParamMistake;
    private javax.swing.JTextField editParamName;
    private javax.swing.JDialog jDialogCalculate;
    private javax.swing.JDialog jDialogEditParam;
    private javax.swing.JDialog jDialogFileChooser;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList0;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JList<String> jList7;
    private javax.swing.JList<String> jList8;
    private javax.swing.JList<String> jList9;
    private javax.swing.JScrollPane jScrollPane0;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton openFile;
    private javax.swing.JTextField param0;
    private javax.swing.JTextField param1;
    private javax.swing.JTextField param2;
    private javax.swing.JTextField param3;
    private javax.swing.JTextField param4;
    private javax.swing.JTextField param5;
    private javax.swing.JTextField param6;
    private javax.swing.JTextField param7;
    private javax.swing.JTextField param8;
    private javax.swing.JTextField param9;
    private javax.swing.JTextField paramCount;
    private javax.swing.JTextField paramMistake0;
    private javax.swing.JTextField paramMistake1;
    private javax.swing.JTextField paramMistake2;
    private javax.swing.JTextField paramMistake3;
    private javax.swing.JTextField paramMistake4;
    private javax.swing.JTextField paramMistake5;
    private javax.swing.JTextField paramMistake6;
    private javax.swing.JTextField paramMistake7;
    private javax.swing.JTextField paramMistake8;
    private javax.swing.JTextField paramMistake9;
    private javax.swing.JTextField paramValue;
    private javax.swing.JButton removeParam;
    private javax.swing.JButton setParamCount;
    private javax.swing.JComboBox<String> studentsCoefficientComboBox;
    private javax.swing.JPanel studentsCoefficientPanel;
    // End of variables declaration//GEN-END:variables
}
