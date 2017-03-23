package com.maia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Maia on 3/22/2017.
 */
public class AWForm extends JFrame {
    private JPanel rootPanel;
    private JTextField projectNameTextField;
    private JButton recommendButton;
    private JLabel recommendedOutputLabel;
    private JCheckBox teamSizeCheckBox;
    private JCheckBox deadLinesCheckBox;
    private JCheckBox experienceCheckBox;
    private JCheckBox qualityControlCheckBox;
    private JCheckBox earlyIntegrationCheckBox;
    private JCheckBox workingModelsCheckBox;
    private String projectName;

    protected AWForm(){
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setTitle("Agile or Waterfall Program");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projectName = projectNameTextField.getText();
                recommendedOutputLabel.setText(agileOrWaterfall());
            }
        });
    }

    private String agileOrWaterfall(){
        ArrayList<Integer> agile = new ArrayList<Integer>();
        ArrayList<Integer> waterfall = new ArrayList<Integer>();

        if (teamSizeCheckBox.isSelected()) {agile.add(1);} else{ waterfall.add(1);}
        if (deadLinesCheckBox.isSelected()){ waterfall.add(1);}else{ agile.add(1);}
        if (experienceCheckBox.isSelected()){agile.add(1);}else{ waterfall.add(1);}
        if (qualityControlCheckBox.isSelected()){waterfall.add(1);}else{agile.add(1);}
        if (earlyIntegrationCheckBox.isSelected()){agile.add(1);}else{waterfall.add(1);}
        if (workingModelsCheckBox.isSelected()){agile.add(1);}else{waterfall.add(1);}

        int aCount = 0;
        int wCount = 0;

        for (int x : agile){aCount = aCount + 1;}
        for (int y : waterfall){wCount = wCount + 1;}

        if (aCount > wCount){return projectName + " should use Agile methodology.";}
        else{return projectName + " should use Waterfall methodology.";}
    }



}