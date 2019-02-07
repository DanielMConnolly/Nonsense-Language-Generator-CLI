package generator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Settings {
	public static final String HELP ="Help";
	public static final String GENERATE = "Generate";
	public static final String HTML = "Html";
	public static final String VERSION = "Version";
	public static final String MODE = "Mode";
	public static final String LIBRARY = "Library";
	public static final String OUTFILE = "Outfile";
	public static final String COUNT = "Count";
	public static final HashSet<String> COMMANDS = new HashSet<String>() {{
		add(HELP);
		add(GENERATE);
		add(HTML);
		add(VERSION);
		add(MODE);
		add(LIBRARY);
		add(OUTFILE);
		add(COUNT);
	}};
	public static final HashMap<String, String> ARGUMENTS = new HashMap<String, String>(){{
		put("--help", HELP);
		put("-h", HELP);
		put("--generate", GENERATE);
		put("-g", GENERATE);
		put("--html", HTML);
		put("-h", HTML);
		put("--version", VERSION);
		put("-v", VERSION);
		put("--library", LIBRARY);
		put("-l", LIBRARY);
		put("--outfile", OUTFILE);
		put("-o", OUTFILE);
		put("--count", COUNT);
		put("-c", COUNT);
	}};
	
	//MODES
	public static final String PARAGRAPH = "paragraph";
	public static final String BULLET = "bullet";
	public static final String WORD = "word";
	public static final HashSet<String> MODEARGS = new HashSet<String>(){{
		add(PARAGRAPH);
		add(BULLET);
		add(WORD);
	}};
	
	//Libraries
	public static final String ANGUISH_LANGUISH = "Anguish Languish";
	public static final String LOREM_IPSUM = "Lorem Ipsum";
	public static final HashSet<String> LIBRARYARGS = new HashSet<String>() {{
		add(LOREM_IPSUM);
		add(ANGUISH_LANGUISH);
	}};
	
	//count stuff
	
	public static final HashMap<String, Integer> countDefaults = new HashMap<String, Integer>() {{
		put(PARAGRAPH, 1);
		put(WORD, 3);
		put(BULLET, 5);
	}};
	
	//outfile stuff
	public static final String NO_OUTFILE = "No Outfile";
	
	//ARGUMENT GROUPS
	public static final HashSet<String> EXCLUSIVEARGS = new HashSet<String>(){{
		add(VERSION);
		add(HELP);
	}};
	
	//Error Messages
	public static final String ERROR_INVALID_COMMAND = "Please only include valid commands. Commands include: "
			+ "/n --generate -g : Generate "
			+ "/n --help -h : Help"
			+ "/n --version -v : Version"
			+ "/n --count -c <Count> : Count"
			+ "/n --library -l <LibraryName> : Library"
			+ "/n --outfile -o <OutfileName> : Outfile"
			+ "/n --mode -m <MODENAME> : MODE"
			+ "/n --html -h : HTML";
	public static final String ERROR_COUNT_LESS_THAN_ONE = "The argument for count must be greater than 0";
	
	public static final String ERROR_COUNT_ARGUMENT_INVALID = "The argument for count must be a valid positive integer";
	
	public static final String ERROR_MODE_ARGUMENT_INVALID = "The argument for mode must be one of: paragraph, word, bullet";
	
	public static final String ERROR_NO_MODE_ARGUMENT = "The mode command must be followed by an argument";
	
	public static final String ERROR_NO_OUTFILE_ARGUMENT = "The outfile command must be followed with the name of a file";
	
	public static final String ERROR_NO_LIBRARY_ARGUMENT = "The library command must be followed with the name of a valid library";
	
	public static final String ERROR_HELP_IS_EXCLUSIVE = "Help can't be combined with other commands ";
	
	public static final String ERROR_VERSION_IS_EXCLUSIVE = "Version can't be combined with other commands";
}
