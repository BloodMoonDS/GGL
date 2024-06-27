package com.bloodiey.GGL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class FileSaver {
	public void Writefile(String Name, String Content) {
	long currentTimeInMillis = System.currentTimeMillis();
	double identifier = Math.random();
	Date currentDate = new Date(currentTimeInMillis);
	String currentDateTime = currentDate.toString(); 
	boolean logsfolder = new File("logs/").mkdir(  );
	
	
	try {
		PrintWriter writer = new PrintWriter("logs/"+Name+ " " + currentDateTime + " " + identifier +".txt");
		writer.println(Content);
		writer.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "ERROR: "+ e+ "\n (File not found)");
		e.printStackTrace();
	}
	}
}
