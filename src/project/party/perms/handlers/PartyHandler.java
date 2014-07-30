/*
 * Author: 598Johnn897
 * 
 * Date: Jul 29, 2014
 * Package: project.party.perms.handlers
 *
 */
package project.party.perms.handlers;

import static project.party.perms.util.CrashUtil.handleCrash;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import project.party.perms.PartyPermsMain;
import project.party.perms.rank.PartyClass;
import project.party.perms.rank.PartyRank;

/**
 * Created: Jul 29, 2014 <br>
 * Time: 9:28:27 PM <br>
 * Year: 2014
 * <p>
 * 
 * By: 598Johnn897
 * <p>
 * 
 * Project: PartyPerms <br>
 * File: PartyHandler.java <br>
 * Package: project.party.perms.handlers
 * <p>
 * 
 * @author 598Johnn897
 */
public class PartyHandler implements Listener {

	private PartyPermsMain plugin = PartyPermsMain.get();

	/**
	 * 
	 * @param player
	 * @return true is player is in database | false if player is not in
	 *         database
	 */
	public synchronized boolean databaseContainsPlayer(Player player) {
		try {
			PreparedStatement sql = plugin.getConnection().prepareStatement(
					"SELECT * FROM `player_lobby_data` WHERE player=?;");
			sql.setString(1, player.getName());
			ResultSet resultSet = sql.executeQuery();
			boolean containsPlayer = resultSet.next();

			sql.close();
			resultSet.close();

			return containsPlayer;

		} catch (Exception e) {
			handleCrash(e);
			return false;
		}
	}

	/**
	 * Gets Rank Of OfflinePlayer from SQL database
	 * 
	 * @param player
	 * @return rank of player
	 */
	public PartyRank getRank(OfflinePlayer player) {
		plugin.getSQLDatabase().openConnection();
		try {
			String rank;

			PreparedStatement sql = plugin.getConnection().prepareStatement(
					"SELECT rank FROM `player_lobby_data` WHERE player=?;");
			sql.setString(1, player.getName());

			ResultSet result = sql.executeQuery();
			result.next();

			rank = result.getString("rank");

			sql.close();
			result.close();

			return PartyRank.getRankFromString(rank);
		} catch (Exception e) {
			handleCrash(e);
			return PartyRank.INVAILD;
		} finally {
			plugin.getSQLDatabase().closeConnection();
		}
	}

	/**
	 * Gets Class Of OfflinePlayer from SQL database
	 * 
	 * @param player
	 * @return rank of player
	 */
	public PartyClass getClass(OfflinePlayer player) {
		plugin.getSQLDatabase().openConnection();
		try {
			String clazz = null;

			PreparedStatement sql = plugin.getConnection().prepareStatement(
					"SELECT clazz FROM `player_lobby_data` WHERE player=?;");
			sql.setString(1, player.getName());

			ResultSet result = sql.executeQuery();
			result.next();

			try {
				clazz = result.getString("clazz");
			} catch (Exception e) {
				clazz = "";
			}

			sql.close();
			result.close();

			return PartyClass.getClassFromString(clazz);
		} catch (Exception e) {
			handleCrash(e);
			return PartyClass.INVALID;
		} finally {
			plugin.getSQLDatabase().closeConnection();
		}
	}

	public void createTables() {
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			plugin.getSQLDatabase().openConnection();
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating table in given database...");

			PreparedStatement newPlayer = plugin.getConnection()
					.prepareStatement(
							"CREATE TABLE REGISTRATION "
									+ "(id INTEGER not NULL, "
									+ " first VARCHAR(255), "
									+ " last VARCHAR(255), " + " age INTEGER, "
									+ " PRIMARY KEY ( id ))");
			newPlayer.execute();
			newPlayer.close();
			System.out.println("Created table in given database...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			plugin.getSQLDatabase().closeConnection();
			;
		}// end try
	}
}
