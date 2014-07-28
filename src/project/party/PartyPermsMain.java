/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party
 *
 */
package project.party;

import static project.party.util.CrashUtil.handleCrash;
import static project.party.util.LogUtil.log;

import java.io.File;
import java.sql.Connection;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import project.party.commands.CommandFramework;
import project.party.config.Config;
import project.party.lib.References;
import project.party.sql.MySQL;

/**
 * Created: Jul 28, 2014 <br>
 * Time: 3:24:58 PM <br>
 * Year: 2014
 * <p>
 * 
 * By: 598Johnn897
 * <p>
 * 
 * Project: PartyPerms <br>
 * File: PartyPermsMain.java <br>
 * Package: project.party
 * <p>
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

	private MySQL database = null;

	public MySQL getSQLDatabase() {
		return database;
	}

	private Connection connection;

	public Connection getConnection() {
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
			if (plugin == null)
				plugin = this;

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

			if (database == null)
				database = new MySQL(this,
						config.getString("SQL DATABASE.hostname"),
						config.getString("SQL DATABASE.port"),
						config.getString("SQL DATABASE.database"),
						config.getString("SQL DATABASE.username"),
						config.getString("SQL DATABASE.password"));

			connection = database.openConnection();

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
}
