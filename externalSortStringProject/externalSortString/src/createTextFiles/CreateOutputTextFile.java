package createTextFiles;

import java.io.File;

import constatnts.FileNames;
import constatnts.FolderNames;
import projectHealper.Helper;

public class CreateOutputTextFile extends Helper {

private String outputFile = System.getProperty("user.dir")+"\\"+FolderNames.output+"\\"+FileNames.outputSortedFile+".txt";
	
	private void createAnOutputFile(String pathName) {
		File file = new File(pathName);
		try {
			if(!file.createNewFile()) {
				file.delete();
				createAnOutputFile(pathName);
				displayLog("Output File Deleted , Created again and path is "+pathName);
			}
		} catch (Exception e) {
			displayLog("ERROR IN METHOD createAnOutputFile "+ pathName + " error is : "+e.getMessage());
		}
	}
	
	public void createSoretedFile() {
		createAnOutputFile(outputFile);
	}
	
	
	
}
