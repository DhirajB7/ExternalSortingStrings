package worker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import constatnts.FileNames;
import constatnts.FolderNames;
import projectHealper.Helper;

public class FileSplitDecider extends Helper{
	
	private String inputFile = System.getProperty("user.dir")+"\\"+FolderNames.input+"\\"+FileNames.inputFile+".txt";
	
	/**
	 * Get number - this number informs size of each file in mb for next operations
	 * 
	 * @return
	 */
	private int getSizeOfEachFileInMb() {
		
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
	
	/**
	 * Actual implementation of One Big input file to multiple smaller files
	 */
	public void makeFilesFromInputFile() {
		try {
			int sizeOfEachFile = getSizeOfEachFileInMb();
			
			
			CreateTrasitionTextFile fileCreate = new CreateTrasitionTextFile();
			
			int i =0;
			String fileName = "file_"+i;
			File file = fileCreate.createAfile(fileName);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line = br.readLine();
			while(line!=null) {
				if(! (file.length()/(1024*1024) < sizeOfEachFile)) {
					bw.close();
					i++;
					fileName = "file_"+i;
					file = fileCreate.createAfile(fileName);
					bw = new BufferedWriter(new FileWriter(file));
				}
				bw.write(line);
				bw.newLine();
				line = br.readLine();
			}
			bw.close();
			br.close();
			System.out.println("");
			displayLog("=================================================================================================");
			displayLog("One input File to Multiple Input file operation completed and each file is "+sizeOfEachFile+" MB.");
			displayLog("==================================================================================================");
			System.out.println("");
		} catch (Exception e) {
			displayLog("[ERROR] "+ e.getLocalizedMessage());
		}
		
		
	}
	
	
	
	
}
