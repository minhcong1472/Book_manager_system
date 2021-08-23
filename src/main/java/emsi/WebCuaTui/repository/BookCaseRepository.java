package emsi.WebCuaTui.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emsi.WebCuaTui.model.BookCase;

@Repository
public interface BookCaseRepository extends JpaRepository<BookCase, Long> {

//	public Optional<BookCase> findByUserID(Long user_id);
}
