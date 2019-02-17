package generator;

import java.io.IOException;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Interactive {
	Parser parser;
	LineReader lineReader;
	boolean shouldProgramExit = false;
	public Interactive(Parser parser) {
		this.parser = parser;
		try {
			Terminal terminal = TerminalBuilder.builder().system(true).build();
			StringsCompleter completer = new StringsCompleter("set","generate", "count", "version", "help", "show", "mode", "exit",
					"quit", "bullet", "", "paragraph", "lorem", "anguish", "word", "library", "anguish", "outfile", "html", "true", "false");
			lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(completer)
                    .build();
			String prompt = Settings.INTERACTIVE_PROMPT;
		    while (!shouldProgramExit) {
		        String line = null;
		        try {
		            line = lineReader.readLine(prompt);
		            parseLine(line);
		        } catch (UserInterruptException e) {
		            // Ignore
		        } catch (EndOfFileException e) {
		            return;
		        }
		}
		}
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	private Boolean parseLine(String line) {
		String [] args = line.split(" ");
		
		if(!Settings.INTERACTIVE_COMMANDS.contains(args[0])) {
			System.out.println(Settings.ERROR_NO_COMMAND_SPECIFIED);
			return false;
		}
		String command =  args[0];
		switch(command) {
		case Settings.GENERATE:
			Generator generator = new Generator(parser);
			generator.generateText();
		break;
		case Settings.SHOW:
			if(!Settings.SHOW_ARGUMENTS.contains(args[1])) {
				System.out.println(Settings.ERROR_SHOW_COMMAND_MUST_TAKE_ARGUMENT);
				return false;
			}
			if(args.length>2) {
				System.out.println(Settings.ERROR_SHOW_COMMAND_TOO_LONG);
				return false;
			}
			String argument = args[1];
			switch(argument) {
			case Settings.MODE:
				System.out.println("Mode is "+ parser.getMode());
				break;
			case Settings.OUTFILE: 
				System.out.println("Outfile is " + parser.getOutfile());
				break;
			case Settings.COUNT:
				System.out.println("Count is " + parser.getCount());
				break;
			case Settings.HTML:
				System.out.println("HTML is "+ parser.htmlOn());
				break;
			case Settings.LIBRARY:
				System.out.println("Library is "+parser.getLibrary());
				break;
			}
		break;
		
		case Settings.SET:
			if(args.length<3) {
				System.out.println(Settings.ERROR_NO_SET_ARGUMENT);
				return false;
			}
			if(!Settings.SHOW_ARGUMENTS.contains(args[1])) {
				System.out.println(Settings.ERROR_BAD_SET_COMMAND);
				return false;
			}
		
			argument = args[1];
			switch(argument) {
			case Settings.MODE:
				if(!Settings.MODEARGS.contains(args[2])) {
					System.out.println(Settings.ERROR_MODE_ARGUMENT_INVALID);
					return false;
				}
				parser.setMode(args[2]);
				System.out.println("Mode set to " + args[2]);
				break;
			case Settings.OUTFILE: 
				String filename = args[2];
				parser.setOutfile(filename);
				break;
			case Settings.LIBRARY:
				if(!Settings.LIBRARYARGS.contains(args[2])) {
					System.out.println(Settings.ERROR_LIBRARY_ARGUMENT_INVALIDE);
					return false;
				}
				parser.setLibrary(args[2]);
				break;
			case Settings.COUNT:
				try {
					int count = Integer.valueOf(args[2]);
					if(count < 1) {
						System.out.println(Settings.ERROR_COUNT_LESS_THAN_ONE);
						return false;
					}
					parser.setCount(count);
				}
				catch(Exception e) {
					System.out.println(Settings.ERROR_COUNT_ARGUMENT_INVALID);
					return false;
				}
				break;
			case Settings.HTML:
				
				try {
				boolean htmlVal = Boolean.valueOf(args[2]);
				parser.setHTML(htmlVal);
				System.out.println("HTML is "+ parser.htmlOn());
				}
				catch(Exception e) {
					System.out.println(Settings.ERROR_HTML_ARGUMENT_INVALID);
					return false;
				}
				
				break;
			}
			
		break;
		case Settings.HELP:
			if(args.length>1) {
				System.out.println(Settings.HELP_STANDALONE_COMMAND);
			}
			else {
				System.out.println(Settings.HELP_TEXT);
			}
			
		break;
		case Settings.VERSION:
			if(args.length>1) {
				System.out.println(Settings.VERSION_STANDALONE_COMMAND);
			}
			else {
				System.out.println(Settings.VERSION_NUMBER);
			}
			
		break;
		case Settings.EXIT:
			shouldProgramExit = true;
			break;
		case Settings.QUIT:
			shouldProgramExit = true;
			break;
		
		}
		
		
		return true;
	}

}
