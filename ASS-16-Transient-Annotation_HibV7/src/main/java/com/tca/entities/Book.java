package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="book")
public class Book 
{
	@Id
	@Column(name="isbm_number")
	private Integer isbmNumber;
	
	@Column(name="book_name", nullable=false, length=30)
	private String bookName;
	
	@Column(name="book_author", nullable=false, length=30)
	private String author;
	
	
	@Column(name="book_price", nullable=false, columnDefinition="float check(book_price >= 0)" ) // take care of field name and column name as they are diff , so column name in check constraint
	private Double price;
	
	@Transient()
	private String publisher;
	
	
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getIsbmNumber() {
		return isbmNumber;
	}
	public void setIsbmNumber(Integer isbmNumber) {
		this.isbmNumber = isbmNumber;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [isbmNumber=" + isbmNumber + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ "]";
	}
}
