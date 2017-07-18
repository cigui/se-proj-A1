package service.impl;

import model.BookComment;
import service.BookCommentService;

import java.util.List;

import dao.BookCommentDao;


public class BookCommentServiceImpl implements BookCommentService {
	private BookCommentDao bookCommentDao;
	
	 public void setBookCommentDao(BookCommentDao bookCommentDao) {
		this.bookCommentDao = bookCommentDao;
	 }
	 
	 public BookComment save(BookComment bookComment){
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
		 List<BookComment> bookCommentsExist = bookCommentDao.getBookCommentById(id);
		 int k = 0;
		 for (BookComment item : bookCommentsExist){
			if (item.getIsbn() == isbn){
				k=1;
			}
		 }
		 if (k == 1){
			 bookCommentDao.update(bookComment);
		 }
		 if (k == 0){
			 bookCommentDao.save(bookComment);
		 }
		 
	 }
	 
	 public List<BookComment> getBookCommentByISBN(long ISBN){
		 return bookCommentDao.getBookCommentByIsbn(ISBN);
	 }

}


