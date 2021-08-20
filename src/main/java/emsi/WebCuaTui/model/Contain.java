//package emsi.WebCuaTui.model;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "contain")
//public class Contain {
//
//	@ManyToOne
//	@JoinColumn(name = "book_case_id")
//	private BookCase bookcase;
//
//	@ManyToOne
//	@JoinColumn(name = "book_id")
//	private Book book;
//
//	@Column(name = "create_date")
//	private Date create_date;
//
//	public BookCase getBookcase() {
//		return bookcase;
//	}
//
//	public void setBookcase(BookCase bookcase) {
//		this.bookcase = bookcase;
//	}
//
//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}
//
//	public Date getCreate_date() {
//		return create_date;
//	}
//
//	public void setCreate_date(Date create_date) {
//		this.create_date = create_date;
//	}
//
//}
