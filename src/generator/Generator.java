package generator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class Generator {
	Parser parser;
	String [] words;
	public Generator(Parser parser) {
		this.parser = parser;
		
		String generationText = Settings.LIBRARY_MAP.get(parser.getLibrary());
		words = parseLibraryText(generationText);
		int count = parser.getCount();
		StringBuilder output = new StringBuilder();
		for(int i = 0; i<count; i++) {
			if(parser.htmlOn()) {
				output.append(htmlIfy(generateText())+"\n"+"\n");
			}
			else {
				output.append(bulletify(generateText())+"\n"+"\n");
			}
		}
		if(parser.getMode().equals(Settings.BULLET) && parser.htmlOn()) {
			output.insert(0, "<ul>");
			output.append("</ul>");
		}
		if(parser.getOutfile()!=Settings.NO_OUTFILE) {
			try {
				FileOutputStream outputStream = new FileOutputStream(parser.getOutfile());
				byte [] strToBytes = output.toString().getBytes();
				outputStream.write(strToBytes);
				outputStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.print(Settings.ERROR_INVALID_FILE);
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println(output);
			}
		}
	
		
	
	private String [] parseLibraryText(String generationText) {
		generationText = generationText.replace("\n" , " ").replace("\" " , "").replace(".", "").replace(",", "").replace(">>", "").replace("<<", "");
		String [] words = generationText.split(" ");
		return words;
	}
	
	private String htmlIfy(String string) {
		if(parser.getMode().equals(Settings.PARAGRAPH)) {
			return "<p>" + string + "</p>";
		}
		else if(parser.getMode().equals(Settings.BULLET)) {
			return "<li>" + string + "</li>";
		}
		else if(parser.getMode().equals(Settings.WORD)) {
			return "<h1>" + string + "</h1>";
		}
		return parser.getMode();
	}
	
	private String bulletify(String string) {
		if(parser.getMode().equals(Settings.BULLET)) {
			return "- " + string;
		}
		return string;
	}
	
	public String generateText() {
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		String mode = parser.getMode();
		
		// get the length of the text
		int lengthRange = Settings.MODE_LENGTHS.get(mode);
		int lowerRange = lengthRange-lengthRange/2;
		int upperRange = lengthRange+lengthRange/2+1;
		int currentRange = random.nextInt(upperRange-lowerRange)+lowerRange;
		
		//get a random number for the random word to be generate;
		int libraryLength =words.length;
		
		
		for(int i =0; i<currentRange; i++){
			int randomIndex = random.nextInt(libraryLength);
			stringBuilder.append(words[randomIndex]+ " ");
		}
		return stringBuilder.toString();
	}

}
