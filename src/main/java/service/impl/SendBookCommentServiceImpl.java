package service.impl;

import model.BookComment;
import service.SendBookCommentService;

import java.util.List;

import dao.BookCommentDao;

/**
 * @author YuHaifeng
 * @version 1.0
 * 
 */
public class SendBookCommentServiceImpl implements SendBookCommentService {
	private BookCommentDao bookCommentDao;
	
	 public void setBookCommentDao(BookCommentDao bookCommentDao) {
		this.bookCommentDao = bookCommentDao;
	 }
	 
	 public Integer save(BookComment bookComment){
		 return bookCommentDao.save(bookComment);
	 }
	 
	 public void delete(BookComment bookComment){
		 bookCommentDao.delete(bookComment);
	 }
	 
	 public void update(BookComment bookComment){
		 bookCommentDao.update(bookComment);
	 }
	 
	 public BookComment getBookCommentByISBN(int ISBN){
		 return bookCommentDao.getBookCommentByIsbn(ISBN);
	 }
	 
	 public BookComment getBookCommentById(int id){
		 return bookCommentDao.getBookCommentById(id);
	 }
	 
	 public List<BookComment> getAllBookComments(){
		 return bookCommentDao.getAllBookComments();
	 }
	 
	 public boolean SendBookComment(BookComment bookComment){
		 if (bookCommentDao.save(bookComment))
			 return True;
		 else
			 return False;
	 }
}


