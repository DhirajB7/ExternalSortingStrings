package driver;

import createTextFiles.CreateInputTextFile;
import createTextFiles.CreateOutputTextFile;
import userIntraction.DataFromUser;
import worker.TextFilesCleaner;

public class RunProject {
	
	private int getDataToCreateFile() {
		
		DataFromUser dataFromUser = new DataFromUser();
		
		dataFromUser.setData();
		
		int inputData = dataFromUser.getSizeOfFile();
		
		return inputData;
		
	}
	
	 void inputFileCreation() {
		int data = getDataToCreateFile();
		CreateInputTextFile createTextFile = new CreateInputTextFile();
		createTextFile.createTextFileInMb(data);
	}
	
	  void outputFileCreation() {
		CreateOutputTextFile createTextFile = new CreateOutputTextFile();
		createTextFile.createSoretedFile();
	}
	  
	void fliesClear() {
		TextFilesCleaner textFilesCleaner = new TextFilesCleaner();
		textFilesCleaner.clearFiles();
	}
		

}
