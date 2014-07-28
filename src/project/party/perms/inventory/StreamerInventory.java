/**
 *   _____           _           _     _____           _         
 *  |  __ \         (_)         | |   |  __ \         | |        
 *  | |__) | __ ___  _  ___  ___| |_  | |__) |_ _ _ __| |_ _   _ 
 *  |  ___/ '__/ _ \| |/ _ \/ __| __| |  ___/ _` | '__| __| | | |
 *  | |   | | | (_) | |  __/ (__| |_  | |  | (_| | |  | |_| |_| |
 *  |_|   |_|  \___/| |\___|\___|\__| |_|   \__,_|_|   \__|\__, |
 *                 _/ |                                     __/ |
 *                |__/                                     |___/ 
 */
package project.party.perms.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import project.party.perms.rank.PartyRank;

/**
 * @author 598Johnn897
 * 
 */
public class StreamerInventory extends PartyInventory implements
		IPartyInventory {

	private ArrayList<String> compassLore = new ArrayList<String>();
	private ArrayList<String> clockLore = new ArrayList<String>();
	private ArrayList<String> petLore = new ArrayList<String>();
	{
		compassLore.add(ChatColor.GRAY + "Get where you want, when you want!");
		clockLore.add(ChatColor.GRAY + "Hide all those unwanted players!");
		petLore.add(ChatColor.GRAY
				+ "A little buddy to accompany you on your journeys. :)");
	}
	private HashMap<PartyItem, Integer> items = new HashMap<PartyItem, Integer>();

	private PartyItem compass = new PartyItem(Material.COMPASS, ChatColor.GOLD
			+ "Navigation Compass " + ChatColor.GRAY + "(Click)", compassLore);
	private PartyItem clock = new PartyItem(Material.WATCH, ChatColor.GOLD
			+ "Magic Watch " + ChatColor.GRAY + "(Click)", clockLore);
	private PartyItem bone = new PartyItem(Material.BONE, ChatColor.GOLD
			+ "Pets " + ChatColor.GRAY + "(Click)", petLore);

	private PartyItem[] itemsList = new PartyItem[] { compass, clock, bone };

	public StreamerInventory() {

		items.put(compass, 0);
		items.put(clock, 1);

		items.put(bone, 8);
	}

	public PartyItem[] getItems() {
		return itemsList;
	}

	public boolean isDefault() {
		return false;
	}

	public PartyRank getRequiredRank() {
		return PartyRank.getRankFromString(this.getClass().getSimpleName()
				.substring(1));
	}

	public void addItemsToPlayer(Player player) {
		for (PartyItem item : getItems()) {
			player.getInventory().setItem(items.get(item), item);
		}
		return;
	}

}
