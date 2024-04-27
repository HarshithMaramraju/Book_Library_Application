package Book_Library_Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Book_Library_Application.Dao.BookDao;
import Book_Library_Application.Dao.RentalDao;
import Book_Library_Application.Dto.Book;
import Book_Library_Application.Dto.Rental;
import Book_Library_Application.ExcetionHandiler.BookIdNotFound;
import Book_Library_Application.ExcetionHandiler.RentalIdNotFound;
import Book_Library_Application.Repo.BookRepo;
import Book_Library_Application.Util.ResponseStructure;

@Service
public class RentalService {

	@Autowired
	RentalDao rentalDao;
	
	@Autowired
	BookRepo bookRepo;
	
	public ResponseStructure<Rental> insetBook(Rental rental) {
		ResponseStructure<Rental> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully added");
		responseStructure.setData(rentalDao.insert(rental));
		return responseStructure;
	}
	
	public ResponseStructure<Rental> fetchAll(Rental rental) {
		ResponseStructure<Rental> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("fetch successful");
		responseStructure.setDatas(rentalDao.findAllRental(rental));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Rental>> findById(int rentalId)
	{
		ResponseStructure<Rental> responseStructure = new ResponseStructure<>();
		Rental rental = rentalDao.findById(rentalId);
		if (rental!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Fetch By Id Successful");
			responseStructure.setData(rentalDao.findById(rentalId));
			return new ResponseEntity<ResponseStructure<Rental>>(responseStructure,HttpStatus.FOUND);			
		}
		else
		{
			throw new RentalIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Rental>> update(int rentalId, Rental rental)
	{
		ResponseStructure<Rental> responseStructure = new ResponseStructure<>();
		Rental rental2 = rentalDao.update(rentalId, rental);
		if (rental2!=null)
		{
			responseStructure.setMessage("updates successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(rentalDao.update(rentalId, rental2));
			return new ResponseEntity<ResponseStructure<Rental>>(responseStructure,HttpStatus.OK);
		}
		else 
		{
			throw new RentalIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Rental>> delete(int rentalId)
	{
		ResponseStructure<Rental> responseStructure = new ResponseStructure<>();
		Rental rental = rentalDao.delete(rentalId);
		if (rental!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			responseStructure.setData(rentalDao.delete(rentalId));
			return new ResponseEntity<ResponseStructure<Rental>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new RentalIdNotFound();
		}
		
	}
	
//	public void rentBook(int bookId)
//	{
//		Book book = bookRepo.findById(bookId).orElseThrow(() -> new BookIdNotFound());
//		if (book) {
//			
//		}
//	}
	
//	public ResponseEntity<ResponseStructure<Rental>> addExistingBookToExistingRental(int rentalId, int bookId) {
//		ResponseStructure<Rental> responseStructure = new ResponseStructure<>();
//		Rental rental = rentalDao.addExistingBookToExistingRental(rentalId, bookId);
//		if (rental!=null) {
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setMessage("Added successfully");
//			responseStructure.setData(rentalDao.addExistingBookToExistingRental(rentalId, bookId));
//			return new ResponseEntity<ResponseStructure<Rental>>(responseStructure,HttpStatus.OK);
//		}
//		else {
//			throw new RentalIdNotFound();
//		}
//	}
}
