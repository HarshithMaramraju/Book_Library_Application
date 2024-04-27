package Book_Library_Application.Dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
//@JsonInclude(value = Include.NON_NULL)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "title not be null")
	@NotBlank(message = "title not be blank")
	private String title;
	
	@NotNull(message = "author  not be null")
	@NotBlank(message = "author  not be blank")
	private String author;
	
	@NotNull(message = "isbn  not be null")
	@NotBlank(message = "isbn  not be blank")
	private String isbn;
	
	@NotNull(message = "production year   be null")
	@NotBlank(message = "production year date not be blank")
	private int publicationYear;
	
	@NotNull(message = "is rented  not be null")
	@NotBlank(message = "is rented  not be blank")
	private boolean isRented;
	
	@NotNull(message = "rental date not be null")
	@NotBlank(message = "rental date not be blank")
	private LocalDate rentalDate;
	
	@NotNull(message = "retuen date not be null")
	@NotBlank(message = "rental date not be blank")
    private LocalDate returnDate;

	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Author> authors;
	
	@OneToMany(cascade = CascadeType.ALL)
//	@ManyToMany(cascade = CascadeType.ALL)
	private List<Rental> rentals;
	
	@NotNull(message = "is avaliable  not be null")
	@NotBlank(message = "is avaliable not be blank")
	private String isAvailable;

	@NotNull(message = "renter name  be null")
	@NotBlank(message = "renter name not be blank")
	private String renterName;
	
	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	
	
	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentalId) {
		this.rentals = rentalId;
	}
	
	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	
	
	public boolean isReturned() {
		return isRented;
	}

	public void setReturned(boolean isReturned) {
		this.isRented = isRented;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publicationYear="
				+ publicationYear + ", isRented=" + isRented + ", rentalDate=" + rentalDate + ", returnDate="
				+ returnDate + ", authors=" + authors + ", rentals=" + rentals + ", isAvailable=" + isAvailable + "]";
	}

	
	 public void rentBook(String renterName, LocalDate rentalDate) {
	        this.isRented = true;
	        this.renterName = renterName;
	        this.rentalDate = rentalDate;
	    }
	
	public void returnBook(LocalDate returnDate) {
        this.isRented = false;
        this.returnDate = returnDate;
    }
	
	
	
	
	
}
