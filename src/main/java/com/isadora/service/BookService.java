package com.isadora.service;

import com.isadora.model.adapter.BookAdapter;
import com.isadora.model.dto.BookDTO;
import com.isadora.exception.BookNotFoundException;
import com.isadora.repository.BookRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@AllArgsConstructor
@ApplicationScoped
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public BookDTO findById(Long id){
        return BookAdapter.toBookDTO(bookRepository.findByIdOptional(id).orElseThrow(BookNotFoundException::new));
    }

    public void save(BookDTO bookDTO){
        bookRepository.persistAndFlush(BookAdapter.toBook(bookDTO));
    }

    public void delete(Long id){
        BookDTO bookDTO = findById(id);
        bookRepository.delete(BookAdapter.toBook(bookDTO));
    }

}
