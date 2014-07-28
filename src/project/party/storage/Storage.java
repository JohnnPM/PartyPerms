/*
 * Author: 598Johnn897
 * 
 * Date: Jul 28, 2014
 * Package: project.party.storage
 *
 */
package project.party.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import project.party.rank.PartyClass;
import project.party.rank.PartyRank;

/**
 * Created: Jul 28, 2014 <br>
 * Time: 6:14:30 PM <br>
 * Year: 2014 <p>
 *
 * By: 598Johnn897 <p>
 * 
 * Project: PartyPerms <br>
 * File: Storage.java <br>
 * Package: project.party.storage <p>
 * 
 * @author 598Johnn897
 */
public class Storage {
	
	public static final ArrayList<UUID> onlineUUIDs = new ArrayList<UUID>();
	public static final ArrayList<String> onlineStrings = new ArrayList<String>();

	public static final HashMap<UUID, PartyRank> rank = new HashMap<UUID, PartyRank>();
	public static final HashMap<UUID, PartyClass> clazz = new HashMap<UUID, PartyClass>();

}
