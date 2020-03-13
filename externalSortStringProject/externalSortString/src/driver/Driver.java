package driver;

import projectHealper.Helper;

public class Driver extends Helper{

	/**
	 * MAIN METHOD - EXECUTE HERE
	 * @param args
	 */
	public static void main(String[] args) {
		RunProject driverProject = new RunProject();
		driverProject.fliesClear();
		driverProject.inputFileCreation();
		driverProject.oneIputFileToMultipleInputFile();
		driverProject.takeAFileSortPlaceInOtherFolder();
		driverProject.outputFileCreation();
		driverProject.bufferedReaderToArrayListsCompareAndwrite();
		
		displayLog("EXECUION COMPLETED");
		
	}
}
