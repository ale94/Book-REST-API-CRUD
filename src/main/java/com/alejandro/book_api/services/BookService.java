package com.alejandro.book_api.services;

import com.alejandro.book_api.dto.BookRequest;
import com.alejandro.book_api.entities.BookEntity;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

    BookEntity save(BookRequest author, Long authorId);

    Optional<BookEntity> update(BookRequest author, Long bookId, Long authorId);

    void remove(Long id);

}
