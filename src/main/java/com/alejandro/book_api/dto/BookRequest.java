package com.alejandro.book_api.dto;

import com.alejandro.book_api.entities.AuthorEntity;
import com.alejandro.book_api.util.Genre;
import com.alejandro.book_api.util.Languaje;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest implements Serializable {

    private String title;
    private String isbn;
    private LocalDate publicationDate;
    private String publisher;
    private Double price;
    private Integer quantityInStock;
    private String coverImageURL;
    private String description;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Languaje languaje;


}
