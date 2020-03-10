package worker;

import java.io.File;

import constatnts.FolderNames;
import projectHealper.Helper;

public class TextFilesCleaner extends Helper {

	private String inputFolder = System.getProperty("user.dir")+"\\"+FolderNames.input;
	private String outputFolder = System.getProperty("user.dir")+"\\"+FolderNames.output;
	private String multipleInputFolder = System.getProperty("user.dir")+"\\"+FolderNames.multipleInputFilesFolder;
	private String multipleSortedInputFolder = System.getProperty("user.dir")+"\\"+FolderNames.multipleSortedFilesFolder;
	
	/**
	 * Nukes all files for gives folder path
	 * @param folderPath
	 */
	private void removeFilesInFolder(String folderPath) {
		File file = new File(folderPath);
		if(file.listFiles().length > 0) {
		for(File fileInFolder : file.listFiles()) {
			displayLog(fileInFolder.getName() + " will be Deleted");
			fileInFolder.delete();
		}
		}
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
	
	/**
	 * Nuke on all folders!!
	 */
	public void clearFiles() {
		removeInputFile();
		removeOutputFile();
		removeAllFilesMultipleInputFiles();
		removeAllFilesMultipleInputSortedFiles();
	}
	
	
}
