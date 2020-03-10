package worker;

import java.io.File;

import constatnts.FileNames;
import constatnts.FolderNames;

public class FileSplitDecider {
	
	private int getSizeOfEachFileInMb() {
		 String inputFile = System.getProperty("user.dir")+"\\"+FolderNames.input+"\\"+FileNames.inputFile+".txt";
		 long inputFileSize = new File(inputFile).length()/(1024*1024);
		 if(inputFileSize <= 50) {
			 return 1;
		 }
		 else if(inputFileSize > 50 && inputFileSize <= 100) {
			 return 10;
		 }else if(inputFileSize > 100 && inputFileSize <= 1000) {
			 return 100;
		 }else {
			 return 500;
		 }
	}
	
	
	
	
}
