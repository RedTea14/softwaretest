package cn.edu.tsinghua.ui.actionlistener.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import cn.edu.tsinghua.ui.Menubar;
import cn.edu.tsinghua.ui.UIContext;
import cn.edu.tsinghua.ui.dao.DataGroupDAO;
import cn.edu.tsinghua.ui.model.DataGroup;
import cn.edu.tsinghua.ui.model.Project;
import cn.edu.tsinghua.util.Constant;
import cn.edu.tsinghua.util.FileUtil;

public class OpenProjectListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.addChoosableFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "*" + Constant.FILE_EXTENSION_SEPARATOR 
						+ Constant.PROJECT_FILE_EXTENSION;
			}
			
			@Override
			public boolean accept(File f) {
				String extension = Constant.FILE_EXTENSION_SEPARATOR 
						+ Constant.PROJECT_FILE_EXTENSION;
				return f.getName().endsWith(extension);
			}
		});
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if(isValidProjectFile(file)) {
            	UIContext.project = new Project(file);
            }
        }
		
		List<DataGroup> dataGroups = DataGroupDAO.getAllDataGroupsInProject(UIContext.project);
		for(DataGroup dataGroup : dataGroups) {
			Menubar.addDataGroup(dataGroup.getName());
		}
	}
	
	private static boolean isValidProjectFile(File file) {
		String fileExt = FileUtil.getFileExtension(file);
		boolean isProjectFile = Constant.PROJECT_FILE_EXTENSION.equalsIgnoreCase(fileExt);
		return isProjectFile;
	}
	
}
