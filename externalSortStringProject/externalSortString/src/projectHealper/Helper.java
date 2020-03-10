package projectHealper;

import java.sql.Timestamp;


public class Helper {

	/**
	 * Custom Logs
	 * @param msg
	 */
	public static void displayLog(String msg) {
		System.out.println(new Timestamp(System.currentTimeMillis()).toString()+" : "+msg);
	}
}
