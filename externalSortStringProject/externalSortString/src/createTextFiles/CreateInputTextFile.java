package createTextFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

import projectHealper.Helper;

public class CreateInputTextFile extends Helper{
	
	private String inputFile = System.getProperty("user.dir")+"\\input\\inputFile.txt";
	
	public void createTextFileInMb(int fileSize) {
		createAFile(inputFile);
		writeStringToFile(inputFile,fileSize);
		
	}
	
	private void createAFile(String pathName) {
		File file = new File(pathName);
		try {
			if(!file.createNewFile()) {
				file.delete();
				createAFile(pathName);
				displayLog("Input File Deleted , Created again and path is "+pathName);
			}
		} catch (Exception e) {
			displayLog("ERROR IN METHOD createAFile "+ pathName + " error is : "+e.getMessage());
		}
	}
	
	private void writeStringToFile(String pathName,int mbSize) {
		try {
			File file = new File(pathName);
			FileWriter fileWritter = new FileWriter(file,true);
			BufferedWriter fw = new BufferedWriter(fileWritter);
			while(file.length()<mbSize*1024*1024) {
				fw.write(UUID.randomUUID().toString().replaceAll("[0-9-]", ""));
				fw.newLine();
			}
			fw.close();
			displayLog("Input File Size in MB : "+file.length()/(1024*1024));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			displayLog("ERROR IN METHOD writeStringToFile " + e.getMessage() );
		}
	}
	

}
