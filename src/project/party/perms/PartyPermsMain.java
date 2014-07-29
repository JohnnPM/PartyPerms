/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party
 *
 */
package project.party.perms;

import static project.party.perms.util.CrashUtil.handleCrash;
import static project.party.perms.util.LogUtil.log;

import java.io.File;
import java.sql.Connection;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import project.party.perms.commands.CommandFramework;
import project.party.perms.commands.CommandFramework.ClassEnumerator;
import project.party.perms.config.Config;
import project.party.perms.handlers.PartyInvHandler;
import project.party.perms.lib.References;
import project.party.perms.sql.MySQL;
import project.party.perms.storage.Storage;

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
public class PartyPermsMain extends JavaPlugin implements Listener {

	private static PartyPermsMain plugin;

	public static PartyPermsMain get() {
		return plugin;
	}

	private PartyInvHandler invHandler;

	public PartyInvHandler getPartyInvHandler() {
		return invHandler;
	}

	private Storage storage;

	public Storage getStorage() {
		return storage;
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
			invHandler = new PartyInvHandler();
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
			this.registerEvents();

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
			log(String.format("%s has enabled. [%dms]", References.NAME, end));
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

	/**
	 * Dynamically registers all listeners/events in project.
	 */
	public void registerEvents() {
		Class<?>[] classes = ClassEnumerator.getInstance()
				.getClassesFromThisJar(plugin);
		if (classes == null || classes.length == 0) {
			return;
		}
		plugin.getLogger().log(Level.INFO, "Starting registration of events:");
		for (Class<?> c : classes) {
			try {
				if (Listener.class.isAssignableFrom(c) && !c.isInterface()
						&& !c.isEnum() && !c.isAnnotation()) {
					if (JavaPlugin.class.isAssignableFrom(c)) {
						if (plugin.getClass().equals(c)) {
							plugin.getLogger().log(Level.INFO,
									"Searching class: " + c.getSimpleName());
							Bukkit.getPluginManager().registerEvents(plugin,
									plugin);
						}
					} else {
						plugin.getLogger().log(Level.INFO,
								"Searching class: " + c.getSimpleName());
						Bukkit.getPluginManager().registerEvents(
								(Listener) c.newInstance(), plugin);
						;
					}
				}
			} catch (IllegalAccessException | InstantiationException e) {
				plugin.getLogger().log(
						Level.INFO,
						c.getSimpleName()
								+ " does not use the default constructor");
				e.printStackTrace();
			}
		}
		plugin.getLogger().log(Level.INFO, "Finished registration of events.");
	}
}
