package com.alejandro.book_api.controllers;

import com.alejandro.book_api.dto.AuthorRequest;
import com.alejandro.book_api.entities.AuthorEntity;
import com.alejandro.book_api.services.AuthorService;
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
public class AuthorController {

    private final AuthorService service;

    @GetMapping("/authors")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<AuthorEntity> author = service.findById(id);
        if (author.isEmpty()) {
            //throw new UserNotFoundException("users", "id", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @PostMapping("/authors")
    public ResponseEntity<?> create(@RequestBody AuthorRequest author) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.save(author));
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<?> update(@RequestBody AuthorRequest author, @PathVariable Long id) {
        Optional<AuthorEntity> searchedAuthor = service.findById(id);
        if (searchedAuthor.isEmpty()) {
            //throw new UserNotFoundException("users", "id", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.update(author, id));
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<AuthorEntity> author = service.findById(id);
        if (author.isEmpty()) {
            //throw new UserNotFoundException("users", "id", id);
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

}
