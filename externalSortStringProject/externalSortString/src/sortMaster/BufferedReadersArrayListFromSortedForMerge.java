package sortMaster;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import constatnts.FolderNames;
import createTextFiles.CreateOutputTextFile;

public class BufferedReadersArrayListFromSortedForMerge {

	private String multipleSortedInputFolder = System.getProperty("user.dir") + "\\"
			+ FolderNames.multipleSortedFilesFolder;

	int loadingNumber = 1000;

	LinkedHashMap<String, ArrayList<String>> aal = new LinkedHashMap<>();

	CreateArrayListOfBufferedReaders createArrayListOfBufferedReaders = new CreateArrayListOfBufferedReaders();
	ArrayList<BufferedReader> abr = createArrayListOfBufferedReaders.returnBufferedReaderArrayList();

	CreateOutputTextFile createOutputTextFile = new CreateOutputTextFile();

	/**
	 * Prepare Data structure
	 */
	public void prepareDataStructure() {
		for (File fileName : new File(multipleSortedInputFolder).listFiles()) {
			aal.putIfAbsent(fileName.getName(), new ArrayList<String>());
		}
	}

	/**
	 * Lad all data sorted file -->bufferReader-->ArrayList in LinkedHashMap [loadingNumber data will be loaded]
	 * @return
	 */
	private LinkedHashMap<String, ArrayList<String>> loadAllData() {
		try {

			int i = 0 ;
			for (ArrayList<String> al : aal.values()) {
				for (int j = 0; j < loadingNumber; j++) {
					String toBeeAdded = abr.get(i).readLine();
					if (toBeeAdded != null) {
						al.add(toBeeAdded);
					}
				}
				i++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return aal;
	}

	/**
	 * Main Operation - think and write
	 */
	public void compareAndSendOutput() {
		aal = loadAllData();

		
		
		
		String value = "DUMMY VALUE";

		createOutputTextFile.writeAValueInOutputFile(value);

	}
	

}
