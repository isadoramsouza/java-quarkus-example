package com.isadora.model.adapter;

import com.isadora.model.dto.BookDTO;
import com.isadora.model.Book;

public class BookAdapter {

    public static Book toBook(BookDTO bookDTO){
        return Book.builder().id(bookDTO.getId()).name(bookDTO.getName()).author(bookDTO.getAuthor()).build();
    }

    public static BookDTO toBookDTO(Book book){
        return BookDTO.builder().id(book.getId()).name(book.getName()).author(book.getAuthor()).build();
    }
}
