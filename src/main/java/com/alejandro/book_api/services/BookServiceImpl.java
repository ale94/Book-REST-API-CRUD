package com.alejandro.book_api.services;

import com.alejandro.book_api.dto.BookRequest;
import com.alejandro.book_api.entities.BookEntity;
import com.alejandro.book_api.repositories.AuthorRepository;
import com.alejandro.book_api.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional()
    @Override
    public BookEntity save(BookRequest request, Long authorId) {
        var author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            var book = bookRequestToBook(request);
            book.setAuthor(author.get());
            return bookRepository.save(book);
        }
        return null;
    }

    @Transactional()
    @Override
    public Optional<BookEntity> update(BookRequest request, Long bookId, Long authorId) {
        Optional<BookEntity> searchedBook = bookRepository.findById(bookId);
        if (searchedBook.isPresent()) {
            var author = authorRepository.findById(authorId).get();
            BookEntity bookDB = searchedBook.get();
            bookDB.setAuthor(author);
            bookDB.setTitle(request.getTitle());
            bookDB.setIsbn(request.getIsbn());
            bookDB.setGenre(request.getGenre());
            return Optional.of(bookRepository.save(bookDB));
        }
        return Optional.empty();
    }

    @Transactional()
    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    private BookEntity bookRequestToBook(BookRequest request) {
        var book = new BookEntity();
        BeanUtils.copyProperties(request, book);
        return book;
    }
}
