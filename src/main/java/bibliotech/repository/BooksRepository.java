package bibliotech.repository;

import bibliotech.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository <Book, Long> {
    List<Book> findByAutor(String autor);
    List<Book> findByTitulo(String titulo);
    List<Book> findByGenero(String genero);
}
