package com.BookFlow.CatalogueService.rest;

import com.BookFlow.CatalogueService.domain.model.queries.GetAllBooksQuery;
import com.BookFlow.CatalogueService.domain.model.queries.GetBookByIdQuery;
import com.BookFlow.CatalogueService.domain.model.queries.GetBookByNameQuery;
import com.BookFlow.CatalogueService.domain.model.valueobjects.BookName;
import com.BookFlow.CatalogueService.domain.services.BookCommandService;
import com.BookFlow.CatalogueService.domain.services.BookQueryService;
import com.BookFlow.CatalogueService.rest.resources.BookResource;
import com.BookFlow.CatalogueService.rest.resources.CreateBookResource;
import com.BookFlow.CatalogueService.rest.transform.BookResourceFromEntityAssembler;
import com.BookFlow.CatalogueService.rest.transform.CreateBookCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/v1/books", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Book", description="Books Management Endpoints")
public class BookController {
    private final BookQueryService bookQueryService;
    private final BookCommandService bookCommandService;

    public BookController(BookQueryService bookQueryService, BookCommandService bookCommandService){
        this.bookQueryService = bookQueryService;
        this.bookCommandService = bookCommandService;
    }
    @PostMapping
    public ResponseEntity<BookResource> CreateBook(@RequestBody CreateBookResource resource) {
        var createBookCommand = CreateBookCommandFromResourceAssembler.toCommandFromResource(resource); // CreateCategoryCommand
        var book = bookCommandService.handle(createBookCommand); //
        if (book.isEmpty()) return ResponseEntity.badRequest().build();
        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(book.get());
        return new ResponseEntity<>(bookResource, HttpStatus.CREATED);
    }
    @GetMapping("/bookId/{bookId}")
    public ResponseEntity<BookResource> getBookById(@PathVariable Long bookId) {
        var getBookByIdQuery = new GetBookByIdQuery(bookId);
        var book = bookQueryService.handle(getBookByIdQuery);
        if (book.isEmpty()) return ResponseEntity.badRequest().build();
        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(book.get());
        return ResponseEntity.ok(bookResource);
    }
    @GetMapping("/bookTittle/{name}")
    public ResponseEntity<BookResource> getBookByName(@PathVariable String name) {
        var nameBook = new BookName(name);
        var getBookByNameQuery = new GetBookByNameQuery(nameBook);
        var book = bookQueryService.handle(getBookByNameQuery);
        if (book.isEmpty()) return ResponseEntity.badRequest().build();
        var bookResource = BookResourceFromEntityAssembler.toResourceFromEntity(book.get());
        return ResponseEntity.ok(bookResource);
    }
    @GetMapping
    public ResponseEntity<List<BookResource>> getAllBooks(){
        var getBooksQuery = new GetAllBooksQuery();
        var books = bookQueryService.handle(getBooksQuery);
        var bookResources = books.stream().map(BookResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(bookResources);
    }
}
