package project.party.perms.lib;

import project.party.perms.PartyPermsMain;

public class References {

	private static PartyPermsMain plugin = PartyPermsMain.get();
	
	public static final String NAME = plugin.getDescription().getName();
	public static final String CRASH_FOLDER_PATH_EXT = "/party-crashes";
	public static final String CRASH_FILE_FORMAT = ".txt";

}
