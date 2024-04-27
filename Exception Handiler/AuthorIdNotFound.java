package Book_Library_Application.ExcetionHandiler;

public class AuthorIdNotFound extends RuntimeException{

public String fetchMessage = "Author id not found";
	
	public String getFetchMessage() {
		return fetchMessage;
	}
}

