package service.impl;

import java.io.File;
import java.util.List;

import dao.BookReleaseDao;
import model.BookRelease;
import service.BookReleaseService;

public class BookReleaseServiceImpl implements BookReleaseService {

	private BookReleaseDao bookReleaseDao;
	
	public BookReleaseDao getBookReleaseDao() {
		return bookReleaseDao;
	}

	public void setBookReleaseDao(BookReleaseDao bookReleaseDao) {
		this.bookReleaseDao = bookReleaseDao;
	}

	public List<BookRelease> getBookReleaseByISBN(int ISBN) {
		return bookReleaseDao.getBookReleaseByIsbn(ISBN);
	}

	public List<BookRelease> getBookReleaseById(int id) {
		return bookReleaseDao.getBookReleaseById(id);
	}

	public BookRelease getBookReleaseByR_id(int r_id) {
		return bookReleaseDao.getBookReleaseByR_id(r_id);
	}

	public List<BookRelease> getAllBookReleases() {
		return bookReleaseDao.getAllBookReleases();
	}

	public boolean ReleaseBook(BookRelease bookRelease) {
		try {
			long isbn = bookRelease.getIsbn();
			/* TODO: GET BOOK INFO FROM DOUBAN AND SAVE IT INTO DB*/
			int r_id = bookReleaseDao.save(bookRelease);
			bookRelease.setR_id(r_id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean uploadImage(int id, File image, String contentType, String fileName) {
		return bookReleaseDao.uploadPicture(id, image, contentType, fileName);
	}
	
}