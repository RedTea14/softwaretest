package cn.edu.tsinghua.ui;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cn.edu.tsinghua.ui.actionlistener.ExistListner;
import cn.edu.tsinghua.ui.actionlistener.datamanagement.DataGroupListener;
import cn.edu.tsinghua.ui.actionlistener.datamanagement.ImportDataListener;
import cn.edu.tsinghua.ui.actionlistener.datamanagement.NewDataGroupListener;
import cn.edu.tsinghua.ui.actionlistener.project.CloseProjectListener;
import cn.edu.tsinghua.ui.actionlistener.project.NewProjectListener;
import cn.edu.tsinghua.ui.actionlistener.project.OpenProjectListener;

public class Menubar {
	private static JMenu dataGroupMenu;
	
	public static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		addMenustoFileMenu(fileMenu);
		menuBar.add(fileMenu);
		
		JMenu dataManagMenu = new JMenu("Data Management");
		addMenusToDataManagMenu(dataManagMenu);
		menuBar.add(dataManagMenu);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		return menuBar;
		
	}
	
	public static void addDataGroup(String dataGroupName) {
		JMenuItem menuItem = new JMenuItem(dataGroupName);
		dataGroupMenu.add(menuItem);
	}
	
	private static void addMenustoFileMenu(JMenu fileMenu) {
		JMenuItem menuItem = new JMenuItem("New Project");
		menuItem.addActionListener(new NewProjectListener());
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Open Project", new ImageIcon("imgs/open.gif"));
		menuItem.addActionListener(new OpenProjectListener());
		menuItem.setMnemonic(KeyEvent.VK_B);
	    fileMenu.add(menuItem);
	    
	    menuItem = new JMenuItem("Close Project");
	    menuItem.addActionListener(new CloseProjectListener());
	    menuItem.setMnemonic(KeyEvent.VK_B);
	    fileMenu.add(menuItem);
	    
	    menuItem = new JMenuItem("Save As...");
	    menuItem.setMnemonic(KeyEvent.VK_B);
	    fileMenu.add(menuItem);
		
	    menuItem = new JMenuItem("Exist");
	    menuItem.addActionListener(new ExistListner());
	    menuItem.setMnemonic(KeyEvent.VK_B);
	    fileMenu.add(menuItem);
	}
	
	private static void addMenusToDataManagMenu(JMenu dataManagMenu) {
		dataGroupMenu = new JMenu("Data Group");
		dataGroupMenu.setMnemonic(KeyEvent.VK_B);
		dataGroupMenu.addActionListener(new DataGroupListener());
		dataManagMenu.add(dataGroupMenu);
		
		JMenuItem menuItem;
		menuItem = new JMenuItem("New Data Group");
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.addActionListener(new NewDataGroupListener());
		dataGroupMenu.add(menuItem);
		
		menuItem = new JMenuItem("Import Data");
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.addActionListener(new ImportDataListener());
		dataManagMenu.add(menuItem);
	}
}
