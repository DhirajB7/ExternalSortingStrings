package worker;

import java.io.File;
import constatnts.FolderNames;
import projectHealper.Helper;

public class CreateTrasitionTextFile extends Helper{

	/**
	 * Creates File in multipleInputFilesFolder folder
	 * @param fileName
	 * @return
	 */
	File createAfile(String fileName) {
		String filePath = System.getProperty("user.dir")+"\\"+FolderNames.multipleInputFilesFolder+"\\"+fileName+".txt";
		File file = new File(filePath);
		try {
			file.createNewFile();
			displayLog(fileName +" file created");
		} catch (Exception e) {
			displayLog("[ERROR] "+fileName + " file not created "+ e.getLocalizedMessage());
		}
		return file;
	}
	
}
