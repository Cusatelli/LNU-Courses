package workshop2.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
	private String path;
	private File file;
	
	public FileHandler(String path) {
		this.path = path;
		file = new File(this.path + ".dat");
	}
	
	public void writeToFile(Object object) {
		ObjectOutputStream objectOutputStream;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			objectOutputStream.writeObject(object);
			objectOutputStream.close();
		
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}
	
	public Object readFromFile() {
		ObjectInputStream objectInputStream;
		Object object = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(file));
			object = objectInputStream.readObject();
		
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public boolean containsFile() {
		return file.isFile() && file.canRead();
	}
}
