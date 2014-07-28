/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party.handlers
 *
 */
package project.party.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created: Jul 28, 2014 <br>
 * Time: 6:18:29 PM <br>
 * Year: 2014 <p>
 *
 * By: 598Johnn897 <p>
 * 
 * Project: PartyPerms <br>
 * File: PlayerJoinHandler.java <br>
 * Package: project.party.handlers <p>
 * 
 * @author 598Johnn897
 */
public class PlayerJoinHandler implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		System.out.println("worked");
	}

}
