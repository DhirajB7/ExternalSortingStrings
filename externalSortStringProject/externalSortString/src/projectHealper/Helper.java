package projectHealper;

import java.sql.Timestamp;


public class Helper {

	public static void displayLog(String msg) {
		System.out.println(new Timestamp(System.currentTimeMillis()).toString()+" : "+msg);
	}
}
