/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party.util
 *
 */
package project.party.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.bukkit.Bukkit;

import project.party.PartyPermsMain;
import project.party.lib.References;
import static project.party.util.FileUtil.writeTo;
import static project.party.util.LogUtil.logError;

/**
 * Created: Jul 28, 2014 <br>
 * Time: 4:50:05 PM <br>
 * Year: 2014 <p>
 *
 * By: 598Johnn897 <p>
 * 
 * Project: PartyPerms <br>
 * File: CrashUtil.java <br>
 * Package: project.party.util <p>
 * 
 * @author 598Johnn897
 */
public class CrashUtil {

	private static PartyPermsMain plugin = PartyPermsMain.get();

	public static void handleCrash(Exception e) {
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);

		File theDir = new File(plugin.getDataFolder().getAbsolutePath());
		File theOtherDir = new File(plugin.getDataFolder().getAbsolutePath()
				+ References.CRASH_FOLDER_PATH_EXT);
		if (!theDir.exists()) {
			try {
				theDir.mkdir();
				theOtherDir.mkdir();
			} catch (SecurityException se) {
				se.printStackTrace();
			}
		}
		File file = new File(plugin.getDataFolder()
				+ References.CRASH_FOLDER_PATH_EXT, String.format(
				"crash-%d-%02d-%02d %02d.%02d", year, day, month + 1, hour,
				minute)
				+ References.CRASH_FILE_FORMAT);
		if (!file.exists()) {
			try {
				file.createNewFile();
				writeTo(file,
						String.format("crash-%d-%02d-%02d %02d.%02d \n", year,
								day, month + 1, hour, minute) + e.toString());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		logError(References.NAME
				+ ": An Error Has Occured During Start Up! Crash Exceptions Can Be Found At: "
				+ plugin.getDataFolder().getAbsolutePath());
		Bukkit.getPluginManager().disablePlugin(plugin);
	}
}
