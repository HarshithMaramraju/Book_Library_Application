package Book_Library_Application.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Book_Library_Application.Dto.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
