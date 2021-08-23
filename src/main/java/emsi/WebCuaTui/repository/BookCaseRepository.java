package emsi.WebCuaTui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emsi.WebCuaTui.model.BookCase;
import emsi.WebCuaTui.model.User;

@Repository
public interface BookCaseRepository extends JpaRepository<BookCase, Long> {

//	public Optional<BookCase> findByUserID(Long user_id);
	
	BookCase findByUser(User user);
	
//	List<BookCase> findByBook_case_id(Long book_case_id);
}
