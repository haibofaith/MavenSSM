package service;

import java.util.List;

import model.Book;

public interface IBookService {
	Book getBookById(String bookId); 
	List<Book> getBookByName(String bookName);
}
