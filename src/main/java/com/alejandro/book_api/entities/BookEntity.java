package com.alejandro.book_api.entities;

import com.alejandro.book_api.util.Genre;
import com.alejandro.book_api.util.Languaje;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @JsonIgnoreProperties({"books", "hibernateLazyInitializer", "handler"})
    @ManyToOne
    private AuthorEntity author;

}
