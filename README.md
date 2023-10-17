# API REST para Gestión de Libros y Autores
### Spring Boot, JPA, Web, Error Handling, DTO, Swagger, Rest API, H2 Console, Lombok

## Introducción
API REST que relaciona libros y autores proporciona una interfaz para interactuar con una base de datos de libros y autores a través de solicitudes HTTP. Ofrece endpoints para operaciones como obtener una lista de libros y autores, recuperar información detallada de libros y autores individuales, crear nuevos libros, actualizar registros existentes y eliminar libros. Esto permite a los desarrolladores gestionar la relación entre libros y autores de manera eficiente a través de servicios web RESTful.

## Configuración
Para utilizar la API REST en tu entorno local, sigue estos pasos:

1. Clona este repositorio: `https://github.com/ale94/Book-REST-API-CRUD.git`
2. Crear base de datos H2 Console: `create database testdb`
3. Cambie el nombre de usuario y la contraseña de H2 Console según su instalación:
    - open src/main/resources/application.properties
    - change spring.datasource.username and spring.datasource.password según su instalación de H2
4. Compile y ejecute la aplicación usando maven: `mvn spring-boot:run`
5. La aplicación comenzará a ejecutarse en http://localhost:8080.

## Endpoints
### Author
- **Listar author**: `GET /api/authors`
- **Obtener author por ID**: `GET /api/authors/{id}`
- **Crear author**: `POST /api/authors`
- **Actualizar author por ID**: `PUT /api/authors/{id}`
- **Eliminar author por ID**: `DELETE /api/authors/{id}`

### Book
- **Listar book**: `GET /api/books`
- **Obtener book por ID**: `GET /api/books/{id}`
- **Crear book**: `POST /api/books/authors/{authorId}`
- **Actualizar book por ID**: `PUT /api/books/{bookId}/authors/{authorId}`
- **Eliminar book por ID**: `DELETE /api/books/{id}`
    
## Ejemplos de uso
### Listar books

- **URL**: `/api/books`
- **Método**: `GET`
- **Respuesta exitosa**:

```json
[
  {
    "id": 1,
    "title": "Harry Potter y la piedra filosofal",
    "isbn": "isbn1",
    "publicationDate": "1997-06-26",
    "publisher": "Bloomsbury",
    "price": 8000,
    "quantityInStock": 1000,
    "coverImageURL": "www.imagen.com.ar",
    "description": "Se narran los primeros pasos de Harry en el mundo de la magia, así como su primer enfrentamiento con Voldemort, quien en su búsqueda de la inmortalidad quiere obtener el poder de la piedra filosofal y posee al profesor de defensa contra las artes oscuras.",
    "genre": "fantastic",
    "languaje": "english",
    "author": {
      "id": 1,
      "firstName": "Joanne",
      "lastName": "Rowling",
      "dateOfBirth": "1965-07-31",
      "nationality": "Reino Unido",
      "biography": "Es una escritora, productora de cine y guionista británica, conocida por ser la autora de la serie de libros Harry Potter, que han superado los quinientos millones de ejemplares vendidos.",
      "email": "info@jkrowling.com",
      "website": "www.jkrowling.com"
    }
  },
  {
    "id": 2,
    "title": "It",
    "isbn": "isbn2",
    "publicationDate": "1986-09-15",
    "publisher": "Signet books",
    "price": 10000,
    "quantityInStock": 650,
    "coverImageURL": "www.imagen.com.ar",
    "description": "Cuenta la historia, en un juego de correspondencias con el pasado y el presente, de un grupo de siete amigos que son perseguidos por una entidad sobrenatural, al que llaman «Eso».",
    "genre": "terror",
    "languaje": "english",
    "author": {
      "id": 2,
      "firstName": "Stephen Edwin",
      "lastName": "King",
      "dateOfBirth": "1947-09-21",
      "nationality": "EEUU",
      "biography": "Es un escritor estadounidense de novelas de terror, ficción sobrenatural, misterio, ciencia ficción y literatura fantástica.",
      "email": "contacto@stephenking.es",
      "website": "www.stephenking.com"
    }
  },
  {
    "id": 3,
    "title": "Crónica de una muerte anunciada",
    "isbn": "isbn3",
    "publicationDate": "1981-09-02",
    "publisher": "Cronica",
    "price": 12000,
    "quantityInStock": 250,
    "coverImageURL": "www.imagen.com.ar",
    "description": "Relata en forma de reconstrucción casi periodística el asesinato de Santiago Nasar a manos de los gemelos Vicario",
    "genre": "police",
    "languaje": "spanish",
    "author": {
      "id": 3,
      "firstName": "Gabriel",
      "lastName": "García Márquez",
      "dateOfBirth": "1927-03-06",
      "nationality": "Colombia",
      "biography": "Fue un escritor y periodista colombiano. Reconocido principalmente por sus novelas y cuentos, también escribió narrativa de no ficción, discursos, reportajes, críticas cinematográficas y memorias",
      "email": "contacto@garciamarquez.com",
      "website": "www.garciamarquez.com"
    }
  }
]
```

### Obtener book por ID

- **URL**: `/api/book/{id}`
- **Método**: GET
- **Cuerpo de la Solicitud:**

```json
{
  "id": 1,
  "title": "Harry Potter y la piedra filosofal",
  "isbn": "isbn1",
  "publicationDate": "1997-06-26",
  "publisher": "Bloomsbury",
  "price": 8000,
  "quantityInStock": 1000,
  "coverImageURL": "www.imagen.com.ar",
  "description": "Se narran los primeros pasos de Harry en el mundo de la magia, así como su primer enfrentamiento con Voldemort, quien en su búsqueda de la inmortalidad quiere obtener el poder de la piedra filosofal y posee al profesor de defensa contra las artes oscuras.",
  "genre": "fantastic",
  "languaje": "english",
  "author": {
    "id": 1,
    "firstName": "Joanne",
    "lastName": "Rowling",
    "dateOfBirth": "1965-07-31",
    "nationality": "Reino Unido",
    "biography": "Es una escritora, productora de cine y guionista británica, conocida por ser la autora de la serie de libros Harry Potter, que han superado los quinientos millones de ejemplares vendidos.",
    "email": "info@jkrowling.com",
    "website": "www.jkrowling.com"
  }
}
```

### Crear book

- **URL**: `/api/books/authors/{authorId}`
- **Método**: POST
- **Cuerpo de la Solicitud:**

```json
{
  "title": "string",
  "isbn": "string",
  "publicationDate": "2023-10-17",
  "publisher": "string",
  "price": 0,
  "quantityInStock": 0,
  "coverImageURL": "string",
  "description": "string",
  "genre": "science_fiction",
  "languaje": "spanish"
}
```

### Actualizar book por ID

- **URL**: `/api/books/{bookId}/authors/{authorId}`
- **Método**: PUT
- **Cuerpo de la Solicitud:**

```json
{
  "title": "string",
  "isbn": "string",
  "publicationDate": "2023-10-17",
  "publisher": "string",
  "price": 0,
  "quantityInStock": 0,
  "coverImageURL": "string",
  "description": "string",
  "genre": "science_fiction",
  "languaje": "spanish"
}
```

### Eliminar book por ID

- **URL**: `/api/book/:id`
- **Método**: DELETE
- **Respuesta exitosa**:

```json
{
    "message": "The book has been successfully deleted"
}
```

