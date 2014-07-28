/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party.inventory
 *
 */
package project.party.inventory;

import org.bukkit.entity.Player;

import project.party.rank.PartyRank;

/**
 * Created: Jul 28, 2014 <br>
 * Time: 5:30:05 PM <br>
 * Year: 2014
 * <p>
 * 
 * By: 598Johnn897
 * <p>
 * 
 * Project: PartyPerms <br>
 * File: IPartyInventory.java <br>
 * Package: project.party.inventory
 * <p>
 * 
 * @author 598Johnn897
 */
public interface IPartyInventory {

	PartyItem[] getItems();

	String getName();

	boolean isDefault();

	PartyRank getRequiredRank();

	void addItemsToPlayer(Player player);

}
