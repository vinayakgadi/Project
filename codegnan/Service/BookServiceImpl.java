package com.codegnan.Service;

import java.util.List;

import com.codegnan.DAO.BookDaoimpl;
import com.codegnan.Exception.BookNotFoundException;
import com.codegnan.model.Book;

public class BookServiceImpl implements BookService {
	BookDaoimpl dao=new BookDaoimpl();

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		dao.save(book);
		
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Book getBookById(int id) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void updateBook(Book book) throws BookNotFoundException {
		// TODO Auto-generated method stub
		dao.Update(book);
		
	}

	@Override
	public void deleteBook(int id) throws BookNotFoundException {
		// TODO Auto-generated method stub
		dao.DeleteById(id);
	}

}
