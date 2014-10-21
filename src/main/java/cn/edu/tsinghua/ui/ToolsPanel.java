package cn.edu.tsinghua.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import cn.edu.tsinghua.util.Constant;

public class ToolsPanel {
	public static void addComponentsToPanel(Container panel) {
		setSize(panel);

		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		panel.add(createToolbar(), c);
		
		CommonUtils.addPlaceHolder(panel);
	}

	private static JToolBar createToolbar() {
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);
		toolbar.setRollover(true);
		addButtons(toolbar);

		return toolbar;
	}
	
	private static void addButtons(JToolBar toolbar) {
		JButton button = null;
		button = new JButton("Another button");
		toolbar.add(button);
		
		JTextField textField = new JTextField("A Text Field");
		textField.setColumns(10);
		toolbar.add(textField);
	}
	
    private static void setSize(Container panel) {
    	panel.setPreferredSize(new Dimension(Constant.WINDOW_WIDTH
    			, (Constant.WINDOW_HEIGHT * Constant.TOOL_PANEL_HEIGHT_RATIO) / 100));
    }
}
