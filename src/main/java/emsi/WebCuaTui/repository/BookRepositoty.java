package emsi.WebCuaTui.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import emsi.WebCuaTui.model.Book;

@Repository
public interface BookRepositoty extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.book_title LIKE %?1%"
			+ "OR b.author LIKE %?1%"
			+ "OR b.category LIKE %?1%"
)
	
	public List<Book> findAll(String keyword);
}
