package bibliotech.example.bibliotech.controllers;



import bibliotech.example.bibliotech.models.Book;
import bibliotech.example.bibliotech.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    public void removeBook(PathVariable Long id){
        booksService.removeBooks(id);
    }

}
