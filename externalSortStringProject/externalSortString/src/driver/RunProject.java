package driver;

import createData.CreateTextFile;
import userIntraction.DataFromUser;

public class RunProject {
	
	private int[] getDataToCreateFile() {
		
		int[] inputData = new int[3];
		
		DataFromUser dataFromUser = new DataFromUser();
		
		dataFromUser.setData();
		
		inputData[0] = dataFromUser.getStartNumber();
		inputData[1] = dataFromUser.getEndNumber();
		inputData[2] = dataFromUser.getSizeOfFile();
		
		return inputData;
		
	}
	
	private  void fileCreation() {
		int[] data = getDataToCreateFile();
		CreateTextFile createTextFile = new CreateTextFile();
		createTextFile.createTextFileInMb(data);
	}
	
	public static void main(String[] args) {
	
		RunProject runner = new RunProject();
		
		
		runner.fileCreation();
		
	}

}
