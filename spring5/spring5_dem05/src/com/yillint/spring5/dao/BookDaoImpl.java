package com.yillint.spring5.dao;

import com.yillint.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        //创建sql语句
        String sql = "insert into t_book values(?,?,?)";
        //调用方法
        Object[] args = {book.getUserId(), book.getUsername(), book.getUstaus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void deleteBook(String id) {
        //创建sql语句
        String sql = "delete from t_book where user_id = ?";
        //调用方法
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        //创建sql语句
        String sql = "update t_book set username = ?, ustaus = ? where user_id = ?";
        //调用方法
        Object[] args = {book.getUsername(), book.getUstaus(),book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        //创建sql语句
        String sql = "select count(*) from t_book";
        //调用方法
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        //创建sql语句
        String sql = "select * from t_book where user_id = ?";
        //调用方法
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        //创建sql语句
        String sql = "select * from t_book";
        //调用方法
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    //批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        //创建sql语句
        String sql = "insert into t_book value (?,?,?)";
        //调用方法
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        //创建sql语句
        String sql = "update t_book set username = ?,ustaus = ? where user_id = ?";
        //调用方法
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        //创建sql语句
        String sql = "delete from t_book where user_id = ?";
        //调用方法
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }


}
