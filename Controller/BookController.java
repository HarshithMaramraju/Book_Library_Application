package Book_Library_Application.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Book_Library_Application.Dto.Book;
import Book_Library_Application.Dto.Rental;
import Book_Library_Application.Service.BookService;
import Book_Library_Application.Util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@ApiOperation(value = "Book inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "book saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PostMapping("/insertBook")
	public ResponseStructure<Book> insertBook(@Valid @RequestBody Book book) {
		return bookService.insetBook(book);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/fetchAllBooks")
	public ResponseStructure<Book> findAll(Book book)
	{
		return bookService.fetchAll(book);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Book>> findById(@RequestParam int bookId){
		return bookService.findById(bookId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PutMapping("/updateBook")
	public ResponseEntity<ResponseStructure<Book>> update(@RequestParam int bookId, @Valid @RequestBody Book book)
	{
		return bookService.update(bookId, book);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@DeleteMapping("/deleteBook")
	public ResponseEntity<ResponseStructure<Book>> delete(@RequestParam int bookId)
	{
		return bookService.delete(bookId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PutMapping("/addExistingBookToExistingRental")
	public ResponseEntity<ResponseStructure<Book>> addExistingBookToExistingRental(@RequestParam int bookId,  @RequestParam int rentalId) {
		return bookService.addExistingBookToExistingRental(bookId, rentalId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PutMapping("/addNewBookToExistingRental")
	public ResponseEntity<ResponseStructure<Book>> addNewBookToExistingRental(@RequestParam int bookId, @Valid @RequestBody List<Rental> rentals) {
		return bookService.addNewBookToExistingRental(bookId, rentals);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/isBookRented")
	public boolean isBookRented(int bookId)
	{
		return bookService.isBookRented(bookId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/rentBook")
	public ResponseEntity<ResponseStructure<Book>> rentBook(@RequestParam int bookId, @Valid @RequestBody String rentName,@Valid @RequestBody LocalDate rentalDate) {
		return bookService.rentBook(bookId, rentName, rentalDate);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/getOverRentals")
	public ResponseStructure<Book> getOverRentals(@Valid @RequestBody Book book) {
		return bookService.getOverRentals(book);
	}

}
