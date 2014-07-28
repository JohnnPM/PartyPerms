/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party
 *
 */
package project.party;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import project.party.commands.CommandFramework;
import project.party.config.Config;
import project.party.lib.References;
import project.party.sql.MySQL;

/**
 * Created: Jul 28, 2014 <br>
 * Time: 3:24:58 PM <br>
 * Year: 2014 <p>
 *
 * By: 598Johnn897 <p>
 * 
 * Project: PartyPerms <br>
 * File: PartyPermsMain.java <br>
 * Package: project.party <p>
 * 
 * @author 598Johnn897
 */
public class PartyPermsMain extends JavaPlugin {

	private static PartyPermsMain plugin;
	public static PartyPermsMain get() {
		return plugin;
	}
	
	private File configFile;
	private Config config;
	public Config getPartyConfig() {
		return config;
	}
	
	private MySQL database = new MySQL(this, "127.0.0.1", "3306", "ProjectParty", "root", "projectparty");
	public MySQL getSQLDatabase(){
		return database;
	}
	private Connection connection;
	public Connection getConnection(){
		return connection;
	}
	
	private CommandFramework framework;

	private int start;
	private int end;
	
	@Override
	public void onLoad() {
		try {
			plugin = this;
			framework = new CommandFramework(this);
			start = (int) System.currentTimeMillis();
		} catch (Exception e) {
			handleCrash(e);
		}
	}

	@Override
	public void onEnable() {
		try {
			if (plugin == null) plugin = this;
			
			framework.registerCommands();
			framework.registerHelp();
			
			File folder = getDataFolder();
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			configFile = new File(folder, "config.txt");
			if (!configFile.exists()) {
				this.saveResource("config.txt", false);
			}
			config = new Config(configFile);
			
		} catch (Exception e) {
			handleCrash(e);
		} finally {
			end = (int) (System.currentTimeMillis() - start);
			log(String.format("%s has enabled. [%d]", References.NAME, end));
		}
	}

	@Override
	public void onDisable() {
		try {

		} catch (Exception e) {
			handleCrash(e);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender,
			org.bukkit.command.Command command, String label, String[] args) {
		return framework.handleCommand(sender, label, command, args);
	}

	public void handleCrash(Exception e) {
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
		Bukkit.getPluginManager().disablePlugin(this);
	}

	public void log(String msg) {
		Bukkit.getLogger().log(Level.INFO, ChatColor.stripColor(msg));
	}

	public void logWarn(String msg) {
		Bukkit.getLogger().log(Level.WARNING, ChatColor.stripColor(msg));
	}

	public void logError(String msg) {
		Bukkit.getLogger().log(Level.SEVERE, ChatColor.stripColor(msg));
	}

	public static HashMap<File, BufferedWriter> writers = new HashMap<File, BufferedWriter>();

	public BufferedWriter getBufferedWriter(File f) {
		try {
			if (writers.containsKey(f)) {
				return writers.get(f);
			} else {
				BufferedWriter returns = new BufferedWriter(new FileWriter(f,
						true));
				writers.put(f, returns);
				return returns;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void writeTo(File f, String message) {
		try {
			if (!f.exists()) {
				f.getParentFile().mkdirs();
				f.createNewFile();
			}
			BufferedWriter br = getBufferedWriter(f);
			br.write(message);
			br.newLine();
			br.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
