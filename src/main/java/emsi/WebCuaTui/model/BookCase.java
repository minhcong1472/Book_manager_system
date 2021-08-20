package emsi.WebCuaTui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookcase")
public class BookCase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long book_case_id;
	
	@Column(name="book_case_name" , length=45 ,  nullable = false)
	private String book_case_name;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public BookCase() {
	}
	
	public BookCase(String book_case_name, User user) {
		this.book_case_name = book_case_name;
		this.user = user;
	}


	public Long getBook_case_id() {
		return book_case_id;
	}

	public void setBook_case_id(Long book_case_id) {
		this.book_case_id = book_case_id;
	}

	public String getBook_case_name() {
		return book_case_name;
	}

	public void setBook_case_name(String book_case_name) {
		this.book_case_name = book_case_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
