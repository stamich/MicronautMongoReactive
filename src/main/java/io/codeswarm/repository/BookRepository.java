package io.codeswarm.repository;

import io.codeswarm.model.Book;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface BookRepository {

    Single<List<Book>> findAll();
    Maybe<Book> findOneByTitle(@NotEmpty String title);
    Single<Book> create(@NotNull Book book);
    Single<Book> update(@NotNull Book book);
    Maybe<Book> delete(@NotNull ObjectId id);
}
