package bibliotech.controllers;

import bibliotech.models.Book;
import bibliotech.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return booksService.addBoks(book);
    }

    @PutMapping("/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return booksService.editBooks(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        booksService.removeBooks(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String autor,
                                  @RequestParam(required = false) String titulo,
                                  @RequestParam(required = false) String genero) {
        if (autor != null) {
            return booksService.findBooksByAutor(autor);
        } else if (titulo != null) {
            return booksService.findBooksByTitulo(titulo);
        } else if (genero != null) {
            return booksService.findBooksByGenero(genero);
        } else {
            return booksService.getAllBooks();
        }

    }
}