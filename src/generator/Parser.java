package generator;

import java.io.File;
import java.util.HashMap;

public class Parser {
	private String [] args;
	private String mode = Settings.PARAGRAPH;
	private String library = Settings.LOREM_IPSUM;
	private String outfile = Settings.NO_OUTFILE;
	private Boolean html = false;
	private Boolean help = false;
	private Boolean version = false;
	private Boolean generate = false;
	private int count = 0;
	private Boolean countSpecified = false;
	private HashMap<String, Boolean> selectedCommands;
	private Boolean exclusiveCommand = false;
	
	public Parser(String [] args) {
		this.args=args;
		selectedCommands = new HashMap<String, Boolean>();
		for(String command: Settings.COMMANDS) {
			selectedCommands.put(command, false);
		}
	}
	public Boolean htmlOn() {
		return html;
	}
	public Boolean shouldGenerate() {
		return generate;
	}
	
	public String getLibrary () {
		return library;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getMode() {
		return mode;
	}
	
	public String getOutfile() {
		return outfile;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setHTML(boolean html) {
		this.html = html;
	}
	
	public void setOutfile(String output) {
		this.outfile = output;
	}
	
	public void setLibrary(String library) {
		this.library = library;
	}
	
	
	public Boolean isValid() {
		int argumentCounter = 0;
		while(argumentCounter<args.length) {
		    String argument = args[argumentCounter];
			if(!Settings.ARGUMENTS.containsKey(argument)) {
				System.out.println(Settings.ERROR_INVALID_COMMAND);
				return false;
			}
			if (exclusiveCommand) {
				if(help) {
					System.out.println(Settings.ERROR_HELP_IS_EXCLUSIVE);
				}
				else {
					System.out.println(Settings.ERROR_VERSION_IS_EXCLUSIVE);
				}
				return false;
			}
			String command = Settings.ARGUMENTS.get(argument);
			if (!selectedCommands.get(command)) {
				selectedCommands.put(command, true);
				switch (command) {
				case Settings.HELP:
					exclusiveCommand = true;
					help = true;
					if(args.length>1) {
						System.out.println(Settings.ERROR_HELP_IS_EXCLUSIVE);
						return false;
					}
					break;
				case Settings.GENERATE:
					generate = true;
					break;
				case Settings.HTML:
					html = true;
					break;
				case Settings.VERSION:
					exclusiveCommand = true;
					version = true;
					if(args.length>1) {
						System.out.println(Settings.ERROR_VERSION_IS_EXCLUSIVE);
						return false;
					}
					
					break;
				case Settings.MODE:
					if (argumentCounter == args.length - 1) {
						System.out.println(Settings.ERROR_NO_MODE_ARGUMENT);
						return false;
					}
					String modeArg = args[argumentCounter += 1];
					if (Settings.MODEARGS.contains(modeArg)) {
						mode = modeArg;
					} else {
						System.out.println(Settings.ERROR_MODE_ARGUMENT_INVALID);
						return false;
					}

					break;
				case Settings.LIBRARY:
					if (argumentCounter == args.length - 1) {
						System.out.println(Settings.ERROR_NO_LIBRARY_ARGUMENT);
						return false;
					}
					String libraryArg = args[argumentCounter += 1];
					if (Settings.LIBRARYARGS.contains(libraryArg)) {
						library = libraryArg;
					} else {
						System.out.println(Settings.ERROR_LIBRARY_ARGUMENT_INVALIDE);
						return false;
					}
					break;
				case Settings.OUTFILE:
					if (argumentCounter == args.length - 1) {
						System.out.println(Settings.ERROR_NO_OUTFILE_ARGUMENT);
						return false;
					}
					String outfiledestination = args[argumentCounter += 1];
					if(Settings.ARGUMENTS.containsKey(outfiledestination)) {
						System.out.println(Settings.ERROR_NO_OUTFILE_ARGUMENT);
						return false;
					}
					File tmpDir = new File(outfiledestination);
					if(tmpDir.exists()) {
						System.out.println(Settings.ERROR_FILE_EXISTS);
						return false;
					}
					outfile = outfiledestination;
					break;
				case Settings.COUNT:
					if (argumentCounter == args.length - 1) {
						System.out.println(Settings.ERROR_NO_COUNT_ARGUMENT);
						return false;
					}
					try {
						int count = Integer.parseInt(args[argumentCounter += 1]);
						if (count < 1) {
						    System.out.println(Settings.ERROR_COUNT_LESS_THAN_ONE);
							return false;
						}
						this.count = count;
						countSpecified = true;
					} catch (NumberFormatException e) {
						System.out.println(Settings.ERROR_COUNT_ARGUMENT_INVALID);
						return false;
					}
					break;
				}
				argumentCounter+=1;
			} else {
				System.out.println(Settings.ERROR_DUPLICATE_COMMAND);
				return false;
			}
				
			}
		if(!countSpecified) {
			count = Settings.COUNT_DEFAULTS.get(mode);
		}
		if(help) {
			System.out.println(Settings.HELP_TEXT);
			return false;
		}
		if(version) {
			System.out.println(Settings.VERSION_NUMBER);
			return false;
		}
		
		return true;
	}
	
}
