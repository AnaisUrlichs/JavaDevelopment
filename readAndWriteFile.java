package com.srccodes.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileGenerator {
	public static void main(String[] args) {
		createFile();
		readFile();
	}
		
		
	public static void createFile() {
		try {
		File file = new File("fileName.txt");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		PrintWriter pw = new PrintWriter(file);
		pw.println("this is my file content");
		pw.close();
		System.out.println("Done");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("fileName.txt"));
			String line;
			
			while ((line = br.readLine())!= null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
