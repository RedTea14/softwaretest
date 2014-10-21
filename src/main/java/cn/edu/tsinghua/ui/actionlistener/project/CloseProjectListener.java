package cn.edu.tsinghua.ui.actionlistener.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.tsinghua.ui.UIContext;
import cn.edu.tsinghua.ui.WorkingPanel;

public class CloseProjectListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		UIContext.project = null;
		WorkingPanel.clooseAll(true);
	}
	
}
