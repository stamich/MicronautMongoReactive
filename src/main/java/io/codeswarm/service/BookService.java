package io.codeswarm.service;

import io.codeswarm.model.Book;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findOneByTitle(@NotEmpty String title);
    void create(@NotNull Book book);
    void update(@NotNull Book book);
    void delete(@NotNull ObjectId id);
}
