package Book_Library_Application.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Book_Library_Application.Dto.Author;
import Book_Library_Application.Dto.Book;
import Book_Library_Application.Repo.AuthorRepo;

@Repository
public class AuthorDao {

	@Autowired
	AuthorRepo authorRepo;
	
	@Autowired
	BookDao bookDao;
	
	public Author insertAuthor(Author author) {
		return authorRepo.save(author);
	}
	
	public List<Author> findAll(Author author) {
		return authorRepo.findAll();
	}
	
	public Author findById(int authorId) {
		Optional<Author> optional = authorRepo.findById(authorId);
		if (optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return null;
		}
	}
	
	public Author update(int authorId, Author author) {
		Optional<Author> optional = authorRepo.findById(authorId);
		if (optional.isPresent()) {
			author.setId(authorId);
			return this.insertAuthor(author);
		}
		else {
			return null;
		}
	}
	
	public Author delete(int authorId) {
		Optional<Author> optional = authorRepo.findById(authorId);
		if (optional.isPresent()) {
			authorRepo.deleteById(authorId);
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public Author addExistingBooktoExistingAuthor(int bookId, int authorId)
	{
		Author author = authorRepo.findById(authorId).get();
		Book book = bookDao.fetchById(bookId);
		author.getBooks().add(book);
		return insertAuthor(author);
	}
	
	public Author addNewBookToExistingAuthor(int authorId, List<Book> book) {
		Author author = findById(authorId);
		if (author!=null) {
			List<Book> books = new ArrayList<>();
			for (Book book2 : books) {
				books.add(book2);
			}
			author.setBooks(books);
			return authorRepo.save(author);
		}
		else
		{
			return null;
		}
	}
}
