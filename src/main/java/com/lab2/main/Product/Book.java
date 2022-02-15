package com.lab2.main.Product;

import java.util.Objects;

public class Book extends Product{

    private String author;

    public Book(int id, String name, float price, String authors) {
        super(id, name, price);
        this.author = authors;
    }

    public Book(Book other){
        super(other.getId(), other.getName(), other.getPrice());
        this.author = other.getAuthor();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String toString() {
        return "Book{" +
                super.toString() +
                "author=" + author +
                '}';
    }
}
