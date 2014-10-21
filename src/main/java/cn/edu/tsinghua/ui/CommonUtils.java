package cn.edu.tsinghua.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

public class CommonUtils {
	public static void addPlaceHolder(Container panel) {
		JButton button = new JButton();
    	button.setBackground(Color.white);
    	button.setEnabled(false);
    	GridBagConstraints cons = new GridBagConstraints();
    	cons.fill = GridBagConstraints.BOTH;
    	cons.gridx = 0;
    	cons.gridy = 3;
    	cons.weightx = 1.0;
    	cons.weighty = 1.0;
    	panel.add(button, cons);
	}
}
