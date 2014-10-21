package cn.edu.tsinghua.ui.actionlistener.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cn.edu.tsinghua.ui.UIContext;
import cn.edu.tsinghua.ui.model.Project;

public class NewProjectListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = (String)JOptionPane.showInputDialog(
                null,
                "Please enter project name:",
                "New Project",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "NewProject");
		if (s != null && !s.isEmpty()) {
			UIContext.project = new Project(s);
			return;
		}
	}

}
