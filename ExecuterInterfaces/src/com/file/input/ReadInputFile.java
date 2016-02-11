package com.file.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadInputFile {
	
	private FileInputStream fstream;
	private String filepath;
	private BufferedReader br;
	public ReadInputFile(String path) {
		filepath = path;
	}
	
	public String readLines() throws IOException {
		return br.readLine();
	}

	public void setup() {
		try {
			fstream = new FileInputStream("C:/textfile.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void closeFile() {
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}