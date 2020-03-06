package driver;

import createData.CreateTextFile;
import userIntraction.DataFromUser;

public class RunProject {
	
	private int getDataToCreateFile() {
		
		DataFromUser dataFromUser = new DataFromUser();
		
		dataFromUser.setData();
		
		int inputData = dataFromUser.getSizeOfFile();
		
		return inputData;
		
	}
	
	private  void fileCreation() {
		int data = getDataToCreateFile();
		CreateTextFile createTextFile = new CreateTextFile();
		createTextFile.createTextFileInMb(data);
	}
	
	public static void main(String[] args) {
	
		RunProject runner = new RunProject();
		
		
		runner.fileCreation();
		
	}

}
