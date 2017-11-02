package service;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.BookMapper;
import model.Book;

@Service("userService")
public class BookServiceImpl implements IBookService{
	@Resource
	private BookMapper bookDao;
	
	public Book getBookById(String bookId) {
		// TODO Auto-generated method stub
		return this.bookDao.selectByPrimaryKey(bookId);
	}
	
	public List<Book> getBookByName(String bookName) {
		return this.bookDao.selectByName(bookName);
	}
}
