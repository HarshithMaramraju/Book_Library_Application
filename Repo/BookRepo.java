package Book_Library_Application.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Book_Library_Application.Dto.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
