package com.yillint.spring5.dao;

import com.yillint.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void deleteBook(String id);
    void updateBook(Book book);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
