package Book_Library_Application.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Book_Library_Application.Dto.Rental;

public interface RentalRepo extends JpaRepository<Rental, Integer>{

}
