package cn.edu.tsinghua.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class IndexPanel {
	public static void addComponentsToPanel(Container panel) {
		panel.setBackground(Color.yellow);
		initComponents(panel);
	}
	
	private static void initComponents(Container panel) {
		JPanel navigationPanel = new JPanel();
		NavigationPanel.addComponentsToPanel(navigationPanel);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		navigationPanel.setBorder(blackline);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(500, 200));
		ToolsPanel.addComponentsToPanel(menuPanel);
		menuPanel.setBorder(blackline);
		
		JPanel workingPanel = new JPanel();
		WorkingPanel.initWorkingPanel(workingPanel);
		workingPanel.setBorder(blackline);
		workingPanel.setPreferredSize(new Dimension(300, 500));
		
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(menuPanel, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(navigationPanel, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(workingPanel, c);
	}
}
