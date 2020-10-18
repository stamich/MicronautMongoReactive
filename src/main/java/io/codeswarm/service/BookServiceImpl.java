package io.codeswarm.service;

import io.codeswarm.model.Book;
import io.codeswarm.repository.BookRepository;
import org.bson.types.ObjectId;

import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Singleton
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll().blockingGet();
    }

    @Override
    public Book findOneByTitle(@NotEmpty String title) {
        return bookRepository.findOneByTitle(title).blockingGet();
    }

    @Override
    public void create(@NotNull Book book) {
        bookRepository.create(book).blockingGet();
    }

    @Override
    public void update(@NotNull Book book) {
        bookRepository.update(book).blockingGet();
    }

    @Override
    public void delete(@NotNull ObjectId id) {
        bookRepository.delete(id).blockingGet();
    }
}
