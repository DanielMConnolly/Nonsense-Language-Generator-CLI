package generator;

import java.util.HashMap;
import java.util.Map;

public class Settings {
	public static final String HELP ="Help";
	public static final String GENERATE = "Generate";
	public static final String HTML = "Html";
	public static final String VERSION = "Version";
	public static final String MODE = "Mode";
	public static final HashMap<String, String> commands = new HashMap<String, String>(){{
		put("--help", HELP);
		put("-h", HELP);
		put("--generate", GENERATE);
		put("-g", GENERATE);
		put("--html", HTML);
		put("-h", HTML);
		put("--version", VERSION);
		put("-v", VERSION);
	}};
	
	
	
}
