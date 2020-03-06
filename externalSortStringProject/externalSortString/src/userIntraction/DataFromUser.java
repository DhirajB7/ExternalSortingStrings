package userIntraction;

import java.util.Scanner;

import projectHealper.Helper;

public class DataFromUser extends Helper{
	
	private int sizeOfFile;
	private int startNumber;
	private int endNumber;
	
	public int getSizeOfFile() {
		return sizeOfFile;
		
	}
	private void setSizeOfFile(int sizeOfFile) {
		this.sizeOfFile = sizeOfFile;
	}
	public int getStartNumber() {
		return startNumber;
	}
	private void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public int getEndNumber() {
		return endNumber;
	}
	private void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}
	
	/**
	 * Very First Method to run for File Generation.
	 */
	public void setData() {
		Scanner scan = new Scanner(System.in);
		displayLog("Enter Low Number");
		int startNumber = scan.nextInt();
		displayLog("Enter High Number");
		int endNumber = scan.nextInt();
		displayLog("Enter Minimum File Size to be generated in MB");
		int sizeFile = scan.nextInt();
		scan.close();
		setStartNumber(startNumber);
		setEndNumber(endNumber);
		setSizeOfFile(sizeFile);
	}
	
	

}
