package com.atguigu.bean;

public class Book {
	

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
@Override
public String toString() {
	return "Book ["+"bookName=" + bookName + ", price="
			+ price + ", author=" + author + "]";
}


public Book(String bookName, String price, String author) {
	super();
	this.bookName = bookName;
	this.price = price;
	this.author = author;
}


public Book() {
	super();
}
String bookName;
String price;
String author;
	
	

}
