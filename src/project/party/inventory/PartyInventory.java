package project.party.inventory;

import org.bukkit.entity.Player;

import project.party.rank.PartyRank;

/**
 * @author 598Johnn897
 * 
 */
public class PartyInventory implements IPartyInventory {

	public PartyItem[] getItems() {
		return null;
	}

	public String getName() {
		return this.getClass().getSimpleName().substring(1);
	}

	public boolean isDefault() {
		return false;
	}

	public PartyRank getRequiredRank() {
		return null;
	}

	public void addItemsToPlayer(Player player) {
		return;
	}

}
