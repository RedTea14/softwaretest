package cn.edu.tsinghua.ui.actionlistener.datamanagement;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cn.edu.tsinghua.ui.Menubar;
import cn.edu.tsinghua.ui.UIContext;
import cn.edu.tsinghua.ui.WorkingPanel;
import cn.edu.tsinghua.ui.model.DataGroup;
import cn.edu.tsinghua.util.Constant;

public class NewDataGroupListener implements ActionListener {
	private JTable dataTable;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (UIContext.project == null) {
			JOptionPane.showMessageDialog(null, "Please choose a project to create data group.");
			return;
		}
		String s = (String)JOptionPane.showInputDialog(
                null,
                "Please enter data group name:",
                "New Data Group",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "NewDataGroup");
		if (s != null && !s.isEmpty()) {
			String proRootPath = UIContext.project.getProjectRoot();
			String dataGroupPath = proRootPath + Constant.FILE_SEPARATOR + Constant.DATA_PATH + s;
			File dataGroupFolder = new File(dataGroupPath);
			dataGroupFolder.mkdirs();
			
			DataGroup dg = new DataGroup(dataGroupFolder.getPath());
			Menubar.addDataGroup(dg.getName());
			UIContext.dataGroup = dg;
			
			dataTable = createDataTable();
			JScrollPane  panel = new JScrollPane(dataTable);
			dataTable.setFillsViewportHeight(true);
			
			WorkingPanel.addTab("Data Group", panel);
			return;
		}
		
	}
	
	private JTable createDataTable() {
		String[] columnNames = {"Number",
                "Failure Time", "Time Unit", 
                "Failure Lost", "Lost Unit"};
		Object[][] data = {
			    {Integer.valueOf(1), "1", "Minute", Float.valueOf(2.34f), "Millon"},
			    {Integer.valueOf(2), "2", "Minute", Float.valueOf(2.34f), "Millon"},
			    {Integer.valueOf(3), "4", "Minute", Float.valueOf(2.34f), "Millon"},
			    {Integer.valueOf(4), "5", "Minute", Float.valueOf(2.34f), "Millon"},
			    {Integer.valueOf(5), "6", "Minute", Float.valueOf(2.34f), "Millon"}
			};
		JTable result = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
		result.setModel(tableModel);
		result.setComponentPopupMenu(createRightClickMenuOnDataTable());
		result.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumn timeUnitColumn = result.getColumnModel().getColumn(2);
		JComboBox<String> timeUnitBox = new JComboBox<String>();
		timeUnitBox.addItem("Month");
		timeUnitBox.addItem("Day");
		timeUnitBox.addItem("Hour");
		timeUnitBox.addItem("Minute");
		timeUnitBox.addItem("Second");
		timeUnitColumn.setCellEditor(new DefaultCellEditor(timeUnitBox));
		
		TableColumn lostUnitColumn = result.getColumnModel().getColumn(4);
		JComboBox<String> lostUnitBox = new JComboBox<String>();
		lostUnitBox.addItem("Billon");
		lostUnitBox.addItem("Millon");
		lostUnitBox.addItem("Thousand");
		lostUnitBox.addItem("Hundrad");
		lostUnitBox.addItem("Dollar");
		lostUnitColumn.setCellEditor(new DefaultCellEditor(lostUnitBox));
		
		return result;
	}
	
	private JPopupMenu createRightClickMenuOnDataTable() {
		JPopupMenu result = new JPopupMenu();
		JMenuItem deleteItem = createRightClickMenuItem("Delete Data");
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowIndex = dataTable.getSelectedRow();
				((DefaultTableModel)(dataTable.getModel())).removeRow(selectedRowIndex);
				
				for (int i = selectedRowIndex; i < dataTable.getRowCount(); i++) {
					int originalNo = (Integer)dataTable.getModel().getValueAt(i, 0);
					dataTable.getModel().setValueAt(Integer.valueOf(originalNo - 1), i, 0);
				}
			}
		});
		JMenuItem addItem = createRightClickMenuItem("Add Data");
		addItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int lastNo = (Integer)dataTable.getModel().getValueAt(dataTable.getRowCount() - 1, 0);
				Object[] data = {Integer.valueOf(lastNo + 1), "", "", "", ""};
				((DefaultTableModel)(dataTable.getModel())).addRow(data);
			}
		});
		JMenuItem insertItem = createRightClickMenuItem("Insert Data");
		insertItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex = dataTable.getSelectedRow();
				int number = (Integer)dataTable.getModel().getValueAt(selectedRowIndex, 0);
				Object[] data = {Integer.valueOf(number + 1), "", "", "", ""};
				((DefaultTableModel)(dataTable.getModel())).insertRow(selectedRowIndex + 1, data);
				for (int i = selectedRowIndex + 2; i < dataTable.getRowCount(); i++) {
					int originalNo = (Integer)dataTable.getModel().getValueAt(i, 0);
					dataTable.getModel().setValueAt(Integer.valueOf(originalNo + 1), i, 0);
				}
			}
		});
		result.add(addItem);
		result.add(insertItem);
		result.add(deleteItem);
		return result;
	}
	
	private JMenuItem createRightClickMenuItem(String text) {
		JMenuItem result = new JMenuItem(text);
		result.setPreferredSize(new Dimension(100, 20));
		return result;
	}
}
