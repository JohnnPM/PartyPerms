package project.party.perms.rank;

import project.party.perms.inventory.AdminInventory;
import project.party.perms.inventory.AgentInventory;
import project.party.perms.inventory.AgentPlusInventory;
import project.party.perms.inventory.BuildTeamInventory;
import project.party.perms.inventory.DClassInventory;
import project.party.perms.inventory.HelperInventory;
import project.party.perms.inventory.ModeratorInventory;
import project.party.perms.inventory.OperatorInventory;
import project.party.perms.inventory.OwnerInventory;
import project.party.perms.inventory.PartyInventory;
import project.party.perms.inventory.PreHelperInventory;
import project.party.perms.inventory.PreModeratorInventory;
import project.party.perms.inventory.ProfessionalInventory;
import project.party.perms.inventory.StreamerInventory;
import project.party.perms.inventory.YoutuberInventory;


/**
 * @author 598Johnn897
 *
 * List of ranks for Project Party.
 */
public enum PartyRank {

	OWNER(false, true, "OWNER", "Director", "OWNER", new OwnerInventory()),
	ADMIN(false, true, "ADMIN", "Director", "ADMIN", new AdminInventory()),
	OPERATOR(false, true, "OPERATOR", "Director", "OP", new OperatorInventory()),
	MODERATOR(false, true, "MODERATOR", "Agent", "MOD", new ModeratorInventory()),
	PREMODERATOR(false, true, "PREMODERATOR", "Agent", "MOD", new PreModeratorInventory()),
	HELPER(false, true, "HELPER", "Agent", "HELPER", new HelperInventory()),
	PREHELPER(false, true, "PREHELPER", "Agent", "HELPER", new PreHelperInventory()),
	AGENTPLUS(false, false, "AGENT+", "Agent+", "AGENT+", new AgentPlusInventory()),
	AGENT(false, false, "AGENT", "Agent", "AGENT", new AgentInventory()),
	DCLASS(true, false, "DCLASS", "", null, new DClassInventory()),
	BUILDTEAM(false, false, "BUILDTEAM", "BuildTeam", "BUILDTEAM", new BuildTeamInventory()),
	PROFESSIONAL(false, false, "PROFESSIONAL", "Pro", "PRO", new ProfessionalInventory()),
	YOUTUBER(false, false, "YOUTUBER", "Youtuber", "YT", new YoutuberInventory()),
	STREAMER(false, false, "STREAMER", "Streamer", "STREAMER", new StreamerInventory()),
	
	INVAILD(false, false, "N/A", "N/A", "N/A", null);

	private final boolean defualt;
	private final String name;
	private String chatPrefix;
	private String tagPrefix;
	private final boolean staff;
	private final PartyInventory inv;

	PartyRank(boolean defualt, boolean staff, String name, String chatPrefix,
			String tagPrefix, PartyInventory inv) {
		this.defualt = defualt;
		this.staff = staff;
		this.name = name;
		this.chatPrefix = chatPrefix;
		this.inv = inv;
	}

	/**
	 * @return the inventory for the rank
	 */
	public PartyInventory getInventory() {
		return inv;
	}

	/**
	 * @return true if rank is default
	 */
	public boolean isDefault() {
		return defualt;
	}

	/**
	 * @return true if rank is default
	 */
	public boolean isStaff() {
		return staff;
	}

	/**
	 * @return name of rank
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return chatPrefix of rank
	 */
	public String getChatPrefix() {
		return chatPrefix;
	}

	/**
	 * Set chat prefix
	 */
	public void setChatPrefix(String prefix) {
		this.chatPrefix = prefix;
	}

	/**
	 * @return tagPrefix of rank
	 */
	public String getTagPrefix() {
		return tagPrefix;
	}

	/**
	 * Set tag prefix
	 */
	public void setTagPrefix(String prefix) {
		this.tagPrefix = prefix;
	}

	/**
	 * Get rank from string
	 */
	public static PartyRank getRankFromString(String name) {
		PartyRank rank = null;
		switch (name.toUpperCase()) {
		case "OWNER":
			rank = PartyRank.OWNER;
			break;
		case "ADMIN":
			rank = PartyRank.ADMIN;
			break;
		case "OPERATOR":
			rank = PartyRank.OPERATOR;
			break;
		case "MODERATOR":
			rank = PartyRank.MODERATOR;
			break;
		case "PREMODERATOR":
			rank = PartyRank.PREMODERATOR;
			break;
		case "HELPER":
			rank = PartyRank.HELPER;
			break;
		case "PREHELPER":
			rank = PartyRank.PREHELPER;
			break;
		case "AGENTPLUS":
			rank = PartyRank.AGENTPLUS;
			break;
		case "AGENT":
			rank = PartyRank.AGENT;
			break;
		case "DCLASS":
			rank = PartyRank.DCLASS;
			break;
		case "BUILDTEAM":
			rank = PartyRank.BUILDTEAM;
			break;
		case "PROFESSIONAL":
			rank = PartyRank.PROFESSIONAL;
			break;
		case "YOUTUBER":
			rank = PartyRank.YOUTUBER;
			break;
		case "STREAMER":
			rank = PartyRank.STREAMER;
			break;
		default:
			rank = PartyRank.INVAILD;
			break;
		}
		return rank;
	}

}
