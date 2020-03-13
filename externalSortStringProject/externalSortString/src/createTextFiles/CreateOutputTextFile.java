package createTextFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import constatnts.FileNames;
import constatnts.FolderNames;
import projectHealper.Helper;

public class CreateOutputTextFile extends Helper {

private String outputFile = System.getProperty("user.dir")+"\\"+FolderNames.output+"\\"+FileNames.outputSortedFile+".txt";
	
/**
 * Create a output file
 * @param pathName
 */
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
	
	public void writeAValueInOutputFile(String value) {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(new File(outputFile),true));
			br.write(value);
			br.newLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for runner
	 */
	public void createSoretedFile() {
		createAnOutputFile(outputFile);
	}
	
	
	
}
