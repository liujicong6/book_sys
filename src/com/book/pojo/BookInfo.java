package com.book.pojo;

public class BookInfo {
	private Integer id;
	private String bookName;
	private String author;
	private String publisher;
	private Double price;
	private String photo;
	// 关系成员
	private Category category;
	public BookInfo() {
		super();
	}
	public BookInfo(Integer id, String bookName, String author, String publisher, Double price, String photo,
			Category category) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.photo = photo;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
