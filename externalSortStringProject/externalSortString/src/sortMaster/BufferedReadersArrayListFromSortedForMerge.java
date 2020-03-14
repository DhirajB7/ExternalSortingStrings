package sortMaster;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import constatnts.FolderNames;
import constatnts.LimitSetting;
import createTextFiles.CreateInputTextFile;
import createTextFiles.CreateOutputTextFile;
import projectHealper.Helper;

public class BufferedReadersArrayListFromSortedForMerge extends Helper {

	private String multipleSortedInputFolder = System.getProperty("user.dir") + "\\"
			+ FolderNames.multipleSortedFilesFolder;

	int loadingNumber = Integer.valueOf(LimitSetting.limit_10000.toString().split("_")[1]);

	int sortedFilesNumber = new File(multipleSortedInputFolder).listFiles().length;

	LinkedHashMap<String, ArrayList<String>> aal = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> alIndex = new LinkedHashMap<String, Integer>();

	CreateArrayListOfBufferedReaders createArrayListOfBufferedReaders = new CreateArrayListOfBufferedReaders();
	ArrayList<BufferedReader> abr = createArrayListOfBufferedReaders.returnBufferedReaderArrayList();

	CreateOutputTextFile createOutputTextFile = new CreateOutputTextFile();

	/**
	 * Prepare Data structure
	 */
	private void prepareDataStructure() {
		displayLog("Method name prepareDataStructure");
		for (File fileName : new File(multipleSortedInputFolder).listFiles()) {
			aal.putIfAbsent(fileName.getName(), new ArrayList<String>());
			displayLog("added ArrayList for " + fileName.getName());
		}
		System.out.println("");
	}

	/**
	 * Fills only one ArrayListInMap
	 * 
	 * @param al - arrayList
	 * @param i  - buffered reader arraylist get
	 * @return
	 */
	private ArrayList<String> loadOneArrayList(ArrayList<String> al, int i) {
		int j = 0;
		try {
			for (j = 0; j < loadingNumber; j++) {
				String toBeeAdded = abr.get(i).readLine();
				if (toBeeAdded != null) {
					al.add(toBeeAdded);
				}
			}
		} catch (Exception e) {
			displayLog("[ERROR] ERROR IN METHOD loadOneArrayList reason is " + e.getMessage());
		}
		displayLog("Method name loadOneArrayList - One Array List ready with data read from buffer : " + j);
		return al;
	}

	/**
	 * Lad all data sorted file -->bufferReader-->ArrayList in LinkedHashMap
	 * [loadingNumber data will be loaded]
	 * 
	 * @return
	 */
	private LinkedHashMap<String, ArrayList<String>> loadAllDataFirstTime() {
		prepareDataStructure();
		try {
			int i = 0;
			for (ArrayList<String> al : aal.values()) {
				loadOneArrayList(al, i);
				i++;
			}

			displayLog("==================================================");
			displayLog("Number Of Array List with value from file are " + i);
			displayLog("Number Of Buffered Reader List are " + abr.size());

		} catch (Exception e) {
			displayLog("[ERROR] ERROR IN METHOD LinkedHashMap reason is " + e.getMessage());
		}

		displayLog("LinkedHashMap with filename and list of data are ready and size is : " + aal.size());
		displayLog("==================================================");

		return aal;
	}

	/**
	 * Main Operation - think and write
	 */
	public void compareAndSendOutput() {

		aal = loadAllDataFirstTime();

		String smallestValue = "zzzzzzzzzzzzzzzzzzzzzzzzzzz";

		String smallestFileName = "empty";

		long loopCount = new CreateInputTextFile().getNumberOfLinesInFile();

		for (long i = 0; i < loopCount; i++) {

			for (Entry<String, ArrayList<String>> entryInMap : aal.entrySet()) {

				if (entryInMap.getValue().size() == 0) {
					ArrayList<String> al = loadOneArrayList(entryInMap.getValue(),
							Integer.valueOf(entryInMap.getKey().replace(".txt", "").substring(12)));
					entryInMap.setValue(al);
				}

				String key = entryInMap.getKey();
				ArrayList<String> valueArrayList = entryInMap.getValue();

				if (valueArrayList.size() > 0) {
					if (valueArrayList.get(0).compareTo(smallestValue) < 0) {
						smallestFileName = key;
						smallestValue = valueArrayList.get(0);
					}
				}

			}

			String value = smallestValue;

			createOutputTextFile.writeAValueInOutputFile(value);

			aal.get(smallestFileName).remove(0);

			smallestValue = "zzzzzzzzzzzzzzzzzzzzzzzzzzz";

			smallestFileName = "empty";
		}

	}
}
