package Book_Library_Application.ExcetionHandiler;

public class BookIdNotFound extends RuntimeException {

	public String fetchMessage = "Book id not found";
	
	public String getFetchMessage() {
		return fetchMessage;
	}
}
