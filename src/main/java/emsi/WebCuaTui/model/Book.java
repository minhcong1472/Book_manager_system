package emsi.WebCuaTui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book" )
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long book_id;
	
	@Column(name= "book_title " ,length = 45 , nullable = false)
	private String book_title;
	
	@Column(name="author",length = 45 , nullable  = false)
	private String author;
	
	@Column(name="brief", length = 45 ,  nullable = false)
	private String brief;
	
	@Column(name="publisher" , length=45, nullable = false)
	private String publisher;
	
	@Column(name="content" , length = 2000 , nullable = false)
	private String content;
	
	@Column(name="category" , length = 45 , nullable = false)
	private String category;
	
	public Book() {
		
	}
	
	public Book( String book_title, String author, String brief, String publisher, String content,
			String category) {
		this.book_title = book_title;
		this.author = author;
		this.brief = brief;
		this.publisher = publisher;
		this.content = content;
		this.category = category;
	}

	
	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	@Override
//	public String toString() {
//		return " id:"+ book_id +" , Tên truyện : "+ book_title +" ";
//	}
	
}
