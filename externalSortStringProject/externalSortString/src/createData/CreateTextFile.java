package createData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import projectHealper.Helper;

public class CreateTextFile extends Helper{
	
	private String inputFile = System.getProperty("user.dir")+"\\files\\inputFile.txt";
	
	public void createTextFileInMb(int[] dataArray) {
		createAFile(inputFile);
		writeNumbersInToFile(inputFile,dataArray[0],dataArray[1],dataArray[2]);
		
		
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
	
	private void writeNumbersInToFile(String pathName,int lowerNumber,int higherNumber,int mbSize) {
		
		try {
			int eachMb = 400000;// 1-9 min size is mbSize
			Random random = new Random();
			BufferedWriter fw = new BufferedWriter(new FileWriter(pathName,true));
			for(int i = 0 ; i <= mbSize*eachMb ;i++) {
				fw.write(String.valueOf(random.nextInt(higherNumber-lowerNumber)+lowerNumber)+"\n");
			}
			fw.close();
			displayLog("File is created and Size in MB : "+new File(pathName).length()/(1024*1024));
		} catch (Exception e) {
			displayLog("ERROR IN METHOD writeNumbersInToFile "+ pathName + " error is : "+e.getMessage());
		}
		
		
	}

}
