package cn.edu.tsinghua.ui.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import cn.edu.tsinghua.util.Constant;
import cn.edu.tsinghua.util.FileUtil;

public class Project {
	
	private final String rootPath;
	private final String name;
	
	public Project(String projectName) {
		this.name = projectName;
		this.rootPath = FileUtil.formatFilePath(System.getProperty("user.home")) 
				+ Constant.FILE_SEPARATOR + Constant.BASE_FOLDER_NAME 
				+ Constant.FILE_SEPARATOR + projectName; 
		init();
	}
	
	public Project(File proFile) {
		Properties prop = new Properties();
		InputStream in;
		try {
			in = new FileInputStream(proFile);
			prop.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.rootPath = prop.getProperty("root");
		this.name = prop.getProperty("name");
		init();
	}
	
	public String getProjectRoot() {
		return rootPath;
	}
	
	public String getName() {
		return name;
	}
	
	private void init() {
		File rootFolder = new File(this.rootPath);
		rootFolder.mkdirs();
		
		File projectFile = new File(rootFolder, "project.stp");
		FileUtil.write("root=" + FileUtil.formatFilePath(this.rootPath) + "\n", projectFile, true);
		FileUtil.write("name=" + this.name + "\n", projectFile, true);
	}
}
