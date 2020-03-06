package createData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

import projectHealper.Helper;

public class CreateTextFile extends Helper{
	
	private String inputFile = System.getProperty("user.dir")+"\\files\\inputFile.txt";
	
	public void createTextFileInMb(int fileSize) {
		createAFile(inputFile);
		writeStringToFile(inputFile,fileSize);
		
	}
	
	private void createAFile(String pathName) {
		File file = new File(pathName);
		try {
			if(file.createNewFile()) {
				displayLog("File Created and path is "+pathName);
			}else {
				System.out.println("File Already Created in path "+pathName);
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
			displayLog("File is created and Size in MB : "+file.length()/(1024*1024));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			displayLog("ERROR IN METHOD writeStringToFile " + e.getMessage() );
		}
	}
	

}
