package io.codeswarm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Introspected;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;

@Introspected
@SuppressWarnings("unused")
public class Book {


    @JsonIgnore
    private ObjectId id;

    @NotBlank
    private String author;

    @NotBlank
    private String title;

    @NotBlank
    private String isbn;

    @NotBlank
    private Boolean available;

    public Book() {

    }

    public Book(ObjectId id, @NotBlank String author, @NotBlank String title, @NotBlank String isbn, @NotBlank Boolean available) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.available = available;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
