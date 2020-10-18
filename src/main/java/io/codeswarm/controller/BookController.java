package io.codeswarm.controller;

import io.codeswarm.model.Book;
import io.codeswarm.service.BookService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Get()
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @Get("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookByTitle(@PathVariable("title") String title) {
        return bookService.findOneByTitle(title);
    }

    @Post()
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse<String> saveOrUpdateBeer(@Body Book book) {
        bookService.create(book);
        return HttpResponse.ok("Book added successfully");
    }

    @Delete("/{title}")
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse<String> deleteBeer(@PathVariable("title") String title) {
        bookService.delete(bookService.findOneByTitle(title).getId());
        return HttpResponse.ok("Beer deleted successfully");
    }
}
