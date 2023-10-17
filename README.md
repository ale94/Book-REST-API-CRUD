# API REST para Gestión de Libros y Autores
### Spring Boot, JPA, Web, Error Handling, DTO, Swagger, Rest API, H2 Console

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
        "firstName": "Andrés",
        "lastName": "Guzmán",
        "email": "profesor@bolsadeideas.com",
        "createAt": "2018-01-01"
    },
    {
        "id": 2,
        "firstName": "Mr. John",
        "lastName": "Doe",
        "email": "john.doe@gmail.com",
        "createAt": "2018-01-02"
    },
    {
        "id": 3,
        "firstName": "Linus",
        "lastName": "Torvalds",
        "email": "linus.torvalds@gmail.com",
        "createAt": "2018-01-03"
    }
]
```

### Listar clientes por paginación

- **URL**: `/api/customers/page/:page`
- **Método**: `GET`
- **Respuesta exitosa**:

```json
{
    "content": [
    {
        "id": 1,
        "firstName": "Andrés",
        "lastName": "Guzmán",
        "email": "profesor@bolsadeideas.com",
        "createAt": "2018-01-01"
    },
    {
        "id": 2,
        "firstName": "Mr. John",
        "lastName": "Doe",
        "email": "john.doe@gmail.com",
        "createAt": "2018-01-02"
    },
    {
        "id": 3,
        "firstName": "Linus",
        "lastName": "Torvalds",
        "email": "linus.torvalds@gmail.com",
        "createAt": "2018-01-03"
    },
    {
        "id": 4,
        "firstName": "Rasmus",
        "lastName": "Lerdorf",
        "email": "rasmus.lerdorf@gmail.com",
        "createAt": "2018-01-04"
    }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 4,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalElements": 11,
    "totalPages": 3,
    "size": 4,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 4,
    "empty": false
}
```

### Obtener cliente por ID

- **URL**: `/api/customer/:id`
- **Método**: GET
- **Cuerpo de la Solicitud:**

```json
{
    "id": 12,
    "firstName": "Jade",
    "lastName": "Doe",
    "email": "jane.doe@gmail.com",
    "createAt": "2018-03-06"
}
```

### Crear cliente

- **URL**: `/api/customer`
- **Método**: POST
- **Cuerpo de la Solicitud:**

```json
{
    "firstName": "Jade",
    "lastName": "Doe",
    "email": "jane.doe@gmail.com",
    "createAt": "2018-03-06"
}
```

### Actualizar cliente por ID

- **URL**: `/api/customer/:id`
- **Método**: PUT
- **Cuerpo de la Solicitud:**

```json
{
    "firstName": "Jade",
    "lastName": "Doe",
    "email": "jane.doe@gmail.com",
    "createAt": "2018-03-06"
}
```

### Eliminar cliente por ID

- **URL**: `/api/customer/:id`
- **Método**: DELETE
- **Respuesta exitosa**:

```json
{
    "message": "The customer has been successfully deleted"
}
```

