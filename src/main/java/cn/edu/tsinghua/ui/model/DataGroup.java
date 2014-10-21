package cn.edu.tsinghua.ui.model;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class DataGroup {
	private final String filePath;
	private List<Data> data;
	
	public DataGroup(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public String getName() {
		return (new File(filePath)).getName();
	}
	
	public List<Data> getDatas() {
		return Collections.unmodifiableList(data);
	}
		
	public void addData(Data data) {
		this.data.add(data);
	}
	
	public static class Data {
		
	}
}
