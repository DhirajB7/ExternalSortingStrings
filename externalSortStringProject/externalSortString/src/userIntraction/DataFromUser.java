package userIntraction;

import java.util.Scanner;

import projectHealper.Helper;

public class DataFromUser extends Helper{
	
	private int sizeOfFile;
	
	/**
	 * getter size of file
	 * @return
	 */
	public int getSizeOfFile() {
		return sizeOfFile;
		
	}
	
	/**
	 * setter size of file
	 * @param sizeOfFile
	 */
	private void setSizeOfFile(int sizeOfFile) {
		this.sizeOfFile = sizeOfFile;
	}
	
	
	/**
	 * Very First Method to run for File Generation.
	 */
	public void setData() {
		Scanner scan = new Scanner(System.in);
		System.out.println(" ");
		displayLog("=====================================");
		displayLog("Enter File Size to be generated in MB");
		displayLog("=====================================");
		int sizeFile = scan.nextInt();
		scan.close();
		setSizeOfFile(sizeFile);
	}
	
	

}
