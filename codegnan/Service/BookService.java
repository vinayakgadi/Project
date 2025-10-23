package com.codegnan.Service;

import java.util.List;

import com.codegnan.Exception.BookNotFoundException;
import com.codegnan.model.Book;

public interface BookService {
	void addBook(Book book);
	List<Book> getAllBook();
	Book getBookById(int id) throws BookNotFoundException;
	void updateBook(Book book) throws  BookNotFoundException;
	void deleteBook(int id) throws BookNotFoundException;

}
