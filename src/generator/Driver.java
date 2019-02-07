package generator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a class");
		Parser parser = new Parser(args);
		if(parser.isValid()) {
			System.out.println("This input was valid");
		}
		else {
			System.out.println("This input was not valid");
		}
	}

}
