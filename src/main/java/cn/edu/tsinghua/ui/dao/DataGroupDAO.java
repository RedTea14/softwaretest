package cn.edu.tsinghua.ui.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.edu.tsinghua.ui.model.DataGroup;
import cn.edu.tsinghua.ui.model.Project;
import cn.edu.tsinghua.util.Constant;

public class DataGroupDAO {
	public static List<DataGroup> getAllDataGroupsInProject(Project pro) {
		List<DataGroup> result = new ArrayList<DataGroup>();
		if (pro == null) {
			return result;
		}
		String proRootPath = pro.getProjectRoot();
		String dataPath = proRootPath + Constant.FILE_SEPARATOR + Constant.DATA_PATH;
		File dataFolder = new File(dataPath);
		File[] dataGroups = dataFolder.listFiles();
		for (int i = 0; i < dataGroups.length; i++) {
			if (dataGroups[i].isDirectory()) {
				result.add(new DataGroup(dataGroups[i].getPath()));
			}
		}
		return result;
	}
}
