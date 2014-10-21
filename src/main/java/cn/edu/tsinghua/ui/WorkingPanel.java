package cn.edu.tsinghua.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import cn.edu.tsinghua.ui.component.ButtonTabComponent;
import cn.edu.tsinghua.util.Constant;


public class WorkingPanel {
	private final static JTabbedPane tabbedPane = new JTabbedPane(); 
	
	public static void initWorkingPanel(Container panel) {
		setSize(panel);
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		panel.add(tabbedPane, cons);
		
		JComponent welcomePanel = makeTextPanel("Welcome Page");
		tabbedPane.addTab("Welcome Page", welcomePanel);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			JComponent buttonTabComponent = new ButtonTabComponent(tabbedPane);
			tabbedPane.setTabComponentAt(i, buttonTabComponent);
		}
	}
	
	public static void addTab(String tabTitle, JComponent tab) {
		tabbedPane.addTab(tabTitle, tab);
		JComponent buttonTabComponent = new ButtonTabComponent(tabbedPane);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(tab), buttonTabComponent);
		tabbedPane.setSelectedComponent(tab);
	}
	
	public static void clooseAll(boolean closeWelcome) {
		tabbedPane.removeAll();
	}
	
	private static JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filter = new JLabel(text);
		filter.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filter);
		return panel;
	}
	
    private static void setSize(Container panel) {
    	panel.setPreferredSize(new Dimension((Constant.WINDOW_WIDTH * 7) / 10
    			, (Constant.WINDOW_HEIGHT * (100 - Constant.TOOL_PANEL_HEIGHT_RATIO)) / 100));
    }

}
