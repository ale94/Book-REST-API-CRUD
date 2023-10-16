package com.alejandro.book_api.services;

import com.alejandro.book_api.dto.AuthorRequest;
import com.alejandro.book_api.entities.AuthorEntity;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findById(Long id);

    AuthorEntity save(AuthorRequest author);

    Optional<AuthorEntity> update(AuthorRequest author, Long id);

    void remove(Long id);
}
