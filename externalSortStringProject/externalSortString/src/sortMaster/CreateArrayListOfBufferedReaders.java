package sortMaster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import constatnts.FolderNames;

public class CreateArrayListOfBufferedReaders {

	private String multipleSortedInputFolder = System.getProperty("user.dir") + "\\"
			+ FolderNames.multipleSortedFilesFolder;

	ArrayList<BufferedReader> abr = new ArrayList<BufferedReader>();

	 ArrayList<BufferedReader> returnBufferedReaderArrayList() {
		try {
		for(File file: new File(multipleSortedInputFolder).listFiles()) {
			
				abr.add(new BufferedReader(new FileReader(file)));
				
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	return abr;
		
	}
}
