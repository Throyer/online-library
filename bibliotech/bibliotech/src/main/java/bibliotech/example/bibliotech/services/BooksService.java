package bibliotech.example.bibliotech.services;

import bibliotech.example.bibliotech.models.Book;
import bibliotech.example.bibliotech.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public Book addBoks(Book book) {
        return booksRepository.save(book);
    }

    public Book editBooks(Book book) {
        return booksRepository.save(book);
    }

    public void removeBooks(Long id) {
        booksRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public List<Book> findBooksByAutor(String autor) {
        return booksRepository.findByAutor(autor);
    }
    public List<Book> findBooksByTitulo(String titulo) {
        return booksRepository.findByTitulo(titulo);
    }
    public List<Book> fiindBooksByGenero(String genero){
        return booksRepository.findByGenero(genero);
    }

}
