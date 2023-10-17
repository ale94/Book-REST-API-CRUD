package com.alejandro.book_api.controllers;

import com.alejandro.book_api.dto.BookRequest;
import com.alejandro.book_api.entities.BookEntity;
import com.alejandro.book_api.services.BookService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService service;

    @GetMapping("/books")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<BookEntity> book = service.findById(id);
        if (book.isEmpty()) {
            //throw new UserNotFoundException("users", "id", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books/authors/{authorId}")
    public ResponseEntity<?> create(@RequestBody BookRequest request, @PathVariable Long authorId) {
        var book = service.save(request, authorId);
        if (book != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/books/{bookId}/authors/{authorId}")
    public ResponseEntity<?> update(@RequestBody BookRequest request, @PathVariable Long bookId,
        @PathVariable Long authorId) {
        Optional<BookEntity> searchedBook = service.findById(bookId);
        if (searchedBook.isEmpty()) {
            //throw new UserNotFoundException("users", "id", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.update(request, bookId, authorId));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<BookEntity> book = service.findById(id);
        if (book.isEmpty()) {
            //throw new UserNotFoundException("users", "id", id);
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
