package cn.edu.tsinghua.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 14-2-13
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class ObjectSerializationUtil {
    private static Logger logger = LoggerFactory.getLogger(ObjectSerializationUtil.class);

    //write LogReportResult to file
    public static void writeReportResult(String fileName,Object object){
        String logFilePath = Constants.OBJECT_SERIALIZATION_STORAGE_PATH + fileName;
        try {
            File file = new File(Constants.OBJECT_SERIALIZATION_STORAGE_PATH);
            if(!file.exists()){
                file.mkdir();
            }
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(logFilePath));
            outputStream.writeObject(object);
            outputStream.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    //read LogReportResult from file
    public static Object readReportResult(String fileName){
        Object object = null;
        String logFilePath = Constants.OBJECT_SERIALIZATION_STORAGE_PATH + fileName;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(logFilePath));
            object = inputStream.readObject();
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
        return  object;
    }

    public static void main(String[] args) {

    }
}
