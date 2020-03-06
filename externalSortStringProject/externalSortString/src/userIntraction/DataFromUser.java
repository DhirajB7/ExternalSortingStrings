package userIntraction;

import java.util.Scanner;

import projectHealper.Helper;

public class DataFromUser extends Helper{
	
	private int sizeOfFile;
	
	public int getSizeOfFile() {
		return sizeOfFile;
		
	}
	private void setSizeOfFile(int sizeOfFile) {
		this.sizeOfFile = sizeOfFile;
	}
	
	
	/**
	 * Very First Method to run for File Generation.
	 */
	public void setData() {
		Scanner scan = new Scanner(System.in);
		displayLog("Enter File Size to be generated in MB");
		int sizeFile = scan.nextInt();
		scan.close();
		setSizeOfFile(sizeFile);
	}
	
	

}
