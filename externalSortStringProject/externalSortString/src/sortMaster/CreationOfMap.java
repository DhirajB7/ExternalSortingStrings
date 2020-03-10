package sortMaster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;

import constatnts.FolderNames;

public class CreationOfMap {

	private LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
	private String SortedFolder = System.getProperty("user.dir") + "\\" + FolderNames.multipleSortedFilesFolder;

	private void loadAllvaluesToMap() {
		try {
			File sortedFolderFiles = new File(SortedFolder);
			BufferedReader br;
			for (File aFile : sortedFolderFiles.listFiles()) {
				br = new BufferedReader(new FileReader(aFile));
				String data = br.readLine();
				if(br!=null) {
					lhm.putIfAbsent(aFile.getName(), data);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	LinkedHashMap<String, String> getFileDataMap(){
		loadAllvaluesToMap();
		return lhm;
		
	}

}
