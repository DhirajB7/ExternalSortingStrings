package driver;

import createTextFiles.CreateInputTextFile;
import createTextFiles.CreateOutputTextFile;
import userIntraction.DataFromUser;
import worker.TextFilesCleaner;

public class RunProject {
	
	/**
	 * Get input file size from user
	 * Return size
	 * @return
	 */
	private int getDataToCreateFile() {
		
		DataFromUser dataFromUser = new DataFromUser();
		
		dataFromUser.setData();
		
		int inputData = dataFromUser.getSizeOfFile();
		
		return inputData;
		
	}
	
	/**
	 * Create input file by using MB specified
	 * Write Random strings in data
	 */
	 void inputFileCreation() {
		int data = getDataToCreateFile();
		CreateInputTextFile createTextFile = new CreateInputTextFile();
		createTextFile.createTextFileInMb(data);
	}
	
	 /**
	  * Create Output file
	  * TO DO : Write Result
	  */
	  void outputFileCreation() {
		CreateOutputTextFile createTextFile = new CreateOutputTextFile();
		createTextFile.createSoretedFile();
	}
	  
	/**
	 * Clears all file in all folder
	 */
	void fliesClear() {
		TextFilesCleaner textFilesCleaner = new TextFilesCleaner();
		textFilesCleaner.clearFiles();
	}
		

}
