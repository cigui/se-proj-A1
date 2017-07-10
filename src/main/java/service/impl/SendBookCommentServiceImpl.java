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
	 

	 public List<BookComment> getBookCommentById(int id){
		 return bookCommentDao.getBookCommentById(id);
	 }
	 
	 public List<BookComment> getAllBookComments(){
		 return bookCommentDao.getAllBookComments();
	 }
	 
	 public void SendBookComment(int id,long isbn,String discription,byte score){
		 BookComment bookComment = new BookComment(id,isbn,discription,score);
		 bookCommentDao.save(bookComment);
		 
	 }
	 
	 public List<BookComment> getBookCommentByISBN(int ISBN){
		 return bookCommentDao.getBookCommentByIsbn(ISBN);
	 }

}


