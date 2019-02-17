package generator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Settings {
	
	public static final String INTERACTIVE_PROMPT = ">>";
	public static final String HELP ="help";
	public static final String GENERATE = "generate";
	public static final String HTML = "html";
	public static final String VERSION = "version";
	public static final String MODE = "mode";
	public static final String LIBRARY = "library";
	public static final String OUTFILE = "outfile";
	public static final String COUNT = "count";
	public static final String QUIT = "quit";
	public static final String SET = "set";
	public static final String SHOW = "show";
	public static final String EXIT = "exit";
	
	
	public static final String VERSION_NUMBER = "1.0.0";
	public static final HashSet<String> COMMANDS = new HashSet<String>() {{
		add(HELP);
		add(HTML);
		add(VERSION);
		add(MODE);
		add(LIBRARY);
		add(GENERATE);
		add(OUTFILE);
		add(COUNT);
	}};
	public static final HashMap<String, String> ARGUMENTS = new HashMap<String, String>(){{
		put("--help", HELP);
		put("-h", HELP);
		put("--generate", GENERATE);
		put("-g", GENERATE);
		put("--html", HTML);
		put("-t", HTML);
		put("--version", VERSION);
		put("--mode", MODE);
		put("-m", MODE);
		put("-v", VERSION);
		put("--library", LIBRARY);
		put("-l", LIBRARY);
		put("--outfile", OUTFILE);
		put("-o", OUTFILE);
		put("--count", COUNT);
		put("-c", COUNT);
	}};
	
	public static final HashSet<String> INTERACTIVE_COMMANDS = new HashSet<String>() {{
		add(HELP);
		add(VERSION);
		add(SET);
		add(SHOW);
		add(GENERATE);
		add(EXIT);
		add(QUIT);
	}};
	
	
	public static final HashSet<String> SHOW_ARGUMENTS = new HashSet<String>() {{
		add(MODE);
		add(HTML);
		add(OUTFILE);
		add(LIBRARY);
		add(COUNT);
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
	public static final String ANGUISH_LANGUISH = "anguish";
	public static final String LOREM_IPSUM = "lorem";
	public static final String FRANCAIS = "francais";
	public static final HashSet<String> LIBRARYARGS = new HashSet<String>() {{
		add(LOREM_IPSUM);
		add(ANGUISH_LANGUISH);
		add(FRANCAIS);
	}};
	
	//count stuff
	
	public static final HashMap<String, Integer> COUNT_DEFAULTS = new HashMap<String, Integer>() {{
		put(PARAGRAPH, 1);
		put(WORD, 3);
		put(BULLET, 5);
	}};
	
	public static final HashMap<String,Integer> MODE_LENGTHS = new HashMap<String, Integer>(){{
		put(PARAGRAPH, 100);
		put(BULLET, 10);
		put(WORD, 1);
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
			+ "\n --generate -g : Generate "
			+ "\n --help -h : Help"
			+ "\n --version -v : Version"
			+ "\n --count -c <Count> : Count"
			+ "\n --library -l <LibraryName> : Library"
			+ "\n --outfile -o <OutfileName> : Outfile"
			+ "\n --mode -m <MODENAME> : Mode"
			+ "\n --html -t : HTML";
	public static final String ERROR_COUNT_LESS_THAN_ONE = "The argument for count must be greater than 0";
	public static final String ERROR_FILE_EXISTS = "The file you specified already exists. Please specify a file that does not exist yet";
	
	public static final String ERROR_DUPLICATE_COMMAND = "A command cannot be executed twice in the same statement";
	
	public static final String ERROR_COUNT_ARGUMENT_INVALID = "The argument for count must be a valid positive integer";
	
	public static final String ERROR_MODE_ARGUMENT_INVALID = "The argument for mode must be one of: \n paragraph, \n word, \n bullet";
	
	public static final String ERROR_HTML_ARGUMENT_INVALID = "HTML can be set to either true or false";
	
	public static final String ERROR_LIBRARY_ARGUMENT_INVALIDE = "The argument for library must be one of "
			+ "the following: \n lorem \n anguish";
	
	public static final String ERROR_NO_MODE_ARGUMENT = "The mode command must be followed by an argument";
	
	public static final String ERROR_NO_SET_ARGUMENT = "The set argument must be followed by a command and an argument for that command. See help for details";
	
	public static final String HELP_STANDALONE_COMMAND = "Help is a standalone command. Please do not include other commands with help";
	
	public static final String VERSION_STANDALONE_COMMAND = "Version is a standalone command. Please do not include other commands with version";
	public static final String ERROR_SHOW_COMMAND_TOO_LONG = "The show command must only be followed by one argument. Acceptable arguments are: \n"
			+ "count \n"
			+ "library \n"
			+ "mode \n"
			+ "outfile \n"
			+ "html";
	public static final String ERROR_SHOW_COMMAND_MUST_TAKE_ARGUMENT = "The show command must take an argument. Acceptable arguments are: "
			+ "\n count \n"
			+ "library \n"
			+ "mode \n"
			+ "outfile \n"
			+ "html";
	public static final String ERROR_BAD_SET_COMMAND = "The set command can only take the following arguments: \n"
			+ "count <count> \n"
			+ "library <libraryName> \n"
			+ "mode <modeName> \n"
			+ "outfile <outFile> \n"
			+ "html <htmlFile> \n";
	public static final String ERROR_NO_COUNT_ARGUMENT = "The count command must be followed by an argument";
	
	public static final String ERROR_NO_OUTFILE_ARGUMENT = "The outfile command must be followed with the name of a file";
	
	public static final String ERROR_NO_LIBRARY_ARGUMENT = "The library command must be followed with the name of a valid library";
	
	public static final String ERROR_HELP_IS_EXCLUSIVE = "Help can't be combined with other commands ";
	
	public static final String ERROR_VERSION_IS_EXCLUSIVE = "Version can't be combined with other commands";
	
	public static final String ERROR_INVALID_FILE = "Please specify the name of a valid file";
	
	public static final String ERROR_NO_COMMAND_SPECIFIED = "Please use one of the following commands:"
			+ "\n version"
			+ "\n help"
			+ "\n set <argument> <value>"
			+ "\n show <argument>"
			+ "\n exit"
			+ "\n quit"
			+ "\n generate";
			
	
	public static final HashMap<String, String> LIBRARY_MAP = new HashMap<String, String>(){{
		put(LOREM_IPSUM, LIBRARY_LOREM);
		put(ANGUISH_LANGUISH, LIBRARY_ANGUISH);
		put(FRANCAIS, LIBRARY_FRANCAIS);
		
	}};
	//Library 
	public static final String LIBRARY_LOREM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
			+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis"
			+ " nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo "
			+ "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
	
	public static final String LIBRARY_ANGUISH = "Wants pawn term dare worsted ladle gull hoe hat search putty yowler coils debt pimple colder Guilty Looks. Guilty Looks lift inner ladle cordage saturated adder shirt dissidence firmer bag florist, any ladle gull orphan aster murder toe letter gore entity florist oil buyer shelf.\n" + 
			"\n" + 
			"\"Guilty Looks!\" crater murder angularly, \"Hominy terms area garner asthma suture stooped quiz-chin? Goiter door florist? Sordidly NUT!\"\n" + 
			"\n" + 
			"\"Wire nut, murder?\" wined Guilty Looks, hoe dint peony tension tore murder's scaldings.\n" + 
			"\n" + 
			"\"Cause dorsal lodge an wicket beer inner florist hoe orphan molasses pimple. Ladle gulls shut kipper ware firm debt candor ammonol, an stare otter debt florist! Debt florist's mush toe dentures furry ladle gull!\"\n" + 
			"\n" + 
			"Wail, pimple oil-wares wander doe wart udder pimple dum wampum toe doe. Debt's jest hormone nurture. Wan moaning, Guilty Looks dissipater murder, an win entity florist.\n" + 
			"\n" + 
			"Fur lung, disk avengeress gull wetter putty yowler coils cam tore morticed ladle cordage inhibited buyer hull firmly off beers—Fodder Beer (home pimple, fur oblivious raisins, coiled \"Brewing\"), Murder Beer, an Ladle Bore Beer. Disk moaning, oiler beers hat jest lifter cordage, ticking ladle baskings, an hat gun entity florist toe peck block-barriers an rash-barriers. Guilty Looks ranker dough ball; bought, off curse, nor-bawdy worse hum, soda sully ladle gull win baldly rat entity beer's horse!\n" + 
			"\n" + 
			"Honor tipple inner darning rum, stud tree boils fuller sop—wan grade bag boiler sop, wan muddle-sash boil, an wan tawny ladle boil. Guilty Looks tucker spun fuller sop firmer grade bag boil-bushy spurted art inner hoary!\n" + 
			"\n" + 
			"\"Arch!\" crater gull, \"Debt sop's toe hart—barns mar mouse!\"\n" + 
			"\n" + 
			"Dingy traitor sop inner muddle-sash boil, witch worse toe coiled. Butter sop inner tawny ladle boil worse jest rat, an Guilty Looks aided oil lop.\n" + 
			"\n" + 
			"Dingy nudist tree cheers—wan anomalous cheer, wan muddle-sash cheer, an wan tawny ladle cheer. Guilty Looks set darn inner ladle cheer, bushy worse toe bag ferret, ant soddenly bustard.\n" + 
			"\n" + 
			"Clamming upper stars tutor beer's bet-rum, Guilty Looks dish-cupboard tree bets—wan grade bag bet, wan muddle-sash bet, an wan tawny ladle bet. Failing torrid, shay flunker shelf honor ladle bet, an, jester cobbler menace letter, worse sunder slip an snorting.\n" + 
			"\n" + 
			"Inner ladle wile, donors offer cordage cam beck firmer barrier-pecking extradition, currying baskings fuller rash-barriers. Whinny entity darning rum, Fodder Beer stuttered snuffing an gruelling tomb shelf.\n" + 
			"\n" + 
			"\"Warts ban goring earn hair? crumpled dole beer, \"Conjure small psalm-sing deferent a boarder horse?\"\n" + 
			"\n" + 
			"\"Crashes!\" crater murder beer, ashy castor quack glands adder tipple, \"Hose ban muddling wet debt sop?\"\n" + 
			"\n" + 
			"Ladle Bore Beer stuttered crayon.\n" + 
			"\n" + 
			"\"Jest locket mar ladle boiler sop- oil garbled dope! An locket mar itchy pitchy cheer—oil bustard!\"\n" + 
			"\n" + 
			"Locking adder bustard cheer, Murder Beer bay-gander gat historical, an stuttered hurling tore horse-barn:\n" + 
			"\n" + 
			"\"Brewing! Brewing! Way gut BURGHERS inner horse. HORSE BURGHERS! Quack! Coiler place! Wail, dun stun dare lacking end-bustle during nosing! Coiler Place Deportment, quack!\n" + 
			"\n" + 
			"\"Harmer garner coiler Place Deportment wen way dun heifer toiler-fun?\" resplendent Brewing, inner trampling verse. \"Set darn, worming, an cape quoit! Yore oil-wares thanking dare burghers inner horse!\"\n" + 
			"\n" + 
			"Oiler shame, Brewing worse jesters scarred aster udders; infect, haze niece war shagging.\n" + 
			"\n" + 
			"Finely, Fodder Beer gutter grade bag short-gum, Murder Beer gutter muddle-sash haunting raffle, an Ladle Bore Beer gutter tawny ladle pestle, an oiler beers crypt upper stars, ware Guilty Looks worse line honor bet, sunder slip an snorting. Herring door beers, shay weakened, lipped otter door windrow, an dished aware harm jesters fascist shagged scrabble.\n" + 
			"\n" + 
			"Oiler beers tar darner stars, an stuttered toe locker doers an windrows.\n" + 
			"\n" + 
			"\"Fodder,\" aster ladle bore beer, finely, \"Wart worse debt discussing crasher honor bet? Wart worse debt ogling ammonol wet oil debt yowler far honor had, an hoe dint half nor far atoll honor beck? Wart worse debt hobble lurking crasher, Fodder?\"\n" + 
			"\n" + 
			"Fodder Beer shuttered.\n" + 
			"\n" + 
			"\"Comb hair, mar bore. Heresy gut lessen furrier! Debt discussing crasher worsen HORMONE BANG! Kipper ware firm debt candor ammonol! Dare nor gut! Warts mar, are dun wander catcher goring entity florist oil bar yore shelf. Debt florist's mush toe dentures furry ladle beer!";
	
	
	public static final String LIBRARY_FRANCAIS = "« Nous n’avons en aucune façon gagné la guerre. » En concluant ainsi un article publié dans la Revue défense nationale de février au sujet des ultimes combats contre l’organisation Etat islamique (EI) en Syrie, le colonel François-Régis Legrier vient d’ulcérer la hiérarchie militaire, jusqu’au cabinet de la ministre des armées, Florence Parly. C’est pourtant le même homme qui a accueilli cette dernière en Irak le 9 février et lui a présenté les forces françaises.\n" + 
			"\n" + 
			"L’officier supérieur, chef de corps du 68e régiment d’artillerie d’Afrique, vient d’être engagé "
			+ "durant six mois au service de la coalition internationale contre l’EI dirigée par les "
			+ "Etats-Unis. Il achève tout juste sa mission de commandant de la Task Force Wagram, le bataillon"
			+ " qui met en œuvre depuis l’Irak les canons Caesar contre les derniers bastions de l’EI. Et il"
			+ " a rédigé son article, « La bataille d’Hajin : victoire tactique, défaite stratégique ? », "
			+ "alors qu’il n’avait pas achevé son mandat.La hiérarchie lui reproche de n’avoir pas soumis son"
			+ " projet et de s’être exprimé sans attendre son retour en France – le premier « retour"
			+ " d’expérience » que doit un chef de corps l’est auprès de ses généraux, par le traditionnel « "
			+ "compte rendu de fin de mission », confidentiel. Le colonel Legrier devrait être sanctionné, "
			+ "apprend-on, vendredi 15 février, auprès de l’état-major.\n" + 
			"\n" + 
			"L’article a été repéré et diffusé sur Twitter jeudi par l’historien et ancien colonel Michel Goya, auteur du blog La Voie de l’épée et expert écouté dans les cercles de réflexion sur la guerre. Le rédacteur en chef de la Revue défense nationale, le général Jérôme Pellistrandi, indique pour sa part « avoir manqué de discernement » et a retiré le "
			+ "texte du site Internet de la publication."
			+ "était dans son lit quand la bombe a explosé. C’était en 1994 et l’Armée républicaine irlandaise (IRA) visait un barrage militaire qui se trouvait juste en face de chez elle. Vingt-cinq ans plus tard, l’émotion est encore à fleur de peau quand cette Irlandaise âgée aujourd’hui de 45 ans se remémore la détonation. Le choc de se retrouver soudain par terre, soufflée par l’explosion ; le soldat qui l’avait mise en joue, hurlant ; sa mère allongée par terre et recouverte de poussière, qu’elle a crue morte quelques instants… « Longtemps, quand je voyais un éclair, mon instinct était de me jeter sous la table pour me protéger, explique-t-elle. Mais ce n’est plus le cas depuis quelques années. »\n" + 
			"\n" + 
			"A Crossmaglen, petit bourg de 3 000 habitants d’Irlande du Nord, les Troubles, nom officiel de la guerre civile survenue entre 1969 et 1998, représentent encore un vif traumatisme. Ils ont fait 3 500 morts – rapporté à la population française, ce serait l’équivalent de 130 000 morts.\n" + 
			"\n" + 
			"Ici, à la frontière avec la République d’Irlande, tout le monde est catholique et nationaliste, c’est-à-dire souhaite le rattachement à l’Irlande. A l’époque des affrontements, les soldats britanniques étaient considérés comme une « armée d’occupation ». Les enfants apprenaient à ne pas s’approcher des militaires qui patrouillaient, de peur que ceux-ci ne soient visés par une attaque. Sortir le samedi soir était strictement interdit, parce que les volontaires de l’IRA, pris la semaine par leur emploi, reprenaient du service le week-end. Les hélicoptères de l’armée survolaient constamment les lieux pour rejoindre leur base, située au milieu de la ville : la voie terrestre était trop dangereuse pour eux. C’était « bandit country », le surnom que les Britanniques avaient donné à la région.\n" + 
			"\n" + 
			"";
	
	public static final String HELP_TEXT = "Welcome to Generator! Generator lets users generate random text which can "
			+ "be used for mocking up graphic design \n \n "
			+ "Use the following commands to generate random text in cli mode:"
			+ "\n \n"
			+"--library -l [arg]      Command to specify which library the user wants to draw the randomly generated words from. Valid arguments are:\n   francais\n   lorem   \n   anguish"
			+ "\n \n"
			+ "--version -v           Command to show the user what version of generate they are using. --version must not be used with other commands."
			+ "\n \n"
			+ "--outfile -o [arg.txt] Command to specify a file to write the output to, if desired. Note that the file specified must not be a file that exists currently." + 
			" \n \n"
			+ "--html -t [arg]        Command to specficy whether or not your output contains html tags. Valid commands are true and false\n \n" + 
			"--count -c [arg]         Command to specify how many paragraphs, words, or bullets you want your output to contain. The count argument must be an integer greater than 0" 
			+ "\n \n"
			+ "--mode -m [arg]        Command to specify what format is used when generating text. Valids arguments are : \n   paragraph \n   bullet \n   word" 
			+ " \n \n"
			+ "--help -h [arg         Command to display help text which tells you how to use the program"
			+ "--generate -g  [arg]   Command that generates the text in the command line output. If this command is not included, interactive mode will start"
			+ " \n \n \n "
			+ "INTERACTIVE MODE"
			+ "\n \n"
			+ "Interactive mode starts when you run generator without using the --generate command. Interactive mode allows the user to input "
			+ "commands that persist between calls to generate. When interactive mode starts, you will see the prompt >> "
			+ "\n \n "
			+ "Use the following commands with interactive mode: "
			+ "\n \n"
			+ "generate: See --generate above"
			+ "\n \n"
			+ "show [command]: show the value that a setting is currently set to. Possible commands include: "
			+ "\n   count"
			+ "\n   outfile"
			+ "\n   html"
			+ "\n   mode"
			+ "\n   library"
			+ "\n \n"
			+ "set [command] [arg]: set a setting type to a value of your choice. You can use the following commands"
			+ "\n   count"
			+ "\n   html"
			+ "\n   mode"
			+ "\n   library"
			+ "\n \n"
			+ "help: See --help above \n \n"
			+ "version: See --version above \n \n"
			+ "exit: Exit out of interactive mode back to the terminal";

}
