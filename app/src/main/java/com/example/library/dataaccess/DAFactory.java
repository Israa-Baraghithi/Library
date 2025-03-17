package com.example.library.dataaccess;

public class DAFactory {
    public IBookDA getInstance(){

        return new BookDA();

    }
}
