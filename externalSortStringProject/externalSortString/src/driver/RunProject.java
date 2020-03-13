package driver;

import createTextFiles.CreateInputTextFile;
import createTextFiles.CreateOutputTextFile;
import sortMaster.BufferedReadersArrayListFromSortedForMerge;
import userIntraction.DataFromUser;
import worker.FileSplitDecider;
import worker.TakeFilesSortStore;
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
	 * Clears all file in all folder
	 */
	void fliesClear() {
		TextFilesCleaner textFilesCleaner = new TextFilesCleaner();
		textFilesCleaner.clearFiles();
	}
		
	/**
	 * One Big file to many Small files in a folder
	 */
	void oneIputFileToMultipleInputFile() {
		FileSplitDecider fsd = new FileSplitDecider();
		fsd.makeFilesFromInputFile();
	}
	
	/**
	 * Small files to Sorted small files
	 */
	void takeAFileSortPlaceInOtherFolder() {
		TakeFilesSortStore tss = new TakeFilesSortStore();
		tss.takeAllFileAndSort();
	}
	
	 /**
	  * Create Output file
	  * loads Data for first time
	  */
	  void outputFileCreation() {
		CreateOutputTextFile createTextFile = new CreateOutputTextFile();
		createTextFile.createSoretedFile();
	  }
	  
	 void bufferedReaderToArrayListsCompareAndwrite() {
		 BufferedReadersArrayListFromSortedForMerge bufferedReadersArrayListFromSortedForMerge = new BufferedReadersArrayListFromSortedForMerge();
		 bufferedReadersArrayListFromSortedForMerge.compareAndSendOutput();
	 }
}
