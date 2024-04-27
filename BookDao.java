package Book_Library_Application.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Book_Library_Application.Dto.Author;
import Book_Library_Application.Dto.Book;
import Book_Library_Application.Dto.Rental;
import Book_Library_Application.ExcetionHandiler.BookIdNotFound;
import Book_Library_Application.Repo.BookRepo;

@Repository
public class BookDao {

	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	RentalDao rentalDao;
	
//	@Autowired
//	AuthorDao authorDao;
	
	public Book insertBook(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> findAllBooks(Book book) {
		return bookRepo.findAll();
	}
	
	public Book fetchById(int bookId)
	{
		Optional<Book> book = bookRepo.findById(bookId);
		if (book.isPresent())
		{
			return book.get();
		}
		else {
			return null;
		}
	}
	
	public Book update(int bookId, Book book)
	{
		Optional<Book> optional = bookRepo.findById(bookId);
		if (optional.isPresent())
		{
			book.setId(bookId);
			return this.insertBook(book);
		}
		else
		{
			return null;
		}
	}
	
	public Book delete(int bookId)
	{
		Optional<Book> optional = bookRepo.findById(bookId);
		if (optional.isPresent())
		{
			bookRepo.deleteById(bookId);
			return optional.get();
		}
		else
		{
			return null;
		}
	}
	
//	public Book addExistingBookToExistingAuthor(int bookId, int authorId)
//	{
//		Book book = bookRepo.findById(authorId).get();
//		Author author = authorDao.findById(authorId);
//		book.getAuthors().add(author);
//		return insertBook(book);
//	}
	
	public Book addExistingBookToExistingRental(int bookId, int rentalId) {
		Book book = bookRepo.findById(bookId).get();
		Rental rental = rentalDao.findById(rentalId);
		book.getRentals().add(rental);
		return insertBook(book);
	}
	
	public Book addNewBookToExistingRental(int bookId, List<Rental> rentals) {
		 Book book = fetchById(bookId);
		 if (book!=null) {
			
			 List<Rental> rentals2 = new ArrayList<>();
			 for (Rental rental : rentals2) {
				rentals2.add(rental);
			}
			 book.setRentals(rentals2);
			 return bookRepo.save(book);
		}
		 else 
		 {
			 return null;
		 }
	}
	
	public Boolean isBookRented(int bookId) {
		return bookRepo.findById(bookId).map(Book::isRented).orElse(false);
	}
	
	public Book rentBook(int bookId, String rentName, LocalDate rentalDate) {
		Book book = bookRepo.findById(bookId).orElseThrow(()-> new BookIdNotFound());
		if (book.isRented())
		{
			throw new RuntimeException("Book is alardy returned");
		}
		book.returnBook(rentalDate);
		bookRepo.save(book);
		return book;
	}
	
	public List<Book> getOverRentals(Book book1) {
		LocalDate localDate = LocalDate.now().minusDays(14);
		return bookRepo.findAll().stream().filter(book->book.isRented()&& book.getRentalDate().isBefore(localDate)).collect(Collectors.toList());
	}
	
}
