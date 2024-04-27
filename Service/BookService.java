package Book_Library_Application.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.Collate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Book_Library_Application.Dao.BookDao;
import Book_Library_Application.Dto.Book;
import Book_Library_Application.Dto.Rental;
import Book_Library_Application.ExcetionHandiler.BookIdNotFound;
import Book_Library_Application.Repo.BookRepo;
import Book_Library_Application.Util.ResponseStructure;

@Service
public class BookService {

	@Autowired
	BookDao bookDao;

	public ResponseStructure<Book> insetBook(Book book) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully added");
		responseStructure.setData(bookDao.insertBook(book));
		return responseStructure;
	}

	public ResponseStructure<Book> fetchAll(Book book) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("fetch successful");
		responseStructure.setDatas(bookDao.findAllBooks(book));
		return responseStructure;
	}

	public ResponseEntity<ResponseStructure<Book>> findById(int bookId)
	{
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		Book book = bookDao.fetchById(bookId);
		if (book!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Fetch By Id Successful");
			responseStructure.setData(bookDao.fetchById(bookId));
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.FOUND);			
		}
		else
		{
			throw new BookIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Book>> update(int bookId, Book book)
	{
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		Book book2 = bookDao.update(bookId, book);
		if (book2!=null)
		{
			responseStructure.setMessage("updates successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(book2);
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
		}
		else 
		{
			throw new BookIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Book>> delete(int bookId)
	{
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		Book book = bookDao.delete(bookId);
		if (book!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			responseStructure.setData(bookDao.delete(bookId));
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BookIdNotFound();
		}
	}

	//	public ResponseEntity<ResponseStructure<Book>> addExistingBookToExistingAuthor(int bookId, int authorId) {
	//		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
	//		Book book = bookDao.addExistingBookToExistingAuthor(bookId, authorId);
	//		if (book!=null) {
	//			responseStructure.setStatus(HttpStatus.OK.value());
	//			responseStructure.setMessage("Added successfully");
	//			responseStructure.setData(bookDao.addExistingBookToExistingAuthor(bookId, authorId));
	//			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);	
	//		}
	//		else
	//		{
	//			throw new BookIdNotFound();
	//		}
	//	}

	public ResponseEntity<ResponseStructure<Book>> addExistingBookToExistingRental(int boookId, int rentals) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		Book book = bookDao.addExistingBookToExistingRental(boookId, boookId);
		if (book!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Added successfully");
			responseStructure.setData(bookDao.addExistingBookToExistingRental(boookId, boookId));
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
		}
		else 
		{
			throw new BookIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Book>> addNewBookToExistingRental(int bookId, List<Rental> rentals ) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		Book book = bookDao.addNewBookToExistingRental(bookId, rentals);
		if (book!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Added successfully");
			responseStructure.setData(bookDao.addNewBookToExistingRental(bookId, rentals));
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BookIdNotFound();
		}
	}


	public boolean isBookRented(int bookId) {
		return bookDao.isBookRented(bookId);
	}

	public ResponseEntity<ResponseStructure<Book>> rentBook(int bookId, String rentName,LocalDate rentalDate) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		Book book = bookDao.rentBook(bookId, rentName, rentalDate);
		if (book!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Book rented");
			responseStructure.setData(bookDao.rentBook(bookId, rentName, rentalDate));
			return new ResponseEntity<ResponseStructure<Book>>(HttpStatus.OK);			
		}
		else {
			throw new BookIdNotFound();
		}
	}
	
	public ResponseStructure<Book> getOverRentals(Book book) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setDatas(bookDao.getOverRentals(book));
		return responseStructure;
	}

}
