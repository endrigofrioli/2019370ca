package ie.cct.exceptions;

public class Exceptions {

	public static void throwException() throws Exception {

		throw new Exception("This is a checked exception, you need to handle it");
	}

	public static void throwRunTimeException() {
		throw new RuntimeException("This is an unchecked exceptio, you can ignore it if required");
	}

	public static void main(String[] args) {
		
		 try {
			throwException();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		// throwRunTimeException();

	}

}
