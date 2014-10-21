package cn.edu.tsinghua.ui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExistListner implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
