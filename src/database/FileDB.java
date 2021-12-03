package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import constants.Constants;

public class FileDB {
	
	public List<String> read(String path) {
		
		List<String> listString = new ArrayList<String>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		File file = new File(path);
		
		if(file.exists()) {
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				
				while(bufferedReader.ready()) {
					listString.add(bufferedReader.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listString;
	}
	
	public void write(String pathDirectory, String fileName, List<Object> objects) {
		File directory = new File(pathDirectory);
		File file = new File(pathDirectory + fileName);
		
		if(!directory.exists()) {
			directory.mkdir();
		}
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			Iterator<Object> iterator = objects.iterator();
			
			while(iterator.hasNext()) {
				bufferedWriter.write(iterator.next().toString());
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> read2(String path) {
		File file = new File(path);
		List<String> listString = new ArrayList<String>();
		char[] in = new char[1024];
		int size = 0;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String tmpString = "";
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			size = bufferedReader.read(in);
			
			for(int i = 0; i < size; i++) {
				if(in[i] != '\n' ) {
					tmpString = tmpString + in[i];
				} else {
					listString.add(tmpString);
					tmpString = "";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return listString;
	}

}
