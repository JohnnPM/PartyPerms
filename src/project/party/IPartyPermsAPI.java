/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party
 *
 */
package project.party;

import org.bukkit.OfflinePlayer;

import project.party.rank.PartyClass;
import project.party.rank.PartyRank;

/**
 * Created: Jul 28, 2014 <br>
 * Time: 5:45:53 PM <br>
 * Year: 2014 <p>
 *
 * By: 598Johnn897 <p>
 * 
 * Project: PartyPerms <br>
 * File: IPartyPermsAPI.java <br>
 * Package: project.party <p>
 * 
 * @author 598Johnn897
 */
public interface IPartyPermsAPI {

	PartyRank getRank(OfflinePlayer player);
	
	PartyClass getClass(OfflinePlayer player);
}
