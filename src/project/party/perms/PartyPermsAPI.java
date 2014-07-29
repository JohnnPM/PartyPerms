package project.party.perms;

import org.bukkit.OfflinePlayer;

import project.party.perms.handlers.PartyInvHandler;
import project.party.perms.rank.PartyClass;
import project.party.perms.rank.PartyRank;

public class PartyPermsAPI implements IPartyPermsAPI {

	private PartyPermsMain plugin = PartyPermsMain.get();
	
	@Override
	public PartyRank getRank(OfflinePlayer player) {
		return null;
	}

	@Override
	public PartyClass getClass(OfflinePlayer player) {
		return null;
	}

	@Override
	public PartyInvHandler getPartyInvHandler() {
		return plugin.getPartyInvHandler();
	}

	@Override
	public void setRank(OfflinePlayer player, PartyRank rank) {
		
	}

	@Override
	public void setClass(OfflinePlayer player, PartyClass clazz) {
		
	}

}
