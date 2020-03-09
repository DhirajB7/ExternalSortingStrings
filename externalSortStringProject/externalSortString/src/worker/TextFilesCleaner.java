package worker;

import java.io.File;

import projectHealper.Helper;

public class TextFilesCleaner extends Helper {

	private String inputFolder = System.getProperty("user.dir")+"\\input";
	private String outputFolder = System.getProperty("user.dir")+"\\output";
	private String multipleInputFolder = System.getProperty("user.dir")+"\\multipleInputFilesFolder";
	private String multipleSortedInputFolder = System.getProperty("user.dir")+"\\multipleSortedFilesFolder";
	
	private void removeFilesInFolder(String folderPath) {
		File file = new File(folderPath);
		if(file.listFiles().length > 0) {
		for(File fileInFolder : file.listFiles()) {
			displayLog(fileInFolder.getName() + "Will be Deleted");
			fileInFolder.delete();
		}
		}
		displayLog(folderPath+" good for opertaion");
	}
	
	private void removeInputFile() {
		removeFilesInFolder(inputFolder);
	}
	
	private void removeOutputFile() {
		removeFilesInFolder(outputFolder);
	}
	
	private void removeAllFilesMultipleInputFiles() {
		removeFilesInFolder(multipleInputFolder);
	}
	
	private void removeAllFilesMultipleInputSortedFiles() {
		removeFilesInFolder(multipleSortedInputFolder);
	}
	
	public void clearFiles() {
		removeInputFile();
		removeOutputFile();
		removeAllFilesMultipleInputFiles();
		removeAllFilesMultipleInputSortedFiles();
	}
	
	
}
