package emsi.WebCuaTui.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles",
	joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn( name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
//	@OneToOne
//	@JoinTable(name="bookcase",joinColumns = @JoinColumn(name="id"))
//	private Collection<BookCase> bookcases;
	
	public User() {
		
	}
	
	public User( String email, String password, Collection<Role> roles) {
		super();

		this.email = email;
		this.password = password;
		this.roles = roles;
//		this.bookcases = bookcases;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

//	public Collection<BookCase> getBookcases() {
//		return bookcases;
//	}
//
//	public void setBookcases(Collection<BookCase> bookcases) {
//		this.bookcases = bookcases;
//	}

	
}
