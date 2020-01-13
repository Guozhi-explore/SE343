package com.example.servlet.service;

import com.example.servlet.entity.Book;
import com.example.servlet.entity.BookCombination;
import com.example.servlet.entity.staBook;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface BookService {
    List<BookCombination> findAllBook();
    void updateBook(Integer book_id,String name,String author,String  isbn,String abstrac,String img_src,Integer price,Integer amount,Integer sales);
    void addBook(String name,String author,String isbn,String abstrac,String img_src,Integer price,Integer amount);
    Book selectBookById(Integer ID);
    void deleteBook(Integer ID);
    List<staBook> statisticBookData(String time1,String time2);
    String uploadComment(Integer book_id,String user_id,String content);
}
