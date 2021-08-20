package emsi.WebCuaTui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emsi.WebCuaTui.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
