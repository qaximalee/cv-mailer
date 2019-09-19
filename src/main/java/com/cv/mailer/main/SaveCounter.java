package com.cv.mailer.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class SaveCounter {

	public void save(int counter) {
		try {
			// What ever the file path is.
			File f = new File("D:/function.txt");
			FileOutputStream is = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			Writer w = new BufferedWriter(osw);
			w.write(""+counter);
			w.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file function.txt");
			e.printStackTrace();
		}
	}
	
	public int getCounter(){
		int counter = 0;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"D:/function.txt"));
			String line = reader.readLine();
			counter = Integer.parseInt(line.trim());
			/*while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
				counter = Integer.parseInt(line.trim());
			}*/
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return  counter = 0;
		}		
		return counter;
	}
}
