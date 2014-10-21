package cn.edu.tsinghua.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import cn.edu.tsinghua.util.Constant;
import cn.edu.tsinghua.util.Resource;

public class NavigationPanel {
	
    public static void addComponentsToPanel(Container panel) {
    	setSize(panel);
    	
    	panel.setLayout(new GridBagLayout());
    	
    	GridBagConstraints cons = new GridBagConstraints();
    	
    	JButton abilityBut = new JButton(Resource.getProperty("NavigationPanel.Ability"));
    	abilityBut.setHorizontalAlignment(SwingConstants.LEADING);
    	cons.fill = GridBagConstraints.HORIZONTAL;
    	cons.gridx = 0;
    	cons.gridy = 0;
    	cons.gridwidth = 1;
    	cons.gridheight = 1;
    	panel.add(abilityBut, cons);
    	
    	cons = new GridBagConstraints();
    	JButton ruleBut = new JButton(Resource.getProperty("NavigationPanel.Rule"));
    	ruleBut.setHorizontalAlignment(SwingConstants.LEADING);
    	cons.fill = GridBagConstraints.HORIZONTAL;
    	cons.gridx = 0;
    	cons.gridy = 1;
    	cons.gridwidth = 1;
    	cons.gridheight = 1;
    	panel.add(ruleBut, cons);
    	
    	cons = new GridBagConstraints();
    	JButton identityBut = new JButton(Resource.getProperty("NavigationPanel.Identity"));
    	identityBut.setHorizontalAlignment(SwingConstants.LEADING);
    	cons.fill = GridBagConstraints.HORIZONTAL;
    	cons.gridx = 0;
    	cons.gridy = 2;
    	cons.gridwidth = 1;
    	cons.gridheight = 1;
    	panel.add(identityBut, cons);
    	
    	CommonUtils.addPlaceHolder(panel);
    }
    
    private static void setSize(Container panel) {
    	panel.setPreferredSize(new Dimension((Constant.WINDOW_WIDTH * 3) / 10
    			, (Constant.WINDOW_HEIGHT * (100 - Constant.TOOL_PANEL_HEIGHT_RATIO)) / 100));
    }
}
