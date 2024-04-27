package Book_Library_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Book_Library_Application.Dto.Rental;
import Book_Library_Application.Service.RentalService;
import Book_Library_Application.Util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class RentalController {

	@Autowired
	RentalService rentalService;
	
	@ApiOperation(value = "Rental inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Rental saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PostMapping("/insertRental")
	public ResponseStructure<Rental> insert( @Valid @RequestBody Rental rental)
	{
		return rentalService.insetBook(rental);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/findAll")
	public ResponseStructure<Rental> findAll(Rental rental)
	{
		return rentalService.fetchAll(rental);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@GetMapping("/findByIdRental")
	public ResponseEntity<ResponseStructure<Rental>> findById(@RequestParam int rentalId){
		return rentalService.findById(rentalId);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PutMapping("/updateRental")
	public ResponseEntity<ResponseStructure<Rental>> update(@RequestParam int rentalId,@Valid @RequestBody Rental rental) {
		return rentalService.update(rentalId, rental);
	}
	
	@ApiOperation(value = "Author inserted", notes = "Api used for Inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "Author saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@DeleteMapping("/deleteRental")
	public ResponseEntity<ResponseStructure<Rental>> delete(@RequestParam int rentalId) {
		return rentalService.delete(rentalId);
	}
	
}
