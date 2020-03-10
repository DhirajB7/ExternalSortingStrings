package driver;

public class Driver{

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
	}
}
