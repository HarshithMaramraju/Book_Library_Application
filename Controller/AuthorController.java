package Book_Library_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Book_Library_Application.Dto.Author;
import Book_Library_Application.Dto.Book;
import Book_Library_Application.Service.AuthorService;
import Book_Library_Application.Util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	
	@PostMapping("/insertAuthor")
	public ResponseStructure<Author> insert(@Valid @RequestBody Author author)
	{
		return authorService.insert(author);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/findAllAuthor")
	public ResponseStructure<Author> findAll(Author author)
	{
		return authorService.findAll(author);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/findByIdAuthor")
	public ResponseEntity<ResponseStructure<Author>> findById(@RequestParam int authorId) {
		return authorService.findById(authorId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PutMapping("/updateAuthor")
	public ResponseEntity<ResponseStructure<Author>> update(@RequestParam int authorId, @Valid @RequestBody Author author) {
		return authorService.update(authorId, author);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@DeleteMapping("/deleteAuthor")
	public ResponseEntity<ResponseStructure<Author>> delete(@RequestParam int authorId) {
		
		return authorService.delete(authorId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PutMapping("/addExistingBooktoExistingAuthor")
	public ResponseEntity<ResponseStructure<Author>> addExistingBooktoExistingAuthor(@RequestParam int authorId, @RequestParam int bookId) {
		return authorService.addExistingBooktoExistingAuthor(authorId, bookId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PutMapping("/addNewBookToExistingAuthor")
	public ResponseEntity<ResponseStructure<Author>> addNewBookToExistingAuthor(@RequestParam int authorId, @Valid @RequestBody List<Book> books) {
		return authorService.addNewBookToExistingAuthor(authorId, books);
	}
}
