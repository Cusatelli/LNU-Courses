package workshop2.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
	private String path;

	public FileHandler(String path) {
		this.path = path;
	}

	public void save(Object object) throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(path);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(object);
		objectOutputStream.close();
	}

	public Object read() throws Exception {
		FileInputStream fileInputStream = new FileInputStream(path);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);		
		Object result = objectInputStream.readObject();
		objectInputStream.close();

		return result;
	}

	public boolean exists() {
		File file = new File(path);
		return file.isFile() && file.canRead();
	}
}
