package io.codeswarm.repository;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.codeswarm.model.Book;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.bson.types.ObjectId;

import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Singleton
public class BookRepositoryImpl implements BookRepository {

    private final MongoClient mongoClient;

    public BookRepositoryImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public Single<List<Book>> findAll() {
        return Flowable
                .fromPublisher(getCollection().find())
                .toList();
    }

    @Override
    public Maybe<Book> findOneByTitle(@NotEmpty String title) {
        return Flowable
                .fromPublisher(getCollection().find(eq("title", title)).limit(1))
                .firstElement();
    }

    @Override
    public Single<Book> create(@NotNull Book book) {
        return Single
                .fromPublisher(getCollection().insertOne(book))
                .map(success -> book);
    }

    @Override
    public Single<Book> update(@NotNull Book book) {
        return Single
                .fromPublisher(getCollection().findOneAndReplace(eq("title", book.getTitle()), book))
                .map(success -> book);
    }

    @Override
    public Maybe<Book> delete(@NotNull ObjectId id) {
        return Flowable
                .fromPublisher(getCollection().findOneAndDelete(eq("id", id)))
                .firstElement();
    }

    private MongoCollection<Book> getCollection() {
        return mongoClient
                .getDatabase("bookstore")
                .getCollection("book", Book.class);
    }
}
