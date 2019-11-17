package workshop2.registry;

import java.io.*;

/***
 * Credit to Mkyong for helping with how to write Objects to a File in Java. 
 * @author cusatelli
 * @version 2.0
 * @see https://www.mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
 */
public class FileHandler {
    private String path;
    
    public FileHandler(String path) {
        this.path = path + ".dat";
    }
    
    /**
     * FileOutputStream is meant for writing streams of raw bytes such as image data. 
     * In order to enable writing of objects into a file using ObjectOutputStream, 
     * it is required to implement the java.io.Serializable.
     * 
     * @param
     * @throws Exception
     * @version 2.0
     * @author cusatelli
     * @throws Exception 
     */
    public void writeToFile(Object object) throws Exception {
    	FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }
    
    /**
     * FileInputStream is meant for reading streams of raw bytes such as image data.On reading objects, 
     * the ObjectInputStream directly tries to map all the attributes into the class 
     * into which we try to cast the read object. If it is unable to map the respective 
     * object exactly then it throws a ClassNotFound exception.
     * 
     * @return Object
     * @throws Exception
     * @version 2.0
     * @author cusatelli
     * @throws ClassNotFoundException 
     */
    public Object readFromFile() throws Exception {
    	FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();

        return object;
    }
    
    /**
     * Instantiate a new File(String pathname) & check whether or 
     * not the file exists & if it is readable by the system.
     * 
     * @return True if file exits & is readable
     * @version 2.0
     * @author cusatelli
     */
    public boolean containsReadableFile() {
        File file = new File(path);
        return file.isFile() && file.canRead();
    }
}
