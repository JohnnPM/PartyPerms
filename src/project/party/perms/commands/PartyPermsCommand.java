/*
 * Author: 598Johnn897
 * 
 * Date: Jul 29, 2014
 * Package: project.party.perms.commands
 *
 */
package project.party.perms.commands;

import java.util.ArrayList;
import java.util.List;

import project.party.perms.commands.CommandFramework.Command;
import project.party.perms.commands.CommandFramework.CommandArgs;
import project.party.perms.commands.CommandFramework.CommandListener;
import project.party.perms.commands.CommandFramework.Completer;

/**
 * Created: Jul 29, 2014 <br>
 * Time: 9:01:48 AM <br>
 * Year: 2014 <p>
 *
 * By: 598Johnn897 <p>
 * 
 * Project: PartyPerms <br>
 * File: PartyPermsCommand.java <br>
 * Package: project.party.perms.commands <p>
 * 
 * @author 598Johnn897
 */
public class PartyPermsCommand implements CommandListener {
	
	@Command(command = "partyperms", permission = "party.perms", aliases = {"pperms"})
	public void partyPerms(CommandArgs info) {
		
	}
	
	@Completer(command = "partyperms", aliases = {"pperms"})
	public List<String> partyPermsCompleter(CommandArgs info){
		List<String> list = new ArrayList<String>();
		list.add("");
		return list;
		
	}

}
