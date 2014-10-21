package cn.edu.tsinghua.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	public static void write(String content, File file, boolean append) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, append);
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				writer = null;
			}
		}
	}
	
	public static String getFileExtension(File file) {
		int separator = file.getName().lastIndexOf(Constant.FILE_EXTENSION_SEPARATOR);
		return file.getName().substring(separator + 1);
	}
	
	public static String formatFilePath(String filePath) {
		if (!Constant.WIN_FILE_SEPARATOR.equals(System.getProperty("file.separator"))) {
			return filePath.replaceAll(Constant.WIN_FILE_SEPARATOR + Constant.WIN_FILE_SEPARATOR
					, Constant.FILE_EXTENSION_SEPARATOR);
		}
		return filePath;
	}
}
