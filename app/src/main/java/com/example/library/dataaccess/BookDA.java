package com.example.library.dataaccess;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookDA
        implements IBookDA{
    private List<Book> books = new ArrayList<>();

    public BookDA(){
        books.add(new Book("Java Programming", "200",
                "Programming"));
        books.add(new Book("Android Develoipment", "200",
                "Programming"));
        books.add(new Book("The art of testiong", "200",
                "Testing"));
        books.add(new Book("QA and Testing", "200",
                "Testing"));
        books.add(new Book("Beginning Photoshop", "200",
                "Design"));

    }
    @Override
    public String[] getCats() {
        String[] cats = {"Programming", "Testing", "Design"};
        return cats;

    }

    @Override
    public List<Book> getBooks(String cat) {
        List<Book> result = new ArrayList<>();

        for(Book b: books){
            if(b.getCategory().equals(cat)){
                result.add(b);
            }
        }
        return result;

    }
}

