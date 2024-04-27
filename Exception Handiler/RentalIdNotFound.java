package Book_Library_Application.ExcetionHandiler;

public class RentalIdNotFound extends RuntimeException {
	
public String fetchMessage = "Rental id not found";
	
	public String getFetchMessage() {
		return fetchMessage;
	}
}
