package worker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import constatnts.FolderNames;
import projectHealper.Helper;

public class TakeFilesSortStore extends Helper{

	private String sourceFolder = System.getProperty("user.dir")+"\\"+FolderNames.multipleInputFilesFolder;
	private String destinationFolder = System.getProperty("user.dir")+"\\"+FolderNames.multipleSortedFilesFolder;
	
	/**
	 * One File  
	 * sort it
	 * make new file under destination folder
	 * @param fileInput
	 * @return
	 */
	private File takeOneFileSortPlace(File fileInput) {
		
		String inputFileName = fileInput.getName();
		String outputFileName = "sorted_"+inputFileName;
		
		File fileOutput = new File(destinationFolder+"\\"+outputFileName);
		
		ArrayList<String> al = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileInput));
			String line = br.readLine();
			while(line!=null) {
				al.add(line);
				line = br.readLine();
			}
			br.close();
			
			Collections.sort(al);
			
			fileOutput.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileOutput));
			
			for(String a: al) {
				bw.write(a);
				bw.newLine();
			}
			
			bw.close();
			al.clear();
			
		} catch (Exception e) {
			displayLog("[ERROR] "+e.getMessage());
		}
		displayLog(outputFileName+" created.");
		return fileOutput; 
	}
	
	/**
	 * For all Files
	 */
	public void takeAllFileAndSort() {
	
		File folder = new File(sourceFolder);
		
		for(File fileFromSource : folder.listFiles()) {
			takeOneFileSortPlace(fileFromSource);
		}
		
		displayLog("All Files are sorted\n");
	}
	
	
}
