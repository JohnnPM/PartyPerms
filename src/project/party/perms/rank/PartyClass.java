/**
 * 
 */
package project.party.perms.rank;

import static org.bukkit.ChatColor.BLUE;
import static org.bukkit.ChatColor.DARK_AQUA;
import static org.bukkit.ChatColor.DARK_GREEN;
import static org.bukkit.ChatColor.DARK_PURPLE;
import static org.bukkit.ChatColor.GOLD;
import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.RED;
import static org.bukkit.ChatColor.WHITE;

import org.bukkit.ChatColor;


/**
 * @author 598Johnn897
 *
 */
public enum PartyClass {
	
	CLASS5(RED, "5", false, true, false),
	CLASS5A(RED, "5A", false, true, true),
	CLASS5E(RED, "5E", false, true, true),
	CLASS4(DARK_GREEN, "4", false, true, false),
	CLASS4E(DARK_GREEN, "4E", false, true, true),
	CLASS3(BLUE, "3", false, true, false),
	CLASS3E(BLUE, "3E", false, true, true),
	CLASS2(WHITE, "2", false, false, false),
	CLASS1(WHITE, "1", false, false, false),
	CLASSD(GRAY, "D", false, false,false),
	CLASSYT(GOLD, "E", true, false, false),
	CLASSSTREAMER(DARK_PURPLE, "E", true, false, false),
	CLASSBT(DARK_AQUA, "E", true, false, false),
	CLASSPRO(DARK_PURPLE, "E", true, false, false),
	
	INVALID(GRAY, "N/A", false, false, false);

	private final ChatColor color;
	private final String name;
	private final boolean staff;
	private final boolean classE;
	private final boolean subclass;

	PartyClass(ChatColor color, String name, boolean classE, boolean staff,
			boolean subclass) {
		this.color = color;
		this.name = name;
		this.classE = classE;
		this.staff = staff;
		this.subclass = subclass;
	}

	/**
	 * @return the color
	 */
	public ChatColor getColor() {
		return color;
	}

	/**
	 * @return the name
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return true if staff | false if not
	 */
	public boolean isStaff() {
		return staff;
	}

	/**
	 * @return true if class e | false if not
	 */
	public boolean isClassE() {
		return classE;
	}

	/**
	 * @return true if class e | false if not
	 */
	public boolean isSubclass() {
		return subclass;
	}

	/**
	 * Get class from string (Make sure name is in caps)
	 */
	public static PartyClass getClassFromString(String name) {
		PartyClass rank = null;
		switch (name) {
		case "5":
			rank = PartyClass.CLASS5;
			break;
		case "5A":
			rank = PartyClass.CLASS5A;
			break;
		case "5E":
			rank = PartyClass.CLASS5E;
			break;
		case "4":
			rank = PartyClass.CLASS4;
			break;
		case "4E":
			rank = PartyClass.CLASS4E;
			break;
		case "3":
			rank = PartyClass.CLASS3;
			break;
		case "3E":
			rank = PartyClass.CLASS3E;
			break;
		case "2":
			rank = PartyClass.CLASS2;
			break;
		case "1":
			rank = PartyClass.CLASS1;
			break;
		case "D":
			rank = PartyClass.CLASSD;
			break;
		case "YT":
			rank = PartyClass.CLASSYT;
			break;
		case "ST":
			rank = PartyClass.CLASSSTREAMER;
			break;
		case "BT":
			rank = PartyClass.CLASSBT;
			break;
		case "PR":
			rank = PartyClass.CLASSPRO;
			break;
		default:
			rank = PartyClass.INVALID;
			break;
		}
		return rank;
	}

}
