package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "us-500.csv";
		File file = new File(fileName);
		//file.lastModified();
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] value = data.split(",");
				System.out.println(value[7]);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
