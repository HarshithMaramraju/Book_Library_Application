package Book_Library_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Book_Library_Application.Dao.AuthorDao;
import Book_Library_Application.Dto.Author;
import Book_Library_Application.Dto.Book;
import Book_Library_Application.ExcetionHandiler.AuthorIdNotFound;
import Book_Library_Application.Util.ResponseStructure;

@Service
public class AuthorService {

	@Autowired
	AuthorDao authorDao;
	
	public ResponseStructure<Author> insert(Author	author) {
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Inserted Successfully");
		responseStructure.setData(authorDao.insertAuthor(author));
		return responseStructure;
	}
	
	public ResponseStructure<Author> findAll(Author author) {
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("fetch successful");
		responseStructure.setDatas(authorDao.findAll(author));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Author>> findById(int authorId)
	{
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		Author author = authorDao.findById(authorId);
		if (author!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Fetch By Id Successful");
			responseStructure.setData(authorDao.findById(authorId));
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure,HttpStatus.FOUND);			
		}
		else
		{
			throw new AuthorIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> update(int authorId, Author author)
	{
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		Author author2 = authorDao.update(authorId, author);
		if (author2!=null)
		{
			responseStructure.setMessage("updates successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(authorDao.update(authorId, author2));
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure,HttpStatus.OK);
		}
		else 
		{
			throw new AuthorIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> delete(int authorId)
	{
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		Author author = authorDao.delete(authorId);
		if (author!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			responseStructure.setData(authorDao.delete(authorId));
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new AuthorIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> addExistingBooktoExistingAuthor(int authorId, int bookId) {
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		Author author = authorDao.findById(authorId);
		if (author!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(authorDao.addExistingBooktoExistingAuthor(authorId, bookId));
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new AuthorIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> addNewBookToExistingAuthor(int authorId, List<Book> books) {
		ResponseStructure<Author> responseStructure = new ResponseStructure<>();
		Author author = authorDao.addNewBookToExistingAuthor(authorId, books);
		if (author!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Added successfully");
			responseStructure.setData(authorDao.addNewBookToExistingAuthor(authorId, books));
			return new ResponseEntity<ResponseStructure<Author>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new AuthorIdNotFound();
		}
	}
}
