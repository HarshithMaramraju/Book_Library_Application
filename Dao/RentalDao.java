package Book_Library_Application.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Book_Library_Application.Dto.Author;
import Book_Library_Application.Dto.Book;
import Book_Library_Application.Dto.Rental;
import Book_Library_Application.Repo.RentalRepo;

@Repository
public class RentalDao {

	@Autowired
	RentalRepo rentalRepo;
	
//	@Autowired
//	BookDao bookDao;
	
	public Rental insert(Rental rental)
	{
		return rentalRepo.save(rental);
	}
	
	public List<Rental> findAllRental(Rental rental) {
		return rentalRepo.findAll();
	}
	
	public Rental findById(int rentalId)
	{
		Optional<Rental> optional = rentalRepo.findById(rentalId);
		if (optional.isPresent()) {
			return optional.get();
		}
		else
		{
			return null;
		}
	}
	
	public Rental update(int rentalId, Rental rental) {
		Optional<Rental> optional = rentalRepo.findById(rentalId);
		if (optional.isPresent()) {
			rental.setId(rentalId);
			return this.insert(rental);
		}
		else
		{
			return null;
		}
	}
	
	public Rental delete(int rentalId)
	{
		Optional<Rental> optional = rentalRepo.findById(rentalId);
		if (optional.isPresent()) {
			rentalRepo.deleteById(rentalId);
			return optional.get();
		}
		else {
			return null;
		}
	}
	
//	public Rental isAvalible(int bookId) {
//		Optional<Rental> optional = rentalRepo.findById(bookId));
//		if (optional.isPresent()) {
//			
//		}
//	}
	
//	public Rental addExistingBookToExistingRental(int rentalId, int BookId) {
//		Rental rental = rentalRepo.findById(rentalId).get();
//		Book book = bookDao.fetchById(BookId);
//		rental.getBooks().add(book);
//		return insert(rental);
//	}
}
