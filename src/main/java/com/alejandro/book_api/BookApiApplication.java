package com.alejandro.book_api;

import com.alejandro.book_api.entities.AuthorEntity;
import com.alejandro.book_api.entities.BookEntity;
import com.alejandro.book_api.repositories.AuthorRepository;
import com.alejandro.book_api.repositories.BookRepository;
import com.alejandro.book_api.util.Genre;
import com.alejandro.book_api.util.Languaje;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class BookApiApplication implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var author1 = AuthorEntity.builder()
            .firstName("Joanne")
            .lastName("Rowling")
            .dateOfBirth(LocalDate.of(1965, 7, 31))
            .nationality("Reino Unido")
            .biography("Es una escritora, productora de cine y guionista británica, "
                + "conocida por ser la autora de la serie de libros Harry Potter, "
                + "que han superado los quinientos millones de ejemplares vendidos.")
            .email("info@jkrowling.com")
            .website("www.jkrowling.com")
            .build();

        var author2 = AuthorEntity.builder()
            .firstName("Stephen Edwin")
            .lastName("King")
            .dateOfBirth(LocalDate.of(1947, 9, 21))
            .nationality("EEUU")
            .biography("Es un escritor estadounidense de novelas de terror, "
                + "ficción sobrenatural, misterio, ciencia ficción y literatura fantástica.")
            .email("contacto@stephenking.es")
            .website("www.stephenking.com")
            .build();

        var author3 = AuthorEntity.builder()
            .firstName("Gabriel")
            .lastName("García Márquez")
            .dateOfBirth(LocalDate.of(1927, 3, 6))
            .nationality("Colombia")
            .biography("Fue un escritor y periodista colombiano. Reconocido principalmente "
                + "por sus novelas y cuentos, también escribió narrativa de no ficción, discursos, "
                + "reportajes, críticas cinematográficas y memorias")
            .email("contacto@garciamarquez.com")
            .website("www.garciamarquez.com")
            .build();

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        var book1 = BookEntity.builder()
            .title("Harry Potter y la piedra filosofal")
            .isbn("isbn1")
            .publicationDate(LocalDate.of(1997, 6, 26))
            .publisher("Bloomsbury")
            .price(8000d)
            .quantityInStock(1000)
            .coverImageURL("www.imagen.com.ar")
            .description("Se narran los primeros pasos de Harry en el mundo de la magia, "
                + "así como su primer enfrentamiento con Voldemort, quien en su búsqueda de la "
                + "inmortalidad quiere obtener el poder de la piedra filosofal y posee al profesor "
                + "de defensa contra las artes oscuras.")
            .genre(Genre.fantastic)
            .languaje(Languaje.english)
            .author(author1)
            .build();

        var book2 = BookEntity.builder()
            .title("It")
            .isbn("isbn2")
            .publicationDate(LocalDate.of(1986, 9, 15))
            .publisher("Signet books")
            .price(10000d)
            .quantityInStock(650)
            .coverImageURL("www.imagen.com.ar")
            .description("Cuenta la historia, en un juego de correspondencias con el pasado y "
                + "el presente, de un grupo de siete amigos que son perseguidos por una entidad "
                + "sobrenatural, al que llaman «Eso».")
            .genre(Genre.terror)
            .languaje(Languaje.english)
            .author(author2)
            .build();

        var book3 = BookEntity.builder()
            .title("Crónica de una muerte anunciada")
            .isbn("isbn3")
            .publicationDate(LocalDate.of(1981, 9, 2))
            .publisher("Cronica")
            .price(12000d)
            .quantityInStock(250)
            .coverImageURL("www.imagen.com.ar")
            .description("Relata en forma de reconstrucción casi periodística el asesinato "
                + "de Santiago Nasar a manos de los gemelos Vicario")
            .genre(Genre.police)
            .languaje(Languaje.spanish)
            .author(author3)
            .build();

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);


    }
}
