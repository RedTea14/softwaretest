package cn.edu.tsinghua.ui.actionlistener.datamanagement;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.tsinghua.ui.MainFrame;

public class ImportDataListener implements ActionListener {

	private static final int COMPONENT_HEIGHT = 20;
	
	private JDialog dialog;
	private JTextField dataGroupNameField;
	private JComboBox<String> dataGroupType;
	private JTextField dataFileField;

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dialog = new JDialog();
		dialog.setTitle("Import data");
		dialog.setSize(new Dimension(400, 200));
		dialog.setLocationRelativeTo(MainFrame.getFrame());
		
		Container contentPane = dialog.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		
		addDataGroupNameFiled(contentPane);
		
		addDataGroupTypeField(contentPane);
		
		addDataFileField(contentPane);
		
		addActionButtons(contentPane);
		
		dialog.setVisible(true);
	}

	private void addActionButtons(Container contentPane) {
		JPanel panel = new JPanel();
		
		final int buttonWidth = 80;
		
		JButton importButton = new JButton();
		importButton.setText("Import");
		importButton.setPreferredSize(new Dimension(buttonWidth, COMPONENT_HEIGHT));
		importButton.setHorizontalAlignment(JButton.LEADING);
		importButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String groupName = dataGroupNameField.getText();
				String dataType = (String)dataGroupType.getSelectedItem();
				String dataPath = dataFileField.getText();
				
				dialog.setVisible(false);
			}
		});
		panel.add(importButton);
		
		JButton cancelButton = new JButton();
		cancelButton.setText("Cancel");
		cancelButton.setPreferredSize(new Dimension(buttonWidth, COMPONENT_HEIGHT));
		panel.add(cancelButton);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
	    c.gridy = 4;
	    c.gridwidth = 3;
	    c.insets = new Insets(10, 0, 0, 10);
	    contentPane.add(panel, c);
	}

	private void addDataFileField(Container contentPane) {
		JLabel dataFileLabel = createLabel("Data File: ");

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 3;
		addComponent(contentPane, dataFileLabel, c);
		
		final JTextField dataFileField = new JTextField();
		dataFileField.setColumns(15);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 3;
		addComponent(contentPane, dataFileField, c);
		
		this.dataFileField = dataFileField;
		
		JButton fileBrowserBtn = new JButton();
		fileBrowserBtn.setText("Browser...");
		fileBrowserBtn.setHorizontalAlignment(JButton.CENTER);
		fileBrowserBtn.setPreferredSize(new Dimension(70, COMPONENT_HEIGHT));
		fileBrowserBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            dataFileField.setText(file.getAbsolutePath());
		        }
			}
		});
		fileBrowserBtn.setToolTipText("Choose File");
		c = new GridBagConstraints();
		c.gridx = 3;
		c.gridy = 3;
		contentPane.add(fileBrowserBtn, c);
	}

	private void addDataGroupTypeField(Container contentPane) {
		JLabel dataGroupTypeLabel = createLabel("Data Group Type: ");

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		addComponent(contentPane, dataGroupTypeLabel, c);
		
		
		String[] typeStr = {"Reliability", "Rule", "Identification"};
		this.dataGroupType = new JComboBox<String>(typeStr);
		dataGroupType.setPreferredSize(new Dimension(224, COMPONENT_HEIGHT));
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 2;
		addComponent(contentPane, dataGroupType, c);
	}

	private void addDataGroupNameFiled(Container contentPane) {
		JLabel dataGroupNameLabel = createLabel("Data Group Name: ");

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		addComponent(contentPane, dataGroupNameLabel, c);
		
		this.dataGroupNameField = new JTextField();
		dataGroupNameField.setColumns(20);
	
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 2;
		addComponent(contentPane, dataGroupNameField, c);
	}

	private JLabel createLabel(String text) {
		JLabel result = new JLabel();
		result.setText(text);
		result.setHorizontalAlignment(JLabel.LEADING);
		result.setHorizontalTextPosition(JLabel.LEADING);
		return result;
	}
	
	private void addComponent(Container contentPane, Component comp, GridBagConstraints c) {
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		contentPane.add(comp, c);
	}
	
	private void loadData() {
		
	}
}
