package cn.edu.tsinghua.ui;

import java.awt.Dimension;

import javax.swing.JFrame;

import cn.edu.tsinghua.util.Constant;
import cn.edu.tsinghua.util.Resource;

public class MainFrame {
	private static JFrame frame;
	
	public static void show() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle(Resource.getProperty("MainFrame.Title"));
				IndexPanel.addComponentsToPanel(frame.getContentPane());
				frame.setSize(new Dimension(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT));
				frame.setJMenuBar(Menubar.createMenuBar());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
	
	public static JFrame getFrame() {
		return frame;
	}
}
