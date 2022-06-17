package exceptions;

public class InvalidCategoryException extends Exception {

	String wrongCategory;

	public InvalidCategoryException(String wrongCategory) {
		super();
		this.wrongCategory = wrongCategory;
	}
	
	public void printException(){
		System.out.println("No " + wrongCategory + " category in the list. Please enter a valid one. ");
	}
	
}
