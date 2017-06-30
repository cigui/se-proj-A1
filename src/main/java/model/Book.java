package model;

import java.sql.Blob;

public class Book {
	private int ISBN;
	private char title;
	private char author;
	private char publisher;
	private char translator;
	private Blob cover;
	
	public Book(){
		
	}
	
	public Book(int ISBN,char title,char author,char publisher,char translator,Blob cover){
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.translator = translator;
		this.cover = cover;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public char getTitle() {
		return title;
	}

	public void setTitle(char title) {
		this.title = title;
	}

	public char getAuthor() {
		return author;
	}

	public void setAuthor(char author) {
		this.author = author;
	}

	public char getPublisher() {
		return publisher;
	}

	public void setPublisher(char publisher) {
		this.publisher = publisher;
	}

	public char getTranslator() {
		return translator;
	}

	public void setTranslator(char translator) {
		this.translator = translator;
	}

	public Blob getCover() {
		return cover;
	}

	public void setCover(Blob cover) {
		this.cover = cover;
	}
	
	
}
