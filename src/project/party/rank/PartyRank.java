package project.party.rank;

import project.party.inventory.DClassInventory;
import project.party.inventory.PartyInventory;


/**
 * @author 598Johnn897
 *
 * List of ranks for Project Party.
 */
public enum PartyRank {

	OWNER(false, true, "OWNER", "Director", "OWNER", null),
	ADMIN(false, true, "ADMIN", "Director", "ADMIN", null),
	OPERATOR(false, true, "OPERATOR", "Director", "OP", null),
	MODERATOR(false, true, "MODERATOR", "Agent", "MOD", null),
	PREMODERATOR(false, true, "PREMODERATOR", "Agent", "MOD", null),
	HELPER(false, true, "HELPER", "Agent", "HELPER", null),
	PREHELPER(false, true, "PREHELPER", "Agent", "HELPER", null),
	AGENTPLUS(false, false, "AGENT+", "Agent+", "AGENT+", null),
	AGENT(false, false, "AGENT", "Agent", "AGENT", null),
	DCLASS(true, false, "DCLASS", "", null, new DClassInventory()),
	BUILDTEAM(false, false, "BUILDTEAM", "BuildTeam", "BUILDTEAM", null),
	PROFESSIONAL(false, false, "PROFESSIONAL", "Pro", "PRO", null),
	YOUTUBER(false, false, "YOUTUBER", "Youtuber", "YT", null),
	STREAMER(false, false, "STREAMER", "Streamer", "STREAMER", null),
	
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
