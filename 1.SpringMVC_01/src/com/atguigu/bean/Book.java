package com.atguigu.bean;

public class Book {
	


public Press getPress() {
		return press;
	}
	public void setPress(Press press) {
		this.press = press;
	}
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
	return "Book [press=" + press + ", bookName=" + bookName + ", price="
			+ price + ", author=" + author + "]";
}


public Book(String bookName, String price, String author) {
	super();
	this.bookName = bookName;
	this.price = price;
	this.author = author;
}
Press press;


public Book(Press press, String bookName, String price, String author) {
	super();
	this.press = press;
	this.bookName = bookName;
	this.price = price;
	this.author = author;
}
String bookName;
public Book() {
	super();
}
String price;
String author;
	
	

}
