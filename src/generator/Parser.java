package generator;

import java.util.HashMap;

public class Parser {
	private String [] args;
	private String mode = Settings.PARAGRAPH;
	private String library = Settings.LOREM_IPSUM;
	private String outfile = Settings.NO_OUTFILE;
	private Boolean html = false;
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
	public Boolean isValid() {
		int argumentCounter = 0;
		while(argumentCounter<args.length) {
		    String argument = args[argumentCounter];
			if(!Settings.ARGUMENTS.containsKey(argument)) {
				System.out.println(Settings.ERROR_INVALID_COMMAND);
				return false;
			}
			String command = Settings.ARGUMENTS.get(argument);
			if (!selectedCommands.get(command)) {
				selectedCommands.put(command, true);
				switch (command) {
				case Settings.HELP:
					if (exclusiveCommand) {
						return false;
					}
					exclusiveCommand = true;
					break;
				case Settings.GENERATE:
					generate = true;
					break;
				case Settings.HTML:
					html = true;
					break;
				case Settings.VERSION:
					if (exclusiveCommand) {
						return false;
					}
					exclusiveCommand = true;
					break;
				case Settings.MODE:
					if (argumentCounter == args.length - 1) {
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
						return false;
					}
					String libraryArg = args[argumentCounter += 1];
					if (Settings.LIBRARYARGS.contains(libraryArg)) {
						library = libraryArg;
					} else {
						return false;
					}
					break;
				case Settings.OUTFILE:
					if (argumentCounter == args.length - 1) {
						return false;
					}
					String outfiledestination = args[argumentCounter += 1];
					outfile = outfiledestination;
					break;
				case Settings.COUNT:
					if (argumentCounter == args.length - 1) {
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

				}
				argumentCounter+=1;
			} else {
				return false;
			}
				
			}
		
		return true;
	}
}
