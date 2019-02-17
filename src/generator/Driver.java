package generator;

import java.io.IOException;

import org.jline.reader.Completer;
import org.jline.reader.EndOfFileException;
import org.jline.reader.Highlighter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Driver {

	public static void main(String[] args){
		
	
		Parser parser = new Parser(args);
		if(parser.isValid()) {
			if(parser.shouldGenerate()) {
				Generator generator = new Generator(parser);
			}
			else {
				Interactive interactive = new Interactive(parser);
			}
		}
		else {
		
		}
	}

}
