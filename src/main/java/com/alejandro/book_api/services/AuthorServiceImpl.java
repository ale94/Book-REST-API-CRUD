package com.alejandro.book_api.services;

import com.alejandro.book_api.dto.AuthorRequest;
import com.alejandro.book_api.entities.AuthorEntity;
import com.alejandro.book_api.repositories.AuthorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<AuthorEntity> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public AuthorEntity save(AuthorRequest author) {
        return repository.save(clientRequestToClient(author));
    }

    @Transactional
    @Override
    public Optional<AuthorEntity> update(AuthorRequest author, Long id) {
        Optional<AuthorEntity> searchedAuthor = repository.findById(id);
        if (searchedAuthor.isPresent()) {
            AuthorEntity authorDB = searchedAuthor.get();
            if (author.getFirstName() != null) {
                authorDB.setFirstName(author.getFirstName());
            }
            if (author.getLastName() != null) {
                authorDB.setLastName(author.getLastName());
            }
            if (author.getDateOfBirth() != null) {
                authorDB.setDateOfBirth(author.getDateOfBirth());
            }
            if (author.getNationality() != null) {
                authorDB.setNationality(author.getNationality());
            }
            if (author.getBiography() != null) {
                authorDB.setBiography(author.getBiography());
            }
            if (author.getEmail() != null) {
                authorDB.setEmail(author.getEmail());
            }
            if (author.getWebsite() != null) {
                authorDB.setWebsite(author.getWebsite());
            }
            return Optional.of(repository.save(authorDB));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    private AuthorEntity clientRequestToClient(AuthorRequest request) {
        var response = new AuthorEntity();
        BeanUtils.copyProperties(request, response);
        return response;
    }
}
