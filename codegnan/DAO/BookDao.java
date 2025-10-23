package com.codegnan.DAO;

import java.util.List;

import com.codegnan.Exception.BookNotFoundException;
import com.codegnan.model.Book;

public interface BookDao {
	public void save(Book book);
	public List<Book> finalAll();
	public Book findById(int id) throws BookNotFoundException;
	public void Update(Book book)throws BookNotFoundException;
	public void DeleteById(int Id)throws BookNotFoundException;
	List<Book> findAll();

}
